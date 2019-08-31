package com.omelchenkoaleks.lists._006_listeners_in_list;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.omelchenkoaleks.lists.R;

import java.util.ArrayList;
import java.util.List;

public class ListenersInListActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener {
    private static final String TAG = "ListenersInListActivity";

    private ListView mListView;
    private List<People> mPeopleListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_006_listeners_in_list);

        mListView = findViewById(R.id.people_listeners_list_view);
        mPeopleListView = getPeopleList();
        LayoutInflater layoutInflater = getLayoutInflater();
        PeopleAdapter adapter = new PeopleAdapter(mPeopleListView, layoutInflater);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(this);
    }

    private List<People> getPeopleList() {
        List<People> peopleList = new ArrayList<>();

        peopleList.add(new People("Aleksandr", 40, "Developer"));
        peopleList.add(new People("Misha", 44, "Java Developer"));
        peopleList.add(new People("Dan", 37, "Kotlin Developer"));

        return peopleList;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        People people = mPeopleListView.get(position);
        Log.d(TAG, "onItemClick: " + people.getName()
                + " " + people.getAge()
                + " " + people.getPosition());

        TextView name = view.findViewById(R.id.name_people_text_view);
        TextView age = view.findViewById(R.id.age_people_text_view);
        TextView pos = view.findViewById(R.id.position_people_text_view);

        Log.d(TAG, "Elements from TextView" + name.getText()
                + " " + age.getText() + " " + pos.getText());

        Toast.makeText(this, "Elements from TextView: " + name.getText()
                + " " + age.getText() + " " + pos.getText(), Toast.LENGTH_SHORT).show();
    }
}
