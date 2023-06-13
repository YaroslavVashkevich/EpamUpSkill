package com.epam.rd.autotasks.confbeans.video;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.stream.Stream;

public class WeeklyVideosChannel extends Channel {
    VideoFactory factory;

    @Override
    public Stream<Video> videos() {
        return Stream.generate(this.factory::create).limit(7);
    }

    @Autowired
    public void setFactory(VideoFactory factory) {
        this.factory = factory;
    }
}
