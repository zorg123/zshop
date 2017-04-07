package com.flyrui.dao.mapper;

import com.flyrui.dao.pojo.sys.TbConfig;
import com.flyrui.dao.pojo.sys.TbConfigCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbConfigMapper {
    int countByExample(TbConfigCriteria example);

    int deleteByExample(TbConfigCriteria example);

    int insert(TbConfig record);

    int insertSelective(TbConfig record);

    List<TbConfig> selectByExample(TbConfigCriteria example);

    int updateByExampleSelective(@Param("record") TbConfig record, @Param("example") TbConfigCriteria example);

    int updateByExample(@Param("record") TbConfig record, @Param("example") TbConfigCriteria example);
}