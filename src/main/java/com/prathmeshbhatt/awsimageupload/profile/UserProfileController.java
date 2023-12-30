package com.prathmeshbhatt.awsimageupload.profile;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import org.springframework.web.multipart.MultipartFile;
@RestController
@RequestMapping("api/v1/user-profile")
//do not deploy this as it allows anyone to access our backend 
@CrossOrigin("*")
public class UserProfileController {
    private final UserProfileService userProfileService;
    @Autowired
    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }
    @GetMapping
    public List<UserProfile> getUserProfiles(){
        return userProfileService.getUserProfiles();
    }
    @PostMapping(
        path="{userProfileId}/image/upload", 
        consumes=MediaType.MULTIPART_FORM_DATA_VALUE, 
        produces = MediaType.APPLICATION_JSON_VALUE

    )
    public void uploadUserProfileImage(@PathVariable("userProfileId") UUID userProfileId, @RequestParam("file") MultipartFile file){
        userProfileService.uploadUserProfileImage(userProfileId, file);
    }
    @GetMapping("{userProfileId}/image/download")
    public byte[] downloadUserProfileImage(@PathVariable("userProfileId") UUID userProfileId){
       return userProfileService.downloadUserProfileImage(userProfileId); 
    }
    
}
