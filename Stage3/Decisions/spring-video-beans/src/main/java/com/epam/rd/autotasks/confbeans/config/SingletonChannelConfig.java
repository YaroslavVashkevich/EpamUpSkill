package com.epam.rd.autotasks.confbeans.config;

import com.epam.rd.autotasks.confbeans.video.Channel;
import com.epam.rd.autotasks.confbeans.video.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class SingletonChannelConfig {
    @Bean
    Video video1() {
        return new Video(
                "How to boil water",
                LocalDateTime.of(2020, 10, 10, 10, 10));
    }


    @Bean
    Video howToBoilWaterVideo() {
        return new Video("How to boil water", LocalDateTime.of(2020, 10, 10, 10, 10));
    }


    @Bean
    Video howToBuildAHouse() {
        return new Video("How to build a house", LocalDateTime.of(2020, 10, 10, 10, 11));
    }

    @Bean
    Video howToEscapeSolitude() {
        return new Video("How to escape solitude", LocalDateTime.of(2020, 10, 10, 10, 12));
    }

    @Bean
    @Autowired
    Channel channel(List<Video> videoList) {
        Channel channel = new Channel();
        videoList.forEach(channel::addVideo);
        return channel;
    }
}
