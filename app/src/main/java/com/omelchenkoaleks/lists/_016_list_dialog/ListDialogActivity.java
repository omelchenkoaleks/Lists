package com.omelchenkoaleks.lists._016_list_dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.omelchenkoaleks.lists.R;

public class ListDialogActivity extends AppCompatActivity {
    private static final String TAG = "ListDialogActivity";

    public static final int DIALOG_ITEMS = 1;
    public static final int DIALOG_ADAPTER = 2;

    private String[] data = new String[]{"one", "two", "tree", "four", "five"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_016_list_dailog);
    }

    public void dialogOnClick(View view) {
        switch (view.getId()) {
            case R.id.items_list_dialog_button:
                showDialog(DIALOG_ITEMS);
                break;
            case R.id.adapter_list_dialog_button:
                showDialog(DIALOG_ADAPTER);
                break;
            default:
                break;
        }
    }

    protected Dialog onCreateDialog(int id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        switch (id) {
            case DIALOG_ITEMS:
                builder.setTitle(R.string.items);
                builder.setItems(data, myClickListener);
                break;
            case DIALOG_ADAPTER:
                builder.setTitle(R.string.adapter);
                ArrayAdapter<String> adapter = new ArrayAdapter<>(
                        this, android.R.layout.select_dialog_item, data);
                builder.setAdapter(adapter, myClickListener);
                break;
            default:
                break;
        }
        return builder.create();
    }

    protected void onPrepareDialog(int id, Dialog dialog) {
        AlertDialog alertDialog = (AlertDialog) dialog;
        ListAdapter listAdapter = alertDialog.getListView().getAdapter();

        switch (id) {
            case DIALOG_ITEMS:
            case DIALOG_ADAPTER:
                // проверка возможности преобразования
                if (listAdapter instanceof BaseAdapter) {
                    BaseAdapter baseAdapter = (BaseAdapter) listAdapter;
                    baseAdapter.notifyDataSetChanged();
                }
                break;
            default:
                break;
        }
    }

    private DialogInterface.OnClickListener myClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Log.d(TAG, "which = " + which);
            Toast.makeText(ListDialogActivity.this, "position: " + which, Toast.LENGTH_SHORT).show();
        }
    };
}
