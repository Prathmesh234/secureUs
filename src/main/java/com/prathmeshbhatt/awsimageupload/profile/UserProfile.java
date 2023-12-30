package com.prathmeshbhatt.awsimageupload.profile;
import java.util.*;
public class UserProfile {
    private UUID userProfileId; 
    private String username; 
    private String userProfileImageLink;  //s3 key

    // Parameterized constructor
    public UserProfile(UUID userProfileId, String username, String userProfileImageLink) {
        this.userProfileId = userProfileId;
        this.username = username;
        this.userProfileImageLink = userProfileImageLink;
    }

    // Getter for userProfileId
    public UUID getUserProfileId() {
        return userProfileId;
    }

    // Setter for userProfileId
    public void setUserProfileId(UUID userProfileId) {
        this.userProfileId = userProfileId;
    }

    // Getter for username
    public String getUsername() {
        return username;
    }

    // Setter for username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter for userProfileImageLink
    public Optional<String> getUserProfileImageLink() {
        return Optional.ofNullable(userProfileImageLink);
    }

    // Setter for userProfileImageLink
    public void setUserProfileImageLink(String userProfileImageLink) {
        this.userProfileImageLink = userProfileImageLink;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        UserProfile that = (UserProfile) obj;
        return Objects.equals(userProfileId, that.userProfileId) &&
                Objects.equals(username, that.username) &&
                Objects.equals(userProfileImageLink, that.userProfileImageLink);
    }
    @Override
    public int hashCode(){
        return Objects.hash(userProfileId, username, userProfileImageLink);
    }

}
