package com.example.jerry.angrymom;

import android.content.Context;
import android.widget.Toast;

import java.util.*;
import java.text.*;

/**
 * Created by Jerry on 15. 1. 21..
 */
public class Common {

    // 메인 날짜 형식을 반환.
    public static String GetDateTitle() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMM dd");
        return dateFormat.format(new Date());
    }

    public static Date GetDateFromString(String dateString){
        Date date;

        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            date = dateFormat.parse(dateString);
        } catch(Exception ex) {
            date = new Date();
        }


        return date;
    }

    public static DBHelper GetDBHelper(Context context){
        return new DBHelper(context, "Todo.db", null, 2);
    }
}
