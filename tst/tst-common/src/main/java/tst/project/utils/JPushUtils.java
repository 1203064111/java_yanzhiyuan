package tst.project.utils;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

public class JPushUtils {
	public static void main(String[] args) {
		// android 1507bfd3f7ef14ab066
		// ios 121c83f7607c80ea89a
		Map<String, String> map = new HashMap<String, String>();
		map.put("order_id", "70");
		map.put("type", "6");
		map.put("order_type", "2");

//		sendNotificationByID("9800afa6543c152e31b0b9d0", "a6d596d8500d36b77db6c0f2", "18171adc035537e918e", "测试",
//				JSON.toJSONString(map));

		 sendNotificationByID("fa3b2aa680d876ab102e2b48","4bfe26a734e9426edf028b83"
		 ,"121c83f7600afbbd75e","一步e家已为您指派维修师傅，请耐心等待师傅上门",JSON.toJSONString(map));
	}

	public static void sendNotificationByID(String appid, String appsercent, String ID, String notification,
			String json) {
		JPushClient jpushClient = new JPushClient(appsercent, appid, null, ClientConfig.getInstance());
		Map<String, String> map = new HashMap<String, String>();
		map.put("value", json);
		try {
			PushPayload payload2 = PushPayload.newBuilder().setPlatform(Platform.all())
					.setAudience(Audience.registrationId(ID))
					.setNotification(Notification.newBuilder().addPlatformNotification(IosNotification.newBuilder()
							.setAlert(notification).setBadge(5).setSound("happy").addExtra("value", json).build())
							.build())
					.setOptions(Options.newBuilder()
	                        .setApnsProduction(true)//true-推送生产环境 false-推送开发环境（测试使用参数）
	                        .build())
					.build();

			PushResult result2 = jpushClient.sendPush(payload2);
			System.out.println("Got result - " + result2);
		} catch (APIConnectionException e) {
			// Connection error, should retry later
			System.out.println("Connection error, should retry later" + e);

		} catch (Exception e) {
			// Should review the error, and fix the request
			System.out.println("Should review the error, and fix the request" + e);
		}

		try {
			PushPayload payload = PushPayload.newBuilder().setPlatform(Platform.all())
					.setAudience(Audience.registrationId(ID))
					.setNotification(Notification.android(notification, notification, map)).build();

			PushResult result = jpushClient.sendPush(payload);
			System.out.println("Got result - " + result);
		} catch (APIConnectionException e) {
			// Connection error, should retry later
			System.out.println("Connection error, should retry later" + e);

		} catch (Exception e) {
			// Should review the error, and fix the request
			System.out.println("Should review the error, and fix the request" + e);
		}
	}
	
	public static String sendNotificationByID2(String appid, String appsercent, String ID, String notification,
			String json) {
		
		System.out.println("123");
		
		JPushClient jpushClient = new JPushClient(appsercent, appid, null, ClientConfig.getInstance());
		
		jpushClient.close();
		return "345";
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("value", json);
//		try {
//			PushPayload payload2 = PushPayload.newBuilder().setPlatform(Platform.all())
//					.setAudience(Audience.registrationId(ID))
//					.setNotification(Notification.newBuilder().addPlatformNotification(IosNotification.newBuilder()
//							.setAlert(notification).setBadge(5).setSound("happy").addExtra("value", json).build())
//							.build())
//
//					.build();
//
//			PushResult result2 = jpushClient.sendPush(payload2);
//			System.out.println("Got result - " + result2);
//		} catch (APIConnectionException e) {
//			// Connection error, should retry later
//			System.out.println("Connection error, should retry later" + e);
//
//		} catch (Exception e) {
//			// Should review the error, and fix the request
//			System.out.println("Should review the error, and fix the request" + e);
//		}
	}
	

}
