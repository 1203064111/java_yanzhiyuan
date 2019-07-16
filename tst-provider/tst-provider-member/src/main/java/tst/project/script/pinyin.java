package tst.project.script;

import java.util.List;

import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import tst.project.bean.setting.CityBean;
import tst.project.bean.shop.OrderBean;
import tst.project.utils.JDBCUtils;
import tst.project.utils.NumberUtils;
import tst.project.utils.PinyinUtils;

public class pinyin {
	public static void main(String[] args) {
		Connection conn = null;
		
		
		String sql = "select * from tst_city";
		try {
			conn = JDBCUtils.startConn(conn,Host.url,Host.username,Host.password);
			Statement st=(Statement) conn.createStatement();	

			String json = JDBCUtils.queryArray(conn, sql);
			List<CityBean> cityBeans = JSON.parseArray(json,CityBean.class);

			if (cityBeans != null) {
				for (int i = 0; i < cityBeans.size(); i++) {
					CityBean cityBean = cityBeans.get(i);
					
					System.out.println(i+"===="+cityBean.getId()+"=="+cityBean.getName());
					String name=PinyinUtils.converterToFirstSpell(cityBean.getName());
					String first_pingyin=name.substring(0,1);
					st.executeUpdate(" update tst_city "
							+ "set first_pingyin='"+first_pingyin+"' "
							+ "where id="+cityBean.getId()+" ");
				
				}
			}

			JDBCUtils.closeConn(st, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
