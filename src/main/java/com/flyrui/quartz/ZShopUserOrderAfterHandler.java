package com.flyrui.quartz;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flyrui.dao.common.page.PageModel;
import com.flyrui.quartz.dto.GoodsOrderAfter;
import com.flyrui.quartz.service.GoodsOrderAfterService;

@Component
public class ZShopUserOrderAfterHandler {
	private static final Logger log = Logger.getLogger(ZShopUserOrderAfterHandler.class);	
	
	@Autowired
	public GoodsOrderAfterService goodsOrderAfterService;
	
	//@PostConstruct
	public void init() {
		try {
			Thread thread = new Thread(new ExecuteService());
			thread.start();
		}catch(Exception ex) {
			log.error("初始化 用户购买订单后调用存储过程处理失败",ex);
		}
	}
	
	class ExecuteService implements Runnable {

		@Override
		public void run() {
			
				while(true) {
					try {
						//查询需要处理的
						GoodsOrderAfter orderAfter = new GoodsOrderAfter();
						orderAfter.setState(1);
						orderAfter.setError_num(3);
						PageModel<GoodsOrderAfter> page = goodsOrderAfterService.getPagerListByCon(orderAfter, 1, 10);
						if(page.getTotal()>0) {
							for(GoodsOrderAfter temp : page.getRows()) {
								orderAfter = new GoodsOrderAfter();
								orderAfter.setId(temp.getId());
								orderAfter.setState(2);
								goodsOrderAfterService.update(orderAfter);
							}
							
							for(GoodsOrderAfter temp : page.getRows()) {
								try {
									goodsOrderAfterService.afterHandler(temp);
									orderAfter.setId(temp.getId());
									orderAfter.setState(3);
									orderAfter.setComments("执行成功");
									goodsOrderAfterService.update(orderAfter);
								}catch(Exception ex) {
									orderAfter = new GoodsOrderAfter();
									orderAfter.setId(temp.getId());
									orderAfter.setState(-1);
									orderAfter.setError_num(temp.getError_num()+1);
									orderAfter.setComments(ex.getMessage());
									goodsOrderAfterService.update(orderAfter);
								}							
							}
							
						}else {
							Thread.sleep(1000);
						}
					}catch(Exception ex) {
						log.error("执行订单后处理调度失败",ex);
					}
				}
		}		
		
	}
}
