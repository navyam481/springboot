package com.example.kafka;

public class Message {
    private String message;
    private String author;

    // Default constructor (needed for deserialization)
    public Message() {}

    // Parameterized constructor
    public Message(String message, String author) {
        this.message = message;
        this.author = author;
    }

    // Getters and Setters
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    @Override
    public String toString() {
        return "Message{message='" + message + "', author='" + author + "'}";
    }
}
