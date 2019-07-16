package tst.project.bean.shop;

import java.io.Serializable;

/**

**

*/

public class OrderRefundReasonBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int refund_reason_id;//
	private String reason_name;//
	private String is_delete;//
	private String sort;//
	private String sort_type;//
	private String create_time;//
	private String update_time;//
	
	
	public int getRefund_reason_id(){
		return refund_reason_id;
	}
	public OrderRefundReasonBean setRefund_reason_id(int refund_reason_id){
		this.refund_reason_id= refund_reason_id;
		return this;
	}
	public String getReason_name(){
		return reason_name;
	}
	public OrderRefundReasonBean setReason_name(String reason_name){
		this.reason_name= reason_name;
		return this;
	}
	
	public String getIs_delete(){
		return is_delete;
	}
	public OrderRefundReasonBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getSort(){
		return sort;
	}
	public OrderRefundReasonBean setSort(String sort){
		this.sort= sort;
		return this;
	}
	
	public String getSort_type() {
		return sort_type;
	}
	public void setSort_type(String sort_type) {
		this.sort_type = sort_type;
	}
	public String getCreate_time(){
		return create_time;
	}
	public OrderRefundReasonBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public OrderRefundReasonBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
