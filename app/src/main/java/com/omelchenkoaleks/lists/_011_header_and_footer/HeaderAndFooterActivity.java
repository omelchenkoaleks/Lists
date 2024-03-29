package com.omelchenkoaleks.lists._011_header_and_footer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.HeaderViewListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.omelchenkoaleks.lists.R;

public class HeaderAndFooterActivity extends AppCompatActivity {
    private static final String TAG = "HeaderAndFooterActivity";

    private String[] mData = {"one", "two", "tree", "four", "five"};
    private ListView mListView;
    private ArrayAdapter<String> mAdapter;

    private View mHeader_1_View;
    private View mHeader_2_View;
    private View mFooter_1_View;
    private View mFooter_2_View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_011_header_and_footer);

        mListView = findViewById(R.id.header_and_footer_list_view);
        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mData);

        mHeader_1_View = createHeader("header 1");
        mHeader_2_View = createHeader("header 2");
        mFooter_1_View = createFooter("footer 1");
        mFooter_2_View = createFooter("footer 2");

        fillList();
    }

    private void fillList() {
        mListView.setAdapter(mAdapter);
        mListView.addHeaderView(mHeader_1_View);
        mListView.addHeaderView(mHeader_2_View, "come text for header 2", false);
        mListView.addFooterView(mFooter_1_View);
        mListView.addFooterView(mFooter_2_View, "some text for footer 2", false);
    }

    private View createHeader(String text) {
        View view = LayoutInflater.from(this).inflate(R.layout.item_011_header, null);
        ((TextView) view.findViewById(R.id.header_text_view_2)).setText(text);
        return view;
    }

    private View createFooter(String text) {
        View view = LayoutInflater.from(this).inflate(R.layout.item_011_footer, null);
        ((TextView) view.findViewById(R.id.footer_text_view_2)).setText(text);
        return view;
    }

    public void headerAndFooterOnClick(View view) {
        // удаляем при нажатии кнопки
//        mListView.removeHeaderView(mHeader_2_View);
//        mListView.removeFooterView(mFooter_2_View);


        Object object;


        HeaderViewListAdapter adapter = (HeaderViewListAdapter) mListView.getAdapter();

        // здесь мы можем взять данные со всех items списка, включая кастомные вью
        object = adapter.getItem(1);
        Log.d(TAG,"adapter.getItem(1): " + object.toString());
        object = adapter.getItem(4);
        Log.d(TAG,"adapter.getItem(4): " + object.toString());

        ArrayAdapter<String> arrayAdapter = (ArrayAdapter<String>) adapter.getWrappedAdapter();

        // здесь мы берем только в самом списке данные, без кастомный вложенный вью
        object = arrayAdapter.getItem(1);
        Log.d(TAG, "arrayAdapter.getItem(1): " + object.toString());
        object = arrayAdapter.getItem(4);
        Log.d(TAG, "arrayAdapter.getItem(4): " + object.toString());
    }
}
