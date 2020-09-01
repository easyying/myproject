package com.example.myproject.dao;

import com.example.myproject.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author
 */
@Mapper
public interface UserDaoMapper {
    /**
     * 通过名字查询用户信息
     */
    //@Select("SELECT * FROM user WHERE name = #{name}")
    User findUserByName(String name);

    User selectUser(String name ,int age);
    User selectUser2(@Param("namepa") String name ,@Param("agepa") int age);

}
