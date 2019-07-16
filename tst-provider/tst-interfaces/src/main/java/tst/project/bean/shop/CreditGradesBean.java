package tst.project.bean.shop;

import java.io.Serializable;

public class CreditGradesBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int credit_id;//授信ID
	private String credit_grades;//授信等级
	private String credit_balance;//授信等级额度
	private String member_count;//会员人数
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	
	
	public int getCredit_id() {
		return credit_id;
	}
	public CreditGradesBean setCredit_id(int credit_id) {
		this.credit_id = credit_id;
		return this;
	}
	public String getCredit_grades() {
		return credit_grades;
	}
	public CreditGradesBean setCredit_grades(String credit_grades) {
		this.credit_grades = credit_grades;
		return this;
	}
	public String getCredit_balance() {
		return credit_balance;
	}
	public CreditGradesBean setCredit_balance(String credit_balance) {
		this.credit_balance = credit_balance;
		return this;
	}
	public String getMember_count() {
		return member_count;
	}
	public CreditGradesBean setMember_count(String member_count) {
		this.member_count = member_count;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public CreditGradesBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	
	public String getCreate_time() {
		return create_time;
	}
	public CreditGradesBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public CreditGradesBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	
	
	
	
	
	
	
	

}
