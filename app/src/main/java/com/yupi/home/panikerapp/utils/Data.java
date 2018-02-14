package com.yupi.home.panikerapp.utils;

/**
 * Created by Home on 24.8.2017..
 */

public class Data {
    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public int getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(int profileImage) {
        this.profileImage = profileImage;
    }

    public int getMainImagePost() {
        return mainImagePost;
    }

    public void setMainImagePost(int mainImagePost) {
        this.mainImagePost = mainImagePost;
    }

    public String getMainTextPost() {
        return mainTextPost;
    }

    public void setMainTextPost(String mainTextPost) {
        this.mainTextPost = mainTextPost;
    }
    public int getIsLive() {
        return isLive;
    }

    public void setIsLive(int isLive) {
        this.isLive = isLive;
    }

    private String profileName;
    private int profileImage;
    private int mainImagePost;
    private String mainTextPost;

    private int isLive;
}
