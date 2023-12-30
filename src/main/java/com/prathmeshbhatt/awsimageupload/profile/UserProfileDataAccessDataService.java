package com.prathmeshbhatt.awsimageupload.profile;
import com.prathmeshbhatt.awsimageupload.datastore.FakeUserProfileDataStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public class UserProfileDataAccessDataService {
    
    private final FakeUserProfileDataStore fakeUserProfileDataStore; 
    @Autowired
    public UserProfileDataAccessDataService(FakeUserProfileDataStore fakeUserProfileDataStore) {
        this.fakeUserProfileDataStore = fakeUserProfileDataStore;
    }
    List<UserProfile> getUserProfiles(){
        return fakeUserProfileDataStore.getUserProfiles();
    }
}
