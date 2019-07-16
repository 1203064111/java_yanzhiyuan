package tst.project.script;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import tst.project.bean.shop.ShopMemberCouponBean;
import tst.project.utils.JDBCUtils;

/**
 * 用户优惠券过期更新
 * @author sjb
 *
 */
public class CouponExpire {
	public static void main(String[] args) {
		Connection conn = null;
		String sql = "select member_coupon_id from tst_member_coupon where coupon_end_time<now() and member_coupon_state='0'";
		try {
			conn = JDBCUtils.startConn(conn,Host.url,Host.username,Host.password);
			Statement st=(Statement) conn.createStatement();	

			String json = JDBCUtils.queryArray(conn, sql);
			List<ShopMemberCouponBean> shopMemberCouponBeans = JSON.parseArray(json,ShopMemberCouponBean.class);
			for (int i = 0; i < shopMemberCouponBeans.size(); i++) {
				ShopMemberCouponBean shopMemberCouponBean=shopMemberCouponBeans.get(i);
				st.executeUpdate(" update tst_member_coupon "
						+ "set update_time=now(),member_coupon_state='3' "
						+ "where member_coupon_id="+shopMemberCouponBean.getMember_coupon_id()+" ");
			}
			JDBCUtils.closeConn(st, conn);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
