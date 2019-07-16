package tst.project.yinlong.interfaces;


import tst.project.bean.yinlong.MemberWorkerBean;

public interface IYinlongMemberService {
	
	/**
	 * 师傅的用户详情
	 * @author sjb
	 * @param memberWorkerBean
	 * @return
	 */
	public Object getMemberWorkerDetail(MemberWorkerBean memberWorkerBean);
	
	
	/**
	 * 修改师傅的用户详情
	 * @author sjb
	 * @param memberWorkerBean
	 * @return
	 */
	public Object updateMemberWorker(MemberWorkerBean memberWorkerBean);
}	
