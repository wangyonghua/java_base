package com.company;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * Created by wangyonghua on 2017/9/1.
 */
public class InstantDemo {
    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime localDateTime = LocalDateTime.now();
        //2017-09-02T11:22:08.687
        System.out.println(localDateTime);
        String s1 = localDateTime.format(dateTimeFormatter);
        //2017-09-02 11:22:08
        System.out.println(s1);
        //Asia/Shanghai
        System.out.println(ZoneId.systemDefault());
        Instant instantdemo = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        //2017-09-02 03:22:08
        System.out.println(instantdemo.atOffset(ZoneOffset.UTC).format(dateTimeFormatter));

        Instant instant = Instant.now();
        //2017-09-02T03:22:08.703Z
        System.out.println(instant);

        OffsetDateTime instant1 = Instant.now().atOffset(ZoneOffset.UTC);

        //2017-09-02T03:22:08.703Z
        System.out.println(">>>>>" + instant1.toInstant());
        instant1.format(dateTimeFormatter);

        ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("UTC"));

        //2017-09-02T11:22:08.703Z[UTC]
        System.out.println(zonedDateTime);
        //2017-09-02 11:22:08
        System.out.println(zonedDateTime.format(dateTimeFormatter));
        //2017-09-02T11:22:08.703Z
        System.out.println(zonedDateTime.toInstant());

        ZonedDateTime zonedDateTime1 = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("UTC+1"));
        //2017-09-02T11:22:08.703+01:00[UTC+01:00]
        System.out.println(zonedDateTime1);

        ZonedDateTime zonedDateTime2 = ZonedDateTime.now();
        //2017-09-02T11:22:08.703+08:00[Asia/Shanghai]
        System.out.println(zonedDateTime2);


        String s = instant1.format(dateTimeFormatter);
        //2017-09-02 03:22:08
        System.out.println(s);

    }
}
