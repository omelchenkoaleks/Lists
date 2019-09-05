package com.omelchenkoaleks.lists._015_list_fragment;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

public class MainFragment extends ListFragment {
    private String[] data = new String[] {"one", "two", "tree", "four"};

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, data);
        setListAdapter(adapter);
    }
}
