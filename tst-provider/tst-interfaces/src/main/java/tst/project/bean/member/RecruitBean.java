package tst.project.bean.member;

import java.io.Serializable;

public class RecruitBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int recruit_id;//招聘ID
	private int member_id;//用户ID
	private String recruit_name;//联系人
	private String recruit_mobile;//联系电话
	private String recruit_type;//服务类型
	private String recruit_pay;//薪资待遇
	private String recruit_title;//标题
	private String position_statement;//岗位职责
	private String recruit_requirements;//职位要求
	private String recruit_city;//市
	private String recruit_country;//区
	private String recruit_city_country;//
	private String submit_state;//提交状态 1:未审核 2:审核通过 3:审核拒绝
	private String submit_state_show;//
	private String refuse_cause;//拒绝原因
	private String sort;//权重
	private String is_delete;//0：未删除 1：已删除
	private String create_time;//
	private String update_time;//
	public int getRecruit_id() {
		return recruit_id;
	}
	public RecruitBean setRecruit_id(int recruit_id) {
		this.recruit_id = recruit_id;
		return this;
	}
	public int getMember_id() {
		return member_id;
	}
	public RecruitBean setMember_id(int member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getRecruit_name() {
		return recruit_name;
	}
	public RecruitBean setRecruit_name(String recruit_name) {
		this.recruit_name = recruit_name;
		return this;
	}
	public String getRecruit_mobile() {
		return recruit_mobile;
	}
	public RecruitBean setRecruit_mobile(String recruit_mobile) {
		this.recruit_mobile = recruit_mobile;
		return this;
	}
	public String getRecruit_type() {
		return recruit_type;
	}
	public RecruitBean setRecruit_type(String recruit_type) {
		this.recruit_type = recruit_type;
		return this;
	}
	public String getRecruit_pay() {
		return recruit_pay;
	}
	public RecruitBean setRecruit_pay(String recruit_pay) {
		this.recruit_pay = recruit_pay;
		return this;
	}
	public String getRecruit_title() {
		return recruit_title;
	}
	public RecruitBean setRecruit_title(String recruit_title) {
		this.recruit_title = recruit_title;
		return this;
	}
	public String getPosition_statement() {
		return position_statement;
	}
	public RecruitBean setPosition_statement(String position_statement) {
		this.position_statement = position_statement;
		return this;
	}
	public String getRecruit_requirements() {
		return recruit_requirements;
	}
	public RecruitBean setRecruit_requirements(String recruit_requirements) {
		this.recruit_requirements = recruit_requirements;
		return this;
	}
	public String getRecruit_city() {
		return recruit_city;
	}
	public RecruitBean setRecruit_city(String recruit_city) {
		this.recruit_city = recruit_city;
		return this;
	}
	public String getRecruit_country() {
		return recruit_country;
	}
	public RecruitBean setRecruit_country(String recruit_country) {
		this.recruit_country = recruit_country;
		this.recruit_city_country = this.recruit_city + this.recruit_country;
		return this;
	}
	public String getRecruit_city_country() {
		return recruit_city_country;
	}
	public RecruitBean setRecruit_city_country(String recruit_city_country) {
		this.recruit_city_country = recruit_city_country;
		return this;
	}
	public String getSubmit_state() {
		return submit_state;
	}
	public RecruitBean setSubmit_state(String submit_state) {
		this.submit_state = submit_state;
		this.submit_state_show = "1".equals(submit_state)?"未审核":
								("2".equals(submit_state)?"审核通过":
							    ("3".equals(submit_state)?"审核拒绝":"未知状态"));
		
		return this;
	}
	public String getSubmit_state_show() {
		return submit_state_show;
	}
	public RecruitBean setSubmit_state_show(String submit_state_show) {
		this.submit_state_show = submit_state_show;
		return this;
	}
	public String getRefuse_cause() {
		return refuse_cause;
	}
	public RecruitBean setRefuse_cause(String refuse_cause) {
		this.refuse_cause = refuse_cause;
		return this;
	}
	public String getSort() {
		return sort;
	}
	public RecruitBean setSort(String sort) {
		this.sort = sort;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public RecruitBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public RecruitBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public RecruitBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	
	

}
