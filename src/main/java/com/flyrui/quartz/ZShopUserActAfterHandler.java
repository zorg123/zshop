package com.flyrui.quartz;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flyrui.dao.common.page.PageModel;
import com.flyrui.quartz.dto.GoodsOrderAfter;
import com.flyrui.quartz.service.GoodsOrderAfterService;
import com.flyrui.sys.service.UserService;

@Component
public class ZShopUserActAfterHandler {
	private static final Logger log = Logger.getLogger(ZShopUserActAfterHandler.class);	
	
	@Autowired
	public GoodsOrderAfterService goodsOrderAfterService;
	
	@Autowired
	public UserService userService;
	
	@PostConstruct
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
						orderAfter.setAfter_type("act");;
						PageModel<GoodsOrderAfter> page = goodsOrderAfterService.getPagerListByCon(orderAfter, 1, 10);
						if(page.getTotal()>0) {
							for(GoodsOrderAfter temp : page.getRows()) {
								orderAfter = new GoodsOrderAfter();
								orderAfter.setId(temp.getId());
								orderAfter.setState(2);
								orderAfter.setState_date(new Date());
								goodsOrderAfterService.update(orderAfter);
							}
							
							for(GoodsOrderAfter temp : page.getRows()) {
								try {
									userService.afterHandler(temp.getUser_id(),temp.getGoods_order_id(),temp.getAct_userId());//goodsOderId暂存为被激活用户id
									orderAfter.setId(temp.getId());
									orderAfter.setState(3);
									orderAfter.setState_date(new Date());
									orderAfter.setComments("执行成功");
									goodsOrderAfterService.update(orderAfter);
								}catch(Exception ex) {
									orderAfter = new GoodsOrderAfter();
									orderAfter.setId(temp.getId());
									orderAfter.setState(-1);
									orderAfter.setState_date(new Date());
									orderAfter.setError_num(temp.getError_num()+1);
									orderAfter.setComments(ex.getMessage());
									goodsOrderAfterService.update(orderAfter);
								}							
							}
							
						}else {
							Thread.sleep(2000);
						}
					}catch(Exception ex) {
						log.error("执行订单后处理调度失败",ex);
					}
				}
		}		
		
	}
}
