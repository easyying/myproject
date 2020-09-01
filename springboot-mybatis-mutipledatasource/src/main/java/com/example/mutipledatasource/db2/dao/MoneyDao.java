package com.example.mutipledatasource.db2.dao;

import com.example.mutipledatasource.bean.Money;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Qualifier;

@Mapper
@Qualifier("db2SqlSessionTemplate")
public interface MoneyDao {

    @Select("SELECT * FROM moneyspringboot WHERE id = #{id}")
    Money findMoneyById(@Param("id") int id);
}
