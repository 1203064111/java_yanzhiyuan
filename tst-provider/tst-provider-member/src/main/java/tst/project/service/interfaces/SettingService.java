package tst.project.service.interfaces;

import java.security.interfaces.RSAPrivateKey;
import java.text.ParseException;
import java.util.Date;

import javax.crypto.Cipher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;

import net.iharder.Base64;
import tst.project.aspect.AppException;
import tst.project.bean.CodeBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.setting.AdviceBean;
import tst.project.bean.setting.HtmlBean;
import tst.project.bean.setting.MsgTypeBean;
import tst.project.bean.wx.WXBean;
import tst.project.bean.wx.WXPubBean;
import tst.project.dao.interfaces.MemberDao;
import tst.project.dao.interfaces.SettingDao;
import tst.project.interfaces.ISettingService;
import tst.project.utils.NumberUtils;
import tst.project.utils.RedisUtils;
import tst.project.utils.RsaUtils;
import tst.project.utils.Sha1Utils;
import tst.project.utils.SmsDemo;
import tst.project.utils.TimeUtils;
import tst.project.utils.VerificationCodeUtils;
import tst.project.utils.WXUtils;

@Service
@Transactional(rollbackFor=Exception.class)
public class SettingService implements ISettingService {
	@Autowired
	SettingDao settingDao;
	
	@Autowired
	MemberDao memberDao;

	@Value("${accessKeyId}")
	private String accessKeyId;// 签名

	@Value("${accessKeySecret}")
	private String accessKeySecret;// 模板code
	
	@Value("${signName}")
	private String signName;// 签名

	@Value("${templateCode}")
	private String templateCode;// 模板code
	
	@Value("${tmeplate}")
	private String tmeplate;// 模板

	@Value("${code_url}")
	private String code_url;

	@Value("${code_username}")
	private String code_username;

	@Value("${code_password}")
	private String code_password;

	@Value("${code_desc}")
	private String code_desc;

	@Value("${code_effective_time}")
	private int code_effective_time;

	@Value("${wx_AppID}")
	private String wx_AppID;

	@Value("${wx_AppSecret}")
	private String wx_AppSecret;

	@Override
	public Object test() {
		// TODO Auto-generated method stub
		String key = RedisUtils.getKey("1");
		return key;
	}

	@Override
	public Object insertAdvice(AdviceBean adviceBean) {
		// TODO Auto-generated method stub
		MemberBean memberBean = memberDao.getMemberDetail(new MemberBean()
				.setMember_id(NumberUtils.Integer(adviceBean.getMember_id())));
		int num = settingDao.insertAdvice(adviceBean.setMember_account(memberBean.getMember_account()));
		if(num<=0){
			throw new AppException("提交失败!");
		}
		return num;
	}
	
	
	@Override
	public Object getHtmlDetail(HtmlBean htmlBean) {
		// TODO Auto-generated method stub
		HtmlBean htmlBean2 = settingDao.getHtmlDetail(htmlBean);
		if (htmlBean2 == null) {
			throw new AppException("详情不存在!");
		}
		return "<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /></head>"
				+ htmlBean2.getHtml_url_desc() + "</html>";
	}
	@Override
	public Object getHtmlDetail2(HtmlBean htmlBean) {
		// TODO Auto-generated method stub
		HtmlBean htmlBean2 = settingDao.getHtmlDetail(htmlBean);
		if (htmlBean2 == null) {
			throw new AppException("详情不存在!");
		}
		return htmlBean2;
	}
	
	
	@Override
	public Object getHtmls(HtmlBean htmlBean) {
		// TODO Auto-generated method stub
		return settingDao.getHtmls(htmlBean);
	}
	@Override
	public Object getWxAutho(String url) {
		try {
			// TODO Auto-generated method stub
			String access_token = WXUtils.getAccess_token(wx_AppID, wx_AppSecret);
			String jsapi_ticket = WXUtils.getJsapi(access_token);
			String nonceStr = NumberUtils.createRandom(false, 16);
			long timestamp = Long.parseLong(String.valueOf(System.currentTimeMillis()).toString().substring(0, 10));
			WXBean wxBean = new WXBean();
			wxBean.setJsapi_ticket(jsapi_ticket);
			wxBean.setAppId(wx_AppID);
			wxBean.setNonceStr(nonceStr);
			wxBean.setTimestamp(timestamp + "");
			String sign = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + nonceStr + "&timestamp=" + timestamp + "&url="
					+ url;
			wxBean.setSignature(Sha1Utils.sha1(sign));
			return wxBean;
		} catch (Exception e) {
			// TODO: handle exception
			throw new AppException(e.getMessage());
		}
	}

	@Override
	public Object sendAliCode(CodeBean codeBean) {
		try {
			RSAPrivateKey privateKey = RsaUtils.getPrivateKey(RsaUtils.DEFAULT_PRIVATE_KEY);
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			byte[] type = cipher.doFinal(Base64.decode(codeBean.getCode_type()));
			codeBean.setCode_type(new String(type));

			byte[] mobile = cipher.doFinal(Base64.decode(codeBean.getMobile()));
			codeBean.setMobile(new String(mobile));
			if (codeBean.getMobile() == null || codeBean.getMobile().length() != 11) {
				throw new AppException("手机号格式错误!");
			}
		} catch (Exception e) {

			throw new AppException("非法请求!");
		}

		String code_type = "withdrawals_password:修改提现密码 " + "binding_bank:绑定银行卡 ver_mobile:验证手机号 "
				+ "register:注册 login:登录 pay_password:修改支付密码 "
				+ "forget_password:修改密码 exchange:使用兑换码 binding_mobile：绑定手机号";
		if (code_type.indexOf(codeBean.getCode_type()) < 0) {
			throw new AppException("短信类型不存在");
		}

		CodeBean codeBean2 = settingDao
				.getCodeBeanByMobile(codeBean.setCreate_time(TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss")));

		if (codeBean2 != null) {
			try {
				if (TimeUtils.getMinCompareDate(TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss"),
						codeBean2.getCreate_time(), "yyyy-MM-dd HH:mm:ss") < 2) {
					throw new AppException("2分钟内不可重复发送!");
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new AppException("时间比较失败!");
			}
			settingDao.deleteCode(codeBean2);
		}

		String code = NumberUtils.createRandom(true, 6);

		// {\"name\":\"Tom\", \"code\":\"123\"}
		String templateParams = "{ \"code\":\"" + code + "\"}";
		SendSmsResponse response = null;
		try {
			response = SmsDemo.sendSms(codeBean,accessKeyId,accessKeySecret ,signName, templateCode, templateParams);
		} catch (Exception e) {
			throw new AppException(e.getMessage());
		}
		int effective_time = code_effective_time;
		String time = TimeUtils.getTimeMinuteAfter("yyyy-MM-dd HH:mm:ss", new Date(), effective_time);
		String temp = tmeplate;
		temp="【"+signName+"】"+temp.replace("{code}", code);
		// mobile,code,code_type,code_desc,create_time,effective_time
		if ("ok".equals(response.getMessage().toLowerCase())) {
			int num = settingDao.insertCode(new CodeBean()
					.setCreate_time(TimeUtils.getCurrentTime())
					.setCode_type(codeBean.getCode_type())
					.setMobile(codeBean.getMobile()).setCode(code)
					.setCode_desc(temp).setEffective_time(time).setCode(code));
			if (num > 0) {
				return code;
			} else {
				throw new AppException("发送失败!");
			}

		} else {
			throw new AppException(response.getMessage());
		}

	}

	@Override
	public Object sendAliCodeV2(CodeBean codeBean){

		if (codeBean.getMobile() == null || codeBean.getMobile().length() != 11) {
			throw new AppException("手机号格式错误!");
		}

		String code_type = "withdrawals_password:修改提现密码 " + "binding_bank:绑定银行卡 ver_mobile:验证手机号 "
				+ "register:注册 login:登录 pay_password:修改支付密码 "
				+ "forget_password:修改密码 exchange:使用兑换码 binding_mobile：绑定手机号";
		if (code_type.indexOf(codeBean.getCode_type()) < 0) {
			throw new AppException("短信类型不存在");
		}

		CodeBean codeBean2 = settingDao
				.getCodeBeanByMobile(codeBean.setCreate_time(TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss")));

		if (codeBean2 != null) {
			try {
				if (TimeUtils.getMinCompareDate(TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss"),
						codeBean2.getCreate_time(), "yyyy-MM-dd HH:mm:ss") < 2) {
					throw new AppException("2分钟内不可重复发送!");
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new AppException("时间比较失败!");
			}
			settingDao.deleteCode(codeBean2);
		}

		String code = NumberUtils.createRandom(true, 6);

		// {\"name\":\"Tom\", \"code\":\"123\"}
		String templateParams = "{ \"code\":\"" + code + "\"}";
		SendSmsResponse response = null;
		try {
			response = SmsDemo.sendSms(codeBean, accessKeyId,accessKeySecret ,signName, templateCode, templateParams);
		} catch (Exception e) {
			throw new AppException(e.getMessage());
		}
		int effective_time = code_effective_time;
		String time = TimeUtils.getTimeMinuteAfter("yyyy-MM-dd HH:mm:ss", new Date(), effective_time);
		String temp = tmeplate;
		temp="【"+signName+"】"+temp.replace("{code}", code);
		// mobile,code,code_type,code_desc,create_time,effective_time
		if ("ok".equals(response.getMessage().toLowerCase())) {
			int num = settingDao.insertCode(new CodeBean()
					.setCreate_time(TimeUtils.getCurrentTime())
					.setCode_type(codeBean.getCode_type())
					.setMobile(codeBean.getMobile()).setCode(code)
					.setCode_desc(temp).setEffective_time(time).setCode(code));
			if (num > 0) {
				return code;
			} else {
				throw new AppException("发送失败!");
			}

		} else {
			throw new AppException(response.getMessage());
		}

	}

	/**
	 * 发送验证码
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@Override
	public Object sendCode(CodeBean codeBean) {
		try {

			RSAPrivateKey privateKey = RsaUtils.getPrivateKey(RsaUtils.DEFAULT_PRIVATE_KEY);
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			byte[] type = cipher.doFinal(Base64.decode(codeBean.getCode_type()));
			codeBean.setCode_type(new String(type));
			
			byte[] mobile = cipher.doFinal(Base64.decode(codeBean.getMobile()));
			codeBean.setMobile(new String(mobile));
			if (codeBean.getMobile() == null || codeBean.getMobile().length() != 11) {
				throw new AppException("手机号格式错误!");
			}
		} catch (Exception e) {

			throw new AppException("非法请求!");
		}

		String code_type = "withdrawals_password:修改提现密码 " + "binding_bank:绑定银行卡 ver_mobile:验证手机号 "
				+ "register:注册 login:登录 pay_password:修改支付密码 "
				+ "forget_password:修改密码 exchange:使用兑换码 binding_mobile：绑定手机号";
		if (code_type.indexOf(codeBean.getCode_type()) < 0) {
			throw new AppException("短信类型不存在");
		}

		CodeBean codeBean2 = settingDao
				.getCodeBeanByMobile(codeBean.setCreate_time(TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss")));

		if (codeBean2 != null) {
			try {
				if (TimeUtils.getMinCompareDate(TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss"),
						codeBean2.getCreate_time(), "yyyy-MM-dd HH:mm:ss") < 2) {
					throw new AppException("2分钟内不可重复发送!");
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new AppException("时间比较失败!");
			}
			settingDao.deleteCode(codeBean2);
		}

		String code = NumberUtils.createRandom(true, 6);

		CodeBean codeBean1 = VerificationCodeUtils.sendCodeZhutong(code_url, code_username, code_password,
				code_effective_time, codeBean.setCode(code).setCode_desc(code_desc.replace("tst_code", code)));
		if (codeBean1 != null) {
			int num = settingDao.insertCode(codeBean1);
			if (num > 0) {
				return code;
			} else {
				throw new AppException("发送失败!");
			}
		} else {
			throw new AppException("发送失败");
		}		
	}

	@Override
	public Object getMsgType(MsgTypeBean msgTypeBean) {

		return settingDao.getMsgType(msgTypeBean);
	}

}
