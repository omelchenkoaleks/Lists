package com.omelchenkoaleks.lists._009_text_image;

import android.content.Context;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.omelchenkoaleks.lists.R;

import java.util.List;
import java.util.Map;

public class MySimpleAdapter extends SimpleAdapter {

    public MySimpleAdapter(Context context,
                           List<? extends Map<String,
                                   ?>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
    }

    @Override
    public void setViewText(TextView v, String text) {
        super.setViewText(v, text);
        if (v.getId() == R.id.text_image_text_view_1) {
            int value = Integer.parseInt(text);
            int color = (value > 0) ? R.color.up : R.color.down;
            v.getResources().getColor(color);
        }
    }

    @Override
    public void setViewImage(ImageView v, int value) {
        super.setViewImage(v, value);
        if (value == Constants.POSITIVE_UP) {
            v.getResources().getColor(R.color.up);
        } else {
            v.getResources().getColor(R.color.down);
        }
    }
}
