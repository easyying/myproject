package com.example.myproject.service.impl;

import com.example.myproject.bean.User;
import com.example.myproject.dao.UserDao;
import com.example.myproject.dao.UserDaoMapper;
import com.example.myproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserDaoMapper userDaomapper;

    /**
     * 根据名字查找用户   mapper
     */
    @Override
    public User selectUserByName(String name) {
        return userDaomapper.findUserByName(name);
    }
    /**
     *    mapper
     */
    @Override
    public User selectUser(String name, int age) {
        return userDaomapper.selectUser(name,age);
    }
    @Override
    public User selectUser2(String name, int age) {
        return userDaomapper.selectUser2(name,age);
    }



    /**
     * 注解
     * 查找所有用户
     */
    @Override
    public List<User> selectAllUser() {
        return userDao.findAllUser();
    }

    /**
     * 插入两个用户
     */
    @Override
    @Transactional
    public void insertService() {
        userDao.insertUser("SnailClimb", 22, 3000.0);
        userDao.insertUser("Daisy", 19, 3000.0);
    }

    /**
     * 根据id 删除用户
     */
    @Override
    public void deleteService(int id) {
        userDao.deleteUser(id);
    }

    /**
     * 模拟事务。由于加上了 @Transactional注解，如果转账中途出了意外 SnailClimb 和 Daisy 的钱都不会改变。
     */
    @Override
    @Transactional
    public void changemoney() {
        userDao.updateUser("SnailClimb", 22, 2000.0, 3);
        // 模拟转账过程中可能遇到的意外状况
        int temp = 1 / 0;
        userDao.updateUser("Daisy", 19, 4000.0, 4);
    }
}
