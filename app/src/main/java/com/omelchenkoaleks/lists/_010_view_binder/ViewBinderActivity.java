package com.omelchenkoaleks.lists._010_view_binder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;

import com.omelchenkoaleks.lists.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ViewBinderActivity extends AppCompatActivity {
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_010_view_binder);

        mListView = findViewById(R.id.view_binder_list_view);

        int load[] = {41, 84, 22, 48, 35, 79, 88, 10};

        ArrayList<Map<String, Object>> data = new ArrayList<>(load.length);
        Map<String, Object> map;

        for (int i = 0; i < load.length; i++) {
            map = new HashMap<>();
            map.put(Constants.ATTRIBUTE_NAME_TEXT, "Day " + (i + 1) + ". Load: " + load[i] + "%");
            map.put(Constants.ATTRIBUTE_NAME_PB, load[i]);
            map.put(Constants.ATTRIBUTE_NAME_LL, load[i]);
            data.add(map);
        }

        String[] from = {Constants.ATTRIBUTE_NAME_TEXT,
                Constants.ATTRIBUTE_NAME_PB, Constants.ATTRIBUTE_NAME_LL};
        int[] to = {R.id.view_binder_text_view, R.id.view_binder_progress_bar, R.id.constraint_layout};

        SimpleAdapter adapter = new SimpleAdapter(
                this, data, R.layout.item_010_view_binder, from, to);
        adapter.setViewBinder(new MyViewBinder());

        mListView.setAdapter(adapter);
    }

    class MyViewBinder implements SimpleAdapter.ViewBinder {


        int red = getResources().getColor(R.color.red_progress);
        int blue = getResources().getColor(R.color.blue_progress);
        int green = getResources().getColor(R.color.green_progress);

        @Override
        public boolean setViewValue(View view, Object data, String textRepresentation) {

            int i = 0;

            switch (view.getId()) {
                case R.id.constraint_layout:
                    i = ((Integer) data).intValue();
                    if (i < 40) view.setBackgroundColor(green);
                    else if (i < 70) view.setBackgroundColor(blue);
                    else view.setBackgroundColor(red);
                    return true;

                case R.id.view_binder_progress_bar:
                    i = ((Integer) data).intValue();
                    ((ProgressBar) view).setProgress(i);
                    return true;
            }

            return false;
        }
    }

}
