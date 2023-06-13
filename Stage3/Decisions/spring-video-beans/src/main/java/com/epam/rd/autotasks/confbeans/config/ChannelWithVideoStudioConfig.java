package com.epam.rd.autotasks.confbeans.config;

import com.epam.rd.autotasks.confbeans.video.Channel;
import com.epam.rd.autotasks.confbeans.video.Video;
import com.epam.rd.autotasks.confbeans.video.VideoStudio;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class ChannelWithVideoStudioConfig {
    @Bean
    VideoStudio videoStudio() {
        return getVideoStudio();
    }

    private VideoStudio getVideoStudio() {
        return new VideoStudio() {
            static final String FILM_NAME = "Cat & Curious";
            int sequel = 0;

            @Override
            public Video produce() {
                return new Video(FILM_NAME + " " + (++sequel),
                        LocalDateTime.of(2001 + ((sequel - 1) * 2), 10, 18, 10, 0));
            }
        };
    }

    @Bean
    Channel channel(VideoStudio studio) {
        Channel channel = new Channel();
        for (int i = 0; i < 8; i++) {
            channel.addVideo(studio.produce());
        }
        return channel;
    }
}
