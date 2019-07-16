package tst.project.bean.information;

import java.io.Serializable;

import com.sun.jmx.snmp.tasks.ThreadService;

public class PayDetailBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int pay_detail_id;//支付明细id 
	private int member_id;//用户id
	private int advertise_order_id;//职位订单id
	private String pay_detail_type;//支付明细类型 pay支付 refund退款
	private String pay_detail_type_show;
	private String pay_detail_title;//支付明细标题
	private String price;//金额
	private String pay_detail_no;//支付单号 
	private String create_time;
	private String update_time;
	private String pay_way;//支付方式 alipay支付宝 wx微信
	
	private String advertise_order_no;//职位订单单号
	private String is_delete;


	
		public String getPay_detail_type_show() {
		return pay_detail_type_show;
	}
	public PayDetailBean setPay_detail_type_show(String pay_detail_type_show) {
		this.pay_detail_type_show = pay_detail_type_show;
		return this;
	}
		public String getPay_detail_title() {
		return pay_detail_title;
		}
		public PayDetailBean setPay_detail_title(String pay_detail_title) {
		this.pay_detail_title = pay_detail_title;
			return this;
		}
		public String getPay_detail_type() {
				return pay_detail_type;
        }
		public PayDetailBean setPay_detail_type(String pay_detail_type) {
				this.pay_detail_type = pay_detail_type;
				this.pay_detail_type_show = "pay".equals(pay_detail_type)?"支付":
					"refund".equals(pay_detail_type)?"退款":"其他";
		        return this;
        }
	
		
	
		public String getPrice() {
				return price;
        }
		public PayDetailBean setPrice(String price) {
				this.price = price;
		        return this;
        }
	
		public String getPay_detail_no() {
				return pay_detail_no;
        }
		public PayDetailBean setPay_detail_no(String pay_detail_no) {
				this.pay_detail_no = pay_detail_no;
		        return this;
        }
	
		
	
		public String getCreate_time() {
			return create_time;
		}
		public PayDetailBean setCreate_time(String create_time) {
			this.create_time = create_time;
			return this;
		}
		public String getUpdate_time() {
			return update_time;
		}
		public PayDetailBean setUpdate_time(String update_time) {
			this.update_time = update_time;
			return this;
		}
		public String getPay_way() {
				return pay_way;
        }
		public PayDetailBean setPay_way(String pay_way) {
				this.pay_way = pay_way;
		        return this;
        }
	
		
	
		public int getPay_detail_id() {
			return pay_detail_id;
		}
		public PayDetailBean setPay_detail_id(int pay_detail_id) {
			this.pay_detail_id = pay_detail_id;
			return this;
		}
		public int getMember_id() {
			return member_id;
		}
		public PayDetailBean setMember_id(int member_id) {
			this.member_id = member_id;
			return this;
		}
		public int getAdvertise_order_id() {
			return advertise_order_id;
		}
		public PayDetailBean setAdvertise_order_id(int advertise_order_id) {
			this.advertise_order_id = advertise_order_id;
			return this;
		}
		public String getIs_delete() {
				return is_delete;
        }
		public PayDetailBean setIs_delete(String is_delete) {
				this.is_delete = is_delete;
		        return this;
        }
		public String getAdvertise_order_no() {
			return advertise_order_no;
		}
		public PayDetailBean setAdvertise_order_no(String advertise_order_no) {
			this.advertise_order_no = advertise_order_no;
			return this;
		}

		
}
