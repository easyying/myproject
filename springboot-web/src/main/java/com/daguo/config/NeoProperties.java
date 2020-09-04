package com.daguo.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 自定义配置类
 */
@Component
@Setter
@Getter
public class NeoProperties {
    @Value("${com.daguo.title}")
    private String title;

    @Value("${com.daguo.discription}")
    private String discription;

}
