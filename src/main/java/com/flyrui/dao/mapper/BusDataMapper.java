package com.flyrui.dao.mapper;

import com.flyrui.dao.pojo.bus.BusData;
import com.flyrui.dao.pojo.bus.BusDataCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BusDataMapper {
    int countByExample(BusDataCriteria example);

    int deleteByExample(BusDataCriteria example);

    int insert(BusData record);

    int insertSelective(BusData record);

    List<BusData> selectByExample(BusDataCriteria example);

    int updateByExampleSelective(@Param("record") BusData record, @Param("example") BusDataCriteria example);

    int updateByExample(@Param("record") BusData record, @Param("example") BusDataCriteria example);
}