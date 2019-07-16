package tst.project.bean.sheep;

import java.io.Serializable;

public class SignBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int sign_id;
	private String is_sign;
	private String sign_day;
	private String is_delete;
	private String create_time;
	private String update_time;
	private String sign_month;
	private String sign_coin;
	private String member_id;
	
	
	public String getMember_id() {
		return member_id;
	}
	public SignBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getSign_coin() {
		return sign_coin;
		
	}
	public SignBean setSign_coin(String sign_coin) {
		this.sign_coin = sign_coin;
		return this;
	}
	public String getSign_month() {
		return sign_month;
	}
	public SignBean setSign_month(String sign_month) {
		this.sign_month = sign_month;
		return this;
	}
	public int getSign_id() {
		return sign_id;
	}
	public SignBean setSign_id(int sign_id) {
		this.sign_id = sign_id;
		return this;
	}
	public String getIs_sign() {
		return is_sign;
	}
	public SignBean setIs_sign(String is_sign) {
		this.is_sign = is_sign;
		return this;
	}
	public String getSign_day() {
		return sign_day;
	}
	public SignBean setSign_day(String sign_day) {
		this.sign_day = sign_day;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public SignBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public SignBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public SignBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
