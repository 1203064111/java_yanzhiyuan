package tst.project.interfaces;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qiniu.util.Auth;

import tst.project.aspect.AppController;
import tst.project.bean.CodeBean;
import tst.project.bean.member.BankCardBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.member.MemberIntegralOrderBean;
import tst.project.bean.member.MemberMsgBean;
import tst.project.bean.setting.MsgTypeBean;
import tst.project.bean.sheep.MemberSignBean;
import tst.project.bean.sheep.MemberTaskBean;
import tst.project.bean.sheep.TaskClassBean;
import tst.project.page.PageBean;
import tst.project.utils.WXUtils;

@Controller
@RequestMapping("/memberInterfaces/v1.0")

public class MemberInterfaces {
	@Autowired
	private IMemberService memberService;

	/**
	 * 获得用户的消息详情
	 * 
	 * @author sjb
	 * @param memberBean
	 * @return
	 */
	@RequestMapping("/outLogin")
	@AppController(isVerToken = true)
	public Object outLogin(MemberBean memberBean) throws Exception {
		return memberService.outLogin(memberBean);
	}
	
	
	@RequestMapping("/getMemberSignByMemberId")
	@AppController(isVerToken=true)
	public Object getMemberSignByMemberId(MemberSignBean memberSignBean)throws Exception{
		return memberService.getMemberSignByMemberId(memberSignBean);
	}
	@RequestMapping("/updateMemberSign")
	@AppController(isVerToken=true)
	public Object updateMemberSign(MemberSignBean memberSignBean)throws Exception{
		return memberService.updateMemberSign(memberSignBean);
	}

	/**
	 * 获得用户的消息详情
	 * 
	 * @author sjb
	 * @param memberMsgBean
	 * @return
	 */
	@RequestMapping("/getMemberMsgDetail")
	@AppController(isVerToken = true)
	public Object getMemberMsgDetail(MemberMsgBean memberMsgBean) throws Exception {
		return memberService.getMemberMsgDetail(memberMsgBean);
	}

	/**
	 * 用户微信公众号支付回调
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/wxpayMemberIntegralOrder")
	@AppController(isNeedPackage = false)
	public Object wxpayMemberIntegralOrder(HttpServletRequest request) throws Exception {
		InputStream inStream = request.getInputStream();
		ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = inStream.read(buffer)) != -1) {
			outSteam.write(buffer, 0, len);
		}
		outSteam.close();
		inStream.close();
		String resultStr = new String(outSteam.toByteArray(), "UTF-8");
		Map<String, String> resultMap = WXUtils.doXMLParse(resultStr);

		String out_trade_no = resultMap.get("out_trade_no");
		String transaction_id = resultMap.get("transaction_id");
		String sign = resultMap.get("sign");
		String return_code = resultMap.get("return_code");
		String cash_fee = resultMap.get("cash_fee");

		return memberService.wxpayMemberIntegralOrder(out_trade_no, transaction_id, cash_fee, sign);
	}

	/**
	 * 用户充值下单
	 * 
	 * @param memberIntegralOrderBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertMemberIntegralOrder")
	@AppController(isVerToken = true)
	public Object insertMemberIntegralOrder(MemberIntegralOrderBean memberIntegralOrderBean) throws Exception {
		return memberService.insertMemberIntegralOrder(memberIntegralOrderBean);
	}

	/**
	 * 用户详情
	 * 
	 * @param memberIntegralOrderBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getMemberDetail")
	@AppController()
	public Object getMemberDetail(MemberBean memberBean) throws Exception {
		return memberService.getMemberDetail(memberBean);
	}

	/**
	 * 微信公众号登录
	 * 
	 * @param memberBean
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/wxLoginMember")
	@AppController
	public Object wxLoginMember(MemberBean memberBean, String code) throws Exception {
		return memberService.wxLoginMember(memberBean, code);
	}

	/**
	 * 微信小程序用户登录
	 * 
	 * @param memberBean
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/wxLiteLoginMember")
	@AppController
	public Object wxLiteLoginMember(String code, String is_bind_mobile) throws Exception {
		return memberService.wxLiteLoginMember(code, is_bind_mobile);
	}

	/**
	 * memberBean
	 * 
	 * @param memberBean
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/wxLitBindMobile")
	@AppController
	public Object wxLitBindMobile(MemberBean memberBean, CodeBean codeBean) throws Exception {
		return memberService.wxLitBindMobile(memberBean, codeBean);
	}

	/**
	 * 获得支付宝的登录凭证
	 * 
	 * @param memberBean
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getAlipayCharge")
	@AppController
	public Object getAlipayCharge() throws Exception {
		return memberService.getAlipayCharge();
	}

	/**
	 * 支付宝app登录
	 * 
	 * @param memberBean
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/alipayAppLoginMember")
	@AppController
	public Object alipayAppLoginMember(String auth_code) throws Exception {
		return memberService.alipayAppLoginMember(auth_code);
	}

	/**
	 * 支付宝app绑定手机号
	 * 
	 * @param memberBean
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/alipayAppBindMobile")
	@AppController
	public Object alipayAppBindMobile(MemberBean memberBean, CodeBean codeBean) throws Exception {
		return memberService.alipayAppBindMobile(memberBean, codeBean);
	}

	/**
	 * 微信app登录
	 * 
	 * @param memberBean
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/wxAppLoginMember")
	@AppController
	public Object wxAppLoginMember(MemberBean memberBean) throws Exception {
		return memberService.wxAppLoginMember(memberBean);
	}

	/**
	 * 微信app登录
	 * 
	 * @param memberBean
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/wxAppBindMobile")
	@AppController
	public Object wxAppBindMobile(MemberBean memberBean, CodeBean codeBean) throws Exception {
		return memberService.wxAppBindMobile(memberBean, codeBean);
	}

	/**
	 * qq登录
	 * 
	 * @param memberBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/qqAppLoginMember")
	@AppController
	public Object qqAppLoginMember(MemberBean memberBean) throws Exception {
		return memberService.qqAppLoginMember(memberBean);
	}

	/**
	 * qq绑定手机号
	 * 
	 * @param memberBean
	 * @param codeBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/qqAppBindMobile")
	@AppController
	public Object qqAppBindMobile(MemberBean memberBean, CodeBean codeBean) throws Exception {
		return memberService.qqAppBindMobile(memberBean, codeBean);
	}

	/**
	 * 微博登录
	 * 
	 * @param memberBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/weiboAppLoginMember")
	@AppController
	public Object weiboAppLoginMember(MemberBean memberBean) throws Exception {
		return memberService.weiboAppLoginMember(memberBean);
	}

	/**
	 * 微博绑定手机号
	 * 
	 * @param memberBean
	 * @param codeBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/weiboAppBindMobile")
	@AppController
	public Object weiboAppBindMobile(MemberBean memberBean, CodeBean codeBean) throws Exception {
		return memberService.weiboAppBindMobile(memberBean, codeBean);
	}

	/**
	 * 用户登录
	 * 
	 * @param memberBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/loginMember")
	@AppController
	public Object loginMember(MemberBean memberBean) throws Exception {
		return memberService.loginMember(memberBean);
	}

	@RequestMapping("/getQiniuToken")
	@AppController
	public Object getQiniuToken(HttpServletRequest request,HttpServletResponse response) throws Exception {

		String accessKey = "NP4_XWRulRuhb2sEg460zF1gfJJSt3D_JryE3KZD";
		String secretKey = "jLz6FqMBksfLuQ9JyYlZnSqQOKq0HHv4lT8SLhHI";
		String bucket = "yzapp";
		Auth auth = Auth.create(accessKey, secretKey);
		String upToken = auth.uploadToken(bucket);
		return upToken;
	}

	/**
	 * 验证码用户登录
	 * 
	 * @param memberBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/CodeLoginMember")
	@AppController
	public Object CodeLoginMember(MemberBean memberBean, CodeBean codeBean) throws Exception {
		return memberService.CodeLoginMember(memberBean, codeBean);
	}

	/**
	 * 用户注册
	 * 
	 * @param memberBean
	 * @param codeBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/registerMember")
	@AppController
	public Object registerMember(MemberBean memberBean, CodeBean codeBean) throws Exception {
		Object object = memberService.registerMember(memberBean, codeBean);
		return object;
	}

	/**
	 * 忘记密码
	 * 
	 * @param memberBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/forgetPassword")
	@AppController
	public Object forgetPassword(MemberBean memberBean, CodeBean codeBean) throws Exception {
		Object object = memberService.forgetPassword(memberBean, codeBean);
		return object;
	}

	/**
	 * 设置支付密码
	 * 
	 * @param memberBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/payPassword")
	@AppController
	public Object payPassword(MemberBean memberBean, CodeBean codeBean) throws Exception {

		return memberService.payPassword(memberBean, codeBean);
	}

	/**
	 * 添加银行卡号
	 * 
	 * @param bankCardBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertBankCard")
	@AppController(isVerToken = true)
	public Object insertBankCard(BankCardBean bankCardBean) throws Exception {
		Object object = memberService.insertBankCard(bankCardBean);
		return object;
	}

	/**
	 * 银行卡解除绑定
	 * 
	 * @param bankCardBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteBankCard")
	@AppController(isVerToken = true)
	public Object deleteBankCard(BankCardBean bankCardBean) throws Exception {
		Object object = memberService.deleteBankCard(bankCardBean);
		return object;
	}

	/**
	 * 获得银行卡列表
	 * 
	 * @param bankCardBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getBankCards")
	@AppController(isVerToken = true)
	public Object getBankCards(BankCardBean bankCardBean) throws Exception {
		Object object = memberService.getBankCards(bankCardBean);
		return object;
	}

	/**
	 * 获得银行卡详情
	 * 
	 * @param bankCardBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getBankCardDetail")
	@AppController(isVerToken = true)
	public Object getBankCardDetail(BankCardBean bankCardBean) throws Exception {
		Object object = memberService.getBankCardDetail(bankCardBean);
		return object;
	}

	/**
	 * 修改银行卡详情
	 * 
	 * @param bankCardBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateBankCardDetail")
	@AppController(isVerToken = true)
	public Object updateBankCardDetail(BankCardBean bankCardBean) throws Exception {
		Object object = memberService.updateBankCardDetail(bankCardBean);
		return object;
	}

	/**
	 * 修改个人资料
	 * 
	 * @param memberBean
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateMemberDetail")
	@AppController(isVerToken = true)
	public Object updateMemberDetail(MemberBean memberBean) throws Exception {
		Object object = memberService.updateMemberDetail(memberBean);
		return object;
	}

	/**
	 * 添加个人消息
	 * 
	 * @author gxq
	 * @param memberMsgBean
	 * @return
	 */
	@RequestMapping("/insertMemberMsg")
	@AppController(isVerToken = true)
	public Object insertMemberMsg(MemberMsgBean memberMsgBean) {

		return memberService.insertMemberMsg(memberMsgBean);
	}

	/**
	 * 消息未读统计
	 * 
	 * @author gxq
	 * @param memberMsgBean
	 * @param pageBean
	 * @return
	 */
	@RequestMapping("/getMsgCount")
	@AppController(isVerToken = true)
	public Object getMsgCount(MemberMsgBean memberMsgBean) {

		return memberService.getMsgCount(memberMsgBean);
	}

	/**
	 * 获取个人消息列表
	 * 
	 * @author gxq
	 * @param memberMsgBean
	 * @param pageBean
	 * @return
	 */
	@RequestMapping("/getMemberMsgs")
	@AppController(isVerToken = true, isPage = true)
	public Object getMemberMsgs(MemberMsgBean memberMsgBean, PageBean pageBean) {

		return memberService.getMemberMsgs(memberMsgBean, pageBean);
	}

	/**
	 * 查看消息详情
	 * 
	 * @author gxq
	 * @param memberMsgBean
	 * @return
	 */
	@RequestMapping("/getMemberMsgsDetail")
	@AppController(isVerToken = true)
	public Object getMemberMsgsDetail(MemberMsgBean memberMsgBean) {
		return memberService.getMemberMsgsDetail(memberMsgBean);
	}

	/**
	 * 获取消息类型
	 * 
	 * @author gxq
	 * @param msgTypeBean
	 * @return
	 */
	@RequestMapping("/getMsgType")
	@AppController(isVerToken = true)
	public Object getMsgTypes(MsgTypeBean msgTypeBean) {
		return memberService.getMsgType(msgTypeBean);
	}
	
	/**
	 * 修改任务状态
	 * @param memberTaskBean
	 * @return
	 */
	@RequestMapping("/updateTaskByType")
	@AppController(isVerToken = true)
	public Object updateTaskByType(MemberTaskBean memberTaskBean) {
		return memberService.updateTaskByType(memberTaskBean);
	}
	/**
	 * 用户的任务列表
	 * @param taskClassBean
	 * @param pageBean
	 * @return
	 */
	@RequestMapping("/getTasksByMember")
	@AppController(isVerToken = true)
	public Object getTasksByMember(TaskClassBean taskClassBean,PageBean pageBean) {
		return memberService.getTasksByMember(taskClassBean,pageBean);
	}

}
