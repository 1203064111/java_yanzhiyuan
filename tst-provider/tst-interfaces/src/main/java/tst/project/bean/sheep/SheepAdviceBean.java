package tst.project.bean.sheep;

import java.io.Serializable;

public class SheepAdviceBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int advice_id;
	private String advice_desc;
	private String advice_imgs;
	private String member_id;
	private String is_delete;
	private String create_time;
	private String update_time;
	public int getAdvice_id() {
		return advice_id;
	}
	public SheepAdviceBean setAdvice_id(int advice_id) {
		this.advice_id = advice_id;
		return this;
	}
	public String getAdvice_desc() {
		return advice_desc;
	}
	public SheepAdviceBean setAdvice_desc(String advice_desc) {
		this.advice_desc = advice_desc;
		return this;
	}
	public String getAdvice_imgs() {
		return advice_imgs;
	}
	public SheepAdviceBean setAdvice_imgs(String advice_imgs) {
		this.advice_imgs = advice_imgs;
		return this;
	}
	public String getMember_id() {
		return member_id;
	}
	public SheepAdviceBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public SheepAdviceBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public SheepAdviceBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public SheepAdviceBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
