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
public class Users {
    private int userID;
    private String username;
    private String name;
    private String email;
    private String password;
    private String role;
    private Date expiredDate;
    private Date createDate;
    private int coins;
    private int phoneNumber;
    private String gender;
    
    // Constructors, getters, and setters go here

    public Users() {
    }

    public Users(int userID, String username, String name, String email, String password, String role, Date expiredDate, Date createDate, int coins, int phoneNumber, String gender) {
        this.userID = userID;
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.expiredDate = expiredDate;
        this.createDate = createDate;
        this.coins = coins;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Users{" + "userID=" + userID + ", username=" + username + ", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role + ", expiredDate=" + expiredDate + ", createDate=" + createDate + ", coins=" + coins + ", phoneNumber=" + phoneNumber + ", gender=" + gender + '}';
    }
    
}

