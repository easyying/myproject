package com.example.mutipledatasource.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

//表示这个类为一个配置类
@Configuration
// 配置mybatis的接口类放的地方
@MapperScan(basePackages = "com.example.mutipledatasource.dao.db1", sqlSessionTemplateRef = "db1SqlSessionTemplate")
public class DataSource1Config {

    /**
     * 生成数据源.  @Primary 注解声明为默认数据源 定义数据源
     */
    // 将这个对象放入Spring容器中
    @Bean(name = "db1DataSource")//等价于spring的xml配置文件中的<bean>，作用为：注册bean对象
    // 读取application.properties中的配置参数映射成为一个对象
    @ConfigurationProperties(prefix = "spring.datasource.hikari.db1")
    // 表示这个数据源是默认数据源 在 springboot 2.x 之前，需要使用注解 @primary 指定主库，否则会报错。 ，因为不加的话spring将分不清楚那个为主数据源（默认数据源）
    @Primary
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 创建 SqlSessionFactory
     */
    @Bean(name = "db1SqlSessionFactory")
    @Primary
    // @Qualifier表示查找Spring容器中名字为db1DataSource的对象
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("db1DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //因为是注解dao，不是mapper
        //设置mybatis的xml所在位置
        //  bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/db1/*.xml"));
        return bean.getObject();
    }

    /**
     * 配置事务管理
     */
    @Bean(name = "db1TransactionManager")
    @Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("db1DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "db1SqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("db1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
