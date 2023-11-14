package com.message.repository;

public class Languages {
    private Integer id;
    private String locale;
    private String messageKey;
    private String messageContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    @Override
    public String toString() {
        return "Languages{" +
                "id=" + id +
                ", locale='" + locale + '\'' +
                ", messageKey='" + messageKey + '\'' +
                ", messageContent='" + messageContent + '\'' +
                '}';
    }
}