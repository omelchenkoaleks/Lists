package com.omelchenkoaleks.lists._009_text_image;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.omelchenkoaleks.lists.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_009_text_image);

        Day[] days = {
                new Day("Day1", 0),
                new Day("Day2", 15),
                new Day("Day3", 20),
                new Day("Day4", 3),
                new Day("Day5", -4),
                new Day("Day6", 5),
                new Day("Day7", -10),
                new Day("Day8", 7),
                new Day("Day9", -1),
                new Day("Day10", 14),
                new Day("Day11", 10)};

        List<Map<String, Object>> valuesMapList = new ArrayList<>();
        Map<String, Object> currentMap;

        for (Day day : days) {
            currentMap = new HashMap<>();

            currentMap.put("text", day.getDay());

            int temperature = day.getTemperature();
            currentMap.put("value", temperature);

            int img = (temperature == 0) ? 0 : ((temperature > 0) ? Constants.POSITIVE_UP : Constants.NEGATIVE_DOWN);
            currentMap.put("img", img);

            valuesMapList.add(currentMap);
        }

        String[] from = {"text", "value", "img"};
        int[] to = {
                R.id.text_image_text_view_2,
                R.id.text_image_text_view_1,
                R.id.text_image_image_view};

        SimpleAdapter simpleAdapter = new MySimpleAdapter(
                this, valuesMapList, R.layout.item_009_text_image, from, to);

        ListView listView = findViewById(R.id.text_image_list_view);
        listView.setAdapter(simpleAdapter);
    }
}
