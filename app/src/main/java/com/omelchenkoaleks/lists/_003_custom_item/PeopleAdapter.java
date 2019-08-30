package com.omelchenkoaleks.lists._003_custom_item;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.omelchenkoaleks.lists.R;

import java.util.List;

public class PeopleAdapter extends BaseAdapter {
    private List<People> mPeople;
    private LayoutInflater mLayoutInflater;

    public PeopleAdapter(List<People> people, LayoutInflater layoutInflater) {
        mPeople = people;
        mLayoutInflater = layoutInflater;
    }

    @Override
    public int getCount() {
        return mPeople.size();
    }

    @Override
    public Object getItem(int position) {
        return mPeople.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            view = mLayoutInflater.inflate(R.layout.item_003_people, parent, false);
        }

        People people = (People) getItem(position);

        TextView peopleName = view.findViewById(R.id.name_people_text_view);
        TextView peopleAge = view.findViewById(R.id.age_people_text_view);
        TextView peoplePosition = view.findViewById(R.id.position_people_text_view);

        peopleName.setText("Name: " + people.getName());
        peopleAge.setText("Age: " + people.getAge());
        peoplePosition.setText("Position: " + people.getPosition());

        return view;
    }

}
