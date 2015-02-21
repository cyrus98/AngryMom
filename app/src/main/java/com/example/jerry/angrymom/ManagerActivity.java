package com.example.jerry.angrymom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class ManagerActivity extends Activity {

    TextView dateTextControl;
    EditText todoText;
    Button btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);



        this.InitializeControl();
    }

    //컨트롤을 초기화 한다..
    private void InitializeControl() {
        dateTextControl = (TextView)findViewById(R.id.dateText);
        dateTextControl.setText(Common.GetDateTitle());

        todoText = (EditText)findViewById(R.id.textToDoManager);

        btnOK = (Button)findViewById(R.id.btnOK);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean result = false;

                result = AddTodo();

                if(result){
                    Intent intent = new Intent(getBaseContext(), MainActivity.class);

                    if(intent != null)
                        startActivity((intent));
                }

            }
        });

    }


    private Boolean AddTodo(){
        Boolean result = false;
        String Title = this.todoText.getText().toString();
        if(Title.trim().length() > 0) {
            TodoEntity addTodo = new TodoEntity(Title);

            DBHelper db = Common.GetDBHelper(getApplicationContext());
            result = db.AddTodo(addTodo);
        } else {
            Toast.makeText(getApplicationContext(), "할일을 적으라우!", Toast.LENGTH_LONG).show();
        }
        return result;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_manager, menu);
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
