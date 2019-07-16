package tst.project.service.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.NameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSON;

import tst.project.aspect.AppException;
import tst.project.bean.GaoDeBean;
import tst.project.bean.GeoCodesBean;
import tst.project.bean.shop.IndustryBean;
import tst.project.bean.shop.MerchantsBalanceBean;
import tst.project.bean.shop.MerchantsBean;
import tst.project.bean.shop.MerchantsBillBean;
import tst.project.bean.shop.MerchantsWithdrawalsBean;
import tst.project.bean.system.SystemAccountBean;
import tst.project.controller.ISystemService;
import tst.project.dao.controller.MerchantsDaoC;
import tst.project.page.PageBean;
import tst.project.shop.controller.IMerchantsServiceC;
import tst.project.utils.GaoDeMapUtils;
import tst.project.utils.HttpUtils;
import tst.project.utils.NumberUtils;
import tst.project.utils.QRCodeUtils;
import tst.project.utils.TimeUtils;

@Service
@Transactional
public class MerchantsServiceC implements IMerchantsServiceC {

	@Value("${img_path}")
	private String img_path;

	@Value("${qrcode_merchants}")
	private String qrcode_merchants;

	@Value("${map_key}")
	private String map_key;

	@Autowired
	MerchantsDaoC merchantsDaoC;

	@Autowired
	ISystemService systemService;

	@Override
	public Map<String, Object> getMerchantsStatistics(MerchantsBean merchantsBean) {
		// TODO Auto-generated method stub
		return merchantsDaoC.getMerchantsStatistics(merchantsBean);
	}

	public Object handleMerchantsWithdrawals(MerchantsWithdrawalsBean merchantsWithdrawalsBean) {
		// TODO Auto-generated method stub
		int num = merchantsDaoC.updateMerchantsWithdrawals(merchantsWithdrawalsBean);
		if (num <= 0) {
			throw new AppException("处理异常");
		}
		if ("2".equals(merchantsWithdrawalsBean.getWithdrawals_state())) {// 接受

		} else if ("3".equals(merchantsWithdrawalsBean.getWithdrawals_state())) {// 拒绝
			MerchantsWithdrawalsBean merchantsWithdrawalsBean2 = merchantsDaoC
					.getMerchantsWithdrawalsDetail(merchantsWithdrawalsBean);
			if (merchantsWithdrawalsBean2 == null) {
				throw new AppException("提现申请不存在!");
			}

			MerchantsBalanceBean merchantsBalanceBean = merchantsDaoC.getMerchantsBalanceDetail(
					new MerchantsBalanceBean().setMerchants_id(merchantsWithdrawalsBean2.getMerchants_id()));
			if (merchantsBalanceBean == null) {
				throw new AppException("账号信息不存在!");
			}

			double withdrawals_price = NumberUtils.Double(merchantsWithdrawalsBean2.getWithdrawals_price());
			double withdrawals_can_balance = NumberUtils.Double(merchantsBalanceBean.getWithdrawals_can_balance());
			double withdrawals_ing_balance = NumberUtils.Double(merchantsBalanceBean.getWithdrawals_ing_balance());

			num = merchantsDaoC.updateMerchantsBalance(
					new MerchantsBalanceBean().setMerchants_id(merchantsWithdrawalsBean2.getMerchants_id())
							.setWithdrawals_ing_balance((withdrawals_ing_balance - withdrawals_price) + "")
							.setWithdrawals_can_balance((withdrawals_can_balance + withdrawals_price) + ""));
			if (num <= 0) {
				throw new AppException("账户更新失败!");
			}

			num = merchantsDaoC.insertMerchantsBill(
					new MerchantsBillBean().setMerchants_id(merchantsWithdrawalsBean2.getMerchants_id())
							.setBill_price(merchantsWithdrawalsBean2.getWithdrawals_price() + "").setBill_type("3")
							.setWithdrawals_id(merchantsWithdrawalsBean2.getWithdrawals_id() + ""));
			if (num <= 0) {
				throw new AppException("账单入库");
			}
		} else if ("4".equals(merchantsWithdrawalsBean.getWithdrawals_state())) {// 打款
			MerchantsWithdrawalsBean merchantsWithdrawalsBean2 = merchantsDaoC
					.getMerchantsWithdrawalsDetail(merchantsWithdrawalsBean);
			if (merchantsWithdrawalsBean2 == null) {
				throw new AppException("提现申请不存在!");
			}

			MerchantsBalanceBean merchantsBalanceBean = merchantsDaoC.getMerchantsBalanceDetail(
					new MerchantsBalanceBean().setMerchants_id(merchantsWithdrawalsBean2.getMerchants_id()));
			if (merchantsBalanceBean == null) {
				throw new AppException("账号信息不存在!");
			}

			double withdrawals_already_balance = NumberUtils
					.Double(merchantsBalanceBean.getWithdrawals_already_balance());
			double withdrawals_price = NumberUtils.Double(merchantsWithdrawalsBean2.getWithdrawals_price());
			double withdrawals_ing_balance = NumberUtils.Double(merchantsBalanceBean.getWithdrawals_ing_balance());

			num = merchantsDaoC.updateMerchantsBalance(
					new MerchantsBalanceBean().setMerchants_id(merchantsWithdrawalsBean2.getMerchants_id())
							.setWithdrawals_ing_balance((withdrawals_ing_balance - withdrawals_price) + "")
							.setWithdrawals_already_balance((withdrawals_already_balance + withdrawals_price) + ""));
			if (num <= 0) {
				throw new AppException("账户更新失败!");
			}

			num = merchantsDaoC.updateMerchantsBill(new MerchantsBillBean()
					.setWithdrawals_id(merchantsWithdrawalsBean2.getWithdrawals_id() + "").setBill_type("4"));
		}
		return num;
	}

	public Object getMerchantsWithdrawalss(MerchantsWithdrawalsBean merchantsWithdrawalsBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<MerchantsWithdrawalsBean> merchantsWithdrawalsBeans = merchantsDaoC
				.getMerchantsWithdrawalss(merchantsWithdrawalsBean, pageBean);
		return pageBean.setObject(merchantsWithdrawalsBeans);
	}

	public Object applyMerchantsWithdrawals(MerchantsWithdrawalsBean merchantsWithdrawalsBean) {
		// TODO Auto-generated method stub
		MerchantsBalanceBean merchantsBalanceBean = merchantsDaoC.getMerchantsBalanceDetail(
				new MerchantsBalanceBean().setMerchants_id(merchantsWithdrawalsBean.getMerchants_id()));
		if (merchantsBalanceBean == null) {
			throw new AppException("账户异常");
		}

		double withdrawals_can_balance = NumberUtils.Double(merchantsBalanceBean.getWithdrawals_can_balance());// 可提现金额
		double withdrawals_ing_balance = NumberUtils.Double(merchantsBalanceBean.getWithdrawals_ing_balance());// 正在提现金额
		double withdrawals_price = NumberUtils.Double(merchantsWithdrawalsBean.getWithdrawals_price());// 本次提现金额
		if (withdrawals_can_balance < withdrawals_price) {
			throw new AppException("可提现金额不足");
		}

		int num = merchantsDaoC.insertMerchantsWithdrawals(merchantsWithdrawalsBean);
		if (num <= 0) {
			throw new AppException("申请提现入库失败");
		}

		num = merchantsDaoC.updateMerchantsBalance(
				new MerchantsBalanceBean().setMerchants_id(merchantsWithdrawalsBean.getMerchants_id())
						.setWithdrawals_can_balance((withdrawals_can_balance - withdrawals_price) + "")
						.setWithdrawals_ing_balance((withdrawals_ing_balance + withdrawals_price) + ""));
		if (num <= 0) {
			throw new AppException("账户信息修改失败");
		}

		num = merchantsDaoC.insertMerchantsBill(new MerchantsBillBean()
				.setMerchants_id(merchantsWithdrawalsBean.getMerchants_id()).setBill_price(withdrawals_price + "")
				.setBill_type("2").setWithdrawals_id(merchantsWithdrawalsBean.getWithdrawals_id() + ""));
		if (num <= 0) {
			throw new AppException("账单入库");
		}
		return num;
	}

	public Object getMerchantsBalanceDetail(MerchantsBalanceBean merchantsBalanceBean) {
		// TODO Auto-generated method stub
		return merchantsDaoC.getMerchantsBalanceDetail(merchantsBalanceBean);
	}

	public Object getMerchantsBills(MerchantsBillBean merchantsBillBean, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<MerchantsBillBean> merchantsBillBeans = merchantsDaoC.getMerchantsBills(merchantsBillBean, pageBean);
		return pageBean.setObject(merchantsBillBeans);
	}

	public Object getMerchantss(MerchantsBean merchantsBean, PageBean pageBean) {
		// TODO Auto-generated method stub\
		List<MerchantsBean> merchantsBeans = merchantsDaoC.getMerchantss(merchantsBean, pageBean);

		return pageBean.setObject(merchantsBeans);
	}

	public MerchantsBean getMerchantsDetail(MerchantsBean merchantsBean) {
		// TODO Auto-generated method stub
		MerchantsBean merchantsBean2 = merchantsDaoC.getMerchantsDetail(merchantsBean);
		return merchantsBean2;
	}

	public int insertMerchants(MerchantsBean merchantsBean) {

		// 修改详细地址时修改经纬度
		if (merchantsBean.getMerchants_detail_address() != null
				&& !"".equals(merchantsBean.getMerchants_detail_address())) {
			String address = merchantsBean.getMerchants_province() + merchantsBean.getMerchants_city()
					+ merchantsBean.getMerchants_country() + merchantsBean.getMerchants_detail_address();
			NameValuePair addressParams = new NameValuePair("address", address);
			NameValuePair output = new NameValuePair("output", "json");
			NameValuePair key = new NameValuePair("key", map_key);
			NameValuePair cityParams = new NameValuePair("city", "");

			String localtion = HttpUtils.getDataByPost("https://restapi.amap.com/v3/geocode/geo",
					new NameValuePair[] { addressParams, output, key, cityParams }, "utf-8");
			
			if (localtion != null) {
				GaoDeBean gaoDeBean = JSON.parseObject(localtion, GaoDeBean.class);
				if ("1".equals(gaoDeBean.getStatus())) {
					List<GeoCodesBean> geoCodes = gaoDeBean.getGeoCodes();
					if (!CollectionUtils.isEmpty(geoCodes)) {
						String[] localtion2 = geoCodes.get(0).getLocation().split(",");
						merchantsBean.setLongitude(localtion2[0]).setLatitude(localtion2[1]);
					}

				}
			}
		}
		int cert_num = 0;
		if (merchantsBean.getCertificate_imgs() != null && !"".equals(merchantsBean.getCertificate_imgs())) {
			String[] imgs = merchantsBean.getCertificate_imgs().split(",");
			cert_num = imgs.length;
		}

		// TODO Auto-generated method stub
		int num = merchantsDaoC.insertMerchants(merchantsBean.setCertificate_num(cert_num + ""));
		if (num <= 0) {
			throw new AppException("添加失败");
		}

		num = merchantsDaoC.insertMerchantsBalance(
				new MerchantsBalanceBean().setMerchants_id(merchantsBean.getMerchants_id() + ""));
		if (num <= 0) {
			throw new AppException("添加账号信息失败");
		}

		// String path=TimeUtils.getCurrentTime("yyyyMMdd");
		// String
		// fileName=TimeUtils.getCurrentTime("yyyyMMddHHmmss")+NumberUtils.createRandom(false,
		// 10)+".png";
		// QRCodeUtils.CreateQrcode(img_path,path,fileName,
		// qrcode_merchants+merchantsBean.getMerchants_id());
		//
		// num=merchantsDaoC.updateMerchants(new MerchantsBean()
		// .setMerchants_id(merchantsBean.getMerchants_id())
		// .setQrcode_img(path+"/"+fileName));
		return num;
	}

	public int updateMerchants(MerchantsBean merchantsBean) {
		// 修改详细地址时修改经纬度
		if (merchantsBean.getMerchants_detail_address() != null
				&& !"".equals(merchantsBean.getMerchants_detail_address())) {
			String address = merchantsBean.getMerchants_province() + merchantsBean.getMerchants_city()
					+ merchantsBean.getMerchants_country() + merchantsBean.getMerchants_detail_address();
			NameValuePair addressParams = new NameValuePair("address", address);
			NameValuePair output = new NameValuePair("output", "json");
			NameValuePair key = new NameValuePair("key", map_key);
			NameValuePair cityParams = new NameValuePair("city", "");

			String localtion = HttpUtils.getDataByPost("https://restapi.amap.com/v3/geocode/geo",
					new NameValuePair[] { addressParams, output, key, cityParams }, "utf-8");
			
			if (localtion != null) {
				GaoDeBean gaoDeBean = JSON.parseObject(localtion, GaoDeBean.class);
				if ("1".equals(gaoDeBean.getStatus())) {
					List<GeoCodesBean> geoCodes = gaoDeBean.getGeoCodes();
					if (!CollectionUtils.isEmpty(geoCodes)) {
						String[] localtion2 = geoCodes.get(0).getLocation().split(",");
						merchantsBean.setLongitude(localtion2[0]).setLatitude(localtion2[1]);
					}

				}
			}
		}
		int cert_num = 0;
		if (merchantsBean.getCertificate_imgs() != null && !"".equals(merchantsBean.getCertificate_imgs())) {
			String[] imgs = merchantsBean.getCertificate_imgs().split(",");
			cert_num = imgs.length;
		}
		// TODO Auto-generated method stub
		int num = merchantsDaoC.updateMerchants(merchantsBean.setCertificate_num(cert_num + ""));
		if (num <= 0) {
			throw new AppException("修改失败");
		}
		systemService
				.updateMerchantsAccount(new SystemAccountBean().setMerchants_id(merchantsBean.getMerchants_id() + "")
						.setMerchants_name(merchantsBean.getMerchants_name()));
		return num;
	}

	public int deleteMerchants(MerchantsBean merchantsBean) {
		// TODO Auto-generated method stub
		int num = merchantsDaoC.deleteMerchants(merchantsBean);
		if (num <= 0) {
			throw new AppException("删除失败");
		}
		return num;
	}

	@Override
	public Object auditMerchants(MerchantsBean merchantsBean) {
		// TODO Auto-generated method stub
		int num = merchantsDaoC.auditMerchants(merchantsBean);
		if (num <= 0) {
			throw new AppException("审核失败");
		}
		return num;
	}

	@Override
	public Object getMerchantssNoPage(MerchantsBean merchantsBean) {
		// TODO Auto-generated method stub
		return merchantsDaoC.getMerchantssNoPage(merchantsBean);
	}

}
