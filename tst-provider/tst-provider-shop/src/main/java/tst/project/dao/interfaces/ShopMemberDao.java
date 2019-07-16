package tst.project.dao.interfaces;

import java.util.List;

import tst.project.annotation.Mapper;
import tst.project.bean.shop.ShopMemberBean;

@Mapper
public interface ShopMemberDao {
	/**
	 * 同步用户
	 * @author sjb
	 * @return
	 */
	public int synchronizationMembers(List<ShopMemberBean> shopMemberBeans);
	
	/**
	 * 添加商城用户
	 * @param shopMemberBean
	 * @return
	 */
	public int insertShopMember(ShopMemberBean shopMemberBean);
	
	
	/**
	 * 修改用户信息
	 * @param shopMemberBean
	 * @return
	 */
	public int updateShopMember(ShopMemberBean shopMemberBean);
}
