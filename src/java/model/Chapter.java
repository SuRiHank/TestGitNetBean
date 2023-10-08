/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Chapter {
    public int chapterID;
    public String title, imageID, description;
    public int mangaID;

    public Chapter() {
    }

    public Chapter(int chapterID, String title, String imageID, String description, int mangaID) {
        this.chapterID = chapterID;
        this.title = title;
        this.imageID = imageID;
        this.description = description;
        this.mangaID = mangaID;
    }

    public int getChapterID() {
        return chapterID;
    }

    public void setChapterID(int chapterID) {
        this.chapterID = chapterID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageID() {
        return imageID;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMangaID() {
        return mangaID;
    }

    public void setMangaID(int mangaID) {
        this.mangaID = mangaID;
    }

    @Override
    public String toString() {
        return "Chapter{" + "chapterID=" + chapterID + ", title=" + title + ", imageID=" + imageID + ", description=" + description + ", mangaID=" + mangaID + '}';
    }
    
}
