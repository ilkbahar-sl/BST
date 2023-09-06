/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project2_trial;

/**
 *
 * @author sulei
 */
public class Song {
    String songName;
    String artist;
    int  ID;
    String genre;
    String year;
    Song left;
    Song right;

    public Song(int ıd) {
        this.ID = ıd;
    }

    public Song(String songName, String artist,int ID, String genre, String year) {
        this.songName = songName;
        this.artist = artist;
        this.ID = ID;
        this.genre = genre;
        this.year = year;
        left =null;
        right = null;
    }
    public String toString(){
    String str = "";
    return str = " Song name :" + this.songName + " Artist :" + this.artist + " ID : " + this.ID +" genre : " + this.genre + "  year : " + this.year;
    }
}
