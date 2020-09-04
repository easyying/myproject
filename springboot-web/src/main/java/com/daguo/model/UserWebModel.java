package com.daguo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author
 * 持久层框架：jpa
 */
@Getter
@Setter
@Entity
public class UserWebModel {

    //@Id 标注用于声明一个实体类的属性映射为数据库的主键列
    //@GeneratedValue用于标注主键的生成策略，通过strategy 属性指定。默认情况下，JPA 自动选择一个最适合底层数据库的主键生成策略：SqlServer对应identity，MySQL 对应 auto increment
    @Id
    @GeneratedValue
    private Long id;

    //nullable=false是这个字段在保存时必需有值，不能还是null值就调用save去保存入库;
    //unique=true是指这个字段的值在这张表里不能重复，所有记录值都要唯一，就像主键那样;
    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private  String passWord;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String nickName;

    @Column(nullable = false)
    private String regTime;

    public UserWebModel(){
        super();
    }

    public UserWebModel(String nickName,String email,String userName,  String passWord, String regTime){
        super();

        this.email = email;
        this.nickName = nickName;
        this.passWord = passWord;
        this.userName = userName;
        this.regTime = regTime;
    }



}
