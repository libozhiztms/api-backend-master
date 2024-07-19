package com.lilibozhi.apiclientsdk;

import com.lilibozhi.apiclientsdk.client.LiApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("liapi.client")
@Data
@ComponentScan
public class LiApiClientConfig {
    private String accessKey;
    private String secretKey;

    @Bean
    public LiApiClient liApiClient(){
        return new LiApiClient(accessKey,secretKey);
    }
}
