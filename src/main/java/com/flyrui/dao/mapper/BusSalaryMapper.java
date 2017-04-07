package com.flyrui.dao.mapper;

import com.flyrui.dao.pojo.salary.BusSalary;
import com.flyrui.dao.pojo.salary.BusSalaryCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BusSalaryMapper {
    int countByExample(BusSalaryCriteria example);

    int deleteByExample(BusSalaryCriteria example);

    int insert(BusSalary record);

    int insertSelective(BusSalary record);

    List<BusSalary> selectByExample(BusSalaryCriteria example);

    int updateByExampleSelective(@Param("record") BusSalary record, @Param("example") BusSalaryCriteria example);

    int updateByExample(@Param("record") BusSalary record, @Param("example") BusSalaryCriteria example);
}