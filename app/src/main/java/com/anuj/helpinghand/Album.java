package com.anuj.helpinghand;

public class Album {
    private String name,hinnt;
    private int numOfSongs;
    private int thumbnail;

    public Album() {
    }

    public Album(String name, int numOfSongs, int thumbnail,String hint) {
        this.name = name;
        this.numOfSongs = numOfSongs;
        this.thumbnail = thumbnail;
        this.hinnt = hint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfSongs() {
        return numOfSongs;
    }

    public void setNumOfSongs(int numOfSongs) {
        this.numOfSongs = numOfSongs;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getHint(){
        return hinnt;
    }

    public void setHint(String hint){
        this.hinnt = hint;
    }
}
