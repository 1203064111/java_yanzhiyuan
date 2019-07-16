package tst.project.bean.member;

import java.io.Serializable;

import tst.project.bean.yinlong.MemberWorkerBean;

/**

**

*/

public class MemberBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int member_id;//
	private String member_ids;//多个id（逗号隔开）
	private String member_token;//用户token
	private String member_account;//用户账号
	private String member_accounts;//多个用户账号（逗号隔开）
	private String weibo_open_id;//微博唯一标识
	private String qq_open_id;//qq唯一标识
	private String weixin_open_id;//微信唯一标识
	private String weixin_pub_open_id;//微信公众号唯一标识
	private String weixin_lite_open_id;//微信小程序唯一标识
	private String weixin_app_open_id;//微信app唯一标识
	private String alipay_app_open_id;//支付宝app唯一id
	private String member_password;//用户密码
	private String pay_password;//支付密码
	private String member_type;//1:普通用户 2:家教 3:讲师 
	private String member_level;//用户等级 ：1：普通用户 2：付费会员
	private String member_phone;//用户手机号
	private String member_img;//用户头像
	private String member_real_name;//真实姓名
	private String member_nick_name;//昵称
	private String member_birthday;//出生日期
	private String member_sex;//m:男  w:女
	private String member_sex_show;//
	private String member_age;//年龄
	private String member_address;//地区
	private String vip_end_time;//会员结束日期
	private String order_count;//订单量
	private String order_refund_count;//订单退款数量
	private String is_delete;//0:未删除 1:删除
	private String member_count;//人数统计
	private String member_min_time;//最远时间
	private String member_max_time;//最近账号
	private String create_time;//创建时间
	private String update_time;//修改时间
	private String hx_account;//环信账号
	private String hx_password;//环信密码
	private String hx_nick_name;//环信昵称
	private String tengxun_im_account;//腾讯im聊天账号
	private String member_integral;//用户积分
	
	private String invitation_code;//自己的邀请码
	private String fill_invitation_code;//别人填的邀请码
	
	private String member_card_no;//身份证号码
	private String is_new_coupon;//是否是新注册用户
	private String is_buy;//是否已经购买 0:未购买 1:已购买
	private String start_time;
	private String end_time;
	private String member_state;//是否禁用用户
	private String member_state_show;
	
	private String pay_treasure; //支付宝账号
	private String bank_name; //开户名
	private String bank_line; //开户行
	private String bank_card; //银行卡号
	private String jiguang_token;//极光token
	private String role_type;//0未认证 01公司认证待审核 02个人认证待审核 011公司认证被拒绝 022 个人认证被拒绝 1公司认证 2个人认证
	private String consume_basic;//简历基础 0无信息 1有信息
	private String pay_account;//用户是否有打款账号 0没有 1有
	private String shop_pay_account;//商家是否有打款账号 0没有 1有
	private int comment_num;//评论数
	private String goods_monnaie;//颜值币
	private String goods_stock;//颜值股
	private String information;//简介
	private String recommend_name;//公司地址
	
	
	
	
	
	
	public String getMember_state_show() {
		return member_state_show;
	}
	public MemberBean setMember_state_show(String member_state_show) {
		this.member_state_show = member_state_show;
		return this;
	}
	public String getMember_age() {
		return member_age;
	}
	public MemberBean setMember_age(String member_age) {
		this.member_age = member_age;
		return this;
	}
	public String getMember_address() {
		return member_address;
	}
	public MemberBean setMember_address(String member_address) {
		this.member_address = member_address;
		return this;
	}
	public String getShop_pay_account() {
		return shop_pay_account;
	}
	public MemberBean setShop_pay_account(String shop_pay_account) {
		this.shop_pay_account = shop_pay_account;
		return this;
	}
	public String getPay_account() {
		return pay_account;
	}
	public MemberBean setPay_account(String pay_account) {
		this.pay_account = pay_account;
		return this;
	}
	public String getConsume_basic() {
		return consume_basic;
	}
	public MemberBean setConsume_basic(String consume_basic) {
		this.consume_basic = consume_basic;
		return this;
	}
	public String getRecommend_name() {
		return recommend_name;
	}
	public MemberBean setRecommend_name(String recommend_name) {
		this.recommend_name = recommend_name;
		return this;
	}
	public String getInformation() {
		return information;
	}
	public MemberBean setInformation(String information) {
		this.information = information;
		return this;
	}
	public String getGoods_stock() {
		return goods_stock;
	}
	public MemberBean setGoods_stock(String goods_stock) {
		this.goods_stock = goods_stock;
		return this;
	}
	public String getGoods_monnaie() {
		return goods_monnaie;
	}
	public MemberBean setGoods_monnaie(String goods_monnaie) {
		this.goods_monnaie = goods_monnaie;
		return this;
	}
	public int getComment_num() {
		return comment_num;
	}
	public MemberBean setComment_num(int comment_num) {
		this.comment_num = comment_num;
		return this;
	}
	public String getRole_type() {
		return role_type;
	}
	public MemberBean setRole_type(String role_type) {
		this.role_type = role_type;
		return this;
	}
	public String getJiguang_token() {
		return jiguang_token;
	}
	public MemberBean setJiguang_token(String jiguang_token) {
		this.jiguang_token = jiguang_token;
		return this;
	}
	public String getPay_treasure() {
		return pay_treasure;
	}
	public MemberBean setPay_treasure(String pay_treasure) {
		this.pay_treasure = pay_treasure;
		return this;
	}
	public String getBank_name() {
		return bank_name;
	}
	public MemberBean setBank_name(String bank_name) {
		this.bank_name = bank_name;
		return this;
	}
	public String getBank_line() {
		return bank_line;
	}
	public MemberBean setBank_line(String bank_line) {
		this.bank_line = bank_line;
		return this;
	}
	public String getBank_card() {
		return bank_card;
	}
	public MemberBean setBank_card(String bank_card) {
		this.bank_card = bank_card;
		return this;
	}
	public String getMember_state() {
		return member_state;
	}
	public MemberBean setMember_state(String member_state) {
		this.member_state = member_state;
		this.member_state_show = "0".equals(member_state)?"否":
			  ("1".equals(member_state)?"是":"未知");
		return this;
	}
	public String getMember_ids() {
		return member_ids;
	}
	public MemberBean setMember_ids(String member_ids) {
		this.member_ids = member_ids;
		return this;
	}
	public String getWeixin_pub_open_id() {
		return weixin_pub_open_id;
	}
	public MemberBean setWeixin_pub_open_id(String weixin_pub_open_id) {
		this.weixin_pub_open_id = weixin_pub_open_id;
		return this;
	}
	public String getMember_card_no() {
		return member_card_no;
	}
	public MemberBean setMember_card_no(String member_card_no) {
		this.member_card_no = member_card_no;
		return this;
	}
	public String getMember_accounts() {
		return member_accounts;
	}
	public MemberBean setMember_accounts(String member_accounts) {
		this.member_accounts = member_accounts;
		return this;
	}
	
	public String getInvitation_code() {
		return invitation_code;
	}
	public MemberBean setInvitation_code(String invitation_code) {
		this.invitation_code = invitation_code;
		return this;
	}
	public String getFill_invitation_code() {
		return fill_invitation_code;
	}
	public MemberBean setFill_invitation_code(String fill_invitation_code) {
		this.fill_invitation_code = fill_invitation_code;
		return this;
	}
	public String getTengxun_im_account() {
		return tengxun_im_account;
	}
	public MemberBean setTengxun_im_account(String tengxun_im_account) {
		this.tengxun_im_account = tengxun_im_account;
		return this;
	}
	public String getMember_integral() {
		return member_integral;
	}
	public MemberBean setMember_integral(String member_integral) {
		this.member_integral = member_integral;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getMember_id(){
		return member_id;
	}
	public MemberBean setMember_id(int member_id){
		this.member_id= member_id;
		return this;
	}
	public String getMember_token(){
		return member_token;
	}
	public MemberBean setMember_token(String member_token){
		this.member_token= member_token;
		return this;
	}
	public String getMember_account(){
		return member_account;
	}
	public MemberBean setMember_account(String member_account){
		this.member_account= member_account;
		return this;
	}
	public String getWeibo_open_id(){
		return weibo_open_id;
	}
	public MemberBean setWeibo_open_id(String weibo_open_id){
		this.weibo_open_id= weibo_open_id;
		return this;
	}
	public String getQq_open_id(){
		return qq_open_id;
	}
	public MemberBean setQq_open_id(String qq_open_id){
		this.qq_open_id= qq_open_id;
		return this;
	}
	public String getWeixin_open_id(){
		return weixin_open_id;
	}
	public MemberBean setWeixin_open_id(String weixin_open_id){
		this.weixin_open_id= weixin_open_id;
		return this;
	}
	
	public String getWeixin_lite_open_id() {
		return weixin_lite_open_id;
	}
	public MemberBean setWeixin_lite_open_id(String weixin_lite_open_id) {
		this.weixin_lite_open_id = weixin_lite_open_id;
		return this;
	}
	public String getWeixin_app_open_id() {
		return weixin_app_open_id;
	}
	public MemberBean setWeixin_app_open_id(String weixin_app_open_id) {
		this.weixin_app_open_id = weixin_app_open_id;
		return this;
	}
	
	public String getAlipay_app_open_id() {
		return alipay_app_open_id;
	}
	public MemberBean setAlipay_app_open_id(String alipay_app_open_id) {
		this.alipay_app_open_id = alipay_app_open_id;
		return this;
	}
	public String getMember_password(){
		return member_password;
	}
	public MemberBean setMember_password(String member_password){
		this.member_password= member_password;
		return this;
	}
	public String getPay_password() {
		return pay_password;
	}
	public MemberBean setPay_password(String pay_password) {
		this.pay_password = pay_password;
		return this;
	}
	public String getMember_type(){
		return member_type;
	}
	public MemberBean setMember_type(String member_type){
		this.member_type= member_type;
		return this;
	}
	public String getMember_level(){
		return member_level;
	}
	public MemberBean setMember_level(String member_level){
		this.member_level= member_level;
		return this;
	}
	public String getMember_phone(){
		return member_phone;
	}
	public MemberBean setMember_phone(String member_phone){
		this.member_phone= member_phone;
		return this;
	}
	public String getMember_img(){
		return member_img;
	}
	public MemberBean setMember_img(String member_img){
		this.member_img= member_img;
		return this;
	}
	public String getMember_real_name(){
		return member_real_name;
	}
	public MemberBean setMember_real_name(String member_real_name){
		this.member_real_name= member_real_name;
		return this;
	}
	public String getMember_nick_name(){
		return member_nick_name;
	}
	public MemberBean setMember_nick_name(String member_nick_name){
		this.member_nick_name= member_nick_name;
		return this;
	}
	public String getMember_birthday(){
		return member_birthday;
	}
	public MemberBean setMember_birthday(String member_birthday){
		this.member_birthday= member_birthday;
		return this;
	}
	public String getMember_sex(){
		return member_sex;
	}
	public MemberBean setMember_sex(String member_sex){
		this.member_sex= member_sex;
		this.member_sex_show = "m".equals(member_sex)?"男":
							  ("w".equals(member_sex)?"女":"未知");
		return this;
	}
	public String getMember_sex_show() {
		return member_sex_show;
	}
	public MemberBean setMember_sex_show(String member_sex_show) {
		this.member_sex_show = member_sex_show;
		return this;
	}
	public String getVip_end_time(){
		return vip_end_time;
	}
	public MemberBean setVip_end_time(String vip_end_time){
		this.vip_end_time= vip_end_time;
		return this;
	}
	public String getOrder_count(){
		return order_count;
	}
	public MemberBean setOrder_count(String order_count){
		this.order_count= order_count;
		return this;
	}
	public String getOrder_refund_count(){
		return order_refund_count;
	}
	public MemberBean setOrder_refund_count(String order_refund_count){
		this.order_refund_count= order_refund_count;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public MemberBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getMember_count() {
		return member_count;
	}
	public MemberBean setMember_count(String member_count) {
		this.member_count = member_count;
		return this;
	}
	public String getMember_min_time() {
		return member_min_time;
	}
	public MemberBean setMember_min_time(String member_min_time) {
		this.member_min_time = member_min_time;
		return this;
	}
	public String getMember_max_time() {
		return member_max_time;
	}
	public MemberBean setMember_max_time(String member_max_time) {
		this.member_max_time = member_max_time;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public MemberBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public MemberBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
	
	public String getHx_account(){
		return hx_account;
	}
	public MemberBean setHx_account(String hx_account){
		this.hx_account= hx_account;
		return this;
	}
	public String getHx_password(){
		return hx_password;
	}
	public MemberBean setHx_password(String hx_password){
		this.hx_password= hx_password;
		return this;
	}
	public String getHx_nick_name(){
		return hx_nick_name;
	}
	public MemberBean setHx_nick_name(String hx_nick_name){
		this.hx_nick_name= hx_nick_name;
		return this;
	}
	public String getIs_new_coupon() {
		return is_new_coupon;
	}
	public MemberBean setIs_new_coupon(String is_new_coupon) {
		this.is_new_coupon = is_new_coupon;
		return this;
	}
	
	public String getIs_buy() {
		return is_buy;
	}
	public MemberBean setIs_buy(String is_buy) {
		this.is_buy = is_buy;
		return this;
	}
	public String getStart_time() {
		return start_time;
	}
	public MemberBean setStart_time(String start_time) {
		this.start_time = start_time;
		return this;
	}
	public String getEnd_time() {
		return end_time;
	}
	public MemberBean setEnd_time(String end_time) {
		this.end_time = end_time;
		return this;
	}
	
}
