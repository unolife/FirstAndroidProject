package com.project.coding101.my.studentBoard;

public class recycler_item {
    private String title;
    private String writer;
    private String date;

    public recycler_item(String title, String writer, String date){
        this.title = title;
        this.writer = writer;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getWriter() {
        return writer;
    }
}

