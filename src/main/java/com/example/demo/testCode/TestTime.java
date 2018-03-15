package com.example.demo.testCode;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.TimeZone;

/**
 * Author: Yi-tong Gao
 * Date: Created in 17:06 2018/3/8
 * Description:
 * Modified By:
 */

public class TestTime {
    public static void main(String args[]){
        LocalDate date=LocalDate.now();
        LocalDateTime dateTime=LocalDateTime.now();
        System.out.println(date.atStartOfDay());
        System.out.println((int)Math.floorMod(date.toEpochDay() + 3, 7));
        System.out.println(date.atStartOfDay().minusDays((int)Math.floorMod(date.toEpochDay()+3,7)));
        System.out.println(date.getDayOfMonth());
        System.out.println(dateTime);
        System.out.println(TimeZone.getDefault().getDSTSavings());
        System.out.println(TimeZone.getDefault().getRawOffset());
        System.out.println(TimeZone.getDefault().toZoneId());
        System.out.println(TimeZone.getTimeZone("000"));
        System.out.println(TimeZone.getAvailableIDs());
        System.out.println(LocalDateTime.now(TimeZone.getDefault().toZoneId()));

    }
}
