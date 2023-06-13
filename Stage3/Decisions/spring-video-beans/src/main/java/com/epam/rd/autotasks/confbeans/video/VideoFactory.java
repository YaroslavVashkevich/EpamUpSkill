package com.epam.rd.autotasks.confbeans.video;

import java.time.LocalDateTime;

public class VideoFactory {
    private static final String FILM_NAME = "Cat Failure Compilation";
    private int day = 1;


    public Video create() {
        return new Video(FILM_NAME,
                LocalDateTime.of(2020, 10, day++, 10, 10, 10));
    }
}
