package tst.project.utils;

import java.net.URLEncoder;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayUserInfoShareRequest;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.alipay.api.response.AlipayUserInfoShareResponse;

public class AlipayUtils {
	
	/**
	 * 获得支付宝用户信息
	 * @param APP_ID
	 * @param APP_PRIVATE_KEY
	 * @param ALIPAY_PUBLIC_KEY
	 * @param auth_code   app获得到授权code
	 * @return
	 */
	public static AlipayUserInfoShareResponse getMemberDetail(String APP_ID, String APP_PRIVATE_KEY,String ALIPAY_PUBLIC_KEY,String auth_code){
		try{
			AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", APP_ID, APP_PRIVATE_KEY, "json", "UTF-8", ALIPAY_PUBLIC_KEY, "RSA2");
	
			AlipaySystemOauthTokenRequest request = new AlipaySystemOauthTokenRequest();//创建API对应的request类
			request.setGrantType("authorization_code");
			request.setCode(auth_code);
			AlipaySystemOauthTokenResponse response = alipayClient.execute(request);//通过alipayClient调用API，获得对应的response类
			
			
			AlipayUserInfoShareRequest request2 = new AlipayUserInfoShareRequest();
			AlipayUserInfoShareResponse response2 = alipayClient.execute(request2,response.getAccessToken());
			if(response.isSuccess()){
				return response2;
			}else {
				return null;
			}	
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	
	public static String getAlipayCharge(String APP_ID, String APP_PRIVATE_KEY,String pid){
		try{	
			String result="apiname=com.alipay.account.auth"
					+ "&app_id="+APP_ID
					+ "&app_name=mc"
					+ "&auth_type=AUTHACCOUNT"
					+ "&biz_type=openservice"
					+ "&method=alipay.open.auth.sdk.code.get"
					+ "&pid="+pid
					+ "&product_id=APP_FAST_LOGIN"
					+ "&scope=kuaijie"
					+ "&sign_type=RSA2"
					+ "&target_id="+NumberUtils.createRandom(false, 32);
			String sign=AlipaySignature.rsa256Sign(result, APP_PRIVATE_KEY, "utf-8");
			sign=URLEncoder.encode(sign,"utf-8");
			return result+"&sign="+sign;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
