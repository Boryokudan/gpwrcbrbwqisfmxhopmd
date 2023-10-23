package greetgo.kz.gpwrcbrbwqisfmxhopmd.mongo.config;

import greetgo.kz.gpwrcbrbwqisfmxhopmd.mongo.util.LocalDateReadConverter;
import greetgo.kz.gpwrcbrbwqisfmxhopmd.mongo.util.LocalDateWriteConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.util.Arrays;

@Configuration
public class MongoConfig {

    @Bean
    public MongoCustomConversions customConversions() {
        return new MongoCustomConversions(
                Arrays.asList(new LocalDateReadConverter(), new LocalDateWriteConverter()));
    }
}
