package com.omelchenkoaleks.lists._005_multiple_choice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.omelchenkoaleks.lists.R;

public class MultipleChoiceActivity extends AppCompatActivity {
    private static final String TAG = "MultipleChoiceActivity";

    private ListView mListView;
    private String[] mArrayStrings = {"one", "two", "tree", "five", "four", "six"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_005_multiple_choice);

        mListView = findViewById(R.id.multiple_choice_list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_multiple_choice, mArrayStrings);
        mListView.setAdapter(adapter);
        mListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }

    public void clickMultipleChoice(View view) {
        // хранит в себе множественный выбор нажатых items
        SparseBooleanArray booleanArray = mListView.getCheckedItemPositions();

        for (int i = 0; i < booleanArray.size(); i++) {
            int key = booleanArray.keyAt(i);
            if (booleanArray.get(key)) {
                Log.d(TAG, "click: " + mArrayStrings[key]);
            }
        }
    }
}
