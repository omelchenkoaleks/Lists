package com.omelchenkoaleks.lists._003_custom_item;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ListView;

import com.omelchenkoaleks.lists.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CustomItemActivity extends AppCompatActivity {
    private List<People> mPeople;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_003_custom_item);

        mListView = findViewById(R.id.people_list_view);
        mPeople = getPeopleList();
        LayoutInflater inflater = getLayoutInflater();
        PeopleAdapter adapter = new PeopleAdapter(mPeople, inflater);
        mListView.setAdapter(adapter);
    }

    private List<People> getPeopleList() {
        List<People> peopleList = new ArrayList<>();

        peopleList.add(new People("Aleksandr", 40, "Developer"));
        peopleList.add(new People("Misha", 44, "Java Developer"));
        peopleList.add(new People("Dan", 37, "Kotlin Developer"));

        return peopleList;
    }
}
