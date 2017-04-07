package com.flyrui.dao.common;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;

public class BaseDAO extends SqlSessionTemplate
{
    public BaseDAO(SqlSessionFactory sqlSessionFactory){
        super(sqlSessionFactory);
    }
    
    public BaseDAO(SqlSessionFactory sqlSessionFactory,ExecutorType executorType){
        super(sqlSessionFactory,executorType);
    }
    
}
