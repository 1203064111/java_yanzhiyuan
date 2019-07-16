package tst.project.bean.information;

import java.io.Serializable;

public class PositionPersonsBean implements Serializable{
	/**
	 * 职位申请人表
	 */
	private static final long serialVersionUID = 1L;
	private int position_persons_id;
	private int position_id;//职位id
	private int member_id;//用户id
	private String require_position_id;//简历id
	private String state;//状态 0投递 1预订 2完成
	private String order_remit;//是否打款 0否 1是 
	private String order_remit_show;
	private String full_person;//判断是否达到活动人数要求 0未达到 1达到 
	private String agree_offline;// 是否同意线下支付  默认0拒绝 1同意
	private String is_delete;//
	private String create_time; //
	private String update_time; //
	
	
	
	public String getAgree_offline() {
		return agree_offline;
	}
	public PositionPersonsBean setAgree_offline(String agree_offline) {
		this.agree_offline = agree_offline;
		return this;
	}
	public String getFull_person() {
		return full_person;
	}
	public PositionPersonsBean setFull_person(String full_person) {
		this.full_person = full_person;
		return this;
	}
	public int getPosition_persons_id() {
		return position_persons_id;
	}
	public PositionPersonsBean setPosition_persons_id(int position_persons_id) {
		this.position_persons_id = position_persons_id;
		return this;
	}
	public int getPosition_id() {
		return position_id;
	}
	public PositionPersonsBean setPosition_id(int position_id) {
		this.position_id = position_id;
		return this;
	}
	public int getMember_id() {
		return member_id;
	}
	public PositionPersonsBean setMember_id(int member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getState() {
		return state;
	}
	public PositionPersonsBean setState(String state) {
		this.state = state;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public PositionPersonsBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public PositionPersonsBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public PositionPersonsBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getRequire_position_id() {
		return require_position_id;
	}
	public PositionPersonsBean setRequire_position_id(String require_position_id) {
		this.require_position_id = require_position_id;
		return this;
	}
	public String getOrder_remit() {
		return order_remit;
	}
	public PositionPersonsBean setOrder_remit(String order_remit) {
		this.order_remit = order_remit;
		this.order_remit_show = "0".equals(order_remit)?"否":
			"1".equals(order_remit)?"是":"其他";
		return this;
	}
	public String getOrder_remit_show() {
		return order_remit_show;
	}
	public PositionPersonsBean setOrder_remit_show(String order_remit_show) {
		this.order_remit_show = order_remit_show;
		return this;
	}
	
	

}
