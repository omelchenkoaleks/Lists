package com.omelchenkoaleks.lists._014_expandable_list_view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import com.omelchenkoaleks.lists.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ExpandableListViewActivity extends AppCompatActivity {
    private List<Car> cars;

    // будут храниться названия наших машин, которые не будут содержать дубликатов
    private Set<String> markSet;

    // список атрибутов группы
    private Map<String, String> currentMap;

    // коллекция для групп
    private List<Map<String, String>> groupData;

    // общая коллекция для коллекций элементов
    private List<List<Map<String, String>>> childData;

    private ExpandableListView expandableListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_014_expandable_list_view);

        initList();
        initSet();

        // заполняем коллекцию групп из массива с названиями групп
        groupData = new ArrayList<>();

        for (String group : markSet) {
            // заполняем список атрибутов для каждой группы
            currentMap = new HashMap<>();
            currentMap.put("groupName", group); // имя компании
            groupData.add(currentMap);
        }

        // список атрибутов групп для чтения
        String[] groupFrom = new String[] {"groupName"};
        // список ID view-элементов, в которые будут помещены атрибуты групп
        int[] groupTo = new int[] {android.R.id.text1};

        childData = initChildData();

        // список атрибутов элементов для чтения
        String[] childFrom = new String[] {"carName"};
        // список ID view-элементов, в которые будут помещены атрибуты элементов
        int[] childTo = new int[] {android.R.id.text1};

        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(
                this,
                groupData,
                android.R.layout.simple_expandable_list_item_1,
                groupFrom,
                groupTo,
                childData,
                android.R.layout.simple_list_item_1,
                childFrom,
                childTo
        );

        expandableListView = findViewById(R.id.expandable_list_view);
        expandableListView.setAdapter(adapter);
    }

    private void initList() {
        cars = new ArrayList<>();
        cars.add(new Car("Porsche", "Panamera turbo"));
        cars.add(new Car("Porsche", "Cayece S"));
        cars.add(new Car("Maseratti", "Qauttroporte"));
        cars.add(new Car("Audi", "A5"));
        cars.add(new Car("Audi", "R8"));
        cars.add(new Car("BMW", "X5"));
        cars.add(new Car("BMW", "M3"));
        cars.add(new Car("BMW", "750Li"));
    }

    // в итоге в списке будет четыре уникаьных элемента (по марке)
    private void initSet() {
        markSet = new TreeSet<>();

        for (Car car : cars) {
            markSet.add(car.getMark());
        }
    }

    private List<List<Map<String, String>>> initChildData() {
        List<List<Map<String, String>>> childData = new ArrayList<>();

        // заполняем список атрибутов для каждого элемента
        for (String mark : markSet) {

            List<Map<String, String>> childDataItem = new ArrayList<>();

            for (Car car : cars) {
                if (car.getMark().equals(mark)) {
                    Map<String, String> modelMap = new HashMap<>();
                    modelMap.put("carName", car.getModel());
                    childDataItem.add(modelMap);
                }
            }
            childData.add(childDataItem);
        }
        return childData;
    }
}
