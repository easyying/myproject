package com.example.mutipledatasource.db1.dao;

import com.example.mutipledatasource.bean.Money;
import com.example.mutipledatasource.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;

@Mapper
@Qualifier("db1SqlSessionTemplate")
public interface UserDao1 {
    /**
     * 通过名字查询用户信息
     */
    @Select("SELECT * FROM userspringboot WHERE name = #{name}")
    User findUserByName(String name);
}
