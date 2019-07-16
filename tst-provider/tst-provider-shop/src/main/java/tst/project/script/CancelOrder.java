package tst.project.script;

import java.util.List;

import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import tst.project.aspect.AppException;
import tst.project.bean.shop.OrderBean;
import tst.project.bean.shop.ShopMemberBean;
import tst.project.utils.JDBCUtils;
import tst.project.utils.NumberUtils;

/**
 * 订单超时未支付 取消订单
 * @author sjb
 *
 */
public class CancelOrder {
	public static void main(String[] args) {
		Connection conn = null;
		
		
		String sql = "select member_id,order_id,member_coupon_id,is_deduction_integral,deduction_integral_value from tst_order as a "
				+ "where FIND_IN_SET(a.order_state,'wait_pay') and is_delete='0' "
				+ "and pay_end_time<now()";
		try {
			conn = JDBCUtils.startConn(conn,Host.url,Host.username,Host.password);
			Statement st=(Statement) conn.createStatement();	

			String json = JDBCUtils.queryArray(conn, sql);
			List<OrderBean> orderBeans = JSON.parseArray(json,OrderBean.class);

			if (orderBeans != null) {
				for (int i = 0; i < orderBeans.size(); i++) {
					OrderBean orderBean = orderBeans.get(i);
					
					System.out.println(i+"===="+orderBean.getOrder_id());
					
					st.executeUpdate(" update tst_order "
							+ "set cancel_time=now(),order_state='cancel' "
							+ "where order_id="+orderBean.getOrder_id()+" ");
					
					
					st.executeUpdate(" update tst_order_merchants "
							+ "set cancel_time=now(),order_state='cancel' "
							+ "where order_id="+orderBean.getOrder_id()+" ");
					
					st.executeUpdate(" update tst_order_goods as a "
							+ "inner join tst_goods as b "
							+ "on a.goods_id=b.goods_id "
							+ "inner join tst_goods_relation_specification as c "
							+ "on a.specification_id=c.specification_id "
							+ "set b.goods_stock=b.goods_stock+a.goods_num"
							+ ",c.specification_stock=c.specification_stock+a.goods_num "
							+ "where a.is_delete='0' and a.order_id="+orderBean.getOrder_id()+" ");
					if(!StringUtils.isEmpty(orderBean.getMember_coupon_id())){
						st.executeUpdate(" update tst_member_coupon "
								+ "set update_time=now() ,member_coupon_state='1' "
								+ "where member_coupon_id="+orderBean.getMember_coupon_id()+" ");
					}
				
					if("1".equals(orderBean.getIs_deduction_integral())){//使用积分抵扣了
						int member_integral=NumberUtils.Integer(orderBean.getDeduction_integral_value());
						if(member_integral>0){//抵扣积分了
							
							st.executeUpdate(" update tst_member set update_time=now() "
									+ ",member_integral=member_integral+"+member_integral+" "
									+ "where member_id="+orderBean.getMember_id()+" ");
							
							st.executeUpdate(" insert into tst_member_integral (member_id,integral_type,integral_value,"
									+ "order_id,order_no,order_merchants_id,order_merchants_no,create_time,update_time) "
									+ "select member_id,'3',deduction_integral_value,order_id,order_no,order_merchants_id,order_merchants_no,"
									+ "now() as create_time,now() as update_time from tst_order_merchants "
									+ "where order_id="+orderBean.getOrder_id()+" and is_delete='0' and deduction_integral_value>0 ");
						}
					}
				}
			}

			JDBCUtils.closeConn(st, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
