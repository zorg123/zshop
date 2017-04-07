package com.flyrui.dao.mapper;

import com.flyrui.dao.pojo.bus.BusTemplate;
import com.flyrui.dao.pojo.bus.BusTemplateCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BusTemplateMapper {
    int countByExample(BusTemplateCriteria example);

    int deleteByExample(BusTemplateCriteria example);

    int insert(BusTemplate record);

    int insertSelective(BusTemplate record);

    List<BusTemplate> selectByExample(BusTemplateCriteria example);

    int updateByExampleSelective(@Param("record") BusTemplate record, @Param("example") BusTemplateCriteria example);

    int updateByExample(@Param("record") BusTemplate record, @Param("example") BusTemplateCriteria example);
}