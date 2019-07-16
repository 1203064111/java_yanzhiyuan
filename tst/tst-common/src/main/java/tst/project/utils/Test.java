package tst.project.utils;

import java.io.UnsupportedEncodingException;
import java.net.Inet4Address;
import java.net.URLDecoder;

public class Test {
	public static void main(String[] args) {
		String aStrings = "0-300,300-400";		
		String[] aStrings2 = aStrings.split(",");
		for(String s:aStrings2){
			System.out.println(s);
		}
	}
}
