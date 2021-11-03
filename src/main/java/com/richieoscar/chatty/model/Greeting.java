package com.richieoscar.chatty.model;

public class Greeting {
    private String greetMessage;
    private String userName;

    public Greeting(String greetMessage, String userName) {
        this.greetMessage = greetMessage;
        this.userName = userName;
    }

    public String getGreetMessage() {
        return greetMessage;
    }

    public void setGreetMessage(String greetMessage) {
        this.greetMessage = greetMessage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "greetMessage='" + greetMessage + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
