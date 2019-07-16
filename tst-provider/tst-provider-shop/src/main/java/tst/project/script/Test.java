package tst.project.script;

import java.security.MessageDigest;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.Cipher;

import com.alibaba.fastjson.JSON;

import net.iharder.Base64;
import tst.project.utils.MD5Util;
import tst.project.utils.RedisUtils;
import tst.project.utils.RsaUtils;
import tst.project.utils.TimeUtils;
import tst.project.utils.UUIDUtils;

import tst.project.utils.TimeUtils;

import java.io.FileInputStream;
import java.util.Properties;

public class Test {
	
	public static void main(String[] args) {
		
//		Map<String, Object> map=new HashMap<String, Object>();
//		map.put("template_id", "NBpuRQR2Ik9AcMN8bODlg7AvlsL0FiZKPW3ZaKAL8jw");
//		map.put("touser", "open_id");
//		map.put("url", "http://www.koubei123.cn/#/afterSaleDetail?refundId=refund_id");
//		
//		Map<String, Object> dataMap=new HashMap<String, Object>();
//		
//		
//		Map<String, Object> map1=new HashMap<String, Object>();
//		map1.put("value", "您申请“退款”的“goods_name”商品，商家已经退款“refund_price”金额到你的微信钱包");
//		map1.put("color", "#173177");
//		dataMap.put("first",map1);
//		
//		Map<String, Object> map2=new HashMap<String, Object>();
//		map2.put("value", "refund_no");
//		map2.put("color", "#173177");
//		dataMap.put("keyword1",map2);
//		
//		Map<String, Object> map3=new HashMap<String, Object>();
//		map3.put("value", "refund_state");
//		map3.put("color", "#173177");
//		dataMap.put("keyword2",map3);
//		
//		Map<String, Object> map4=new HashMap<String, Object>();
//		map4.put("value", "time");
//		map4.put("color", "#173177");
//		dataMap.put("keyword3",map4);
//		
//		Map<String, Object> map5=new HashMap<String, Object>();
//		map5.put("value", "address_name");
//		map5.put("color", "#173177");
//		dataMap.put("keyword4",map5);
//		
//		Map<String, Object> map6=new HashMap<String, Object>();
//		map6.put("value", "address_name");
//		map6.put("color", "#173177");
//		dataMap.put("keyword5",map6);
//		
//		Map<String, Object> map7=new HashMap<String, Object>();
//		map7.put("value", "点此链接进入售后订单页面查看，查看详情！");
//		map7.put("color", "#173177");
//		dataMap.put("remark",map7);
//	
//
//		map.put("data", dataMap);
//		System.out.println(JSON.toJSON(map));
		
//		try {
//			RSAPublicKey publicKey =RsaUtils.getPublicKey(RsaUtils.DEFAULT_PUBLIC_KEY);
//			String data = "login";
//	        Cipher cipher1 = Cipher.getInstance("RSA");  
//	        cipher1.init(Cipher.ENCRYPT_MODE, publicKey);  
//	       
//	        byte[] output= cipher1.doFinal(data.getBytes()); 
//	        String a=new String(Base64.encodeBytes(output));
//	        
//	        System.out.println("密文:"+new String(Base64.encodeBytes(output)));
//	        
//	        
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		RedisUtils.getJedis().keys("*");
//		Long num = RedisUtils.getJedis().del("shop_banners");
//		System.out.println(num);
//		System.out.println(RedisUtils.getJedis().keys("*"));
		
		
//		UUIDUtils uuidUtils = new UUIDUtils(1);
//		String order_no = uuidUtils.nextId(false, 1) + "";
//		System.out.println(order_no);

		
//		String str="cancel,wait_pay,wait_send,wait_receive,end,";
//		String a = str.replace("wait_pay,", ",");
		
//		System.out.print(TimeUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss"));
//		System.out.print("11,2".contains("3"));
//		System.out.print((int)Math.floor((10.0/4)));
		
		
	
		
//		String price = "2000";
//		System.out.println("-￥"+price);
		
		
		
		
		
		
//		Date date = new Date("2018-08-11");
//		
//		System.out.println(date.toString());
		
		
		String merchants_id = "4,";
		String merchants_id2 = "4,";
//		System.out.println(merchants_id.contains(","+merchants_id2));
		System.out.println(merchants_id.indexOf(merchants_id2));
		System.out.println(merchants_id.replace(merchants_id2, ""));
		
		
		
		
	}
}
