package org.javaboy.properties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@PropertySource(value = "classpath:library.properties",encoding = "UTF-8")
@ConfigurationProperties(prefix = "library")
@ToString
@Data
public class Library {

    String location;
    List<Tushu> tushus;//list配置读取
}
