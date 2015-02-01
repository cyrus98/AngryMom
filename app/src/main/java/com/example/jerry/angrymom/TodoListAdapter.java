package com.example.jerry.angrymom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Jerry on 15. 1. 31..
 */
public class TodoListAdapter extends ArrayAdapter<TodoEntity> {
    private ArrayList<TodoEntity> items;
    private Context context;

    public TodoListAdapter(Context context, int textViewResourceId, ArrayList<TodoEntity> items){
        super(context, textViewResourceId, items);
        this.items = items;
        this.context = context;
    }

    public View getView(int position, View counterView, ViewGroup viewGroup){
        View v = counterView;
        if(v == null) {
            LayoutInflater vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.row, null);
        }

        TodoEntity todo = items.get(position);
        if(todo != null){
            // 타이틀 설정
            final TextView titleTextView = (TextView)v.findViewById(R.id.rowtitle);
            if(titleTextView != null){
                titleTextView.setText(todo.getTitle());

                // 클릭 이벤트 설정
                titleTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TextView textView = (TextView)v;
                        Toast.makeText(context, String.format("타이틀은 %s", textView.getText()), Toast.LENGTH_LONG).show();
                    }
                });

                /*titleTextView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        Toast.makeText(context, "long click test", Toast.LENGTH_LONG).show();
                        return false;
                    }
                });*/
            }


            // 체크박스 이벤트 할당
            CheckBox checkBox = (CheckBox)v.findViewById(R.id.rowCheckBox);
            if(checkBox != null){
                checkBox.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        CheckBox chkBox = (CheckBox)v;
                        Toast.makeText(context, "체크박스" + chkBox.isChecked(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        }



        return v;
    }

}
