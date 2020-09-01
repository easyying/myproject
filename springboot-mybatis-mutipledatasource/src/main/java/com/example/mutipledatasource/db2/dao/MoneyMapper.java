package com.example.mutipledatasource.db2.dao;

import com.example.mutipledatasource.bean.Money;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;

@Mapper
@Qualifier("db2SqlSessionTemplate")
public interface MoneyMapper {
    Money findMoneyById(int id);
}
