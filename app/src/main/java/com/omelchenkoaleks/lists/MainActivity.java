package com.omelchenkoaleks.lists;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.omelchenkoaleks.lists._001_simple_list.SimpleListActivity;
import com.omelchenkoaleks.lists._002_layout_inflater.LayoutInflaterActivity;
import com.omelchenkoaleks.lists._003_custom_item.CustomItemActivity;
import com.omelchenkoaleks.lists._004_single_choice.SingleChoiceActivity;
import com.omelchenkoaleks.lists._005_multiple_choice.MultipleChoiceActivity;
import com.omelchenkoaleks.lists._006_listeners_in_list.ListenersInListActivity;
import com.omelchenkoaleks.lists._007_add_data.AddDataActivity;
import com.omelchenkoaleks.lists._008_simple_list_adapter.SimpleListAdapterActivity;
import com.omelchenkoaleks.lists._009_text_image.TextImageActivity;

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

            case R.id.custom_item_button:
                Intent customItemIntent = new Intent(this, CustomItemActivity.class);
                startActivity(customItemIntent);
                break;

            case R.id.single_choice_button:
                Intent singleChoiceIntent = new Intent(this, SingleChoiceActivity.class);
                startActivity(singleChoiceIntent);
                break;

            case R.id.multiple_choice_main_button:
                Intent multipleChoiceIntent = new Intent(this, MultipleChoiceActivity.class);
                startActivity(multipleChoiceIntent);
                break;

            case R.id.listeners_in_list_button:
                Intent listenersInListIntent = new Intent(this, ListenersInListActivity.class);
                startActivity(listenersInListIntent);
                break;

            case R.id.add_data_list_button:
                Intent addDataIntent = new Intent(this, AddDataActivity.class);
                startActivity(addDataIntent);
                break;

            case R.id.simple_list_adapter_button:
                Intent simpleListAdapterIntent = new Intent(this, SimpleListAdapterActivity.class);
                startActivity(simpleListAdapterIntent);
                break;

            case R.id.text_image_button:
                Intent textImageIntent = new Intent(this, TextImageActivity.class);
                startActivity(textImageIntent);
                break;

            default:
                break;
        }
    }
}
