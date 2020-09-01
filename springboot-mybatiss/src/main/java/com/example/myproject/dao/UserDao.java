package com.example.myproject.dao;

import com.example.myproject.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author
 */
@Mapper
public interface UserDao {

    /**
     * 查询所有用户信息
     */
    @Select("SELECT * FROM userspringboot")
    List<User> findAllUser();


    /**
     * 插入用户信息
     */
    @Insert("INSERT INTO userspringboot(name, age,money) VALUES(#{name}, #{age}, #{money})")
    void insertUser(@Param("name") String name, @Param("age") Integer age, @Param("money") Double money);

    /**
     * 根据 id 更新用户信息
     */
    @Update("UPDATE  userspringboot SET name = #{name},age = #{age},money= #{money} WHERE id = #{id}")
    void updateUser(@Param("name") String name, @Param("age") Integer age, @Param("money") Double money,
                    @Param("id") int id);

    /**
     * 根据 id 删除用户信息
     */
    @Delete("DELETE from userspringboot WHERE id = #{id}")
    void deleteUser(@Param("id") int id);
}
