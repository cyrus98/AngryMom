package com.example.jerry.angrymom;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

import java.util.ArrayList;

/**
 * Created by Jerry on 15. 2. 21..
 */
public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context, String name, CursorFactory cursorFactory, int version) {
        super(context, name, cursorFactory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Todo(id INTEGER PRIMARY KEY AUTOINCREMENT, Title TEXT, Status INTEGER, DueDate TEXT, RegisterDate TEXT)";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < newVersion) {
            String sql = "drop table if exists Todo";
            db.execSQL(sql);

            onCreate(db);
        }
    }

    public Boolean AddTodo(TodoEntity todoEntity) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("Title", todoEntity.getTitle());
        values.put("Status", 0);        // 0은 기본값
        values.put("DueDate", todoEntity.getTargetDate());
        values.put("RegisterDate", todoEntity.getRegisterDate());

        long result = db.insert("Todo", null, values);
        db.close();

        return result > 0;
    }

    public ArrayList<TodoEntity> GetTodoList() {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "select * from Todo order by id desc";
        ArrayList<TodoEntity> list = new ArrayList<TodoEntity>();

        Cursor cursor = db.rawQuery(sql, null);
        while(cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String title = cursor.getString(cursor.getColumnIndex("Title"));
            String dueDate = cursor.getString(cursor.getColumnIndex("DueDate"));
            String registerDate = cursor.getString(cursor.getColumnIndex("RegisterDate"));

            TodoEntity todo = new TodoEntity(title);
            todo.setId(id);
            todo.setTargetDate(Common.GetDateFromString(dueDate));
            todo.setRegisterDate(Common.GetDateFromString(registerDate));

            list.add(todo);
        }
        return list;
    }


}
