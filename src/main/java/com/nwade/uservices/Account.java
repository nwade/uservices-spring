package com.nwade.uservices;

public class Account {
    private int id;
    private int ownerId;
    private String name;

    public Account() { }

    public Account(int ownerId, String name) {
        this.ownerId = ownerId;
        this.name = name;
    }

    public Account(int id, int ownerId, String name) {
        this.id = id;
        this.ownerId = ownerId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getOwnerId() {
        return ownerId;
    }
}
