package com.flyrui.dao.mapper;

import com.flyrui.dao.pojo.bus.BusTemplateItem;
import com.flyrui.dao.pojo.bus.BusTemplateItemCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BusTemplateItemMapper {
    int countByExample(BusTemplateItemCriteria example);

    int deleteByExample(BusTemplateItemCriteria example);

    int insert(BusTemplateItem record);

    int insertSelective(BusTemplateItem record);

    List<BusTemplateItem> selectByExample(BusTemplateItemCriteria example);

    int updateByExampleSelective(@Param("record") BusTemplateItem record, @Param("example") BusTemplateItemCriteria example);

    int updateByExample(@Param("record") BusTemplateItem record, @Param("example") BusTemplateItemCriteria example);
}