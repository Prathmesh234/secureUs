package com.prathmeshbhatt.awsimageupload.datastore;
import org.springframework.stereotype.Repository;
import com.prathmeshbhatt.awsimageupload.profile.UserProfile;
import java.util.*;
@Repository
public class FakeUserProfileDataStore {
    private static final List<UserProfile> USER_PROFILES = new ArrayList<>();
    static{
        USER_PROFILES.add(new UserProfile(UUID.fromString("57fee66-adc0-4e01-8197-fce905c3aa41"), "Front View Video", null));
        USER_PROFILES.add(new UserProfile(UUID.fromString("8c9eb1d8-1f98-4ecd-8843-5900ea3fe9df"), "Back View Video", null));
        USER_PROFILES.add(new UserProfile(UUID.fromString("4382bb7f-995b-44ff-8473-ab4bda94b6c2"), "Left Side View", null));
        USER_PROFILES.add(new UserProfile(UUID.fromString("e7260d1f-3389-459e-a3c6-ee826fa85ba9"), "Right Side View", null));



    }
    public List<UserProfile> getUserProfiles(){
        return USER_PROFILES; 
    }
}
