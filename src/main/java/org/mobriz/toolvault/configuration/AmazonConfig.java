package org.mobriz.toolvault.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;

import java.net.URI;

@Configuration
@EnableJpaRepositories(basePackages = "org.mobriz.toolvault.repository")
@EntityScan({"org.mobriz.toolvault"})
public class AmazonConfig {
    @Value("${amazon.dynamodb.endpoint}")
    private String awsDynamoDBEndpoint;

    @Value("${aws.region}")
    private String amazonRegion;


    @Bean
    public DynamoDbAsyncClient dynamoDbAsyncClient() {
//        ProfileCredentialsProvider.builder().build()
        return DynamoDbAsyncClient.builder()
                .credentialsProvider(ProfileCredentialsProvider.builder().build())
                .endpointOverride(URI.create(awsDynamoDBEndpoint))
                .region(Region.of(amazonRegion))
                .build();
    }

    @Bean
    public DynamoDbEnhancedAsyncClient dynamoDbEnhancedAsyncClient() {
        return DynamoDbEnhancedAsyncClient.builder()
                .dynamoDbClient(dynamoDbAsyncClient())
                .build();
    }
}
