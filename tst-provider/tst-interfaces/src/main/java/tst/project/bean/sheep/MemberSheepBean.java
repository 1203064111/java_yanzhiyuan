package tst.project.bean.sheep;

import java.io.Serializable;
import java.util.List;

public class MemberSheepBean  implements Serializable{
	private static final long serialVersionUID = 1L;
	private int member_sheep_id;
	private String order_id;
	private String member_id;
	private String  ear_id;
	private String bitch_sheep_id;
	private String sheep_breed_time;
	private String sheep_end_time;
	private String sheep_type;
	private String sheep_name;
	private String sheep_nick_name;
	private String sheep_desc;
	private String ear_sign;
	private String sheep_price;
	private String sheep_kg;
	private String sheep_room;
	private String is_delete;
	private String update_time;
	private String create_time;
	private String is_finish;//是否完成养殖
	private String cut_factory;//宰割场
	private String cut_time;//宰割时间
	private String  is_cut;//是否需要切割
	
	private String cut_price;//切割费用
	private String is_insurance;//是否保险
	private String insurance_price;//保险费
	private List<SheepSourceBean> sheepSourceBeans;
	private String is_cut_show;
	private String sheep_type_show;
	private String group_type_show;
	private String is_finish_show;
	private String sheep_imgs;
	private SheepBean bitchSheepBean;
	private OrderSheepBean orderSheepBean;
	private String qr_code;
	
	
	
	
	public String getQr_code() {
		return qr_code;
	}
	public MemberSheepBean setQr_code(String qr_code) {
		this.qr_code = qr_code;
		return this;
	}
	public SheepBean getBitchSheepBean() {
		return bitchSheepBean;
	}
	public MemberSheepBean setBitchSheepBean(SheepBean bitchSheepBean) {
		this.bitchSheepBean = bitchSheepBean;
		return this;
	}
	public OrderSheepBean getOrderSheepBean() {
		return orderSheepBean;
	}
	public MemberSheepBean setOrderSheepBean(OrderSheepBean orderSheepBean) {
		this.orderSheepBean = orderSheepBean;
		return this;
	}
	public String getSheep_imgs() {
		return sheep_imgs;
	}
	public MemberSheepBean setSheep_imgs(String sheep_imgs) {
		this.sheep_imgs = sheep_imgs;
		return this;
	}
	public String getIs_cut_show() {
		return is_cut_show;
	}
	public MemberSheepBean setIs_cut_show(String is_cut_show) {
		this.is_cut_show = is_cut_show;
		return this;
	}
	public String getSheep_type_show() {
		return sheep_type_show;
	}
	public MemberSheepBean setSheep_type_show(String sheep_type_show) {
		this.sheep_type_show = sheep_type_show;
		return this;
	}
	public String getGroup_type_show() {
		return group_type_show;
	}
	public MemberSheepBean setGroup_type_show(String group_type_show) {
		this.group_type_show = group_type_show;
		return this;
	}
	public String getIs_finish_show() {
		return is_finish_show;
	}
	public MemberSheepBean setIs_finish_show(String is_finish_show) {
		this.is_finish_show = is_finish_show;
		return this;
	}
	public String getCut_factory() {
		return cut_factory;
	}
	public MemberSheepBean setCut_factory(String cut_factory) {
		this.cut_factory = cut_factory;
		return this;
	}
	public String getCut_time() {
		return cut_time;
	}
	public MemberSheepBean setCut_time(String cut_time) {
		this.cut_time = cut_time;
		return this;
	}
	public String getIs_cut() {
		return is_cut;
	}
	public MemberSheepBean setIs_cut(String is_cut) {
		this.is_cut = is_cut;
		this.is_cut_show="1".equals(is_cut)?"是":"否";
		return this;
	}
	public String getCut_price() {
		return cut_price;
	}
	public MemberSheepBean setCut_price(String cut_price) {
		this.cut_price = cut_price;
		return this;
	}
	public String getIs_insurance() {
		return is_insurance;
	}
	public MemberSheepBean setIs_insurance(String is_insurance) {
		this.is_insurance = is_insurance;
		return this;
	}
	public String getInsurance_price() {
		return insurance_price;
	}
	public MemberSheepBean setInsurance_price(String insurance_price) {
		this.insurance_price = insurance_price;
		return this;
	}
	public String getOrder_id() {
		return order_id;
	}
	public MemberSheepBean setOrder_id(String order_id) {
		this.order_id = order_id;
		return this;
	}
	public List<SheepSourceBean> getSheepSourceBeans() {
		return sheepSourceBeans;
	}
	public MemberSheepBean setSheepSourceBeans(List<SheepSourceBean> sheepSourceBeans) {
		this.sheepSourceBeans = sheepSourceBeans;
		return this;
	}
	public String getIs_finish() {
		return is_finish;
	}
	public MemberSheepBean setIs_finish(String is_finish) {
		this.is_finish = is_finish;
		this.is_finish_show="0".equals(is_finish)?"养殖中":
			              "1".equals(is_finish)?"养殖完成":"已发货";
		return this;
	}
	
	public String getSheep_end_time() {
		return sheep_end_time;
	}
	public MemberSheepBean setSheep_end_time(String sheep_end_time) {
		this.sheep_end_time = sheep_end_time;
		return this;
	}
	public int getMember_sheep_id() {
		return member_sheep_id;
	}
	public MemberSheepBean setMember_sheep_id(int member_sheep_id) {
		this.member_sheep_id = member_sheep_id;
		return this;
	}
	public String getMember_id() {
		return member_id;
	}
	public MemberSheepBean setMember_id(String member_id) {
		this.member_id = member_id;return this;
	}
	public String getEar_id() {
		return ear_id;
	}
	public MemberSheepBean setEar_id(String ear_id) {
		this.ear_id = ear_id;return this;
	}
	public String getBitch_sheep_id() {
		return bitch_sheep_id;
	}
	public MemberSheepBean setBitch_sheep_id(String bitch_sheep_id) {
		this.bitch_sheep_id = bitch_sheep_id;return this;
	}
	public String getSheep_breed_time() {
		return sheep_breed_time;
	}
	public MemberSheepBean setSheep_breed_time(String sheep_breed_time) {
		this.sheep_breed_time = sheep_breed_time;return this;
	}
	public String getSheep_type() {
		return sheep_type;
	}
	public MemberSheepBean setSheep_type(String sheep_type) {
		this.sheep_type = sheep_type;
		this.sheep_type_show="0".equals(sheep_type)?"认养":"合养";
				return this;
	}
	public String getSheep_name() {
		return sheep_name;
	}
	public MemberSheepBean setSheep_name(String sheep_name) {
		this.sheep_name = sheep_name;return this;
	}
	public String getSheep_nick_name() {
		return sheep_nick_name;
	}
	public MemberSheepBean setSheep_nick_name(String sheep_nick_name) {
		this.sheep_nick_name = sheep_nick_name;return this;
	}
	public String getSheep_desc() {
		return sheep_desc;
	}
	public MemberSheepBean setSheep_desc(String sheep_desc) {
		this.sheep_desc = sheep_desc;return this;
	}
	public String getEar_sign() {
		return ear_sign;
	}
	public MemberSheepBean setEar_sign(String ear_sign) {
		this.ear_sign = ear_sign;return this;
	}
	public String getSheep_price() {
		return sheep_price;
	}
	public MemberSheepBean setSheep_price(String sheep_price) {
		this.sheep_price = sheep_price;return this;
	}
	public String getSheep_kg() {
		return sheep_kg;
	}
	public MemberSheepBean setSheep_kg(String sheep_kg) {
		this.sheep_kg = sheep_kg;return this;
	}
	public String getSheep_room() {
		return sheep_room;
	}
	public MemberSheepBean setSheep_room(String sheep_room) {
		this.sheep_room = sheep_room;return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public MemberSheepBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public MemberSheepBean setUpdate_time(String update_time) {
		this.update_time = update_time;return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public MemberSheepBean setCreate_time(String create_time) {
		this.create_time = create_time;return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
