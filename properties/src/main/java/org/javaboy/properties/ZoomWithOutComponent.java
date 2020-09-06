package org.javaboy.properties;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@Data
@ToString
@PropertySource(value = "classpath:zoom.properties",encoding = "UTF-8")
@ConfigurationProperties(value = "zoom")
public class ZoomWithOutComponent {
    String name;
    Integer num;
}
