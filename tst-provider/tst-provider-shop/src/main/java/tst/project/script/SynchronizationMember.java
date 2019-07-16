package tst.project.script;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import tst.project.bean.member.MemberBean;
import tst.project.utils.JDBCUtils;

/**
 * 同步用户
 * @author sjb
 *
 */
public class SynchronizationMember {
	
	public static void main(String[] args) {
		Connection conn = null;
		Connection conn2 = null;
		String sql = "select * from tst_member where is_delete='0' and is_synchronization='0' ";
		try {
			conn = JDBCUtils.startConn(conn,Host.url,Host.username,Host.password);
			Statement st=(Statement) conn.createStatement();	
			
			conn2 = JDBCUtils.startConn(conn,Host.url2,Host.username2,Host.password2);
			Statement st2=(Statement) conn2.createStatement();	
			
			String json = JDBCUtils.queryArray(conn2, sql);
			List<MemberBean> memberBeans = JSON.parseArray(json,MemberBean.class);
			for (int i = 0; i < memberBeans.size(); i++) {
				MemberBean memberBean=memberBeans.get(i);
				String member_json=JDBCUtils.queryObject(conn, "select * from tst_member where member_id="+memberBean.getMember_id()+" ");
				MemberBean memberBean2=JSON.parseObject(member_json,MemberBean.class);
				if(memberBean2==null){//未注册过的用户
					st.execute("insert into tst_member"
							+ "(member_id,create_time,update_time) "
							+ "values "
							+ "("+memberBean.getMember_id()+",now(),now())");
				}
				
				st2.execute(" update tst_member set update_time=now(),is_synchronization='1' where member_id="+memberBean.getMember_id()+" ");
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}
