package com.omelchenkoaleks.lists._008_simple_list_adapter;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.omelchenkoaleks.lists.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleListAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_008_simple_list_adapter);

//        String[] values = {"text1", "text2", "text3", "text4", "text5"};
//        boolean[] checked = {false, true, false, true, true};
        int img = R.mipmap.ic_launcher_round;

        MyObj[] objs = {new MyObj("text1", false, img),
                new MyObj("text2", false, img),
                new MyObj("text3", true, img),
                new MyObj("text4", false, img),
                new MyObj("text5", true, img)};

        List<Map<String, Object>> valuesMapList = new ArrayList<>();
        Map<String, Object> currentMap;

        for (MyObj obj : objs) {
            currentMap = new HashMap<>();
            currentMap.put("text", obj.getValue());
            currentMap.put("check", obj.isCheck());
            currentMap.put("img", obj.getImgId());
            valuesMapList.add(currentMap);
        }

//        for (int i = 0; i < 5; i++) {
//            currentMap = new HashMap<>();
//            currentMap.put("text", values[i]);
//            currentMap.put("check", checked[i]);
//            currentMap.put("img", img);
//            valuesMapList.add(currentMap);
//        }

        String[] from = {"text", "check", "img"};
        int[] to = {R.id.simple_list_adapter_text_view,
                R.id.simple_list_adapter_check_box, R.id.simple_list_adapter_image_view};

        SimpleAdapter simpleAdapter = new SimpleAdapter(
                this, valuesMapList, R.layout.item_008_simple_list_adapter, from, to);

        ListView listView = findViewById(R.id.simple_list_adapter_list_view);
        listView.setAdapter(simpleAdapter);
    }

    private class MyObj {
        private String value;
        private boolean check;
        private int imgId;

        public MyObj(String value, boolean check, int imgId) {
            this.value = value;
            this.check = check;
            this.imgId = imgId;
        }

        public String getValue() {
            return value;
        }

        public boolean isCheck() {
            return check;
        }

        public int getImgId() {
            return imgId;
        }
    }
}
