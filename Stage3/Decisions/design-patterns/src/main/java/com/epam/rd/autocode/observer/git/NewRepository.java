package com.epam.rd.autocode.observer.git;

import java.util.ArrayList;
import java.util.List;

public class NewRepository implements Repository {
    private List<WebHook> webHooks = new ArrayList<>();
    private List<Commit> commits;
    private List<Commit> commitsMaster = new ArrayList<>();
    private List<Commit> commitsOther = new ArrayList<>();
    private Event.Type type;
    private final String BRANCH = "master";

    @Override
    public void addWebHook(WebHook webHook) {
        webHooks.add(webHook);
    }

    public void info(String branch) {
        if (webHooks != null) {
            for (WebHook s : webHooks) {
                if (s.branch() == branch && s.getClass() == WebHookCommit.class) {
                    s.onEvent(new Event(type, branch, commits));
                }
            }
        }
    }

    @Override
    public Commit commit(String branch, String author, String[] changes) {
        type = Event.Type.COMMIT;
        commits = new ArrayList<>();
        commits.add(new Commit(author, changes));
        info(branch);
        if (!webHooks.isEmpty() && branch == BRANCH) {
            commitsMaster.add(new Commit(author, changes));
        }
        if (!webHooks.isEmpty() && branch != BRANCH) {
            commitsOther.add(new Commit(author, changes));
        }
        return null;
    }

    @Override
    public void merge(String sourceBranch, String targetBranch) {
        if (targetBranch == BRANCH) {
            if (webHooks != null) {
                for (WebHook s : webHooks) {
                    if (s.branch() == targetBranch && s.getClass() != WebHookCommit.class) {
                        s.onEvent(new Event(type, "branch", commitsOther));
                    } else if (s.branch() == sourceBranch && s.getClass() != WebHookCommit.class) {
                        s.onEvent(new Event(type, "branch", commitsMaster));
                    }
                }
            }
        }
    }
}


