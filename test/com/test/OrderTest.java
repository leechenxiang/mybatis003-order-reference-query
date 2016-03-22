package com.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.mybatis.bean.OrderUserCustom;
import com.mybatis.bean.Orders;
import com.mybatis.mapper.OrderMapper;

public class OrderTest {

	// 会话工厂
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {
		// 加载配置文件
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 根据mytais的配置创建SqlSessionFactory

		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

	}

	@Test
	public void testFindOrderUserList() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//通过sqlSession创建代理对象(接口的实现类对象)
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		List<OrderUserCustom> list = orderMapper.findOrderUserList();
		
		if (!list.isEmpty()) {
			for (OrderUserCustom ou : list) {
				System.out.print(ou.getId() + "\t");
				System.out.print(ou.getOrder_number() + "\t");
				System.out.print(ou.getUsername() + "\t");
				System.out.println(ou.getBirthday());
			}
		}
	}
	
	@Test
	public void testFindOrderUserListByResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//通过sqlSession创建代理对象(接口的实现类对象)
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		List<Orders> list = orderMapper.findOrderUserListByResultMap();
		
		System.out.println(list.size());
	}
	
	@Test
	public void testFindOrderItemsList() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//通过sqlSession创建代理对象(接口的实现类对象)
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		List<Orders> list = orderMapper.findOrderItemsList();
		
		System.out.println(list.size());
	}
}
