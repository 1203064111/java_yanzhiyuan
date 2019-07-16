package tst.project.bean.information;

import java.io.Serializable;

public class MaterialBean implements Serializable{
	/**
	 * 招聘认证表
	 */
	private static final long serialVersionUID = 1L;
	
	private int material_id; //认证id
	private int position_id; //招聘职位id
	private String linkman_name;//联系人姓名
	private String material_name; //企业/个人名称
	private String material_type; //0 企业 1 个人
	private String material_type_show;//
	private String id_card ;//身份证号
	private String birth_time; //出生日期
	private String material_phone; // 联系方式
	private String material_address;//公司地址
	private String material_imgs1; //身份证正面照/营业执照 多张逗号相隔
	private String material_imgs2; //身份证反面照/公司照片 逗号相隔
	private String is_delete; //
	private String create_time; //
	private String update_time; //
	private String material_provider; //省
	private String material_city; //市
	private String material_country; //区
	private String material_information;//公司/个人简介
	private String material_state;//0待审核 1通过 2拒绝
	private String material_state_show;
	private String refuse_desc;//审核拒绝理由
	private int member_id;//创建者id
	private String hx_account;//创建者环信账号
	
	private int comment_num;//评论数
	private String comment_grade;//评分
	
	
	
	public String getHx_account() {
		return hx_account;
	}
	public MaterialBean setHx_account(String hx_account) {
		this.hx_account = hx_account;
		return this;
	}
	public String getComment_grade() {
		return comment_grade;
	}
	public MaterialBean setComment_grade(String comment_grade) {
		this.comment_grade = comment_grade;
		return this;
	}
	public int getComment_num() {
		return comment_num;
	}
	public MaterialBean setComment_num(int comment_num) {
		this.comment_num = comment_num;
		return this;
	}
	public String getLinkman_name() {
		return linkman_name;
	}
	public MaterialBean setLinkman_name(String linkman_name) {
		this.linkman_name = linkman_name;
		return this;
	}
	public String getMaterial_information() {
		return material_information;
	}
	public MaterialBean setMaterial_information(String material_information) {
		this.material_information = material_information;
		return this;
	}
	public String getMaterial_state() {
		return material_state;
	}
	public MaterialBean setMaterial_state(String material_state) {
		this.material_state_show = "0".equals(material_state)?"待审核":
						"1".equals(material_state)?"已通过":
					  "2".equals(material_state)?"已拒绝":"未知";
		this.material_state = material_state;
		return this;
	}
	public int getMember_id() {
		return member_id;
	}
	public MaterialBean setMember_id(int member_id) {
		this.member_id = member_id;
		return this;
	}
	public int getMaterial_id() {
		return material_id;
	}
	public MaterialBean setMaterial_id(int material_id) {
		this.material_id = material_id;
		return this;
	}
	public int getPosition_id() {
		return position_id;
	}
	public MaterialBean setPosition_id(int position_id) {
		this.position_id = position_id;
		return this;
	}
	public String getMaterial_name() {
		return material_name;
	}
	public MaterialBean setMaterial_name(String material_name) {
		this.material_name = material_name;
		return this;
	}
	public String getMaterial_type() {
		return material_type;
	}
	public MaterialBean setMaterial_type(String material_type) {
		this.material_type = material_type;
		this.material_type_show = "0".equals(material_type)?"企业":
							"1".equals(material_type)?"个人":"其他";
		return this;
	}
	public String getMaterial_type_show() {
		return material_type_show;
	}
	public MaterialBean setMaterial_type_show(String material_type_show) {
		this.material_type_show = material_type_show;
		return this;
	}
	public String getId_card() {
		return id_card;
	}
	public MaterialBean setId_card(String id_card) {
		this.id_card = id_card;
		return this;
	}
	public String getBirth_time() {
		return birth_time;
	}
	public MaterialBean setBirth_time(String birth_time) {
		this.birth_time = birth_time;
		return this;
	}
	public String getMaterial_phone() {
		return material_phone;
	}
	public MaterialBean setMaterial_phone(String material_phone) {
		this.material_phone = material_phone;
		return this;
	}
	public String getMaterial_address() {
		return material_address;
	}
	public MaterialBean setMaterial_address(String material_address) {
		this.material_address = material_address;
		return this;
	}
	public String getMaterial_imgs1() {
		return material_imgs1;
	}
	public MaterialBean setMaterial_imgs1(String material_imgs1) {
		this.material_imgs1 = material_imgs1;
		return this;
	}
	public String getMaterial_imgs2() {
		return material_imgs2;
	}
	public MaterialBean setMaterial_imgs2(String material_imgs2) {
		this.material_imgs2 = material_imgs2;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public MaterialBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public MaterialBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public MaterialBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getMaterial_provider() {
		return material_provider;
	}
	public MaterialBean setMaterial_provider(String material_provider) {
		this.material_provider = material_provider;
		return this;
	}
	public String getMaterial_city() {
		return material_city;
	}
	public MaterialBean setMaterial_city(String material_city) {
		this.material_city = material_city;
		return this;
	}
	public String getMaterial_country() {
		return material_country;
	}
	public MaterialBean setMaterial_country(String material_country) {
		this.material_country = material_country;
		return this;
	}
	public String getMaterial_state_show() {
		return material_state_show;
	}
	public MaterialBean setMaterial_state_show(String material_state_show) {
		this.material_state_show = material_state_show;
		return this;
	}
	public String getRefuse_desc() {
		return refuse_desc;
	}
	public MaterialBean setRefuse_desc(String refuse_desc) {
		this.refuse_desc = refuse_desc;
		return this;
	}
	
	
}
