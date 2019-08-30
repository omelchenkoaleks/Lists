package com.omelchenkoaleks.lists._001_simple_list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.omelchenkoaleks.lists.R;

import java.util.ArrayList;

public class SimpleListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_001_simple_list);

        ListView listView = findViewById(R.id.list_view);
        String[] array = {"one", "two", "tree", "four", "five"};
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, array);
        listView.setAdapter(adapter);
    }
}
