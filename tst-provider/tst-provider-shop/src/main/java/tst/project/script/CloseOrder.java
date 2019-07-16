package tst.project.script;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import tst.project.bean.shop.OrderMerchantsBean;
import tst.project.utils.JDBCUtils;

/**
 * 结算订单
 * @author sjb
 *
 */
public class CloseOrder {
	public static void main(String[] args) {
		Connection conn = null;
		String sql = "select a.order_merchants_id,a.member_id,a.merchants_id,a.order_actual_price,a.order_merchants_no"
				+ " from tst_order_merchants as a where FIND_IN_SET(a.order_state,'end,wait_assessment') "
				+ "and TIMESTAMPDIFF(hour,a.receive_time,now())>(select percent_value from tst_percent where percent_type='close_time')";

		try {
			conn = JDBCUtils.startConn(conn,Host.url,Host.username,Host.password);
			Statement st=(Statement) conn.createStatement();	

			String json = JDBCUtils.queryArray(conn, sql);
			List<OrderMerchantsBean> orderMerchantsBeans = JSON.parseArray(json,OrderMerchantsBean.class);

			if (orderMerchantsBeans != null) {
				for (int i = 0; i < orderMerchantsBeans.size(); i++) {
					OrderMerchantsBean orderMerchantsBean=orderMerchantsBeans.get(i);
					System.out.println(i+"===="+orderMerchantsBean.getOrder_merchants_id());
					
					st.executeUpdate(" update tst_order_merchants set order_state='close',close_time = now() "
							+ "where order_merchants_id="+orderMerchantsBean.getOrder_merchants_id()+" ");
					
					st.executeUpdate(" update tst_order_sale set update_time = now(),"
						+ " order_price = order_price - "+orderMerchantsBean.getOrder_actual_price()
						+ " where order_state = '"+ orderMerchantsBean.getOrder_state() +"'");
					
					st.executeUpdate(" update tst_order_sale set update_time = now(),"
							+ " order_price = order_price + " + orderMerchantsBean.getOrder_actual_price()
							+ " where order_state = 'close'");
					
					st.executeUpdate(" update tst_merchants_balance "
							+ "set withdrawals_can_balance=withdrawals_can_balance+"+orderMerchantsBean.getOrder_actual_price()+"-IFNULL((select SUM(refund_price) from tst_order_refund where order_merchants_id="+orderMerchantsBean.getOrder_merchants_id()+" and FIND_IN_SET(refund_state,'refund_ing,end')),0),update_time = now() "
							+ "where merchants_id="+orderMerchantsBean.getMerchants_id()+" ");
					
					st.executeUpdate("insert into tst_merchants_bill"
									+ "(merchants_id,bill_type,bill_price,"
									+ "order_merchants_id,order_merchants_no,"
									+ "create_time,update_time)"
									+ "values"
									+ "("+orderMerchantsBean.getMerchants_id()+",'1',"+orderMerchantsBean.getOrder_actual_price()+"-IFNULL((select SUM(refund_price) from tst_order_refund where order_merchants_id="+orderMerchantsBean.getOrder_merchants_id()+" and FIND_IN_SET(refund_state,'refund_ing,end')),0),"
									+ ""+orderMerchantsBean.getOrder_merchants_id()+",'"+orderMerchantsBean.getOrder_merchants_no()+"',"
									+ "now(),now())");
				}
			}
			JDBCUtils.closeConn(st, conn);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}
