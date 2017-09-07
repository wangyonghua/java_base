package com.company;

import java.time.*;
import java.util.Calendar;
import java.util.Date;

public class InstantExample1 {

    public static void main(String[] argv) {

        // Parse a ISO 8601 Date directly
        //Instant instant = Instant.parse("2016-08-18T06:17:10.225Z");

        ZonedDateTime zdt1 = ZonedDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
        System.out.println(zdt1);

        ZonedDateTime zdt = ZonedDateTime.now();
        System.out.println(zdt);
        System.out.println(">>>>" + zdt.toInstant());

        System.out.println(new Date());
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 8);
        cal.set(Calendar.MINUTE, 30);
        Date startTime = cal.getTime();
        System.out.println(startTime);
        Instant i1 = startTime.toInstant();
        System.out.println(i1);

        long d = new Date().getTime();
        System.out.println(d);
        Instant ins = Instant.ofEpochMilli(d);
        System.out.println(ins);
        System.out.println(ins.getEpochSecond() * 1000);
        Instant instant = Instant.now();

        System.out.println("Instant : " + instant);

        //Convert instant to LocalDateTime, no timezone, add a zero offset / UTC+0
        LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneOffset.systemDefault());

        System.out.println("LocalDateTime : " + ldt);

        LocalDateTime dt = LocalDateTime.now();
        Instant instant1 = dt.atZone(ZoneId.systemDefault()).toInstant();
        System.out.println(dt);
        System.out.println(instant1);

        LocalDate date = LocalDate.now();
        Instant i = date.atStartOfDay(ZoneId.systemDefault()).toInstant();
        System.out.println(i);

    }

}