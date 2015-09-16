package com.nwade.uservices.models;

public class Story {
    private int id;
    private int projectId;
    private String name;

    public Story() { }

    public Story(int projectId, String name) {
        this.projectId = projectId;
        this.name = name;
    }

    public Story(int id, int projectId, String name) {
        this.id = id;
        this.projectId = projectId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getProjectId() {
        return projectId;
    }

    public String getName() {
        return name;
    }
}
