package org.javaboy.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
//encoding = "UTF-8 自定义配置文件@Value读取中文乱码的解决方案
@PropertySource(value = "classpath:book.properties",encoding = "UTF-8")//项目启动并不会自动的加载该配置文件 需要自己指定 然后项目启动即可自动加载
//@ConfigurationProperties(prefix = "book")//@ConfigurationProperties(prefix = “book”) 注解，并且配置了属性的前缀，此时会自动将 Spring 容器中对应的数据注入到对象对应的属性中，就不用通过 @Value 注解挨个注入了，减少工作量并且避免出错。
@Getter
@Setter
public class Book {

    @Value("${book.id}")
    private Long id;
    @Value("${book.name}")
    private String name;
    @Value("${book.author}")
    private String author;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

}
