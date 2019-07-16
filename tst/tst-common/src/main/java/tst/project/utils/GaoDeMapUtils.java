package tst.project.utils;

import java.util.List;
import java.util.Map;

import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSON;

import tst.project.bean.GaoDeBean;
import tst.project.bean.GeoCodesBean;


public class GaoDeMapUtils {
	
	/**
	 * 根据地址 解析出经纬度
	 * @param key
	 * @param address
	 * @return
	 */
	public static String geocoderLocation(String key,String address){
		try{
			String Url = "https://restapi.amap.com/v3/geocode/geo?address="+address+"&key="+key+"&output=JSON";
			String str=HttpUtils.sendGet(Url);
			GaoDeBean gaoDeBean=JSON.parseObject(str, GaoDeBean.class);
			if("1".equals(gaoDeBean.getStatus())){
				List<GeoCodesBean> geoCodes=gaoDeBean.getGeoCodes();
				if(CollectionUtils.isEmpty(geoCodes)){
					return null;
				}
				return geoCodes.get(0).getLocation();
			}else{
				return null;
			}
		}catch (Exception e) {
			return null;
		}
		
		
	}
	
	
	
	
//	public static void main(String[] args) {
//		System.out.println(geocoderLocation("adf34c98e649fb7b25f21d36de414655","上海市闵行区浦江镇浦瑞路55弄"));
//	}
}
