/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

public class Manga {
     public int mangaID;
     public String title, description;
     public int userID;
     public Date createAt;
     public boolean isCopyRight, isFree;

    public Manga() {
    }
    public Manga(int mangaID, String title, String description, int userID, Date createAt, boolean isCopyRight, boolean isFree) {
        this.mangaID = mangaID;
        this.title = title;
        this.description = description;
        this.userID = userID;
        this.createAt = createAt;
        this.isCopyRight = isCopyRight;
        this.isFree = isFree;
    }
    

    public int getMangaID() {
        return mangaID;
    }

    public void setMangaID(int mangaID) {
        this.mangaID = mangaID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public boolean isIsCopyRight() {
        return isCopyRight;
    }

    public void setIsCopyRight(boolean isCopyRight) {
        this.isCopyRight = isCopyRight;
    }

    public boolean isIsFree() {
        return isFree;
    }

    public void setIsFree(boolean isFree) {
        this.isFree = isFree;
    }

    @Override
    public String toString() {
        return "manga{" + "mangaID=" + mangaID + ", title=" + title + ", description=" + description + ", userID=" + userID + ", createAt=" + createAt + ", isCopyRight=" + isCopyRight + ", isFree=" + isFree + '}';
    }


}
