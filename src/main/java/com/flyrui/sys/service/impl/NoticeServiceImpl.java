package com.flyrui.sys.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flyrui.common.service.BaseService;
import com.flyrui.dao.pojo.sys.Notice;
import com.flyrui.dao.pojo.sys.TbContent;
import com.flyrui.dao.pojo.sys.TbNotice;
import com.flyrui.sys.service.ContentService;
import com.flyrui.sys.service.NoticeService;

@Service(value="noticeService")
public class NoticeServiceImpl extends BaseService<TbNotice> implements NoticeService {

	@Autowired
	public ContentService contentService;
	
	public NoticeServiceImpl(){
		   super.setNameSpace("com.flyrui.dao.mapper.TbNoticeMapper");
	}
	
	public Notice queryNoticeDetail(TbNotice notice){
		Notice retNotice = null;
		List<Notice> retList =  baseDao.selectList(nameSpace+".selectDetail", notice);
		if(retList!=null && retList.size()>0){
			retNotice = retList.get(0);
		}
		return retNotice;
	}
	
	@Transactional
	public int insert(Notice notice) {	
		
		//插入详情
		TbContent content = new TbContent();
		content.setContent(notice.getContent());
		content.setContent_id(notice.getContent_id());
		content.setCreate_date(new Date());
		contentService.insert(content);
		
		notice.setContent_id(content.getContent_id());
		//插入标题
		return  insert((TbNotice)notice);
	}
	
	@Transactional
	public int update(Notice notice){
		//插入标题
		update((TbNotice)notice);	
		
		//修改详情
		TbContent content = new TbContent();
		content.setContent(notice.getContent());	
		content.setContent_id(notice.getContent_id());
		return contentService.update(content);
	}
	
	@Transactional
	public int delete(Notice notice){
		//插入标题
		delete((TbNotice)notice);
		//修改详情
		TbContent content = new TbContent();		
		content.setContent_id(notice.getContent_id());
		return contentService.delete(content);
	}
	
	public List<Notice> queryEffNoticeList(Notice notice,int pageNo,int pageSize){
		return  baseDao.selectList(nameSpace+".selectEffNotice", notice);
	}
	
}
