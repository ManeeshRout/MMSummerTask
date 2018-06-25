package com.example.hp.mondaymorning;

public class ListItem {
    private String editors;
    private String title;
    private int views;
    private String date;
    private String imageurl;

    public ListItem(String editors, String title, int views, String date,String imageurl) {
        this.editors = editors;
        this.title = title;
        this.views = views;
        this.date = date;
        this.imageurl=imageurl;
    }



    public String getEditors() {
        return editors;
    }

    public String getTitle() {
        return title;
    }

    public int getViews() {
        return views;
    }

    public String getDate() {
        return date;
    }
    public String getImageurl()
    {
        return imageurl;
    }
}
