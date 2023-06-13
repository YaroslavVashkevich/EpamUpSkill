package com.epam.rd.autocode.observer.git;

public class GitRepoObservers {
    public static Repository newRepository() {
        return new NewRepository();
    }

    public static WebHook mergeToBranchWebHook(String branchName) {
        return new WebHookMerge(branchName);
    }

    public static WebHook commitToBranchWebHook(String branchName) {
        return new WebHookCommit(branchName);
    }
}
