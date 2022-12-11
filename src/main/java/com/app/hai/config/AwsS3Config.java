package com.app.hai.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// import com.amazonaws.auth.AWSStaticCredentialsProvider;
// import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class AwsS3Config {
    @Value("${cloud.aws.credentials.access-key}")
    private String accessKey;

    @Value("${cloud.aws.credentials.secret-key}")
    private String secretKey;

    @Value("${cloud.aws.region.static}")
    private String region;

    private String endPoint="http://localhost:4566";

    @Bean
    public AmazonS3 awsS3ConfigUpload() {
        System.out.println("Access Key- " + accessKey + " secretkey- " + secretKey + " endpoint- " + endPoint
                + " region- " + region);
        return AmazonS3ClientBuilder.standard()
                .withEndpointConfiguration(
                        new EndpointConfiguration(endPoint, region))
                .withPathStyleAccessEnabled(true)
                .build();
    }
}
