package com.example.userapp;

public class UserHelperClass {
    String TVname,TVimgurl,videoUrl;

    public UserHelperClass() {
    }

    public UserHelperClass(String TVname, String TVimgurl, String videoUrl) {
        this.TVname = TVname;
        this.TVimgurl = TVimgurl;
        this.videoUrl = videoUrl;
    }

    public String getTVname() {
        return TVname;
    }

    public void setTVname(String TVname) {
        this.TVname = TVname;
    }

    public String getTVimgurl() {
        return TVimgurl;
    }

    public void setTVimgurl(String TVimgurl) {
        this.TVimgurl = TVimgurl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
