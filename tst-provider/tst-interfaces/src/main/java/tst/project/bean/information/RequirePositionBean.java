package tst.project.bean.information;

import java.io.Serializable;
import java.security.KeyStore.PrivateKeyEntry;
import java.util.List;

public class RequirePositionBean implements Serializable{

	/**
	 * 简历表
	 */
	private static final long serialVersionUID = 1L;
	private int require_position_id;//简历id
	private String require_position_provider; //省
	private String require_position_city; //市
	private String require_position_country; //区
	private int member_id;//创建人id
	private String hx_account;//创建者环信账号
	private String start_time;//求职开始日期
	private String end_time;//求职结束日期
	private String require_position_salaries_id;//薪资id 多个用逗号拼接
	private String position_class_id;//岗位id 多个用逗号拼接
	private String imgs;//头像
	private String name;
	private String sex;//性别 1男 2女
	private String age;
	private String weight;//体重
	private String height;//身高
	private String three_size;//三围
	private String id_card;//身份证号
	private String information;//个人简介
	private String information_imgs;//简介图片 多张用逗号隔开
	private String information_video;//简介视频 
	private String total_score;//简历总评分
	private String is_delete; //
	private String create_time; //
	private String update_time;//
	private String require_position_salaries;
	private String position_class_names;
	private String state;//0投递 1定人 2完成
	private int comment_count;//商家对简历的评论总数
	
	private int assessment_identity;//简历的平均外形星级
	private int assessment_attitude;//简历的平均态度星级
	private int assessment_skill;//简历的平均技能星级
	
	
	private List<RequirePositionSalaryBean> requirePositionSalaryBeans;//求职薪资
	private List<PositionClassesBean> positionClassesBeans;//求职岗位 
	
	private String is_comment;//是否评论
	private String agree_offline;//是否同意线下支付
	
	
	private String alipay_account;
	private String bank_account;
	
	
	
	
	
	public int getAssessment_identity() {
		return assessment_identity;
	}
	public RequirePositionBean setAssessment_identity(int assessment_identity) {
		this.assessment_identity = assessment_identity;
		return this;
	}
	public int getAssessment_attitude() {
		return assessment_attitude;
	}
	public RequirePositionBean setAssessment_attitude(int assessment_attitude) {
		this.assessment_attitude = assessment_attitude;
		return this;
	}
	public int getAssessment_skill() {
		return assessment_skill;
	}
	public RequirePositionBean setAssessment_skill(int assessment_skill) {
		this.assessment_skill = assessment_skill;
		return this;
	}
	public int getComment_count() {
		return comment_count;
	}
	public RequirePositionBean setComment_count(int comment_count) {
		this.comment_count = comment_count;
		return this;
	}
	public String getAlipay_account() {
		return alipay_account;
	}
	public RequirePositionBean setAlipay_account(String alipay_account) {
		this.alipay_account = alipay_account;
		return this;
	}
	public String getBank_account() {
		return bank_account;
	}
	public RequirePositionBean setBank_account(String bank_account) {
		this.bank_account = bank_account;
		return this;
	}
	public String getAgree_offline() {
		return agree_offline;
	}
	public RequirePositionBean setAgree_offline(String agree_offline) {
		this.agree_offline = agree_offline;
		return this;
	}
	public String getHx_account() {
		return hx_account;
	}
	public RequirePositionBean setHx_account(String hx_account) {
		this.hx_account = hx_account;
		return this;
	}
	public String getInformation_video() {
		return information_video;
	}
	public RequirePositionBean setInformation_video(String information_video) {
		this.information_video = information_video;
		return this;
	}
	public String getState() {
		return state;
	}
	public RequirePositionBean setState(String state) {
		this.state = state;
		return this;
	}
	public String getIs_comment() {
		return is_comment;
	}
	public RequirePositionBean setIs_comment(String is_comment) {
		this.is_comment = is_comment;
		return this;
	}
	public int getRequire_position_id() {
		return require_position_id;
	}
	public RequirePositionBean setRequire_position_id(int require_position_id) {
		this.require_position_id = require_position_id;
		return this;
	}
	public String getRequire_position_provider() {
		return require_position_provider;
	}
	public RequirePositionBean setRequire_position_provider(String require_position_provider) {
		this.require_position_provider = require_position_provider;
		return this;
	}
	public String getRequire_position_city() {
		return require_position_city;
	}
	public RequirePositionBean setRequire_position_city(String require_position_city) {
		this.require_position_city = require_position_city;
		return this;
	}
	public String getRequire_position_country() {
		return require_position_country;
	}
	public RequirePositionBean setRequire_position_country(String require_position_country) {
		this.require_position_country = require_position_country;
		return this;
	}
	public int getMember_id() {
		return member_id;
	}
	public RequirePositionBean setMember_id(int member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getStart_time() {
		return start_time;
	}
	public RequirePositionBean setStart_time(String start_time) {
		this.start_time = start_time;
		return this;
	}
	public String getEnd_time() {
		return end_time;
	}
	public RequirePositionBean setEnd_time(String end_time) {
		this.end_time = end_time;
		return this;
	}
	public List<RequirePositionSalaryBean> getRequirePositionSalaryBeans() {
		return requirePositionSalaryBeans;
	}
	public RequirePositionBean setRequirePositionSalaryBeans(List<RequirePositionSalaryBean> requirePositionSalaryBeans) {
		this.requirePositionSalaryBeans = requirePositionSalaryBeans;
		return this;
	}
	public List<PositionClassesBean> getPositionClassesBeans() {
		return positionClassesBeans;
	}
	public RequirePositionBean setPositionClassesBeans(List<PositionClassesBean> positionClassesBeans) {
		this.positionClassesBeans = positionClassesBeans;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public RequirePositionBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public RequirePositionBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public RequirePositionBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getRequire_position_salaries_id() {
		return require_position_salaries_id;
	}
	public RequirePositionBean setRequire_position_salaries_id(String require_position_salaries_id) {
		this.require_position_salaries_id = require_position_salaries_id;
		return this;
	}
	public String getPosition_class_id() {
		return position_class_id;
	}
	public RequirePositionBean setPosition_class_id(String position_class_id) {
		this.position_class_id = position_class_id;
		return this;
	}
	public String getImgs() {
		return imgs;
	}
	public RequirePositionBean setImgs(String imgs) {
		this.imgs = imgs;
		return this;
	}
	public String getName() {
		return name;
	}
	public RequirePositionBean setName(String name) {
		this.name = name;
		return this;
	}
	public String getSex() {
		return sex;
	}
	public RequirePositionBean setSex(String sex) {
		this.sex = sex;
		return this;
	}
	public String getAge() {
		return age;
	}
	public RequirePositionBean setAge(String age) {
		this.age = age;
		return this;
	}
	public String getWeight() {
		return weight;
	}
	public RequirePositionBean setWeight(String weight) {
		this.weight = weight;
		return this;
	}
	public String getHeight() {
		return height;
	}
	public RequirePositionBean setHeight(String height) {
		this.height = height;
		return this;
	}
	public String getThree_size() {
		return three_size;
	}
	public RequirePositionBean setThree_size(String three_size) {
		this.three_size = three_size;
		return this;
	}
	public String getId_card() {
		return id_card;
	}
	public RequirePositionBean setId_card(String id_card) {
		this.id_card = id_card;
		return this;
	}
	public String getInformation() {
		return information;
	}
	public RequirePositionBean setInformation(String information) {
		this.information = information;
		return this;
	}
	public String getInformation_imgs() {
		return information_imgs;
	}
	public RequirePositionBean setInformation_imgs(String information_imgs) {
		this.information_imgs = information_imgs;
		return this;
	}
	public String getRequire_position_salaries() {
		return require_position_salaries;
	}
	public RequirePositionBean setRequire_position_salaries(String require_position_salaries) {
		this.require_position_salaries = require_position_salaries;
		return this;
	}
	public String getPosition_class_names() {
		return position_class_names;
	}
	public RequirePositionBean setPosition_class_names(String position_class_names) {
		this.position_class_names = position_class_names;
		return this;
	}
	public String getTotal_score() {
		return total_score;
	}
	public RequirePositionBean setTotal_score(String total_score) {
		this.total_score = total_score;
		return this;
	}
	
	

}
