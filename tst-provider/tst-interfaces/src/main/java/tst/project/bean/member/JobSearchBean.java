package tst.project.bean.member;

import java.io.Serializable;

public class JobSearchBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int jobsearch_id;//找工作ID
	private int member_id;//用户ID
	private String jobsearch_title;//标题
	private String jobsearch_name;//联系人
	private String jobsearch_mobile;//联系电话
	private String jobsearch_img;//图片
	private String jobsearch_type;//服务类型
	private String jobsearch_desc;//服务简介
	private String jobsearch_city;//市
	private String jobsearch_country;//区
	private String jobsearch_city_country;//
	private String submit_state;//提交状态 1:未审核 2:审核通过 3:审核拒绝
	private String submit_state_show;//
	private String refuse_cause;//拒绝原因
	private String sort;//权重
	private String is_delete;//0：未删除 1：已删除
	private String create_time;//
	private String update_time;//
	public int getJobsearch_id() {
		return jobsearch_id;
	}
	public JobSearchBean setJobsearch_id(int jobsearch_id) {
		this.jobsearch_id = jobsearch_id;
		return this;
	}
	public int getMember_id() {
		return member_id;
	}
	public JobSearchBean setMember_id(int member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getJobsearch_title() {
		return jobsearch_title;
	}
	public JobSearchBean setJobsearch_title(String jobsearch_title) {
		this.jobsearch_title = jobsearch_title;
		return this;
	}
	public String getJobsearch_name() {
		return jobsearch_name;
	}
	public JobSearchBean setJobsearch_name(String jobsearch_name) {
		this.jobsearch_name = jobsearch_name;
		return this;
	}
	public String getJobsearch_mobile() {
		return jobsearch_mobile;
	}
	public JobSearchBean setJobsearch_mobile(String jobsearch_mobile) {
		this.jobsearch_mobile = jobsearch_mobile;
		return this;
	}
	public String getJobsearch_img() {
		return jobsearch_img;
	}
	public JobSearchBean setJobsearch_img(String jobsearch_img) {
		this.jobsearch_img = jobsearch_img;
		return this;
	}
	public String getJobsearch_type() {
		return jobsearch_type;
	}
	public JobSearchBean setJobsearch_type(String jobsearch_type) {
		this.jobsearch_type = jobsearch_type;
		return this;
	}
	public String getJobsearch_desc() {
		return jobsearch_desc;
	}
	public JobSearchBean setJobsearch_desc(String jobsearch_desc) {
		this.jobsearch_desc = jobsearch_desc;
		return this;
	}
	public String getJobsearch_city() {
		return jobsearch_city;
	}
	public JobSearchBean setJobsearch_city(String jobsearch_city) {
		this.jobsearch_city = jobsearch_city;
		return this;
	}
	public String getJobsearch_country() {
		return jobsearch_country;
	}
	public JobSearchBean setJobsearch_country(String jobsearch_country) {
		this.jobsearch_country = jobsearch_country;
		this.jobsearch_city_country = this.jobsearch_city + this.jobsearch_country;
		return this;
	}
	public String getJobsearch_city_country() {
		return jobsearch_city_country;
	}
	public JobSearchBean setJobsearch_city_country(String jobsearch_city_country) {
		this.jobsearch_city_country = jobsearch_city_country;
		return this;
	}
	public String getSubmit_state() {
		return submit_state;
	}
	public JobSearchBean setSubmit_state(String submit_state) {
		this.submit_state = submit_state;
		this.submit_state_show = "1".equals(submit_state)?"未审核":
								("2".equals(submit_state)?"审核通过":
							    ("3".equals(submit_state)?"审核拒绝":"未知状态"));
		
		return this;
	}
	public String getSubmit_state_show() {
		return submit_state_show;
	}
	public JobSearchBean setSubmit_state_show(String submit_state_show) {
		this.submit_state_show = submit_state_show;
		return this;
	}
	public String getRefuse_cause() {
		return refuse_cause;
	}
	public JobSearchBean setRefuse_cause(String refuse_cause) {
		this.refuse_cause = refuse_cause;
		return this;
	}
	public String getSort() {
		return sort;
	}
	public JobSearchBean setSort(String sort) {
		this.sort = sort;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public JobSearchBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public JobSearchBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public JobSearchBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	

}
