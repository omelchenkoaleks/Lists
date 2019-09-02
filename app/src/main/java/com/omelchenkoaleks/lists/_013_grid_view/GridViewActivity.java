package com.omelchenkoaleks.lists._013_grid_view;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.omelchenkoaleks.lists.R;

public class GridViewActivity extends AppCompatActivity {
    private String[] data = {"grid", "view", "doctor", "sector", "price", "thing", "men", "women",
            "lite", "live", "love", "Dan", "don", "top"};

    private GridView mGridView;
    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_013_grid_view);

        mAdapter = new ArrayAdapter<>(this,
                R.layout.item_013_grid_view, R.id.grid_view_text_view, data);
        mGridView = findViewById(R.id.grid_view);
        mGridView.setAdapter(mAdapter);

        adjustGridView(); // без настроек будет просто обычный лист
    }

    private void adjustGridView() {
//        mGridView.setNumColumns(3);

        mGridView.setNumColumns(GridView.AUTO_FIT);

//        mGridView.setColumnWidth(50); // плохо
        mGridView.setColumnWidth(100);

        mGridView.setVerticalSpacing(5);
        mGridView.setHorizontalSpacing(5);
    }
}
