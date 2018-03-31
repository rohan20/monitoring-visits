package com.rohantaneja.monitoringvisits.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ralph on 30/03/18.
 */

public class User {

    @SerializedName("oid")
    private int id;
    private String name;
    @SerializedName("emailId")
    private String email;
    @SerializedName("tokenId")
    private String token;
    private String adminRights;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isAdmin(){
        return (adminRights != null && adminRights.toUpperCase().equals("YES"));
    }

}
