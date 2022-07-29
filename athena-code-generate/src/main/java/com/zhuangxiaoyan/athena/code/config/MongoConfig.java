package com.zhuangxiaoyan.athena.code.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @description MongoConfig
 * @date: 2022/7/29 12:26
 * @author: xjl
 */
@Component
@ConfigurationProperties(prefix = "mongodb")
@Data
public class MongoConfig {

    private String host;

    private int port;

    private String username;

    private String password;

    private String dataBase;

    private boolean auth;

    private String source;

    @Bean
    @Conditional(MongoCondition.class)
    private MongoClient getMongoClient() {
        List<ServerAddress> adds = new ArrayList<>();
        ServerAddress serverAddress = new ServerAddress(this.host, this.port);
        adds.add(serverAddress);
        if (this.auth) {
            MongoCredential mongoCredential = MongoCredential.
                    createScramSha1Credential(this.username, this.source, this.password.toCharArray());
            MongoClientOptions mongoClientOptions = MongoClientOptions.builder().build();
            return new MongoClient(adds, mongoCredential, mongoClientOptions);
        }
        return new MongoClient(adds);
    }

    @Bean
    @Conditional(MongoCondition.class)
    public MongoDatabase getDataBase() {
        return getMongoClient().getDatabase(dataBase);
    }
}
