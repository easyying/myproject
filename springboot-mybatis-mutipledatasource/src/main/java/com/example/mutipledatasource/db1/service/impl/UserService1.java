package com.example.mutipledatasource.db1.service.impl;

import com.example.mutipledatasource.bean.User;
import com.example.mutipledatasource.db1.dao.UserDao1;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserService1 {

    User selectUserByName(String name);
}
