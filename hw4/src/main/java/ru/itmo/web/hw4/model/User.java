package ru.itmo.web.hw4.model;

public class User {
    private final long id;
    private final String handle;
    private final String name;
    private final long postsCount;
    private final Color color;

    public enum Color {
        RED, GREEN, BLUE, YARA
    }

    public User(long id, String handle, String name, long postsCount, Color color) {
        this.id = id;
        this.handle = handle;
        this.name = name;
        this.postsCount = postsCount;
        this.color = color;
    }

    public long getId() {
        return id;
    }

    public String getHandle() {
        return handle;
    }

    public String getName() {
        return name;
    }

    public long getPostsCount() {
        return postsCount;
    }

    public Color getColor() {
        return color;
    }
}
