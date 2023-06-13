package com.epam.rd.autotasks.confbeans.config;

import com.epam.rd.autotasks.confbeans.video.Channel;
import com.epam.rd.autotasks.confbeans.video.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDateTime;

@Configuration
public class ChannelWithPhantomVideoStudioConfig {
    private int sequel = 0;
    private static final String FILM_NAME = "Cat & Curious";

    @Bean
    @Autowired
    @Scope("prototype")
    Video video(Channel channel) {
        return new Video(FILM_NAME + " " + (++sequel),
                LocalDateTime.of(2001 + ((sequel - 1) * 2), 10, 18, 10, 0));
    }

    @Bean
    Channel channel() {
        Channel channel = new Channel();
        for (int i = 0; i < 8; i++) {
            channel.addVideo(video(channel));
        }
        return channel;
    }
}
