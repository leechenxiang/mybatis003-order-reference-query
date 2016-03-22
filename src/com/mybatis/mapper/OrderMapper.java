package com.mybatis.mapper;

import java.util.List;

import com.mybatis.bean.OrderUserCustom;
import com.mybatis.bean.Orders;

public interface OrderMapper {
	
	public List<OrderUserCustom> findOrderUserList() throws Exception;
	
	public List<Orders> findOrderUserListByResultMap() throws Exception;
	
	public List<Orders> findOrderItemsList() throws Exception;
	
}
