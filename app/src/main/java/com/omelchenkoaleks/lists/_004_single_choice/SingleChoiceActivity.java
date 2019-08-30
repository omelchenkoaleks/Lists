package com.omelchenkoaleks.lists._004_single_choice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.omelchenkoaleks.lists.R;

public class SingleChoiceActivity extends AppCompatActivity {
    private static final String TAG = "SingleChose";

    private ListView mListView;
    private String[] mArray = {"one", "two", "tree", "four", "five"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_004_single_choice);

        mListView = findViewById(R.id.chose_info_list_view);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_single_choice, mArray);
        mListView.setAdapter(adapter);
        mListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }

    public void clickChoseInfo(View view) {
        Log.d(TAG, "click: " + mArray[mListView.getCheckedItemPosition()]);
    }
}
