package tst.project.dao.interfaces;

import java.util.List;

import tst.project.annotation.Mapper;
import tst.project.bean.CodeBean;
import tst.project.bean.setting.AdviceBean;
import tst.project.bean.setting.HtmlBean;
import tst.project.bean.setting.MsgTypeBean;

@Mapper
public interface SettingDao {
	
	/**
	 * 提交意见反馈
	 * @author sjb
	 * @param adviceBean
	 * @return
	 */
	public int insertAdvice(AdviceBean adviceBean);
	
	/**
	 * 图文配置详情
	 * @param htmlBean
	 * @return
	 */
	public HtmlBean getHtmlDetail(HtmlBean htmlBean);
	
	
	/**
	 * 图文配置列表
	 * @author sjb
	 * @param htmlBean
	 * @return
	 */
	public List<HtmlBean> getHtmls(HtmlBean htmlBean);
	
	/**
	 * 根据验证码获得验证信息
	 * @return
	 */
	public CodeBean getCodeBeanByMobile(CodeBean codeBean);
	
	/**
	 * 添加新的验证码
	 * @param codeBean
	 * @return
	 */
	public int insertCode(CodeBean codeBean);
	/**
	 * 修改验证码
	 * @param codeBean
	 * @return
	 */
	public int deleteCode(CodeBean codeBean);
	/**
	 * 验证手机号验证码是否匹配
	 * @param codeBean
	 * @return
	 */
	public CodeBean getCodeBeanByMobileAndCode(CodeBean codeBean);
	
	/**
	 * 删除验证码
	 * @param codeBean
	 * @return
	 */
	public int deleteCodeByMobileAndCode(CodeBean codeBean);

	/**
	 * 消息类型
	 * @param msgTypeBean
	 * @return
	 */
	public MsgTypeBean  getMsgType(MsgTypeBean msgTypeBean);
}
