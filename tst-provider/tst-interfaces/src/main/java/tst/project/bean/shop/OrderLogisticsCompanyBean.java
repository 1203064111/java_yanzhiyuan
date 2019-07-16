package tst.project.bean.shop;

import java.io.Serializable;

public class OrderLogisticsCompanyBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int logistics_id;//快递ID
	private String logistics_name;//快递名称
	private String logistics_pinyin;//快递拼音
	private String is_delete;//是否删除
	private String create_time;//
	public int getLogistics_id() {
		return logistics_id;
	}
	public OrderLogisticsCompanyBean setLogistics_id(int logistics_id) {
		this.logistics_id = logistics_id;
		return this;
	}
	public String getLogistics_name() {
		return logistics_name;
	}
	public OrderLogisticsCompanyBean setLogistics_name(String logistics_name) {
		this.logistics_name = logistics_name;
		return this;
	}
	public String getLogistics_pinyin() {
		return logistics_pinyin;
	}
	public OrderLogisticsCompanyBean setLogistics_pinyin(String logistics_pinyin) {
		this.logistics_pinyin = logistics_pinyin;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public OrderLogisticsCompanyBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public OrderLogisticsCompanyBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	

}
