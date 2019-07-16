package tst.project.yinlong.controller;

import tst.project.bean.member.MemberBean;
import tst.project.bean.yinlong.MemberWorkerBean;
import tst.project.page.PageBean;

public interface IYinlongMemberServiceC {
	/**
	 * 师傅的用户详情
	 * @author hxf
	 * @param memberWorkerBean
	 * @return
	 */
	public Object getMemberWorkerDetail(MemberWorkerBean memberWorkerBean);
	
	/**
	 * 获得所有师傅的用户信息
	 * @author hxf
	 * @param memberWorkerBean
	 * @return
	 */
	public Object getMemberWorker(MemberWorkerBean memberWorkerBean,PageBean pageBean);
	
	/**
	 * 获得可指派的所有师傅
	 * @author hxf
	 * @param memberWorkerBean
	 * @return
	 */
	public Object getMemberWorkerV2(MemberWorkerBean memberWorkerBean,PageBean pageBean);
	/**
	 * 添加维修师傅的用户信息
	 * @author hxf
	 * @param memberWorkerBean
	 * @return
	 */
	public Object insertMemberWorker(MemberWorkerBean memberWorkerBean,MemberBean memberBean);
	
	/**
	 * 修改用户信息
	 * @author hxf
	 * @param memberWorkerBean
	 * @return
	 */
	public Object updateMemberWorker(MemberWorkerBean memberWorkerBean);
}
