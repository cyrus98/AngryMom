package com.example.jerry.angrymom;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jerry on 15. 1. 31..
 */
public class TodoEntity {

    private String Title;
    private Date RegisterDate;
    private Date TargetDate;

    public enum State {Appointment, Completed, Cancel}

    public TodoEntity(String title){
        this.Title = title;
        this.RegisterDate = new Date();
    }

    public String getTitle() {
        return Title;
    }

    public String getRegisterDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(dateFormat);
    }

    public Date getTargetDate() {
        return TargetDate;
    }

    public void setTargetDate(Date targetDate) {
        TargetDate = targetDate;
    }
}
