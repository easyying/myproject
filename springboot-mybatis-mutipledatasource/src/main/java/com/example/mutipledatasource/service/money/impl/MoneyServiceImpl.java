package com.example.mutipledatasource.service.money.impl;

import com.example.mutipledatasource.bean.Money;
import com.example.mutipledatasource.dao.db2mapper.MoneyMapper;
import com.example.mutipledatasource.service.money.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoneyServiceImpl implements MoneyService {
    @Autowired
    private MoneyMapper moneyMapper;

    /**
     * 根据名字查找用户
     */
    @Override
    public Money selectMoneyById(int id) {
        return moneyMapper.findMoneyById(id);
    }
}
