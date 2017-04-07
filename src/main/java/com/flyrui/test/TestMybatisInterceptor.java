package com.flyrui.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSession;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;

import com.flyrui.dao.common.Page;
import com.flyrui.dao.pojo.sys.User;

public class TestMybatisInterceptor {
	public static void main(String[] args) {
		String resource = "E:\\work\\github\\HkyInfoShare\\src\\main\\java\\config\\mybatis\\mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);

			DefaultSqlSessionFactory sqlSessionFactory = (DefaultSqlSessionFactory) new SqlSessionFactoryBuilder()
					.build(inputStream);
			DefaultSqlSession session = (DefaultSqlSession) sqlSessionFactory
					.openSession();
			try {
				// UserMapper userMapper = session.getMapper(UserMapper.class);
				Page<User> page = new Page<User>();
				page.setPageNo(2);
				// List<User> users = userMapper.findPage(page);
				// page.setResults(users);
				System.out.println(page);
			} finally {
				session.close();
			}
			session.commit();
			session.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
