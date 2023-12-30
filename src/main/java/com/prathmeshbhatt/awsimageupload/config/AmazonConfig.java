package com.prathmeshbhatt.awsimageupload.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
@Configuration
public class AmazonConfig{
    @Bean
    public AmazonS3 s3(){
        AWSCredentials awsCredentials = new BasicAWSCredentials("AKIAUAY4POF67VJJJZNM", "LFPduOUgqYFlfxDsmhhGG2C13ZqAMr7RI02YJ+CI");
        return AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
    }
}