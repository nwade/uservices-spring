package com.nwade.uservices.projects;

public class Project {
    private int id;
    private int accountId;
    private String name;

    public Project() {
    }

    public Project(int accountId, String name) { // for rest
        this.accountId = accountId;
        this.name = name;
    }

    public Project(int id, int accountId, String name) { // for jdbc
        this.id = id;
        this.accountId = accountId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getName() {
        return name;
    }
}
