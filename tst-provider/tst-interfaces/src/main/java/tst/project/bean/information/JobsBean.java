package tst.project.bean.information;

import java.io.Serializable;

public class JobsBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int jobs_id; //
	private int member_id;//用户id
	private String member_name; //姓名
	private String sex; //性别 m 男 w 女
	private String age; //年龄
	private String weight; //体重
	private String height; //升高
	private String jobs_type; //简历类型 0 全职 1 兼职
	private String jobs_type_show;//
	private String salary; //薪资
	private String personal; //个人介绍
	private String born_time; //出生日期
	private String jobs_img;// 简历照片
	private String personal_imgs; //个人介绍照片 多张逗号相隔
	private String jobs_phone; //联系电话
	private String jobs_provider; //省
	private String jobs_city; //市
	private String jobs_country; // 区
	private String jobs_address; //详情地址
	private String is_delete; //
	private String create_time;//
	private String update_time;//
	public int getJobs_id() {
		return jobs_id;
	}
	public JobsBean setJobs_id(int jobs_id) {
		this.jobs_id = jobs_id;
		return this;
	}
	public int getMember_id() {
		return member_id;
	}
	public JobsBean setMember_id(int member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getMember_name() {
		return member_name;
	}
	public JobsBean setMember_name(String member_name) {
		this.member_name = member_name;
		return this;
	}
	public String getSex() {
		return sex;
	}
	public JobsBean setSex(String sex) {
		this.sex = sex;
		return this;
	}
	public String getAge() {
		return age;
	}
	public JobsBean setAge(String age) {
		this.age = age;
		return this;
	}
	public String getJobs_type() {
		return jobs_type;
	}
	public JobsBean setJobs_type(String jobs_type) {
		this.jobs_type = jobs_type;
		return this;
	}
	public String getJobs_type_show() {
		return jobs_type_show;
	}
	public JobsBean setJobs_type_show(String jobs_type_show) {
		this.jobs_type_show = jobs_type_show;
		return this;
	}
	public String getSalary() {
		return salary;
	}
	public JobsBean setSalary(String salary) {
		this.salary = salary;
		return this;
	}
	public String getPersonal() {
		return personal;
	}
	public JobsBean setPersonal(String personal) {
		this.personal = personal;
		return this;
	}
	public String getBorn_time() {
		return born_time;
	}
	public JobsBean setBorn_time(String born_time) {
		this.born_time = born_time;
		return this;
	}
	public String getJobs_img() {
		return jobs_img;
	}
	public JobsBean setJobs_img(String jobs_img) {
		this.jobs_img = jobs_img;
		return this;
	}
	public String getPersonal_imgs() {
		return personal_imgs;
	}
	public JobsBean setPersonal_imgs(String personal_imgs) {
		this.personal_imgs = personal_imgs;
		return this;
	}
	public String getJobs_phone() {
		return jobs_phone;
	}
	public JobsBean setJobs_phone(String jobs_phone) {
		this.jobs_phone = jobs_phone;
		return this;
	}
	public String getJobs_provider() {
		return jobs_provider;
	}
	public JobsBean setJobs_provider(String jobs_provider) {
		this.jobs_provider = jobs_provider;
		return this;
	}
	public String getJobs_city() {
		return jobs_city;
	}
	public JobsBean setJobs_city(String jobs_city) {
		this.jobs_city = jobs_city;
		return this;
	}
	public String getJobs_country() {
		return jobs_country;
	}
	public JobsBean setJobs_country(String jobs_country) {
		this.jobs_country = jobs_country;
		return this;
	}
	public String getJobs_address() {
		return jobs_address;
	}
	public JobsBean setJobs_address(String jobs_address) {
		this.jobs_address = jobs_address;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public JobsBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public JobsBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public JobsBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getWeight() {
		return weight;
	}
	public JobsBean setWeight(String weight) {
		this.weight = weight;
		return this;
	}
	public String getHeight() {
		return height;
	}
	public JobsBean setHeight(String height) {
		this.height = height;
		return this;
	}
	
	
	
}
