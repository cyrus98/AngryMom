package com.example.jerry.angrymom;

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
}
