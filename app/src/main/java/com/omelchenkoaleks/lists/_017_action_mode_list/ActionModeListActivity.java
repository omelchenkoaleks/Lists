package com.omelchenkoaleks.lists._017_action_mode_list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.omelchenkoaleks.lists.R;

import java.util.ArrayList;
import java.util.List;

public class ActionModeListActivity extends AppCompatActivity {
    private static final String TAG = "ActionModeListActivity";
    private ListView mListView;
    private List<String> mData = new ArrayList<String>() {
        {
            add("one");
            add("two");
            add("tree");
            add("four");
            add("five");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_017_action_mode_list);

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_activated_1, mData);
        mListView = findViewById(R.id.action_mode_list_view);
        mListView.setAdapter(adapter);
        mListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        mListView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            private List<String> currentData = new ArrayList<>();

            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                String item = adapter.getItem(position);
                Log.d(TAG, "position = " + position + ", checked = " + checked + " " + item);

                if (checked) {
                    currentData.add(item);
                } else {
                    currentData.remove(item);
                }
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                mode.getMenuInflater().inflate(R.menu.menu, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                for (String value : currentData) {
                    mData.remove(value);
                    adapter.notifyDataSetChanged();
                }
                currentData.clear();
                mode.finish();
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });
    }
}
