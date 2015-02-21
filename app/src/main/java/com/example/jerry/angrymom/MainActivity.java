package com.example.jerry.angrymom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jerry.angrymom.Common;

import java.util.*;
import java.text.*;


public class MainActivity extends Activity {

    TextView dateTextControl;
    EditText todoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 텍스트 박스 설정
        todoText = (EditText)findViewById(R.id.textToDo);
        todoText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent managerTodo = new Intent(getBaseContext(), ManagerActivity.class);

                if(managerTodo != null)
                    startActivity((managerTodo));
            }
        });

        final DBHelper dbHelper = Common.GetDBHelper(getApplicationContext()); //new DBHelper(getApplicationContext(), "Todo.db", null, 2);

        // 리스트 아답터 설정
        ArrayList<TodoEntity> list = dbHelper.GetTodoList();
        TodoListAdapter todoAdapter = new TodoListAdapter(this, R.layout.row, list);

        ListView listView = (ListView)findViewById(R.id.listTodo);
        listView.setAdapter(todoAdapter);

        this.InitializeControl();

    }

    //컨트롤을 초기화 한다..
    private void InitializeControl() {
        dateTextControl = (TextView)findViewById(R.id.dateText);
        dateTextControl.setText(Common.GetDateTitle());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
