package tst.project.interfaces;

import tst.project.bean.CodeBean;
import tst.project.bean.setting.AdviceBean;
import tst.project.bean.setting.HtmlBean;
import tst.project.bean.setting.MsgTypeBean;

public interface ISettingService {
	
	public Object test();
	
	/**
	 * 提交意见反馈
	 * @author sjb
	 * @param adviceBean
	 * @return
	 */
	public Object insertAdvice(AdviceBean adviceBean);
	
	/**
	 * 发送短信验证码
	 */
	Object sendCode(CodeBean codeBean);
	
	/**
	 * 阿里云发送验证码(加密)
	 * @param codeBean
	 * @return
	 */
	public Object sendAliCode(CodeBean codeBean);
	
	/**
	 * 发送验证码(不加密)
	 * @param codeBean
	 * @return
	 */
	public Object sendAliCodeV2 (CodeBean codeBean);
	
	/**
	 * 获得微信分享权限
	 * @param url
	 * @return
	 */
	Object getWxAutho(String url);
	
	/**
	 * 图文配置详情
	 * @param htmlBean
	 * @return
	 */
	public Object getHtmlDetail(HtmlBean htmlBean);
	
	
	/**
	 * 图文详情
	 * @author lx
	 * @param htmlBean
	 * @return
	 */
	public Object getHtmlDetail2(HtmlBean htmlBean);
	
	/**
	 * 图文配置列表
	 * @author sjb
	 * @param htmlBean
	 * @return
	 */
	public Object getHtmls(HtmlBean htmlBean);

	/**
	 * 获取消息类型
	 * @param msgTypeBean
	 * @return
	 */
	public Object getMsgType(MsgTypeBean msgTypeBean);


	

	

}
