package com.flyrui.dao.mapper;

import com.flyrui.dao.pojo.bus.BusRule;
import com.flyrui.dao.pojo.bus.BusRuleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BusRuleMapper {
    int countByExample(BusRuleCriteria example);

    int deleteByExample(BusRuleCriteria example);

    int insert(BusRule record);

    int insertSelective(BusRule record);

    List<BusRule> selectByExample(BusRuleCriteria example);

    int updateByExampleSelective(@Param("record") BusRule record, @Param("example") BusRuleCriteria example);

    int updateByExample(@Param("record") BusRule record, @Param("example") BusRuleCriteria example);
}