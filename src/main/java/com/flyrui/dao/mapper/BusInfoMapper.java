package com.flyrui.dao.mapper;

import com.flyrui.dao.pojo.bus.BusInfo;
import com.flyrui.dao.pojo.bus.BusInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BusInfoMapper {
    int countByExample(BusInfoCriteria example);

    int deleteByExample(BusInfoCriteria example);

    int insert(BusInfo record);

    int insertSelective(BusInfo record);

    List<BusInfo> selectByExample(BusInfoCriteria example);

    int updateByExampleSelective(@Param("record") BusInfo record, @Param("example") BusInfoCriteria example);

    int updateByExample(@Param("record") BusInfo record, @Param("example") BusInfoCriteria example);
}