package com.epam.rd.autotasks.confbeans.config;

import com.epam.rd.autotasks.confbeans.video.Channel;
import com.epam.rd.autotasks.confbeans.video.Video;
import com.epam.rd.autotasks.confbeans.video.VideoFactory;
import com.epam.rd.autotasks.confbeans.video.WeeklyVideosChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ChannelWithInjectedPrototypeVideoConfig {


    @Bean
    @Autowired
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    Video video(VideoFactory factory) {
       return factory.create();
    }

    @Bean
    Channel channel() {
        return new WeeklyVideosChannel();
    }

    @Bean
    VideoFactory factory(){
        return new VideoFactory();
    }
}
