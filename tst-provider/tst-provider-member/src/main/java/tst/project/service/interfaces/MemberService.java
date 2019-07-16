package tst.project.service.interfaces;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alipay.api.response.AlipayUserInfoShareResponse;

import tst.project.aspect.AppException;
import tst.project.bean.CodeBean;
import tst.project.bean.information.InformationAssessmentBean;
import tst.project.bean.information.RequirePositionBean;
import tst.project.bean.information.ShareRelationBean;
import tst.project.bean.information.SystemInformationBean;
import tst.project.bean.member.BankCardBean;
import tst.project.bean.member.MemberBean;
import tst.project.bean.member.MemberIntegralOrderBean;
import tst.project.bean.member.MemberMsgBean;
import tst.project.bean.setting.MsgTypeBean;
import tst.project.bean.setting.PercentBean;
import tst.project.bean.sheep.MemberSignBean;
import tst.project.bean.sheep.MemberTaskBean;
import tst.project.bean.sheep.TaskClassBean;
import tst.project.bean.wx.WXPubBean;
import tst.project.dao.interfaces.MemberDao;
import tst.project.dao.interfaces.SettingDao;
import tst.project.interfaces.IMemberService;
import tst.project.page.PageBean;
import tst.project.shop.interfaces.IMerchantsService;
import tst.project.utils.AlipayUtils;
import tst.project.utils.HuanXinUtils;
import tst.project.utils.MD5Util;
import tst.project.utils.NumberUtils;
import tst.project.utils.RedisUtils;
import tst.project.utils.StringUtils;
import tst.project.utils.TimeUtils;
import tst.project.utils.UUIDUtils;
import tst.project.utils.WXUtils;

@Service
@Transactional(rollbackFor = Exception.class)
public class MemberService implements IMemberService {

	@Autowired
	MemberDao memberDao;

	@Autowired
	SettingDao settingDao;
	
	@Autowired
	IMerchantsService merchantsService;

	@Value("${tengxun_im_sdk_appid}")
	private Long tengxun_im_sdk_appid;

	@Value("${tengxun_im_identifier}")
	private String tengxun_im_identifier;

	@Value("${tengxun_im_private_key}")
	private String tengxun_im_private_key;

	@Value("${wx_lite_AppID}")
	private String wx_lite_AppID;

	@Value("${wx_lite_AppSecret}")
	private String wx_lite_AppSecret;

	@Value("${weixin_lite_partnerkey}")
	private String weixin_lite_partnerkey;

	@Value("${weixin_lite_mchid}")
	private String weixin_lite_mchid;

	@Value("${weixin_lite_notify_url}")
	private String weixin_lite_notify_url;

	@Value("${wx_AppID}")
	private String wx_AppID;

	@Value("${wx_AppSecret}")
	private String wx_AppSecret;

	@Value("${weixin_partnerkey}")
	private String weixin_partnerkey;

	@Value("${weixin_mchid}")
	private String weixin_mchid;

	@Value("${weixin_pub_notify_url}")
	private String weixin_pub_notify_url;

	@Value("${alipay_app_id}")
	private String alipay_app_id;

	@Value("${alipay_pid}")
	private String alipay_pid;

	@Value("${alipay_private_key}")
	private String alipay_private_key;

	@Value("${alipay_public_key}")
	private String alipay_public_key;

	@Value("${hx_id}")
	private String hx_id;

	@Value("${hx_name}")
	private String hx_name;

	@Override
	public int updateSynchronizationMembers(String member_ids) {
		// TODO Auto-generated method stub
		int num = memberDao.updateSynchronizationMembers(member_ids);
		if (num <= 0) {
			throw new AppException("同步更新失败!");
		}
		return num;
	}

	@Override
	public List<MemberBean> getSynchronizationMembers(MemberBean memberBean) {
		// TODO Auto-generated method stub
		return memberDao.getSynchronizationMembers(memberBean);
	}

	@Override
	public Object outLogin(MemberBean memberBean) {
		// TODO Auto-generated method stub

		UUID uuid = UUID.randomUUID();
		int num = memberDao.updateMemberDetail(memberBean.setMember_token(uuid.toString()));
		if (num <= 0) {
			throw new AppException("退出失败!");
		}

		boolean is_success = RedisUtils.setKey("member_id" + memberBean.getMember_id(), uuid.toString());
		if (!is_success) {
			throw new AppException("缓存失败!");
		}

		return num;
	}

	@Override
	public Object getMemberMsgDetail(MemberMsgBean memberMsgBean) {
		// TODO Auto-generated method stub
		return memberDao.getMemberMsgDetail(memberMsgBean);
	}

	public Object wxpayMemberIntegralOrder(String order_no, String transaction_id, String cash_fee, String sign) {
		// TODO Auto-generated method stub
		MemberIntegralOrderBean memberIntegralOrderBean = memberDao
				.getMemberIntegralOrderDetail(new MemberIntegralOrderBean().setOrder_no(order_no));
		if (memberIntegralOrderBean == null) {
			throw new AppException("订单不存在!");
		}

		if (!"wait_pay".equals(memberIntegralOrderBean.getOrder_state())) {
			throw new AppException("非代付款订单!");
		}

		int num = memberDao.updateMemberIntegralOrderDetail(
				new MemberIntegralOrderBean().setOrder_id(memberIntegralOrderBean.getOrder_id()).setCash_fee(cash_fee)
						.setOut_trade_no(order_no).setSign(sign).setTransaction_id(transaction_id).setOrder_state("end")
						.setPay_time(TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss")));
		if (num <= 0) {
			throw new AppException("订单状态更新失败");
		}

		MemberBean memberBean = memberDao.getMemberDetail(
				new MemberBean().setMember_id(NumberUtils.Integer(memberIntegralOrderBean.getMember_id())));
		if (memberBean == null) {
			throw new AppException("用户不存在!");
		}

		int member_integral = NumberUtils.Integer(memberBean.getMember_integral())
				+ NumberUtils.Integer(memberIntegralOrderBean.getOrder_integral());
		num = memberDao.updateMemberDetail(
				new MemberBean().setMember_id(NumberUtils.Integer(memberIntegralOrderBean.getMember_id()))
						.setMember_integral(member_integral + ""));
		if (num <= 0) {
			throw new AppException("用户积分更新失败!");
		}
		return "<xml><return_code><![CDATA[SUCCESS]]></return_code></xml>";
	}

	public Object insertMemberIntegralOrder(MemberIntegralOrderBean memberIntegralOrderBean) {
		// TODO Auto-generated method stub
		MemberBean memberBean = memberDao.getMemberDetail(
				new MemberBean().setMember_id(NumberUtils.Integer(memberIntegralOrderBean.getMember_id())));

		UUIDUtils uuidUtils = new UUIDUtils(1);
		String order_no = uuidUtils.nextId(false, 10) + "";
		Map<String, String> map = null;
		if ("wx_pub".equals(memberIntegralOrderBean.getPay_way())) {// 公众号支付
			map = WXUtils.getWxPubPay(wx_AppID, wx_AppSecret, weixin_partnerkey, weixin_mchid,
					memberBean.getWeixin_open_id(), order_no,
					NumberUtils.Integer(memberIntegralOrderBean.getOrder_integral()) * 100, weixin_pub_notify_url);
			if (map == null) {
				throw new AppException("支付凭证认证失败!");
			}
			memberIntegralOrderBean.setPay_charge(JSON.toJSONString(map));
		}

		int num = memberDao.insertMemberIntegralOrder(memberIntegralOrderBean.setOrder_no(order_no));
		if (num <= 0) {
			throw new AppException("下单失败!");
		}

		if ("wx_pub".equals(memberIntegralOrderBean.getPay_way())) {// 公众号支付
			return map;
		}
		return null;
	}

	public int updateMemberDetail(MemberBean memberBean) {
		// TODO Auto-generated method stub
		return memberDao.updateMemberDetail(memberBean);
	}

	public MemberBean getMemberDetail(MemberBean memberBean) {
		// TODO Auto-generated method stub
		return memberDao.getMemberDetail(memberBean);
	}

	public Object wxLoginMember(MemberBean memberBean3, String code) {
		// TODO Auto-generated method stub

		WXPubBean wxPubBean = WXUtils.getWXUserInfo(wx_AppID, wx_AppSecret, code);
		if (wxPubBean == null) {
			throw new AppException("微信code有误");
		}

		UUID uuid = UUID.randomUUID();
		MemberBean memberBean2 = new MemberBean().setWeixin_open_id(wxPubBean.getOpenid())
				.setMember_nick_name(wxPubBean.getNickname()).setMember_img(wxPubBean.getHeadimgurl())
				.setMember_token(uuid.toString());
				

		MemberBean memberBean1 = memberDao.getMemberDetail(new MemberBean().setWeixin_open_id(wxPubBean.getOpenid()));
		if (memberBean1 != null) {
			int num = memberDao.updateMemberDetail(memberBean1.setMember_token(uuid.toString()));
			if (num <= 0) {
				throw new AppException("更新失败");
			}
		} else {
			String pass = "";
			String t = NumberUtils.createRandom(true, 6);
			boolean is_success = false;
			try {
				pass = MD5Util.md5Encode(NumberUtils.createRandom(false, 10));
				is_success = HuanXinUtils.registerOneUser(hx_id, hx_name, memberBean2.getWeixin_open_id() + t, pass);
				// if (!is_success) {
				// throw new AppException("环信注册失败!");
				// }
			} catch (Exception e) {
				// TODO: handle exception
				throw new AppException("环信注册失败!");
			}

			int num = memberDao.registerMember(memberBean2.setMember_token(uuid.toString())
					.setHx_account(memberBean2.getWeixin_open_id() + t).setHx_password(pass)
					.setFill_invitation_code(memberBean3.getFill_invitation_code()));
			if (num > 0) {
				memberBean1 = memberDao.getMemberDetail(new MemberBean().setMember_id(memberBean2.getMember_id()));
			} else {
				throw new AppException("注册失败");
			}
		}

		boolean is_success = RedisUtils.setKey("member_id" + memberBean1.getMember_id(), uuid.toString());
		if (!is_success) {
			throw new AppException("缓存失败!");
		}

		return memberBean1.setMember_password("");
	}

	@Override
	public Object wxLiteLoginMember(String code, String is_bind_mobile) {
		// TODO Auto-generated method stub
		WXPubBean wxPubBean = WXUtils.getWXLiteUserInfo(wx_lite_AppID, wx_lite_AppSecret, code);
		if (wxPubBean == null) {
			throw new AppException("微信code有误");
		}

		UUID uuid = UUID.randomUUID();

		MemberBean memberBean1 = memberDao
				.getMemberDetail(new MemberBean().setWeixin_lite_open_id(wxPubBean.getOpenid()));
		if (memberBean1 != null) {
			int num = memberDao.updateMemberDetail(memberBean1.setMember_token(uuid.toString()));
			if (num <= 0) {
				throw new AppException("更新失败");
			}

			boolean is_success = RedisUtils.setKey("member_id" + memberBean1.getMember_id(), uuid.toString());
			if (!is_success) {
				throw new AppException("缓存失败!");
			}
		} else {

			if ("1".equals(is_bind_mobile)) {// 需要绑定手机号 先不注册入库
				return new MemberBean().setWeixin_lite_open_id(wxPubBean.getOpenid())
						.setMember_nick_name(wxPubBean.getNickname()).setMember_img(wxPubBean.getHeadimgurl());
			} else {
				MemberBean memberBean2 = new MemberBean().setWeixin_lite_open_id(wxPubBean.getOpenid())
						.setMember_nick_name(wxPubBean.getNickname()).setMember_img(wxPubBean.getHeadimgurl())
						.setMember_token(uuid.toString());
				String pass = "";
				String t = NumberUtils.createRandom(true, 6);
				boolean is_success = false;
				try {
					pass = MD5Util.md5Encode(NumberUtils.createRandom(false, 10));
					is_success = HuanXinUtils.registerOneUser(hx_id, hx_name, memberBean2.getWeixin_lite_open_id() + t, pass);
					// if (!is_success) {
					// throw new AppException("环信注册失败!");
					// }
				} catch (Exception e) {
					// TODO: handle exception
					throw new AppException("环信注册失败!");
				}

				int num = memberDao.registerMember(memberBean2.setMember_token(uuid.toString())
						.setHx_account(memberBean2.getWeixin_lite_open_id() + t).setHx_password(pass));
				if (num > 0) {
					memberBean1 = memberDao.getMemberDetail(new MemberBean().setMember_id(memberBean2.getMember_id()));
				} else {
					throw new AppException("注册失败");
				}

				is_success = RedisUtils.setKey("member_id" + memberBean1.getMember_id(), uuid.toString());
				if (!is_success) {
					throw new AppException("缓存失败!");
				}
			}
		}

		return memberBean1.setMember_password("");
	}

	@Override
	public Object wxLitBindMobile(MemberBean memberBean, CodeBean codeBean) {
		// TODO Auto-generated method stub

		if (memberBean.getMember_account() == null || memberBean.getMember_account().length() != 11) {
			throw new AppException("手机号非法!");
		}

		if (settingDao.getCodeBeanByMobileAndCode(
				codeBean.setMobile(memberBean.getMember_account()).setCode_type("binding_mobile")
						.setCreate_time(TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss"))) == null) {
			throw new AppException("此验证码已过期!");
		}

		MemberBean memberBean2 = memberDao
				.getMemberDetail(new MemberBean().setMember_account(memberBean.getMember_account()));

		UUID uuid = UUID.randomUUID();

		if (memberBean2 != null) {// 该手机号已经注册过
			if (!StringUtils.isNull(memberBean2.getWeixin_lite_open_id())) {
				throw new AppException("该手机号已绑定小程序");
			}

			int num = memberDao.updateMemberDetail(new MemberBean().setMember_id(memberBean2.getMember_id())
					.setWeixin_lite_open_id(memberBean.getWeixin_lite_open_id())
					.setMember_img(memberBean.getMember_img()).setMember_nick_name(memberBean.getMember_nick_name())
					.setMember_token(uuid.toString()));
			if (num <= 0) {
				throw new AppException("更新失败");
			}

			boolean is_success = RedisUtils.setKey("member_id" + memberBean2.getMember_id(), uuid.toString());
			if (!is_success) {
				throw new AppException("缓存失败!");
			}

			settingDao.deleteCodeByMobileAndCode(codeBean);

			return memberBean2.setMember_id(memberBean2.getMember_id())
					.setWeixin_lite_open_id(memberBean.getWeixin_lite_open_id())
					.setMember_img(memberBean.getMember_img()).setMember_nick_name(memberBean.getMember_nick_name())
					.setMember_token(uuid.toString()).setMember_password("");
		} else {
			String pass = "";
			String t = NumberUtils.createRandom(true, 6);
			boolean is_success = false;
			try {
				pass = MD5Util.md5Encode(NumberUtils.createRandom(false, 10));
				is_success = HuanXinUtils.registerOneUser(hx_id, hx_name, memberBean.getMember_account() + t, pass);
				// if (!is_success) {
				// throw new AppException("环信注册失败!");
				// }
			} catch (Exception e) {
				// TODO: handle exception
				throw new AppException("环信注册失败!");
			}

			int num = memberDao.registerMember(memberBean.setMember_token(uuid.toString())
					.setHx_account(memberBean.getMember_account() + t).setHx_password(pass));
			if (num <= 0) {
				throw new AppException("注册失败!");
			}

			MemberBean memberBean3 = memberDao
					.getMemberDetail(new MemberBean().setMember_id(memberBean.getMember_id()));

			is_success = RedisUtils.setKey("member_id" + memberBean3.getMember_id(), uuid.toString());
			if (!is_success) {
				throw new AppException("缓存失败!");
			}

			settingDao.deleteCodeByMobileAndCode(codeBean);
			return memberBean3.setMember_password("");
		}
	}

	@Override
	public Object getAlipayCharge() {
		String result = AlipayUtils.getAlipayCharge(alipay_app_id, alipay_private_key, alipay_pid);
		if (result == null) {
			throw new AppException("签名失败!");
		}
		return result;
	}

	@Override
	public Object alipayAppLoginMember(String auth_code) {
		// TODO Auto-generated method stub
		AlipayUserInfoShareResponse response2 = AlipayUtils.getMemberDetail(alipay_app_id, alipay_private_key,
				alipay_public_key, auth_code);
		if (response2 == null) {
			throw new AppException("授权失败!");
		}
		MemberBean memberBean2 = memberDao
				.getMemberDetail(new MemberBean().setAlipay_app_open_id(response2.getUserId()));
		if (memberBean2 != null) {// 已经登录过
			UUID uuid = UUID.randomUUID();

			int num = memberDao.updateMemberDetail(memberBean2.setMember_token(uuid.toString()));
			if (num <= 0) {
				throw new AppException("更新失败");
			}

			boolean is_success = RedisUtils.setKey("member_id" + memberBean2.getMember_id(), uuid.toString());
			if (!is_success) {
				throw new AppException("缓存失败!");
			}
			return memberBean2.setMember_password("");
		} else {// 未登录过 需要绑定手机号
			return new MemberBean().setAlipay_app_open_id(response2.getUserId())
					.setMember_nick_name(response2.getNickName()).setMember_img(response2.getAvatar());
		}

	}

	@Override
	public Object alipayAppBindMobile(MemberBean memberBean, CodeBean codeBean) {
		// TODO Auto-generated method stub

		if (memberBean.getMember_account() == null || memberBean.getMember_account().length() != 11) {
			throw new AppException("手机号非法!");
		}

		if (settingDao.getCodeBeanByMobileAndCode(
				codeBean.setMobile(memberBean.getMember_account()).setCode_type("binding_mobile")
						.setCreate_time(TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss"))) == null) {
			throw new AppException("此验证码已过期!");
		}

		MemberBean memberBean2 = memberDao
				.getMemberDetail(new MemberBean().setMember_account(memberBean.getMember_account()));

		UUID uuid = UUID.randomUUID();

		if (memberBean2 != null) {// 该手机号已经注册过
			if (!StringUtils.isNull(memberBean2.getAlipay_app_open_id())) {
				throw new AppException("该手机号已绑定支付宝");
			}

			int num = memberDao.updateMemberDetail(new MemberBean().setMember_id(memberBean2.getMember_id())
					.setAlipay_app_open_id(memberBean.getAlipay_app_open_id()).setMember_img(memberBean.getMember_img())
					.setMember_nick_name(memberBean.getMember_nick_name()).setMember_token(uuid.toString()));
			if (num <= 0) {
				throw new AppException("更新失败");
			}

			boolean is_success = RedisUtils.setKey("member_id" + memberBean2.getMember_id(), uuid.toString());
			if (!is_success) {
				throw new AppException("缓存失败!");
			}

			settingDao.deleteCodeByMobileAndCode(codeBean);

			return memberBean2.setMember_id(memberBean2.getMember_id())
					.setAlipay_app_open_id(memberBean.getAlipay_app_open_id()).setMember_img(memberBean.getMember_img())
					.setMember_nick_name(memberBean.getMember_nick_name()).setMember_token(uuid.toString())
					.setMember_password("");
		} else {
			String pass = "";
			String t = NumberUtils.createRandom(true, 6);
			boolean is_success = false;
			try {
				pass = MD5Util.md5Encode(NumberUtils.createRandom(false, 10));
				is_success = HuanXinUtils.registerOneUser(hx_id, hx_name, memberBean.getMember_account() + t, pass);
				// if (!is_success) {
				// throw new AppException("环信注册失败!");
				// }
			} catch (Exception e) {
				// TODO: handle exception
				throw new AppException("环信注册失败!");
			}

			int num = memberDao.registerMember(memberBean.setMember_token(uuid.toString())
					.setHx_account(memberBean.getMember_account() + t).setHx_password(pass));
			if (num <= 0) {
				throw new AppException("注册失败!");
			}

			MemberBean memberBean3 = memberDao
					.getMemberDetail(new MemberBean().setMember_id(memberBean.getMember_id()));

			is_success = RedisUtils.setKey("member_id" + memberBean3.getMember_id(), uuid.toString());
			if (!is_success) {
				throw new AppException("缓存失败!");
			}

			settingDao.deleteCodeByMobileAndCode(codeBean);
			return memberBean3.setMember_password("");
		}
	}

	@Override
	public Object wxAppLoginMember(MemberBean memberBean) {
		// TODO Auto-generated method stub
		MemberBean memberBean2 = memberDao
				.getMemberDetail(new MemberBean().setWeixin_app_open_id(memberBean.getWeixin_app_open_id()));
		if (memberBean2 != null) {// 已经登录过
			UUID uuid = UUID.randomUUID();
			if ("1".equals(memberBean2.getMember_state())) {
				throw new AppException("该用户已被禁用!");
			}
			int num = memberDao.updateMemberDetail(memberBean2.setMember_token(uuid.toString()));
			if (num <= 0) {
				throw new AppException("更新失败");
			}

			boolean is_success = RedisUtils.setKey("member_id" + memberBean2.getMember_id(), uuid.toString());
			if (!is_success) {
				throw new AppException("缓存失败!");
			}
			return memberBean2.setMember_password("");
		} else {// 未登录过 需要绑定手机号
			return memberBean;
		}
	}

	@Override
	public Object wxAppBindMobile(MemberBean memberBean, CodeBean codeBean) {
		// TODO Auto-generated method stub

		if (memberBean.getMember_account() == null || memberBean.getMember_account().length() != 11) {
			throw new AppException("手机号非法!");
		}

		if (settingDao.getCodeBeanByMobileAndCode(
				codeBean.setMobile(memberBean.getMember_account()).setCode_type("binding_mobile")
						.setCreate_time(TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss"))) == null) {
			throw new AppException("此验证码已过期!");
		}

		MemberBean memberBean2 = memberDao
				.getMemberDetail(new MemberBean().setMember_account(memberBean.getMember_account()));

		UUID uuid = UUID.randomUUID();

		if (memberBean2 != null) {// 该手机号已经注册过
			if (!StringUtils.isNull(memberBean2.getWeixin_app_open_id())) {
				throw new AppException("该手机号已绑定微信");
			}
			MemberBean memberBean3 =new MemberBean().setMember_id(memberBean2.getMember_id())
					.setWeixin_app_open_id(memberBean.getWeixin_app_open_id()).setMember_token(uuid.toString());
			if("".equals(memberBean2.getMember_img()) || memberBean2.getMember_img() == null){
				memberBean3.setMember_img(memberBean.getMember_img());
			}
			if("".equals(memberBean2.getMember_nick_name()) || memberBean2.getMember_nick_name() == null){
				memberBean3.setMember_nick_name(memberBean.getMember_nick_name());
			}
			int num = memberDao.updateMemberDetail(memberBean3);
			if (num <= 0) {
				throw new AppException("更新失败");
			}

			boolean is_success = RedisUtils.setKey("member_id" + memberBean2.getMember_id(), uuid.toString());
			if (!is_success) {
				throw new AppException("缓存失败!");
			}

			settingDao.deleteCodeByMobileAndCode(codeBean);

			return memberBean2.setMember_id(memberBean2.getMember_id())
					.setWeixin_app_open_id(memberBean.getWeixin_app_open_id()).setMember_token(uuid.toString())
					.setMember_password("");
		} else {
			String pass = "";
			String t = NumberUtils.createRandom(true, 6);
			boolean is_success = false;
			try {
				pass = MD5Util.md5Encode(NumberUtils.createRandom(false, 10));
				is_success = HuanXinUtils.registerOneUser(hx_id, hx_name, memberBean.getMember_account() + t, pass);
				// if (!is_success) {
				// throw new AppException("环信注册失败!");
				// }
			} catch (Exception e) {
				// TODO: handle exception
				throw new AppException("环信注册失败!");
			}

			int num = memberDao.registerMember(memberBean.setMember_token(uuid.toString())
					.setHx_account(memberBean.getMember_account() + t).setHx_password(pass));
			if (num <= 0) {
				throw new AppException("注册失败!");
			}

			MemberBean memberBean3 = memberDao
					.getMemberDetail(new MemberBean().setMember_id(memberBean.getMember_id()));

			is_success = RedisUtils.setKey("member_id" + memberBean3.getMember_id(), uuid.toString());
			if (!is_success) {
				throw new AppException("缓存失败!");
			}

			settingDao.deleteCodeByMobileAndCode(codeBean);
			return memberBean3.setMember_password("");
		}
	}
	
	@Override
	public Object qqAppLoginMember(MemberBean memberBean) {
		// TODO Auto-generated method stub
		MemberBean memberBean2 = memberDao
				.getMemberDetail(new MemberBean().setQq_open_id(memberBean.getQq_open_id()));
		if (memberBean2 != null) {// 已经登录过
			UUID uuid = UUID.randomUUID();
			if ("1".equals(memberBean2.getMember_state())) {
				throw new AppException("该用户已被禁用!");
			}
			int num = memberDao.updateMemberDetail(memberBean2.setMember_token(uuid.toString()));
			if (num <= 0) {
				throw new AppException("更新失败");
			}

			boolean is_success = RedisUtils.setKey("member_id" + memberBean2.getMember_id(), uuid.toString());
			if (!is_success) {
				throw new AppException("缓存失败!");
			}
			return memberBean2.setMember_password("");
		} else {// 未登录过 需要绑定手机号
			return memberBean;
		}
	}

	@Override
	public Object qqAppBindMobile(MemberBean memberBean, CodeBean codeBean) {
		// TODO Auto-generated method stub

		if (memberBean.getMember_account() == null || memberBean.getMember_account().length() != 11) {
			throw new AppException("手机号非法!");
		}

		if (settingDao.getCodeBeanByMobileAndCode(
				codeBean.setMobile(memberBean.getMember_account()).setCode_type("binding_mobile")
						.setCreate_time(TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss"))) == null) {
			throw new AppException("此验证码已过期!");
		}

		MemberBean memberBean2 = memberDao
				.getMemberDetail(new MemberBean().setMember_account(memberBean.getMember_account()));

		UUID uuid = UUID.randomUUID();

		if (memberBean2 != null) {// 该手机号已经注册过
			if (!StringUtils.isNull(memberBean2.getQq_open_id())) {
				throw new AppException("该手机号已绑定QQ");
			}
			MemberBean memberBean3 =new MemberBean().setMember_id(memberBean2.getMember_id())
					.setQq_open_id(memberBean.getQq_open_id()).setMember_token(uuid.toString());
			if("".equals(memberBean2.getMember_img()) || memberBean2.getMember_img() == null){
				memberBean3.setMember_img(memberBean.getMember_img());
			}
			if("".equals(memberBean2.getMember_nick_name()) || memberBean2.getMember_nick_name() == null){
				memberBean3.setMember_nick_name(memberBean.getMember_nick_name());
			}
			int num = memberDao.updateMemberDetail(memberBean3);
			if (num <= 0) {
				throw new AppException("更新失败");
			}

			boolean is_success = RedisUtils.setKey("member_id" + memberBean2.getMember_id(), uuid.toString());
			if (!is_success) {
				throw new AppException("缓存失败!");
			}

			settingDao.deleteCodeByMobileAndCode(codeBean);

			return memberBean2.setMember_id(memberBean2.getMember_id())
					.setQq_open_id(memberBean.getQq_open_id()).setMember_token(uuid.toString())
					.setMember_password("");
		} else {
			String pass = "";
			String t = NumberUtils.createRandom(true, 6);
			boolean is_success = false;
			try {
				pass = MD5Util.md5Encode(NumberUtils.createRandom(false, 10));
				is_success = HuanXinUtils.registerOneUser(hx_id, hx_name, memberBean.getMember_account() + t, pass);
				// if (!is_success) {
				// throw new AppException("环信注册失败!");
				// }
			} catch (Exception e) {
				// TODO: handle exception
				throw new AppException("环信注册失败!");
			}

			int num = memberDao.registerMember(memberBean.setMember_token(uuid.toString())
					.setHx_account(memberBean.getMember_account() + t).setHx_password(pass));
			if (num <= 0) {
				throw new AppException("注册失败!");
			}

			MemberBean memberBean3 = memberDao
					.getMemberDetail(new MemberBean().setMember_id(memberBean.getMember_id()));

			is_success = RedisUtils.setKey("member_id" + memberBean3.getMember_id(), uuid.toString());
			if (!is_success) {
				throw new AppException("缓存失败!");
			}

			settingDao.deleteCodeByMobileAndCode(codeBean);
			return memberBean3.setMember_password("");
		}
	}
	@Override
	public Object weiboAppLoginMember(MemberBean memberBean) {
		// TODO Auto-generated method stub
		MemberBean memberBean2 = memberDao
				.getMemberDetail(new MemberBean().setWeibo_open_id(memberBean.getWeibo_open_id()));
		if (memberBean2 != null) {// 已经登录过
			UUID uuid = UUID.randomUUID();
			if ("1".equals(memberBean2.getMember_state())) {
				throw new AppException("该用户已被禁用!");
			}
			int num = memberDao.updateMemberDetail(memberBean2.setMember_token(uuid.toString()));
			if (num <= 0) {
				throw new AppException("更新失败");
			}

			boolean is_success = RedisUtils.setKey("member_id" + memberBean2.getMember_id(), uuid.toString());
			if (!is_success) {
				throw new AppException("缓存失败!");
			}
			return memberBean2.setMember_password("");
		} else {// 未登录过 需要绑定手机号
			return memberBean;
		}
	}

	@Override
	public Object weiboAppBindMobile(MemberBean memberBean, CodeBean codeBean) {
		// TODO Auto-generated method stub

		if (memberBean.getMember_account() == null || memberBean.getMember_account().length() != 11) {
			throw new AppException("手机号非法!");
		}

		if (settingDao.getCodeBeanByMobileAndCode(
				codeBean.setMobile(memberBean.getMember_account()).setCode_type("binding_mobile")
						.setCreate_time(TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss"))) == null) {
			throw new AppException("此验证码已过期!");
		}

		MemberBean memberBean2 = memberDao
				.getMemberDetail(new MemberBean().setMember_account(memberBean.getMember_account()));

		UUID uuid = UUID.randomUUID();

		if (memberBean2 != null) {// 该手机号已经注册过
			if (!StringUtils.isNull(memberBean2.getWeibo_open_id())) {
				throw new AppException("该手机号已绑定微博");
			}
			MemberBean memberBean3 =new MemberBean().setMember_id(memberBean2.getMember_id())
					.setWeibo_open_id(memberBean.getWeibo_open_id()).setMember_token(uuid.toString());
			if("".equals(memberBean2.getMember_img()) || memberBean2.getMember_img() == null){
				memberBean3.setMember_img(memberBean.getMember_img());
			}
			if("".equals(memberBean2.getMember_nick_name()) || memberBean2.getMember_nick_name() == null){
				memberBean3.setMember_nick_name(memberBean.getMember_nick_name());
			}
			int num = memberDao.updateMemberDetail(memberBean3);
			if (num <= 0) {
				throw new AppException("更新失败");
			}

			boolean is_success = RedisUtils.setKey("member_id" + memberBean2.getMember_id(), uuid.toString());
			if (!is_success) {
				throw new AppException("缓存失败!");
			}

			settingDao.deleteCodeByMobileAndCode(codeBean);

			return memberBean2.setMember_id(memberBean2.getMember_id())
					.setWeibo_open_id(memberBean.getWeibo_open_id()).setMember_token(uuid.toString())
					.setMember_password("");
		} else {
			String pass = "";
			String t = NumberUtils.createRandom(true, 6);
			boolean is_success = false;
			try {
				pass = MD5Util.md5Encode(NumberUtils.createRandom(false, 10));
				is_success = HuanXinUtils.registerOneUser(hx_id, hx_name, memberBean.getMember_account() + t, pass);
				// if (!is_success) {
				// throw new AppException("环信注册失败!");
				// }
			} catch (Exception e) {
				// TODO: handle exception
				throw new AppException("环信注册失败!");
			}

			int num = memberDao.registerMember(memberBean.setMember_token(uuid.toString())
					.setHx_account(memberBean.getMember_account() + t).setHx_password(pass));
			if (num <= 0) {
				throw new AppException("注册失败!");
			}

			MemberBean memberBean3 = memberDao
					.getMemberDetail(new MemberBean().setMember_id(memberBean.getMember_id()));

			is_success = RedisUtils.setKey("member_id" + memberBean3.getMember_id(), uuid.toString());
			if (!is_success) {
				throw new AppException("缓存失败!");
			}

			settingDao.deleteCodeByMobileAndCode(codeBean);
			return memberBean3.setMember_password("");
		}
	}

	public Object loginMember(MemberBean memberBean) {
		// TODO Auto-generated method stub
		String member_password = "";
		try {
			member_password = MD5Util.md5Encode(memberBean.getMember_password());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("加密失败!");
		}
		UUID uuid = UUID.randomUUID();

		MemberBean memberBean2 = memberDao.getMemberDetail(memberBean.setMember_password(""));
		if (memberBean2 == null) {
			throw new AppException("该手机号还未注册!");
		}
		if ("1".equals(memberBean2.getMember_state())) {
			throw new AppException("该用户已被禁用!");
		}
		if (!member_password.equals(memberBean2.getMember_password())) {
			throw new AppException("密码错误!");
		}

		int num = memberDao.updateMemberDetail(
				new MemberBean().setMember_id(memberBean2.getMember_id()).setMember_token(uuid.toString())
				.setJiguang_token(memberBean.getJiguang_token()));
		if (num <= 0) {
			throw new AppException("token更新失败");
		}

		boolean is_success = RedisUtils.setKey("member_id" + memberBean2.getMember_id(), uuid.toString());
		if (!is_success) {
			throw new AppException("缓存失败!");
		}
		return memberBean2.setMember_token(uuid.toString()).setMember_password("2");
	}

	/**
	 * 验证码登录
	 * 
	 * @param memberBean
	 * @return
	 */
	public Object CodeLoginMember(MemberBean memberBean, CodeBean codeBean) {
		UUID uuid = UUID.randomUUID();
		MemberBean memberBean2 = null;

		if (settingDao.getCodeBeanByMobileAndCode(codeBean.setMobile(memberBean.getMember_account())
				.setCode_type("login").setCreate_time(TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss"))) == null) {
			throw new AppException("此验证码错误或已过期!");
		}
		memberBean2 = memberDao.getMemberDetail(memberBean.setMember_password(""));
		if (memberBean2 == null) {
			String pass = "123456";
			try {
				pass = MD5Util.md5Encode(NumberUtils.createRandom(false, 10));
			} catch (Exception e) {
				// TODO: handle exception
				throw new AppException("加密失败!");
			}
			String t = NumberUtils.createRandom(true, 6);
			boolean is_success = HuanXinUtils.registerOneUser(hx_id, hx_name, memberBean.getMember_account() + t, pass);

			int num = memberDao
					.registerMember(memberBean.setHx_password(pass).setHx_account(memberBean.getMember_account() + t)
							.setHx_nick_name(memberBean.getMember_account() + t).setMember_token(uuid.toString()));
			if (num > 0) {
				settingDao.deleteCodeByMobileAndCode(codeBean);
				boolean is_success2 = RedisUtils.setKey("member_id" + memberBean.getMember_id(), uuid.toString());
				if (!is_success2) {
					throw new AppException("缓存失败!");
				}
				return memberDao.getMemberDetail(memberBean);
			}

		} else {
			
			if ("1".equals(memberBean2.getMember_state())) {
				throw new AppException("该用户已被禁用!");
			}
			int num = memberDao.updateMemberDetail(
					new MemberBean().setMember_id(memberBean2.getMember_id()).setMember_token(uuid.toString()));
			if (num <= 0) {
				throw new AppException("token更新失败");
			}

			// 删除验证码
			num = settingDao.deleteCodeByMobileAndCode(codeBean);
			if (num <= 0) {
				throw new AppException("验证码删除失败");
			}
		}

		boolean is_success = RedisUtils.setKey("member_id" + memberBean2.getMember_id(), uuid.toString());
		if (!is_success) {
			throw new AppException("缓存失败!");
		}
		return memberBean2.setMember_token(uuid.toString()).setMember_password("2");
	}

	public Object registerMember(MemberBean memberBean, CodeBean codeBean) {
		// TODO Auto-generated method stub
		if (memberBean.getMember_account() == null || memberBean.getMember_account().length() != 11) {
			throw new AppException("手机号非法!");
		}

		if (settingDao.getCodeBeanByMobileAndCode(codeBean.setMobile(memberBean.getMember_account())
				.setCode_type("register").setCreate_time(TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss"))) == null) {
			throw new AppException("此验证码已过期!");
		}

		MemberBean memberBean2 = memberDao
				.getMemberDetail(new MemberBean().setMember_account(memberBean.getMember_account()));
		if (memberBean2 != null) {
			throw new AppException("该手机号已注册过!");
		}

		try {
			String pass = "";
			try {
				pass = MD5Util.md5Encode(memberBean.getMember_password());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new AppException("加密失败!");
			}

			String t = NumberUtils.createRandom(true, 6);
			boolean is_success = HuanXinUtils.registerOneUser(hx_id, hx_name, memberBean.getMember_account() + t, pass);
			if("".equals(memberBean.getMember_img()) && memberBean.getMember_img() == null){
				memberBean.setMember_img("/default.png");
			}
			int num = memberDao.registerMember(memberBean.setMember_password(pass)
					.setHx_account(memberBean.getMember_account() + t).setHx_password(pass)
					.setHx_nick_name(memberBean.getMember_account() + t).setMember_token(UUID.randomUUID().toString()));

			if (num > 0) {
				settingDao.deleteCodeByMobileAndCode(codeBean);
				return memberDao.getMemberDetail(memberBean);
			} else {
				throw new AppException("注册失败");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException(e.getMessage());
		}

	}

	public Object forgetPassword(MemberBean memberBean, CodeBean codeBean) {
		// TODO Auto-generated method stub
		MemberBean memberDetail = memberDao.getMemberDetail(new MemberBean()
				.setMember_account(memberBean.getMember_account()).setMember_type(memberBean.getMember_type()));
		if (memberDetail == null) {
			throw new AppException("此号码未注册");
		}
		try {
			if (MD5Util.md5Encode(memberBean.getMember_password()).equals(memberDetail.getMember_password())) {
				throw new AppException("新密码不可以与原密码相同");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (settingDao.getCodeBeanByMobileAndCode(
				codeBean.setMobile(memberBean.getMember_account()).setCode_type("forget_password")
						.setCreate_time(TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss"))) == null) {
			throw new AppException("验证码已过期");
		}

		try {
			memberBean.setMember_password(MD5Util.md5Encode(memberBean.getMember_password()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("密码加密失败");
		}

		int num = memberDao.updateMemberDetail(memberBean);
		if (num > 0) {
			settingDao.deleteCodeByMobileAndCode(codeBean);
		} else {
			throw new AppException("修改密码失败");
		}
		return "密码修改成功";
	}

	public Object payPassword(MemberBean memberBean, CodeBean codeBean) {
		if (settingDao.getCodeBeanByMobileAndCode(
				codeBean.setMobile(memberBean.getMember_account()).setCode_type("pay_password")
						.setCreate_time(TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss"))) == null) {
			throw new AppException("验证码已过期");
		}

		try {
			memberBean.setPay_password(MD5Util.md5Encode(memberBean.getPay_password()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new AppException("密码加密失败");
		}

		int num = memberDao.payPassword(memberBean);
		if (num > 0) {
			settingDao.deleteCodeByMobileAndCode(codeBean);
		} else {
			throw new AppException("设置密码失败");
		}
		return "密码设置成功";

	}

	public Object insertBankCard(BankCardBean bankCardBean) {
		// TODO Auto-generated method stub
		int num = memberDao.insertBankCard(bankCardBean);
		if (num <= 0) {
			throw new AppException("添加失败");
		}
		return num;
	}

	public Object deleteBankCard(BankCardBean bankCardBean) {
		// TODO Auto-generated method stub
		int num = memberDao.deleteBankCard(bankCardBean);
		if (num <= 0) {
			throw new AppException("解除绑定失败");
		}
		return num;
	}

	public Object getBankCards(BankCardBean bankCardBean) {
		// TODO Auto-generated method stub
		List<BankCardBean> bankCards = memberDao.getBankCards(bankCardBean);
		return bankCards;
	}

	public Object getBankCardDetail(BankCardBean bankCardBean) {
		// TODO Auto-generated method stub
		BankCardBean bankCardDetail = memberDao.getBankCardDetail(bankCardBean);
		return bankCardDetail;
	}

	public Object updateBankCardDetail(BankCardBean bankCardBean) {
		// TODO Auto-generated method stub
		int num = memberDao.updateBankCardDetail(bankCardBean);
		if (num <= 0) {
			throw new AppException("修改失败");
		}
		return num;
	}

	@Override
	public int insertMemberMsg(MemberMsgBean memberMsgBean) {
		// TODO Auto-generated method stub
		return memberDao.insertMemberMsg(memberMsgBean);
	}

	@Override
	public Object getMemberMsgs(MemberMsgBean memberMsgBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<MemberMsgBean> memberMsgBeans = memberDao.getMemberMsgs(memberMsgBean, pageBean);
		return pageBean.setObject(memberMsgBeans);
	}

	@Override
	public MemberMsgBean getMemberMsgsDetail(MemberMsgBean memberMsgBean) {
		MemberMsgBean memberMsgBean2 = memberDao.getMemberMsgsDetail(memberMsgBean);
		int num = memberDao
				.updateMemberMsgDetail(new MemberMsgBean().setIs_read("1").setMsg_id(memberMsgBean2.getMsg_id()));
		if (num <= 0) {
			throw new AppException("消息更新失败");
		}
		return memberMsgBean2;
	}

	@Override
	public MsgTypeBean getMsgType(MsgTypeBean msgTypeBean) {
		// TODO Auto-generated method stub
		return memberDao.getMsgType(msgTypeBean);
	}

	@Override
	public Object getMembers(MemberBean memberBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<MemberBean> memberBeans = memberDao.getMembers(memberBean, pageBean);
		if (memberBeans != null && memberBeans.size() > 0) {
			for (int i = 0; i < memberBeans.size(); i++) {
				MemberBean memberBean2 = memberBeans.get(i);
				memberBean2.setPay_password("").setMember_password("");
			}

		}
		return pageBean.setObject(memberBeans);
	}

	/**
	 * 消息统计
	 */
	@Override
	public Object getMsgCount(MemberMsgBean memberMsgBean) {
	Map<String ,String> map=memberDao.getMsgCount(memberMsgBean.setIs_read("0"));
		return map;
	}
	
	@Override
	public Object getMemberSignByMemberId(MemberSignBean memberSignBean) {
		MemberSignBean memberSignBean2 = memberDao.getMemberSignByMemberId(memberSignBean);
		if(memberSignBean2 == null){
			//没有签到信息 
			return 0;
		}
		//获取今天的签到信息
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(date);
		String last_modify_time = memberSignBean2.getLast_modify_time().substring(0, 10);
		if(today.equals(last_modify_time)){
			//最近签到时间与系统时间相等 表示今日已经签到
			return 1;
		}else{
			//不相等 未签到
			return 0;
		}
	}

	@Override
	public Object updateMemberSign(MemberSignBean memberSignBean) {
		int num =1;
		MemberSignBean memberSignBean2 = memberDao.getMemberSignByMemberId(memberSignBean);
		if(memberSignBean2 == null){
			//没有签到信息 添加签到记录
			 num = memberDao.insertMemberSign(memberSignBean);
			if(num <= 0){
				throw new AppException("签到失败!");
			}
		}else{
			//有签到信息记录 修改签到信息
			int count = NumberUtils.Integer(memberSignBean2.getCount());
			count++;
			num = memberDao.updateMemberSign(new MemberSignBean().setCount(count+"").setSign_id(memberSignBean2.getSign_id()));
			if(num <= 0){
				throw new AppException("签到失败!");
			}
		}
		//签到后增加用户颜值币
		MemberBean memberBean = memberDao.getMemberDetail(new MemberBean().setMember_id(Integer.valueOf(memberSignBean.getMember_id())));
		if(memberBean == null){
			throw new AppException("用户信息不存在!");
		}
		PercentBean percentBean = memberDao.getPercentDetail(new PercentBean().setPercent_type("member_sign"));
		int sign_monnaie = 0;
		if(percentBean != null){
			sign_monnaie = NumberUtils.Integer(percentBean.getPercent_value());
		}
		int  monnaie = NumberUtils.Integer(memberBean.getGoods_monnaie());
		monnaie = monnaie + sign_monnaie;
		num = memberDao.updateMemberDetail(new MemberBean().setMember_id(memberBean.getMember_id()).setGoods_monnaie(monnaie+""));
		if(num <= 0){
			throw new AppException("用户颜值币修改失败!");
		}
		return num;
	}

	@Override
	public Object getSendTaskByMember(MemberTaskBean memberTaskBean) {
		MemberTaskBean memberTaskBean2 = memberDao.getTaskByMember(memberTaskBean.setTask_type("send"));
		
		if(memberTaskBean2 == null ){
			MemberTaskBean memberTaskBean3 = new MemberTaskBean();
			//没有领取记录 去统计用户今日发帖的次数
			Map<String, Object> map = memberDao.getSystemInformationCount(new SystemInformationBean()
					.setMember_id(Integer.valueOf(memberTaskBean.getMember_id())));
			int count = NumberUtils.Integer(map.get("total_count").toString());
			if(count>=1){
				memberTaskBean3.setTask_state("have_done");
				memberTaskBean3.setCount("1");
				memberTaskBean3.setTask_type("send");
				memberTaskBean3.setMember_id(memberTaskBean.getMember_id());
				return memberTaskBean3;
			}else{
				memberTaskBean3.setTask_state("wait_do");
				memberTaskBean3.setCount("0");
				memberTaskBean3.setTask_type("send");
				memberTaskBean3.setMember_id(memberTaskBean.getMember_id());
				return memberTaskBean3;
			}
		}else{//有领取记录 查看领取时间是否是今天
			
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String today = sdf.format(date);
			String last_modify_time = memberTaskBean2.getLast_modify_time().substring(0, 10);
			if(today.equals(last_modify_time)){
				//最近领取时间与系统时间相等 表示今日已经领取
				memberTaskBean2.setCount("1");
				return memberTaskBean2;
			}else{
				//今日未领取 统计今天的发帖次数
				Map<String, Object> map = memberDao.getSystemInformationCount(new SystemInformationBean()
						.setMember_id(Integer.valueOf(memberTaskBean.getMember_id())));
				int count = NumberUtils.Integer(map.get("total_count").toString());
				//次数大于1 待领取
				if(count>=1){
					memberTaskBean2.setTask_state("have_done");
					memberTaskBean2.setCount("1");
					memberTaskBean2.setTask_type("send");
					memberTaskBean2.setMember_id(memberTaskBean.getMember_id());
					return memberTaskBean2;
				}else{
					memberTaskBean2.setTask_state("wait_do");
					memberTaskBean2.setCount("0");
					memberTaskBean2.setTask_type("send");
					memberTaskBean2.setMember_id(memberTaskBean.getMember_id());
					return memberTaskBean2;
				}
			}
		}
	}

	@Override
	public Object updateTaskByType(MemberTaskBean memberTaskBean) {
		TaskClassBean taskClassBean = memberDao.getTaskClass(new TaskClassBean().setClass_type(memberTaskBean.getTask_type()));
		if(taskClassBean == null){
			throw new AppException("任务不存在!");
		}
		MemberTaskBean memberTaskBean2 = memberDao.getTaskByMember(memberTaskBean);
		int num = 0;
		if(memberTaskBean2 == null){
			//没有领取记录  添加一条发帖任务的领取记录
			num = memberDao.insertMemberTask(memberTaskBean.setCount(taskClassBean.getTask_num()).setTask_state("have_gain").setTask_type(taskClassBean.getClass_type()));
			if(num <=0){
				throw new AppException("领取失败!");
			}
			
		}else{
			num = memberDao.updateMemberTask(memberTaskBean2);
			if(num <=0){
				throw new AppException("领取失败!");
			}
		}
		//修改用户的颜值币
		//增加用户颜值币
		MemberBean memberBean = memberDao.getMemberDetail(new MemberBean().setMember_id(Integer.valueOf(memberTaskBean.getMember_id())));
		if(memberBean == null){
			throw new AppException("用户信息不存在!");
		}
		int  monnaie = NumberUtils.Integer(memberBean.getGoods_monnaie());
		int task_monnaie = NumberUtils.Integer(taskClassBean.getClass_monnaie());
		monnaie =monnaie +task_monnaie;
		num = memberDao.updateMemberDetail(new MemberBean().setMember_id(memberBean.getMember_id()).setGoods_monnaie(monnaie+""));
		if(num <= 0){
			throw new AppException("用户颜值币修改失败!");
		}
		return num;
	}

	@Override
	public Object updateInfoTask(MemberTaskBean memberTaskBean) {
		MemberTaskBean memberTaskBean2 = memberDao.getTaskByMember(memberTaskBean.setTask_type("info"));
		int num = 0;
		if(memberTaskBean2 == null){
			//没有领取记录  添加一条简历任务的领取记录
			num = memberDao.insertMemberTask(memberTaskBean.setCount("1").setTask_state("have_gain").setTask_type("info"));
			if(num <=0){
				throw new AppException("领取失败!");
			}
			
		}
		//修改用户的颜值币
		//增加用户颜值币
		MemberBean memberBean = memberDao.getMemberDetail(new MemberBean().setMember_id(Integer.valueOf(memberTaskBean.getMember_id())));
		if(memberBean == null){
			throw new AppException("用户信息不存在!");
		}
		int  monnaie = NumberUtils.Integer(memberBean.getGoods_monnaie());
		monnaie = monnaie + 20;
		num = memberDao.updateMemberDetail(new MemberBean().setMember_id(memberBean.getMember_id()).setGoods_monnaie(monnaie+""));
		if(num <= 0){
			throw new AppException("用户颜值币修改失败!");
		}
		return num;
	}

	@Override
	public Object getInfoTaskByMember(MemberTaskBean memberTaskBean) {
		MemberTaskBean memberTaskBean2 = memberDao.getTaskByMember(memberTaskBean.setTask_type("info"));
		if(memberTaskBean2 == null){
			MemberTaskBean memberTaskBean3 = new MemberTaskBean();
			//没有领取记录 去找用户的简历信息
			RequirePositionBean requirePositionBean = memberDao.getRequirePositionByMember(new RequirePositionBean().setMember_id(Integer.valueOf(memberTaskBean.getMember_id())));
			if(requirePositionBean != null){
				//简历信息为空 表示没有简历
				memberTaskBean3.setTask_state("have_done");
				memberTaskBean3.setCount("1");
				memberTaskBean3.setTask_type("info");
				memberTaskBean3.setMember_id(memberTaskBean.getMember_id());
				return memberTaskBean3;
			}else{
				memberTaskBean3.setTask_state("wait_do");
				memberTaskBean3.setCount("0");
				memberTaskBean3.setTask_type("info");
				memberTaskBean3.setMember_id(memberTaskBean.getMember_id());
				return memberTaskBean3;
			}
		}else{
			return memberTaskBean2;
		}
	}

	@Override
	public Object updateRealTask(MemberTaskBean memberTaskBean) {
		MemberTaskBean memberTaskBean2 = memberDao.getTaskByMember(memberTaskBean.setTask_type("real"));
		int num = 0;
		if(memberTaskBean2 == null){
			//没有领取记录  添加一条实名任务的领取记录
			num = memberDao.insertMemberTask(memberTaskBean.setCount("1").setTask_state("have_gain").setTask_type("real"));
			if(num <=0){
				throw new AppException("领取失败!");
			}
			
		}
		//修改用户的颜值币
		//增加用户颜值币
		MemberBean memberBean = memberDao.getMemberDetail(new MemberBean().setMember_id(Integer.valueOf(memberTaskBean.getMember_id())));
		if(memberBean == null){
			throw new AppException("用户信息不存在!");
		}
		int  monnaie = NumberUtils.Integer(memberBean.getGoods_monnaie());
		monnaie = monnaie + 20;
		num = memberDao.updateMemberDetail(new MemberBean().setMember_id(memberBean.getMember_id()).setGoods_monnaie(monnaie+""));
		if(num <= 0){
			throw new AppException("用户颜值币修改失败!");
		}
		return num;
	}

	@Override
	public Object getRealTaskByMember(MemberTaskBean memberTaskBean) {
		MemberTaskBean memberTaskBean2 = memberDao.getTaskByMember(memberTaskBean.setTask_type("real"));
		if(memberTaskBean2 == null){
			MemberTaskBean memberTaskBean3 = new MemberTaskBean();
			//没有领取记录 去找用户的简历信息
			RequirePositionBean requirePositionBean = memberDao.getRequirePositionByMember(new RequirePositionBean().setMember_id(Integer.valueOf(memberTaskBean.getMember_id())));
			if(requirePositionBean != null){
				if(StringUtils.isNull(requirePositionBean.getId_card())){
					memberTaskBean3.setTask_state("wait_do");
					memberTaskBean3.setCount("0");
					memberTaskBean3.setTask_type("real");
					memberTaskBean3.setMember_id(memberTaskBean.getMember_id());
					return memberTaskBean3;
				}else{
					//简历的身份证信息不为空 表示已经实名
					memberTaskBean3.setTask_state("have_done");
					memberTaskBean3.setCount("1");
					memberTaskBean3.setTask_type("real");
					memberTaskBean3.setMember_id(memberTaskBean.getMember_id());
					return memberTaskBean3;
				}
				
			}else{
				memberTaskBean3.setTask_state("wait_do");
				memberTaskBean3.setCount("0");
				memberTaskBean3.setTask_type("real");
				memberTaskBean3.setMember_id(memberTaskBean.getMember_id());
				return memberTaskBean3;
			}
		}else{
			return memberTaskBean2;
		}
	}

	@Override
	public Object updateAnswerTask(MemberTaskBean memberTaskBean) {
		MemberTaskBean memberTaskBean2 = memberDao.getTaskByMember(memberTaskBean.setTask_type("answer"));
		int num = 0;
		if(memberTaskBean2 == null){
			//没有领取记录  添加一条回复任务的领取记录
			num = memberDao.insertMemberTask(memberTaskBean.setCount("3").setTask_state("have_gain").setTask_type("answer"));
			if(num <=0){
				throw new AppException("领取失败!");
			}
			
		}else{
			num = memberDao.updateMemberTask(memberTaskBean2);
			if(num <=0){
				throw new AppException("领取失败!");
			}
		}
		//修改用户的颜值币
		//增加用户颜值币
		MemberBean memberBean = memberDao.getMemberDetail(new MemberBean().setMember_id(Integer.valueOf(memberTaskBean.getMember_id())));
		if(memberBean == null){
			throw new AppException("用户信息不存在!");
		}
		int  monnaie = NumberUtils.Integer(memberBean.getGoods_monnaie());
		monnaie = monnaie + 20;
		num = memberDao.updateMemberDetail(new MemberBean().setMember_id(memberBean.getMember_id()).setGoods_monnaie(monnaie+""));
		if(num <= 0){
			throw new AppException("用户颜值币修改失败!");
		}
		return num;
	}

	@Override
	public Object getAnswerTaskByMember(MemberTaskBean memberTaskBean) {
		MemberTaskBean memberTaskBean2 = memberDao.getTaskByMember(memberTaskBean.setTask_type("answer"));
		
		if(memberTaskBean2 == null ){
			MemberTaskBean memberTaskBean3 = new MemberTaskBean();
			//没有领取记录 去统计用户今日回复的次数
			Map<String, Object> map = memberDao.getSystemInformationAnswerCount(new InformationAssessmentBean().setMember_id(Integer.valueOf(memberTaskBean.getMember_id())));
			int count = NumberUtils.Integer(map.get("total_count").toString());
			if(count>=3){
				memberTaskBean3.setTask_state("have_done");
				memberTaskBean3.setCount("3");
				memberTaskBean3.setTask_type("answer");
				memberTaskBean3.setMember_id(memberTaskBean.getMember_id());
				return memberTaskBean3;
			}else{
				memberTaskBean3.setTask_state("wait_do");
				memberTaskBean3.setCount(count+"");
				memberTaskBean3.setTask_type("answer");
				memberTaskBean3.setMember_id(memberTaskBean.getMember_id());
				return memberTaskBean3;
			}
		}else{//有领取记录 查看领取时间是否是今天
			
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String today = sdf.format(date);
			String last_modify_time = memberTaskBean2.getLast_modify_time().substring(0, 10);
			if(today.equals(last_modify_time)){
				//最近领取时间与系统时间相等 表示今日已经领取
				memberTaskBean2.setCount("3");
				return memberTaskBean2;
			}else{
				//今日未领取 统计今天的回复次数
				Map<String, Object> map = memberDao.getSystemInformationAnswerCount(new InformationAssessmentBean().setMember_id(Integer.valueOf(memberTaskBean.getMember_id())));
				int count = NumberUtils.Integer(map.get("total_count").toString());
				//次数大于1 待领取
				if(count>=3){
					memberTaskBean2.setTask_state("have_done");
					memberTaskBean2.setCount("3");
					memberTaskBean2.setTask_type("answer");
					memberTaskBean2.setMember_id(memberTaskBean.getMember_id());
					return memberTaskBean2;
				}else{
					memberTaskBean2.setTask_state("wait_do");
					memberTaskBean2.setCount(count+"");
					memberTaskBean2.setTask_type("answer");
					memberTaskBean2.setMember_id(memberTaskBean.getMember_id());
					return memberTaskBean2;
				}
			}
		}
	}

	@Override
	public Object updateShareTask(MemberTaskBean memberTaskBean) {
		MemberTaskBean memberTaskBean2 = memberDao.getTaskByMember(memberTaskBean.setTask_type("share"));
		int num = 0;
		if(memberTaskBean2 == null){
			//没有领取记录  添加一条发帖任务的领取记录
			num = memberDao.insertMemberTask(memberTaskBean.setCount("3").setTask_state("have_gain").setTask_type("share"));
			if(num <=0){
				throw new AppException("领取失败!");
			}
			
		}else{
			num = memberDao.updateMemberTask(memberTaskBean2);
			if(num <=0){
				throw new AppException("领取失败!");
			}
		}
		//修改用户的颜值币
		//增加用户颜值币
		MemberBean memberBean = memberDao.getMemberDetail(new MemberBean().setMember_id(Integer.valueOf(memberTaskBean.getMember_id())));
		if(memberBean == null){
			throw new AppException("用户信息不存在!");
		}
		int  monnaie = NumberUtils.Integer(memberBean.getGoods_monnaie());
		monnaie = monnaie + 20;
		num = memberDao.updateMemberDetail(new MemberBean().setMember_id(memberBean.getMember_id()).setGoods_monnaie(monnaie+""));
		if(num <= 0){
			throw new AppException("用户颜值币修改失败!");
		}
		return num;
	}

	@Override
	public Object getShareTaskByMember(MemberTaskBean memberTaskBean) {
		MemberTaskBean memberTaskBean2 = memberDao.getTaskByMember(memberTaskBean.setTask_type("share"));
		
		if(memberTaskBean2 == null ){
			MemberTaskBean memberTaskBean3 = new MemberTaskBean();
			//没有领取记录 去统计用户今日分享的次数
			Map<String, Object> map = memberDao.getSystemInformationShareCount(new ShareRelationBean().setMember_id(memberTaskBean.getMember_id()));
			int count = NumberUtils.Integer(map.get("total_count").toString());
			if(count>=3){
				memberTaskBean3.setTask_state("have_done");
				memberTaskBean3.setCount("3");
				memberTaskBean3.setTask_type("share");
				memberTaskBean3.setMember_id(memberTaskBean.getMember_id());
				return memberTaskBean3;
			}else{
				memberTaskBean3.setTask_state("wait_do");
				memberTaskBean3.setCount(count+"");
				memberTaskBean3.setTask_type("share");
				memberTaskBean3.setMember_id(memberTaskBean.getMember_id());
				return memberTaskBean3;
			}
		}else{//有领取记录 查看领取时间是否是今天
			
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String today = sdf.format(date);
			String last_modify_time = memberTaskBean2.getLast_modify_time().substring(0, 10);
			if(today.equals(last_modify_time)){
				//最近领取时间与系统时间相等 表示今日已经领取
				memberTaskBean2.setCount("3");
				return memberTaskBean2;
			}else{
				//今日未领取 统计今天的分享次数
				Map<String, Object> map = memberDao.getSystemInformationShareCount(new ShareRelationBean().setMember_id(memberTaskBean.getMember_id()));
				int count = NumberUtils.Integer(map.get("total_count").toString());
				//次数大于1 待领取
				if(count>=3){
					memberTaskBean2.setTask_state("have_done");
					memberTaskBean2.setCount("3");
					memberTaskBean2.setTask_type("share");
					memberTaskBean2.setMember_id(memberTaskBean.getMember_id());
					return memberTaskBean2;
				}else{
					memberTaskBean2.setTask_state("wait_do");
					memberTaskBean2.setCount(count+"");
					memberTaskBean2.setTask_type("share");
					memberTaskBean2.setMember_id(memberTaskBean.getMember_id());
					return memberTaskBean2;
				}
			}
		}
	}

	@Override
	public Object getTasksByMember(TaskClassBean taskClassBean,PageBean pageBean) {
		//获取所有任务
		List<TaskClassBean> taskClassBeans = memberDao.getTaskClasses(taskClassBean,pageBean);
		for(TaskClassBean taskClassBean2 : taskClassBeans){
			MemberTaskBean memberTaskBean2 = memberDao.getTaskByMember(new MemberTaskBean()
					.setMember_id(taskClassBean.getMember_id()).setTask_type(taskClassBean2.getClass_type()));
			if(memberTaskBean2 == null ){
				//没有领取记录 去统计用户今日任务的完成次数
				if("send".equals(taskClassBean2.getClass_type())){
					Map<String, Object> map = memberDao.getSystemInformationCount(new SystemInformationBean()
							.setMember_id(Integer.valueOf(taskClassBean.getMember_id())));
					int count = NumberUtils.Integer(map.get("total_count").toString());
					int total = NumberUtils.Integer(taskClassBean2.getTask_num());
					if(count>=total){
						taskClassBean2.setDone_num(total+"");
						taskClassBean2.setTask_state("have_done");
					}else{
						taskClassBean2.setDone_num(count+"");
						taskClassBean2.setTask_state("wait_do");
					}
				}else if("share".equals(taskClassBean2.getClass_type())){
					Map<String, Object> map = memberDao.getSystemInformationShareCount(new ShareRelationBean().setMember_id(taskClassBean.getMember_id()));
					int count = NumberUtils.Integer(map.get("total_count").toString());
					int total = NumberUtils.Integer(taskClassBean2.getTask_num());
					if(count>=total){
						taskClassBean2.setDone_num(total+"");
						taskClassBean2.setTask_state("have_done");
					}else{
						taskClassBean2.setDone_num(count+"");
						taskClassBean2.setTask_state("wait_do");
					}
				}else if("answer".equals(taskClassBean2.getClass_type())){
					Map<String, Object> map = memberDao.getSystemInformationAnswerCount(new InformationAssessmentBean().setMember_id(Integer.valueOf(taskClassBean.getMember_id())));
					int count = NumberUtils.Integer(map.get("total_count").toString());
					int total = NumberUtils.Integer(taskClassBean2.getTask_num());
					if(count>=total){
						taskClassBean2.setDone_num(total+"");
						taskClassBean2.setTask_state("have_done");
					}else{
						taskClassBean2.setDone_num(count+"");
						taskClassBean2.setTask_state("wait_do");
					}
				}else if("info".equals(taskClassBean2.getClass_type())){
					//没有领取记录 去找用户的简历信息
					RequirePositionBean requirePositionBean = memberDao.getRequirePositionByMember(new RequirePositionBean().setMember_id(Integer.valueOf(taskClassBean.getMember_id())));
					if(requirePositionBean != null){
						//简历信息不为空 表示有简历
						taskClassBean2.setDone_num(taskClassBean2.getTask_num()+"");
						taskClassBean2.setTask_state("have_done");
						
					}else{
						taskClassBean2.setDone_num("0");
						taskClassBean2.setTask_state("wait_do");
						
					}
				}else if("real".equals(taskClassBean2.getClass_type())){
					RequirePositionBean requirePositionBean = memberDao.getRequirePositionByMember(new RequirePositionBean().setMember_id(Integer.valueOf(taskClassBean.getMember_id())));
					if(requirePositionBean != null){
						if(StringUtils.isNull(requirePositionBean.getId_card())){
							taskClassBean2.setDone_num("0");
							taskClassBean2.setTask_state("wait_do");
						}else{
							//简历的身份证信息不为空 表示已经实名
							taskClassBean2.setDone_num(taskClassBean2.getTask_num()+"");
							taskClassBean2.setTask_state("have_done");
						}
					}else{
						taskClassBean2.setDone_num("0");
						taskClassBean2.setTask_state("wait_do");
					}
				}
				
			}else{//有领取记录 查看领取时间是否是今天
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String today = sdf.format(date);
				String last_modify_time = memberTaskBean2.getLast_modify_time().substring(0, 10);
				if("send".equals(taskClassBean2.getClass_type())){
					if(today.equals(last_modify_time)){
						//最近领取时间与系统时间相等 表示今日已经领取
						taskClassBean2.setDone_num(taskClassBean2.getTask_num()+"");
						taskClassBean2.setTask_state(memberTaskBean2.getTask_state());
					}else{
						Map<String, Object> map = memberDao.getSystemInformationCount(new SystemInformationBean()
								.setMember_id(Integer.valueOf(taskClassBean.getMember_id())));
						int count = NumberUtils.Integer(map.get("total_count").toString());
						int total = NumberUtils.Integer(taskClassBean2.getTask_num());
						if(count>=total){
							taskClassBean2.setDone_num(total+"");
							taskClassBean2.setTask_state("have_done");
						}else{
							taskClassBean2.setDone_num(count+"");
							taskClassBean2.setTask_state("wait_do");
						}
					}
				}else if("share".equals(taskClassBean2.getClass_type())){
					if(today.equals(last_modify_time)){
						//最近领取时间与系统时间相等 表示今日已经领取
						taskClassBean2.setDone_num(taskClassBean2.getTask_num()+"");
						taskClassBean2.setTask_state(memberTaskBean2.getTask_state());
					}else{
						Map<String, Object> map = memberDao.getSystemInformationShareCount(new ShareRelationBean().setMember_id(taskClassBean.getMember_id()));
						int count = NumberUtils.Integer(map.get("total_count").toString());
						int total = NumberUtils.Integer(taskClassBean2.getTask_num());
						if(count>=total){
							taskClassBean2.setDone_num(total+"");
							taskClassBean2.setTask_state("have_done");
						}else{
							taskClassBean2.setDone_num(count+"");
							taskClassBean2.setTask_state("wait_do");
						}
					}
				}else if("answer".equals(taskClassBean2.getClass_type())){
					if(today.equals(last_modify_time)){
						//最近领取时间与系统时间相等 表示今日已经领取
						taskClassBean2.setDone_num(taskClassBean2.getTask_num()+"");
						taskClassBean2.setTask_state(memberTaskBean2.getTask_state());
					}else{
						Map<String, Object> map = memberDao.getSystemInformationAnswerCount(new InformationAssessmentBean().setMember_id(Integer.valueOf(taskClassBean.getMember_id())));
						int count = NumberUtils.Integer(map.get("total_count").toString());
						int total = NumberUtils.Integer(taskClassBean2.getTask_num());
						if(count>=total){
							taskClassBean2.setDone_num(total+"");
							taskClassBean2.setTask_state("have_done");
						}else{
							taskClassBean2.setDone_num(count+"");
							taskClassBean2.setTask_state("wait_do");
						}
					}
				}else if("info".equals(taskClassBean2.getClass_type())){
					taskClassBean2.setDone_num(taskClassBean2.getTask_num()+"");
					taskClassBean2.setTask_state(memberTaskBean2.getTask_state());
				}else if("real".equals(taskClassBean2.getClass_type())){
					taskClassBean2.setDone_num(taskClassBean2.getTask_num()+"");
					taskClassBean2.setTask_state(memberTaskBean2.getTask_state());
				}
			
			}
		}
		return pageBean.setObject(taskClassBeans);
	}

	

}
