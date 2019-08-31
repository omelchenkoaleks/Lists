package com.omelchenkoaleks.lists._007_add_data;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.omelchenkoaleks.lists.R;

import java.util.ArrayList;
import java.util.List;

public class AddDataActivity extends AppCompatActivity {
    private static final String TAG = "AddDataActivity";

    private List<People> mPeoples;
    private ListView mListView;
    private PeopleAdapter mAdapter;

    private int mId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_007_add_data);

        mListView = findViewById(R.id.add_data_list_view);
        mPeoples = getPeopleList();
        LayoutInflater layoutInflater = getLayoutInflater();
        mAdapter = new PeopleAdapter(mPeoples, layoutInflater);
        mListView.setAdapter(mAdapter);
    }

    private List<People> getPeopleList() {
        List<People> peopleList = new ArrayList<>();

        peopleList.add(new People(40,"Aleksandr", "Developer"));
        peopleList.add(new People(38, "Misha", "Java Developer"));
        peopleList.add(new People(20, "Dan", "Kotlin Developer"));

        return peopleList;
    }

    public void onClickData(View view) {

        switch (view.getId()) {

            case R.id.add_data_button:
                // этот прикол с цифрами просто для примера, чтобы увидеть как добавляется в список
                mPeoples.add(new People(++mId, "people: " + mId, "Programmer: " + mId));
                break;

            case R.id.remove_data_button:
                mPeoples.remove(mPeoples.size() -1);
                mId--;
                break;

            default:
                break;
        }

        mAdapter.notifyDataSetChanged();
    }
}
