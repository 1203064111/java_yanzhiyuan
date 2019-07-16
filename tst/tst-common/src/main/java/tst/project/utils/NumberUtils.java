package tst.project.utils;

import java.math.BigDecimal;

public class NumberUtils {
	
	/**  
     * 使用java正则表达式去掉多余的.与0  
     * @param s  
     * @return   
     */    
    public static String subZeroAndDot(String s){ 
    	if(s==null||"".equals(s)){
    		return s;
    	}
    	
    	s=NumberUtils.KeepDecimal(s,2)+"";
    	
        if(s.indexOf(".") > 0){    
            s = s.replaceAll("0+?$", "");//去掉多余的0    
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉    
        }    
        return s;    
    }
    
    
	/**
	 * 产生随机数
	 * 
	 * @param numberFlag
	 * @param length
	 * @return
	 */
	public static String createRandom(boolean numberFlag, int length) {
		String retStr = "";
		String strTable = numberFlag ? "1234567890" : "1234567890abcdefghijkmnpqrstuvwxyz";
		int len = strTable.length();
		boolean bDone = true;
		do {
			retStr = "";
			int count = 0;
			for (int i = 0; i < length; i++) {
				double dblR = Math.random() * len;
				int intR = (int) Math.floor(dblR);
				char c = strTable.charAt(intR);
				if (('0' <= c) && (c <= '9')) {
					count++;
				}
				retStr += strTable.charAt(intR);
			}
			if (count >= 2) {
				bDone = false;
			}
		} while (bDone);
		return retStr;
	}
	
	public static Double Double(String value){
		return value==null||"".equals(value)||"null".equals(value)?0:Double.valueOf(value);
	}
	
	public static int Integer(String value){
		try{
			return Integer.valueOf(value==null||"".equals(value)?"0":value);
		}catch(Exception e){
			return -1;
		}
	}
	
	public static long Long(String value){
		try{
			return Long.valueOf(value==null||"".equals(value)?"0":value);
		}catch(Exception e){
			return -1;
		}
	}
	
	public static float Float(String value){
		return Float.valueOf(value==null||"".equals(value)?"0":value);
	}
	/**
	 * 保留2位小数
	 * @param value
	 * @param count
	 * @return
	 */
	public static double KeepDecimal(double value,int count){
		BigDecimal   bd   =   new   BigDecimal(value);   
		bd=bd.setScale(count,BigDecimal.ROUND_HALF_UP);   
		return bd.doubleValue();
	}
	public static void main(String[] args) {
		System.out.print(createRandom(false,32));
	}
	
	/**
	 * 保留2位小数s
	 * @param value
	 * @param count
	 * @return
	 */
	public static double KeepDecimal(String value,int count){
		BigDecimal   bd   =   new   BigDecimal(value);   
		bd=bd.setScale(count,BigDecimal.ROUND_HALF_UP);   
		return bd.doubleValue();
	}
	/**
	 * 保留2位小数
	 * @param value
	 * @param count
	 * @return
	 */
	public static int KeepDecimal(double value){
		BigDecimal   bd   =   new   BigDecimal(value);   
		bd=bd.setScale(0,BigDecimal.ROUND_HALF_UP);   
		return bd.intValue();
	}
	

	

	
	/**
	 * 保留2位小数
	 * @param value
	 * @param count
	 * @return
	 */
	public static int KeepDecimal(String value){
		BigDecimal   bd   =   new   BigDecimal(value);   
		bd=bd.setScale(0,BigDecimal.ROUND_HALF_UP);   
		return bd.intValue();
	}
	
	/**
	 * 数字加法
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static double add(double v1, double v2) {
        BigDecimal b1=new BigDecimal(Double.toString(v1));
       BigDecimal b2 = new BigDecimal(Double.toString(v2));
       return b1.add(b2).doubleValue();
   }
	/**
	 * 数字减法
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static double subtract(double v1, double v2) {
        BigDecimal b1=new BigDecimal(Double.toString(v1));
       BigDecimal b2 = new BigDecimal(Double.toString(v2));
       return b1.subtract(b2) .doubleValue();
   }
	/**
	 * 数字乘法
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static double multiply(double v1, double v2) {
        BigDecimal b1=new BigDecimal(Double.toString(v1));
       BigDecimal b2 = new BigDecimal(Double.toString(v2));
       BigDecimal  b3=b1.multiply(b2);
       b3 = b3.setScale(2,BigDecimal.ROUND_HALF_UP);   
       return  b3.doubleValue();
   }
	/**
	 * 数字除法
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static double divide(double v1, double v2) {
        BigDecimal b1=new BigDecimal(Double.toString(v1));
       BigDecimal b2 = new BigDecimal(Double.toString(v2));
       BigDecimal  b3=b1.divide(b2);
       b3 = b3.setScale(2,BigDecimal.ROUND_HALF_UP);   
       return b3.doubleValue();
   }
}
