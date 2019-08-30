package com.omelchenkoaleks.lists._002_layout_inflater;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.omelchenkoaleks.lists.R;

public class LayoutInflaterActivity extends AppCompatActivity {
    private static final String TAG = "Log";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_002_layout_inflater);

        /*            1 ПРИМЕР           */

//        LayoutInflater layoutInflater = getLayoutInflater();
//        LinearLayoutCompat linearLayoutCompat = findViewById(R.id.linear_layout);
//        // генерируем view
//        View view = layoutInflater.inflate(R.layout.text_view_002_view, null);
//        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
//
//        Log.d(TAG, "Class of view: " + view.getClass().toString());
//        Log.d(TAG, "LayoutParams of view in null: " + (layoutParams == null));
//        // здесь у нас жесткий кастинг - если view будет layout а не TextView - будет исключение!!!
//        Log.d(TAG, "Text of view: " + ((TextView) view).getText());
//
//        linearLayoutCompat.addView(view);


        /*          2 ПРИМЕР            */

//        LayoutInflater layoutInflater = getLayoutInflater();
//        LinearLayoutCompat linearLayoutCompat = findViewById(R.id.linear_layout);
//        // генерируем view
//        // в этом случае layoutParams было взято из указанного Layout-a
//        View view = layoutInflater.inflate(R.layout.text_view_002_view, linearLayoutCompat, false);
//
//        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
//
//        Log.d(TAG, "Class of view: " + view.getClass().toString());
//        Log.d(TAG, "LayoutParams of view in null: " + (layoutParams == null));
//        // здесь у нас жесткий кастинг - если view будет layout а не TextView - будет исключение!!!
//        Log.d(TAG, "Text of view: " + ((TextView) view).getText());
//
//        linearLayoutCompat.addView(view);



        /*           3 ПРИМЕР            */

        LayoutInflater layoutInflater = getLayoutInflater();
        LinearLayoutCompat linearLayoutCompat = findViewById(R.id.linear_layout);
        // генерируем view
        // в этом случае layoutParams было взято из указанного Layout-a
        /*
                если указать true, то мы присодиняем к группе LinearLayout
                НО, мы явно указываем кастинг ((TextView) view).getText()) - будет исключение
                ПРАВДА = указав true, мы уже сделали автоматически присоединение - и,
                кастинг не нужен ))) - аналогичто присоединению linearLayoutCompat.addView(view)

         */
        View view = layoutInflater.inflate(R.layout.text_view_002_view, linearLayoutCompat, true);

        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();

        Log.d(TAG, "Class of view: " + view.getClass().toString());
        Log.d(TAG, "LayoutParams of view in null: " + (layoutParams == null));

        // здесь у нас жесткий кастинг - если view будет layout а не TextView - будет исключение!!!
//        Log.d(TAG, "Text of view: " + ((TextView) view).getText());

        // при true это уже не нужно ...
//        linearLayoutCompat.addView(view);
    }
}
