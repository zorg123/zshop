package com.flyrui.dao.mapper;

import com.flyrui.dao.pojo.sys.TbNotice;
import com.flyrui.dao.pojo.sys.TbNoticeCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbNoticeMapper {
    int countByExample(TbNoticeCriteria example);

    int deleteByExample(TbNoticeCriteria example);

    int deleteByPrimaryKey(Integer notice_id);

    int insert(TbNotice record);

    int insertSelective(TbNotice record);

    List<TbNotice> selectByExample(TbNoticeCriteria example);

    TbNotice selectByPrimaryKey(Integer notice_id);

    int updateByExampleSelective(@Param("record") TbNotice record, @Param("example") TbNoticeCriteria example);

    int updateByExample(@Param("record") TbNotice record, @Param("example") TbNoticeCriteria example);

    int updateByPrimaryKeySelective(TbNotice record);

    int updateByPrimaryKey(TbNotice record);
}