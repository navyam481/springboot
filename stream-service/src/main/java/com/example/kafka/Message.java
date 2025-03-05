package com.example.kafka;

public class Message {
    private String message;
    private String author;

    public Message() {} // Default constructor

    public Message(String message, String author) {
        this.message = message;
        this.author = author;
    }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    @Override
    public String toString() {
        return "Message{message='" + message + "', author='" + author + "'}";
    }
}

