package com.daguo.dao;

import com.daguo.model.UserWebModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * @author
 * dao 只要继承 JpaRepository 类就可以，几乎可以不用写方法，
 * 还有一个特别有尿性的功能非常赞，就是可以根据方法名(如果命名规范的话)来自动的生成 SQL，
 * 比如findByUserName 会自动生成一个以 userName 为参数的查询方法，比如 findAlll 自动会查询表里面的所有数据，比如自动分页等等。。
 * JpaRepository 中自带了一些基本的增删改查方法
 */


public interface UserWebDao extends JpaRepository<UserWebModel,Long>{
    //会自动生成一个以 userName 为参数的查询方法
    UserWebModel findByUserName(String userName);

    UserWebModel findByUserNameOrEmail(String userName,String email);
}
