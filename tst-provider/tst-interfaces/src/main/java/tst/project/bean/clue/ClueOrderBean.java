package tst.project.bean.clue;

import java.io.Serializable;

import tst.project.bean.member.MemberBean;

/**

**

*/

public class ClueOrderBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int order_id;//
	private String order_no;//订单号
	private String member_id;//
	private String clue_id;//
	private String industry_id;//
	private String clue_name;//
	private String clue_desc;//
	private String clue_price;//
	private String clue_num;//
	private String clue_buy_num;//
	private String clue_mobile;
	private String order_price;//订单支付价格
	private String pay_way;//支付方式 1:积分支付
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	
	private String industry_name;//线索名称
	private MemberBean memberBean;
	
	public String getClue_mobile() {
		return clue_mobile;
	}
	public ClueOrderBean setClue_mobile(String clue_mobile) {
		this.clue_mobile = clue_mobile;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getOrder_id(){
		return order_id;
	}
	public ClueOrderBean setOrder_id(int order_id){
		this.order_id= order_id;
		return this;
	}
	public String getOrder_no(){
		return order_no;
	}
	public ClueOrderBean setOrder_no(String order_no){
		this.order_no= order_no;
		return this;
	}
	public String getMember_id(){
		return member_id;
	}
	public ClueOrderBean setMember_id(String member_id){
		this.member_id= member_id;
		return this;
	}
	public String getClue_id(){
		return clue_id;
	}
	public ClueOrderBean setClue_id(String clue_id){
		this.clue_id= clue_id;
		return this;
	}
	public String getIndustry_id(){
		return industry_id;
	}
	public ClueOrderBean setIndustry_id(String industry_id){
		this.industry_id= industry_id;
		return this;
	}
	public String getClue_name(){
		return clue_name;
	}
	public ClueOrderBean setClue_name(String clue_name){
		this.clue_name= clue_name;
		return this;
	}
	public String getClue_desc(){
		return clue_desc;
	}
	public ClueOrderBean setClue_desc(String clue_desc){
		this.clue_desc= clue_desc;
		return this;
	}
	public String getClue_price(){
		return clue_price;
	}
	public ClueOrderBean setClue_price(String clue_price){
		this.clue_price= clue_price;
		return this;
	}
	public String getClue_num(){
		return clue_num;
	}
	public ClueOrderBean setClue_num(String clue_num){
		this.clue_num= clue_num;
		return this;
	}
	public String getClue_buy_num(){
		return clue_buy_num;
	}
	public ClueOrderBean setClue_buy_num(String clue_buy_num){
		this.clue_buy_num= clue_buy_num;
		return this;
	}
	public String getOrder_price(){
		return order_price;
	}
	public ClueOrderBean setOrder_price(String order_price){
		this.order_price= order_price;
		return this;
	}
	public String getPay_way(){
		return pay_way;
	}
	public ClueOrderBean setPay_way(String pay_way){
		this.pay_way= pay_way;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public ClueOrderBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public ClueOrderBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public ClueOrderBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
	
	
	public String getIndustry_name() {
		return industry_name;
	}
	public ClueOrderBean setIndustry_name(String industry_name) {
		this.industry_name = industry_name;
		return this;
	}
	
	public MemberBean getMemberBean() {
		return memberBean;
	}
	public ClueOrderBean setMemberBean(MemberBean memberBean) {
		this.memberBean = memberBean;
		return this;
	}
	
	
	
}
