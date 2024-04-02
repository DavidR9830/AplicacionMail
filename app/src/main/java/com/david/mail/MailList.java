package com.david.mail;


public class MailList {
    private String name;
    private String mail;
    private String mailNames;
    private int image;

    private  boolean read;

    public MailList(String name, String mail, String mailNames, int image) {
        this.name = name;
        this.mail = mail;
        this.mailNames = mailNames;
        this.image = image;
        this.read = false;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public String getMailNames() {
        return mailNames;
    }

    public void setMailNames(String mailNames) {
        this.mailNames = mailNames;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public boolean isRead() {return read;}

    public void setRead(boolean read) {this.read = read;}



}
