package tst.project.bean.sheep;

import java.io.Serializable;
import java.util.List;

import tst.project.utils.TimeUtils;

public class SignMonthBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String is_sign;
	private String total_day;
	private String times=TimeUtils.getCurrentTime("yyyy-MM-dd");

	private String member_id;
	private String today_coin;
	private List<SignBean> signBeans;
	
	
	
	
	
	public String getIs_sign() {
		return is_sign;
	}
	public SignMonthBean setIs_sign(String is_sign) {
		this.is_sign = is_sign;
		return this;
	}
	public String getToday_coin() {
		return today_coin;
	}
	public SignMonthBean setToday_coin(String today_coin) {
		this.today_coin = today_coin;
		return this;
	}
	public String getTimes() {
		return times;
	}
	public SignMonthBean setTimes(String times) {
		this.times = times;
		return this;
	}
	public String getTotal_day() {
		return total_day;
	}
	public SignMonthBean setTotal_day(String total_day) {
		this.total_day = total_day;
		return this;
	}
	
	public String getMember_id() {
		return member_id;
	}
	public SignMonthBean setMember_id(String member_id) {
		this.member_id = member_id;return this;
	}
	public List<SignBean> getSignBeans() {
		return signBeans;
	}
	public SignMonthBean setSignBeans(List<SignBean> signBeans) {
		this.signBeans = signBeans;return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
