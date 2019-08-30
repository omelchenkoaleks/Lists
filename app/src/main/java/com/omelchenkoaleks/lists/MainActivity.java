package com.omelchenkoaleks.lists;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.omelchenkoaleks.lists._001_simple_list.SimpleListActivity;
import com.omelchenkoaleks.lists._002_layout_inflater.LayoutInflaterActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.simple_list_button:
                Intent simpleListIntent = new Intent(this, SimpleListActivity.class);
                startActivity(simpleListIntent);
                break;

            case R.id.layout_inflater_button:
                Intent layoutInflaterIntent = new Intent(this, LayoutInflaterActivity.class);
                startActivity(layoutInflaterIntent);
                break;

            default:
                break;
        }
    }
}
