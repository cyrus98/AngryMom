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
    private int Status; // 0:등록, 1:완
    private int id;

    public TodoEntity() {

    }

    public TodoEntity(String title){
        this.Title = title;
        this.RegisterDate = new Date();
        this.TargetDate = new Date();
        this.Status = 0;
        this.id = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getRegisterDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(RegisterDate);
    }

    public String getTargetDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(TargetDate);
    }

    public void setTargetDate(Date targetDate) {
        TargetDate = targetDate;
    }

    public void setRegisterDate(Date registerDate){
        RegisterDate=registerDate;
    }

}
