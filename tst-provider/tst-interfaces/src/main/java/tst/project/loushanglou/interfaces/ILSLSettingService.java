package tst.project.loushanglou.interfaces;

import tst.project.bean.loushanglou.AppointmentBean;

public interface ILSLSettingService {
	
	/**
	 * 提交体验店预约
	 * @author sjb
	 * @param appointmentBean
	 * @return
	 */
	public Object insertOfflineAppiontment(AppointmentBean appointmentBean);
}
