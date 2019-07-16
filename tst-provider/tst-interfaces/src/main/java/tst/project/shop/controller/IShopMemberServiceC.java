package tst.project.shop.controller;

import tst.project.bean.member.MemberBean;
import tst.project.bean.shop.ShopMemberBean;
import tst.project.page.PageBean;

public interface IShopMemberServiceC {
	/**
	 * 口呗商城用户列表
	 * @author sjb
	 * @param shopMemberBean
	 * @return
	 */
	public Object getShopMembersKoubei(MemberBean memberBean,PageBean pageBean);
}
