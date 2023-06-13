package com.epam.rd.autotasks.confbeans.video;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Channel {

    private List<Video> videos = new ArrayList<>();

    public void addVideo(Video video) {
        videos.add(video);
    }

    public Stream<Video> videos() {
        return videos.stream();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Channel channel = (Channel) o;

        return videos.equals(channel.videos);
    }

    @Override
    public int hashCode() {
        return videos.hashCode();
    }
}
