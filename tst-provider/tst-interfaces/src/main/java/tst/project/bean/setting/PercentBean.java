package tst.project.bean.setting;

import java.io.Serializable;

public class PercentBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String percent_id;
	private String percent_name;
	private String percent_value;
	private String percent_type;
	private String payment_percent;//定金比例
	private String charge_percent;//佣金比例
	private String create_time;
	private String is_delete;
	public String getPercent_id() {
		return percent_id;
	}
	public PercentBean setPercent_id(String percent_id) {
		this.percent_id = percent_id;
		return this;
		
	}
	public String getPercent_name() {
		return percent_name;
	}
	public PercentBean setPercent_name(String percent_name) {
		this.percent_name = percent_name;
		return this;
	}
	public String getPercent_value() {
		return percent_value;
	}
	public PercentBean setPercent_value(String percent_value) {
		this.percent_value = percent_value;
		return this;
	}
	public String getPercent_type() {
		return percent_type;
	}
	public PercentBean setPercent_type(String percent_type) {
		this.percent_type = percent_type;
		return this;
		
	}
	public String getCreate_time() {
		return create_time;
	}
	public PercentBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public PercentBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getPayment_percent() {
		return payment_percent;
	}
	public PercentBean setPayment_percent(String payment_percent) {
		this.payment_percent = payment_percent;
		return this;
	}
	public String getCharge_percent() {
		return charge_percent;
	}
	public PercentBean setCharge_percent(String charge_percent) {
		this.charge_percent = charge_percent;
		return this;
	}
	
	
}
