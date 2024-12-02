package com.hometask2930;

public class RequestBody {
    private String title;
    private String body;
    private int userid;

    public RequestBody(String title, String body, int userid) {
        this.title = title;
        this.body = body;
        this.userid = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    

    
}
