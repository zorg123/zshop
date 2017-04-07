package com.flyrui.framework.spring;

import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.flyrui.framework.common.Des;

/**
 * 解析properties文件 并对系统进行配置
 * 
 * @author dwb
 * 
 */
public class EncryptablePropertyPlaceholderConfigurer extends
		PropertyPlaceholderConfigurer {
	private static final String key = "0002000200020002";

	protected void processProperties(
			ConfigurableListableBeanFactory beanFactory, Properties props)
			throws BeansException {
		System.out.println("正在解密系统文件...");
		try {
			
			String rkUserName = props.getProperty("rk.jdbc.username");
			if (rkUserName != null) {
				String usernameVal = Des.Decrypt(rkUserName, Des.hex2byte(key));
				props.setProperty("rk.jdbc.username", usernameVal);
			}
			String rkPassword = props.getProperty("rk.jdbc.password");
			if (rkPassword != null) {
				String passwordVal = Des.Decrypt(rkPassword, Des.hex2byte(key));
				props.setProperty("rk.jdbc.password", passwordVal);
			}
			String rkUrl = props.getProperty("rk.jdbc.url");
			if (rkUrl != null) {
				String urlVal = Des.Decrypt(rkUrl, Des.hex2byte(key));
				props.setProperty("rk.jdbc.url", urlVal);
			}
			String rkDriverClassName = props
					.getProperty("rk.jdbc.driverClassName");
			if (rkDriverClassName != null) {
				String driverClassNameVal = Des.Decrypt(rkDriverClassName,
						Des.hex2byte(key));
				props.setProperty("rk.jdbc.driverClassName", driverClassNameVal);
			}
			// temp----------------------
			String usernameTemp = props.getProperty("temp.jdbc.username");
			if (usernameTemp != null) {
				String usernameVal = Des.Decrypt(usernameTemp,
						Des.hex2byte(key));
				props.setProperty("temp.jdbc.username", usernameVal);
			}
			String passwordTemp = props.getProperty("temp.jdbc.password");
			if (passwordTemp != null) {
				String passwordVal = Des.Decrypt(passwordTemp,
						Des.hex2byte(key));
				props.setProperty("temp.jdbc.password", passwordVal);
			}
			String urlTemp = props.getProperty("temp.jdbc.url");
			if (urlTemp != null) {
				String urlVal = Des.Decrypt(urlTemp, Des.hex2byte(key));
				props.setProperty("temp.jdbc.url", urlVal);
			}
			String driverClassNameTemp = props
					.getProperty("temp.jdbc.driverClassName");
			if (driverClassNameTemp != null) {
				String driverClassNameVal = Des.Decrypt(driverClassNameTemp,
						Des.hex2byte(key));
				props.setProperty("temp.jdbc.driverClassName",
						driverClassNameVal);
			}
			super.processProperties(beanFactory, props);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BeanInitializationException(e.getMessage());
		}
	}
}
