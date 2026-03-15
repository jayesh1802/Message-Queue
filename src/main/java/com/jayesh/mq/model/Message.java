package com.jayesh.mq.model;

public class Message {
    private String payload;
    private long timestamp;

    public Message(String payload) {
        this.payload = payload;
        this.timestamp = System.nanoTime();
    }

    public String getPayload() {
        return payload;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
