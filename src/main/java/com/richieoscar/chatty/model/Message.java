package com.richieoscar.chatty.model;

public class Message {

    private String content;
    private String userName;

    public Message(String content, String userName) {
        this.content = content;
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Message{" +
                "content='" + content + '\'' +
                '}';
    }
}
