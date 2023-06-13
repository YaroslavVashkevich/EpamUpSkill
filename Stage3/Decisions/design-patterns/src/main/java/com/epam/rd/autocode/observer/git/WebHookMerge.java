package com.epam.rd.autocode.observer.git;

import java.util.ArrayList;
import java.util.List;

public class WebHookMerge implements WebHook {
    private String branchName;
    private List<Event> events;
    private Event.Type type;

    public WebHookMerge(String branchName) {
        this.branchName = branchName;
    }

    @Override
    public String branch() {
        return branchName;
    }

    @Override
    public Event.Type type() {
        return type;
    }

    @Override
    public List<Event> caughtEvents() {
        if (events != null) {
            return events;
        } else {
            events = new ArrayList();
            return events;
        }
    }

    @Override
    public void onEvent(Event event) {
        if (events == null) {
            events = new ArrayList();
            events.add(event);
        }
    }
}
