package tst.project.utils;

import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.google.gson.Gson;

import tst.project.wx.RequestHandler;

public class PayUtils {
	/**
	 * 微信小程序支付下单
	 * 
	 * @return
	 */
	public static Map<String, String> wxLitePay(Map<String, Object> map) {
		// 设置微信原生支付所需参数
		String appid = map.get("wx_lite_appid") + "";// "wxe5703c4e06a09cc8";
		String appsecret = map.get("wx_lite_appsecret") + ""; // merchantsWeiXinBean.getWeixin_appsecret();
		String partnerkey = map.get("wx_lite_partnerkey") + "";// "HAYServices137670713564607753998";//merchantsWeiXinBean.getPartnerkey();
		String mch_id = map.get("wx_lite_mch_id") + "";// "1265437601";//merchantsWeiXinBean.getMch_id();
		String nonce_str = NumberUtils.createRandom(false, 32);
		String openid = map.get("wx_lite_openid") + "";// memberBean2.getWx_pub_openid();
		String out_trade_no = map.get("out_trade_no") + "";
		String spbill_create_ip = "172.168.0.1";

		String total_fee = map.get("total_fee") + "";
		String trade_type = "JSAPI";
		String sign_type = "MD5";

		// 封装
		SortedMap<String, String> paraMap = new TreeMap<String, String>();
		paraMap.put("appid", appid);
		paraMap.put("attach", StringUtils.isNull(map.get("attach") + "") ? "商品购买" : map.get("attach") + "");
		paraMap.put("body", StringUtils.isNull(map.get("body") + "") ? "商品购买" : map.get("body") + "");
		paraMap.put("mch_id", mch_id);
		paraMap.put("nonce_str", nonce_str);

		paraMap.put("openid", openid);
		paraMap.put("out_trade_no", out_trade_no);
		paraMap.put("spbill_create_ip", spbill_create_ip);
		paraMap.put("total_fee", total_fee);
		paraMap.put("trade_type", trade_type);
		paraMap.put("notify_url", map.get("wx_lite_notify_url") + "");
		paraMap.put("sign_type", sign_type);

		// 签名
		RequestHandler reqHandler = new RequestHandler(null, null);
		reqHandler.init(appid, appsecret, partnerkey);
		String sign = reqHandler.createSign(paraMap);
		paraMap.put("sign", sign);

		// 统一下单
		String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
		String xml = WXUtils.ArrayToXml(paraMap);
		System.out.println(xml);
		System.out.println("-=========");
		String prepay_id = "";
		try {
			// 提交
			prepay_id = getPayNo(url, xml);
			if (prepay_id.equals("")) {
				return null;
			} else {
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
		System.out.println("付款单号" + prepay_id);
		SortedMap<String, String> packageParams = new TreeMap<String, String>();

		// 需要再次签名，这里要加上时间戳
		String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
		String prepay_id2 = "prepay_id=" + prepay_id;
		String packages = prepay_id2;
		packageParams.put("appId", appid);
		packageParams.put("timeStamp", timestamp);
		packageParams.put("nonceStr", nonce_str);
		packageParams.put("package", packages);
		packageParams.put("signType", sign_type);
		String finalsign = reqHandler.createSign(packageParams);

		packageParams.put("paySign", finalsign);
		return packageParams;
	}

	/**
	 * 微信小程序支付下单
	 * 
	 * @return
	 */
	public static Map<String, String> wxPubPay(Map<String, Object> map) {
		// 设置微信原生支付所需参数
		String appid = map.get("wx_pub_appid") + "";// "wxe5703c4e06a09cc8";
		String appsecret = map.get("wx_pub_appsecret") + ""; // merchantsWeiXinBean.getWeixin_appsecret();
		String partnerkey = map.get("wx_pub_partnerkey") + "";// "HAYServices137670713564607753998";//merchantsWeiXinBean.getPartnerkey();
		String mch_id = map.get("wx_pub_mch_id") + "";// "1265437601";//merchantsWeiXinBean.getMch_id();
		String nonce_str = NumberUtils.createRandom(false, 32);
		String openid = map.get("wx_pub_openid") + "";// memberBean2.getWx_pub_openid();
		String out_trade_no = map.get("out_trade_no") + "";
		String spbill_create_ip = "172.168.0.1";

		String total_fee = map.get("total_fee") + "";
		String trade_type = "JSAPI";
		String sign_type = "MD5";

		// 封装
		SortedMap<String, String> paraMap = new TreeMap<String, String>();
		paraMap.put("appid", appid);
		paraMap.put("attach", StringUtils.isNull(map.get("attach") + "") ? "商品购买" : map.get("attach") + "");
		paraMap.put("body", StringUtils.isNull(map.get("body") + "") ? "商品购买" : map.get("body") + "");
		paraMap.put("mch_id", mch_id);
		paraMap.put("nonce_str", nonce_str);

		paraMap.put("openid", openid);
		paraMap.put("out_trade_no", out_trade_no);
		paraMap.put("spbill_create_ip", spbill_create_ip);
		paraMap.put("total_fee", total_fee);
		paraMap.put("trade_type", trade_type);
		paraMap.put("notify_url", map.get("wx_pub_notify_url") + "");
		paraMap.put("sign_type", sign_type);

		// 签名
		RequestHandler reqHandler = new RequestHandler(null, null);
		reqHandler.init(appid, appsecret, partnerkey);
		String sign = reqHandler.createSign(paraMap);
		paraMap.put("sign", sign);

		// 统一下单
		String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
		String xml = WXUtils.ArrayToXml(paraMap);
		System.out.println(xml);
		System.out.println("-=========");
		String prepay_id = "";
		try {
			// 提交
			prepay_id = getPayNo(url, xml);
			if (prepay_id.equals("")) {
				return null;
			} else {
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
		System.out.println("付款单号" + prepay_id);
		SortedMap<String, String> packageParams = new TreeMap<String, String>();

		// 需要再次签名，这里要加上时间戳
		String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
		String prepay_id2 = "prepay_id=" + prepay_id;
		String packages = prepay_id2;
		packageParams.put("appId", appid);
		packageParams.put("timeStamp", timestamp);
		packageParams.put("nonceStr", nonce_str);
		packageParams.put("package", packages);
		packageParams.put("signType", sign_type);
		String finalsign = reqHandler.createSign(packageParams);

		packageParams.put("paySign", finalsign);
		return packageParams;
	}

	public static String getPayNo(String url, String xmlParam) {
		String prepay_id = "";
		try {
			String result = HttpUtils.getDataByJson(url, xmlParam);
			if (result.indexOf("FAIL") != -1) {
				return prepay_id;
			}
			// Map map = doXMLParse(result);
			// String return_code = (String) map.get("return_code");
			Document document = XmlUtils.getDocumentByXml(result);
			prepay_id = XmlUtils.getValueByTagName(document, "prepay_id");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			System.out.println("------------------------------" + e.getMessage());
		}
		return prepay_id;
	}

	public static SortedMap<String, String> wxPay(Map<String, Object> map) {
		// 设置微信原生支付所需参数
		String body = StringUtils.getNull(map.get("body") + "", "商品购买");
		String nonce_str = NumberUtils.createRandom(false, 30);
		String out_trade_no = map.get("out_trade_no") + "";
		System.out.println(out_trade_no);
		String spbill_create_ip = "127.0.0.1";
		int total_fee = NumberUtils.Integer(map.get("total_fee") + "");
		String trade_type = "APP";
		String notify_url = map.get("notify_url") + "";
		String packageValue = "Sign=WXPay";
		// 封装
		SortedMap<String, String> paraMap = new TreeMap<String, String>();
		paraMap.put("appid", map.get("wx_appid") + "");
		paraMap.put("body", body);
		paraMap.put("mch_id", map.get("wx_mch_id") + "");
		paraMap.put("nonce_str", nonce_str);
		paraMap.put("spbill_create_ip", spbill_create_ip);
		paraMap.put("out_trade_no", out_trade_no);
		paraMap.put("total_fee", total_fee + "");// total_fee
		paraMap.put("trade_type", trade_type);
		paraMap.put("notify_url", notify_url);

		// 签名
		RequestHandler reqHandler = new RequestHandler(null, null);
		reqHandler.init(map.get("wx_appid") + "", map.get("wx_appsecret") + "", map.get("wx_partnerkey") + "");
		String sign = reqHandler.createSign(paraMap);
		paraMap.put("sign", sign);

		// 统一下单https://api.mch.weixin.qq.com/pay/unifiedorder
		String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
		String xml = XmlUtils.ArrayToXml(paraMap);
		String prepay_id = "";
		try {
			// 提交
			prepay_id = WXUtils.getPayNo(url, xml);
			if (prepay_id.equals("")) {
				System.out.println("统一支付接口获取预支付订单出错");
				return null;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			return null;
		}
		SortedMap<String, String> packageParams = new TreeMap<String, String>();
		// 需要再次签名，这里要加上时间戳
		String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
		packageParams.put("appid", map.get("wx_appid") + "");
		packageParams.put("timestamp", timestamp);
		packageParams.put("noncestr", nonce_str);
		packageParams.put("package", packageValue);
		packageParams.put("prepayid", prepay_id);
		packageParams.put("partnerid", map.get("wx_mch_id") + "");
		String sign1 = reqHandler.createSign(packageParams);
		packageParams.put("sign", sign1);
		return packageParams;
	}

	public static Map<String,Object> wxAppRefund(Map<String, Object> map) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		String path = map.get("path")+"";//this.getClass().getResource("/").getFile().toString() + "apiclient_cert.p12";
		String refund_no = map.get("refund_no")+"";
		String nonce_str = NumberUtils.createRandom(false, 30);
		String mch_id = map.get("wx_mch_id")+"";
		String appid = map.get("wx_appid")+"";
		String secret = map.get("wx_appsecret")+"";
		String partnerkey = map.get("wx_partnerkey")+"";
		String out_trade_no = map.get("out_trade_no")+"";
		int total_fee = NumberUtils.Integer(map.get("total_fee") + "");
		int refund_fee = NumberUtils.Integer(map.get("refund_fee") + "");

		SortedMap<String, String> packageParams = new TreeMap<String, String>();
		packageParams.put("appid", appid);
		packageParams.put("mch_id", mch_id);
		packageParams.put("nonce_str", nonce_str);
		packageParams.put("out_trade_no", out_trade_no);
		packageParams.put("out_refund_no", refund_no);
		packageParams.put("total_fee", total_fee + "");
		packageParams.put("refund_fee", refund_fee + "");
		/*----2.根据package生成签名sign---- */
		RequestHandler reqHandler = new RequestHandler(null, null);
		reqHandler.init(appid, secret, partnerkey);
		String sign = reqHandler.createSign(packageParams);
		System.out.println("sign=" + sign);
		/*----3.拼装需要提交到微信的数据xml---- */
		String xml = "<xml>" + "<appid>" + appid + "</appid>" + "<mch_id>" + mch_id + "</mch_id>" + "<nonce_str>"
				+ nonce_str + "</nonce_str>" + "<out_refund_no>" + refund_no + "</out_refund_no>" + "<out_trade_no>"
				+ out_trade_no + "</out_trade_no>" + "<total_fee>" + total_fee + "</total_fee>" + "<refund_fee>" + refund_fee
				+ "</refund_fee>"
				+ "<sign>" + sign + "</sign>" + "</xml>";
		try {
			/*----4.读取证书文件,这一段是直接从微信支付平台提供的demo中copy的，所以一般不需要修改---- */
			KeyStore keyStore = KeyStore.getInstance("PKCS12");
			FileInputStream instream = new FileInputStream(new File(path));
			try {
				keyStore.load(instream,mch_id.toCharArray());
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				instream.close();
			}
			// Trust own CA and all self-signed certs
			@SuppressWarnings("deprecation")
			SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, mch_id.toCharArray()).build();
			// Allow TLSv1 protocol only
			@SuppressWarnings("deprecation")
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" },
					null, SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
			CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
			/*----5.发送数据到微信的退款接口---- */
			String url = "https://api.mch.weixin.qq.com/secapi/pay/refund";
			HttpPost httpost = new HttpPost(url); // 设置响应头信息
			httpost.setEntity(new StringEntity(xml, "UTF-8"));
			HttpResponse weixinResponse = httpClient.execute(httpost);
			if (weixinResponse.getEntity() == null) {
				resultMap.put("status", "error");
				resultMap.put("error", "无响应");
				return resultMap;
			}

			String jsonStr = EntityUtils.toString(weixinResponse.getEntity(), "UTF-8");
			
			Document document = XmlUtils.getDocumentByXml(jsonStr);
			String return_code = XmlUtils.getValueByTagName(document, "return_code");
			String return_msg = XmlUtils.getValueByTagName(document, "return_msg");
			String result_code = XmlUtils.getValueByTagName(document, "result_code");
			String err_code_des = XmlUtils.getValueByTagName(document, "err_code_des");
			
			if ("FAIL".equals(return_code)) {
				if ("invalid total_fee".equals(return_msg)) {
					resultMap.put("status", "error");
					resultMap.put("error", "无效的总金额");
					return resultMap;
				} else {
					resultMap.put("status", "error");
					resultMap.put("error", return_msg);
					return resultMap;
				}
			} else {
				if ("FAIL".equals(result_code)) {
					resultMap.put("status", "error");
					resultMap.put("error", err_code_des);
					return resultMap;
				}
			}
			
			
		} catch (Exception e) {
			resultMap.put("status", "error");
			resultMap.put("error", e.getMessage());
			return resultMap;
		}
		
		resultMap.put("status", "ok");
		return resultMap;

	}

	public static String alipay(Map<String, Object> map) {
		try {
			AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
			model.setBody(StringUtils.getNull(map.get("body") + "", "商品购买"));
			model.setSubject(StringUtils.getNull(map.get("subject") + "", "商品购买"));
			model.setOutTradeNo(map.get("out_trade_no") + "");
			model.setTotalAmount(map.get("total_fee") + "");

			// 实例化客户端
			AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",
					map.get("alipay_app_id") + "", map.get("alipay_private_key") + "", "json", "utf-8",
					map.get("alipay_public_key") + "", "RSA2");
			// 实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
			AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
			// SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
			// AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
			model.setProductCode("QUICK_MSECURITY_PAY");
			request.setBizModel(model);
			request.setNotifyUrl(map.get("notify_url") + "");
			AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
			// response.getBody()可以直接给客户端请求，无需再做处理。
			return response.getBody();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	
	 /**  支付宝退款接口
     * @param out_trade_no 订单支付时传入的商户订单号,不能和支付宝交易号（trade_no）同时为空。
     * @param trade_no 支付宝交易号
     * @param refund_amount 需要退款的金额，该金额不能大于订单金额,单位为元，支持两位小数
     * @return 将提示信息返回
     */
    public static Map<String,Object> alipayRefund(Map<String,Object> map) {
        Map<String,Object> resultMap=new HashMap<String,Object>();
        //out_request_no随机数  不是全额退款，部分退款使用该参数
        try {
        	AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do",
        			map.get("alipay_app_id")+"",  map.get("alipay_private_key") + "", "json", "utf-8",
        			map.get("alipay_public_key") + "", "RSA2");
            AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
            request.setBizContent("{" +
                    "\"out_trade_no\":\"" + map.get("out_trade_no") + "" + "\"," +
                  //  "\"trade_no\":\"" + refundBean.getPay_no() + "\"," +
                    "\"refund_amount\":\"" +   map.get("refund_fee")+ "\"," +
                    "\"out_request_no\":\"" +  map.get("refund_no")+ "\"," +
                    "\"refund_reason\":\"正常退款\"" +
                    " }");
            AlipayTradeRefundResponse response = alipayClient.execute(request);
            if (!response.isSuccess()) {
            	resultMap.put("status", "error");
    			resultMap.put("error",response.getSubMsg());
    			return resultMap;
    	    }

        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("status", "error");
			resultMap.put("error", e.getMessage());
			return resultMap;
        }
        resultMap.put("status", "ok");
        return resultMap;
    }
	public static void main(String[] args) {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("path", "/mnt/tomcat/images/clue/"+"apiclient_cert.p12");
//		map.put("out_trade_no","g2067966463485935625");
//		map.put("refund_no", NumberUtils.createRandom(false, 10));
//		map.put("total_fee", 1);// total_fee
//		map.put("refund_fee", 1);// total_fee
//		map.put("wx_appid", "wxdaeea85921c0c658");
//		map.put("wx_appsecret", "51ca476fcf7623149a6e33b1eb47e5a5");
//		map.put("wx_partnerkey", "q2kcawea9fg0r8fdq8ezs4necfbrd314");
//		map.put("wx_mch_id", "1505733491");
//		Map<String,Object> resultMap=PayUtils.wxAppRefund(map);
//		System.out.print(JSON.toJSON(resultMap));
		
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("alipay_app_id", "2018052360247120");
		map.put("alipay_private_key", "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCbBfqtSxNnhQ1RmrDFVkXkAsN+T1srmLrqUSIp+jyvhlXqQzOtEuz956WcpwRYlTJ9giIORO/fGJwCR0ZnDus5HxbWq9oM/Q6xYDftZLl6i0Ym/xQuvHNV3V1GZxuklS/pVxkMc25WCIT3a8Yx6GTewnIhjjfj9pFy+CoCIHqRm/3txzJEfmgqm9tbmykImUV23S9qFyAS1Coa6LQ+sNQwgiN3mTYyEqwDYqXKa/hX2FCKyiXEzq+Od0TFz3RPxBztfDY35c05obeGrxn0BJHNj++plW+UXhIxYFpKbAUUzASlq1qACuptZ23ehqRob6dhz3eq/nWkRumaWDotms89AgMBAAECggEBAImXrP7Se86N0Vx0qCD+idnuegVJ+emgDYabrG8Fo4dG/EqIiv06pw5U5DE+LCVThxTOw9tWZHDnLtD24g3mt/BjH6o5rbeJg9j7Rah2lgmmRAWosQkqSlQTvg4Wxfo2T+gTXjAm4++IcDwKdEcntR/iBdqyl/jFiCM7EE4C9cb1+ycLvSfg9ZiH/nllzXD2ZmNtg/9A3dfli783iepqfm7D0DB1G1L6qeuI83S07Lokej6373xARtslLKcG5r7eyh8AXm3SVJ/0rt7Y/N+poJ8GB4Ce9paP8civDnbCLS0g3qEwp3lQV1j7Sc7pBUhhxgWpnSf45npHhJBbWBvJHQECgYEA+BHikAfnP+FYFN3ZNJSZ1np7PwPu+JDclxU31N8l+DF6bGCfLWmeAl+4zduFi4ypQZs0tfznr/YCcJA3Bp5yQ78J2UBk9B4YtyVtpCBD+0j0jnIwTywa8OsxKbSYFTufp9PbqwyfqJW4FsJtYhKTVtTTDxeMfuslVbqDwItdfNkCgYEAn/qih3ZgLEsbLzrgzXKbleIQkzd7/4r3K8U1vnHd13vngQ+zUbwANQB+ycEpqqisoJQsWPuN1lD3NNZ7ZDI6dzTO+PKkJrtgGDNPNdnHjtb3GqEq7j8KKUyEpOxeAby7yO91uZ4Onv9+dXMfDNAAqB3MsFLYrGJi9vODCUCi9wUCgYBN0daAFmqd6IQoL5wm2YMU/GFTWFmMEm2Q27AjEEmp/WOJQhpNNbfCyOKBeZ8AMwUZtqWnfYn08ji7tRH9+pCf3fsp8wB4cESSl6Q4e4K3/p/xW7L58z0UXMOUcLnQ115zWIutsg0X5rfUM/P6cxdTgvoe3uVNH1kb9qHEMjQGqQKBgGS9Wl19IICj5wFtzSPyeKEAkzlxJgc8RfttGzPK1kycPKLb9SqR/XtizXRUy90ojFQuGmMKPT3pDFJcgaUNsB1ixrajbNTrB08V+FpLwktjeIVvWe5fChIJmjmUknn7lDCrAfIZ4tEiyEpDbRkPXmp/IWcjNEgRSIqDu083QafVAoGBAMSCztg4ELs2KYc7/LjbfnXKZlLx1uTk4Ioye+Ofs3ydX2OIk/2FVDnRBnFug7bjKO1UZfI55OktKij2R2Dx+zjGaYDJ3+Jr4APD5SFhyPnxQOUi7pMTzHsykEEBGQh8a+AL5xDIIzGRtIOeDrlptj7ZnDAiRaUwfvhACxzocS++");
		map.put("alipay_public_key", "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnYqIw3qipB2aSDvIEQg6rWLp7U/aztqf6nIECz1VS1M5KYbRe/enIFhJIZSsfWzxzbI56NxelSFrSkTT35gykMDv7Qvgr2Sk9B9wuAe9mxYEGcBrjI98f81KOR4uxCf5NyHyvTNBvzy4HtW8EYaLW41QS3MuF4T39SiMNZd+eACQw/DWz+NQ5TjzsLGpT2/b24dBhWVZ7a+zkPmBKHIIodc6hYvjh2eoHeHDUi34NjGK0hCnnzKjRtYdUaWfZBc6LzQwGs58HTbHRkol7IEKaBczIF1GyKHvRNIn5tBqFCXntzo5WpVlL3LWRDGcUGc3HHD676qx3BGyNHlocf9sGwIDAQAB");
		
		
		map.put("out_trade_no","g2075917213772021767");
		map.put("refund_no", NumberUtils.createRandom(false, 10));
		map.put("refund_fee", 1);// total_fee
		
		Map<String,Object> resultMap=PayUtils.alipayRefund(map);
		System.out.print(JSON.toJSON(resultMap));
		
	}
}
