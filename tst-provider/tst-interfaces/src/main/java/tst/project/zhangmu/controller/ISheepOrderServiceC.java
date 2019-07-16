package tst.project.zhangmu.controller;

import tst.project.bean.sheep.OrderSheepBean;
import tst.project.page.PageBean;

public interface ISheepOrderServiceC {

	public Object getOrders(OrderSheepBean orderSheepBean, PageBean pageBean);

	public Object getOrderDetail(OrderSheepBean orderSheepBean);

	public int sendOrder(OrderSheepBean orderSheepBean);

	public Object updateSheepOrder(OrderSheepBean orderSheepBean);

	

}
