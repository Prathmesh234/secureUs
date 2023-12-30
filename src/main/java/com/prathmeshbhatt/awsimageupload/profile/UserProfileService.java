package com.prathmeshbhatt.awsimageupload.profile;

import java.io.IOException;
import java.util.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prathmeshbhatt.awsimageupload.bucket.BucketName;
import com.prathmeshbhatt.awsimageupload.fileStore.*;
@Service
public class UserProfileService {
    private final UserProfileDataAccessDataService userProfileDataAccessDataService; 
    private final FileStore fileStore; 
    @Autowired
    public UserProfileService (UserProfileDataAccessDataService userProfileDataAccessDataService, FileStore fileStore) {
        this.userProfileDataAccessDataService = userProfileDataAccessDataService;
        this.fileStore = fileStore;
    }
     List<UserProfile> getUserProfiles(){
        return userProfileDataAccessDataService.getUserProfiles();
    }
    public byte[] downloadUserProfileImage(UUID userProfileId){
    UserProfile user =  userProfileDataAccessDataService.getUserProfiles().stream().filter(userProfile-> userProfile.getUserProfileId().equals(userProfileId)).findFirst().orElseThrow(() -> new IllegalStateException(String.format("User profile %s not found", userProfileId)));
    String path  = String.format("%s/%s", BucketName.PROFILE_IMAGE.getBucketName(), user.getUserProfileId());
    return user.getUserProfileImageLink().map(key -> fileStore.download(path, key)).orElse(new byte[0]);
    }
    public void uploadUserProfileImage(UUID userProfileId, MultipartFile file){
        //1 - check if the image is not empty 
        if(file.isEmpty()){
            throw new IllegalStateException("Cannot upload the empty file [" + file.getSize() + "]");
        }
//2 - check if the file is an image(in the future you can change this as you might have to add a video)
        if(!Arrays.asList(ContentType.IMAGE_JPEG.getMimeType(), ContentType.IMAGE_PNG.getMimeType(), ContentType.IMAGE_GIF.getMimeType()).contains(file.getContentType())){
           throw new IllegalStateException("File must be an image + [" + file.getContentType() + "]");

        }
        //3 - Check if the user exists in the database
        //the stream function here is really powerful, check it out. 
       UserProfile user =  userProfileDataAccessDataService.getUserProfiles().stream().filter(userProfile-> userProfile.getUserProfileId().equals(userProfileId)).findFirst().orElseThrow(() -> new IllegalStateException(String.format("User profile %s not found", userProfileId)));
        //4 - grab some metadata from file if any 
        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content Type", file.getContentType()); 
        metadata.put("Content Length", String.valueOf(file.getSize())); 
        //5- Store image in s3 and update the database  {userProfileImageLink} s3 with a new link
        String path  = String.format("%s/%s", BucketName.PROFILE_IMAGE.getBucketName(), user.getUserProfileId());
        String filename  = String.format("%s-%s", file.getOriginalFilename(), UUID.randomUUID());
        try{
            fileStore.save(path, filename, Optional.of(metadata), file.getInputStream());
            user.setUserProfileImageLink(filename); 
        }catch(IOException e){
            throw new IllegalStateException(e); 
        }
    }
}
