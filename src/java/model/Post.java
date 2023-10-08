/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author OS
 */
public class Post {
    private int postID;
    private int userID;
    private String title;
    private String description;
    private Date createAt;
    
    // Constructors, getters, and setters go here

    public Post() {
    }

    public Post(int postID, int userID, String title, String description, Date createAt) {
        this.postID = postID;
        this.userID = userID;
        this.title = title;
        this.description = description;
        this.createAt = createAt;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "Post{" + "postID=" + postID + ", userID=" + userID + ", title=" + title + ", description=" + description + ", createAt=" + createAt + '}';
    }
    
}

