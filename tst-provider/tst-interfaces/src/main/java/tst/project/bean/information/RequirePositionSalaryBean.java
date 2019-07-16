package tst.project.bean.information;

import java.io.Serializable;

public class RequirePositionSalaryBean implements Serializable{

	/**
	 * 求职薪资关联表
	 */
	private static final long serialVersionUID = 1L;
	private int require_position_salary_id;//
	private int require_position_id;//求职id
	private int salary_id;//薪资id
	private String salary_range;//薪资范围 作显示用
	private int member_id;//创建人id
	private String is_remark;//0未标记 1 已标记
	private String sort; // 权重
	private String is_delete; //
	private String create_time; //
	private String update_time;//
	public int getRequire_position_salary_id() {
		return require_position_salary_id;
	}
	public RequirePositionSalaryBean setRequire_position_salary_id(int require_position_salary_id) {
		this.require_position_salary_id = require_position_salary_id;
		return this;
	}
	public int getRequire_position_id() {
		return require_position_id;
	}
	public RequirePositionSalaryBean setRequire_position_id(int require_position_id) {
		this.require_position_id = require_position_id;
		return this;
	}
	public int getSalary_id() {
		return salary_id;
	}
	public RequirePositionSalaryBean setSalary_id(int salary_id) {
		this.salary_id = salary_id;
		return this;
	}
	public int getMember_id() {
		return member_id;
	}
	public RequirePositionSalaryBean setMember_id(int member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getSort() {
		return sort;
	}
	public RequirePositionSalaryBean setSort(String sort) {
		this.sort = sort;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public RequirePositionSalaryBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public RequirePositionSalaryBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public RequirePositionSalaryBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getSalary_range() {
		return salary_range;
	}
	public RequirePositionSalaryBean setSalary_range(String salary_range) {
		this.salary_range = salary_range;
		return this;
	}
	public String getIs_remark() {
		return is_remark;
	}
	public RequirePositionSalaryBean setIs_remark(String is_remark) {
		this.is_remark = is_remark;
		return this;
	}
	
	

}
