package com.eazybytes.eazyschool.models;

public class Holiday {

    private final String day;
    private final String reason;
    private final Type type;

    public Holiday(String day, String reason, Type type) {
        this.day = day;
        this.reason = reason;
        this.type = type;
    }

    public enum Type {
        FESTIVAL, FEDERAL
    }

    public String getReason() {
        return reason;
    }

    public String getDay() {
        return day;
    }

    public Type getType() {
        return type;
    }
}
