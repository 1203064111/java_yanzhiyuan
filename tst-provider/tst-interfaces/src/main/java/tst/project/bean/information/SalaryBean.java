package tst.project.bean.information;

import java.io.Serializable;

public class SalaryBean implements Serializable {

	/**
	 * 薪资表
	 */
	private static final long serialVersionUID = 1L;
	private int salary_id;//
	private String salary_range;///薪资范围
	private String sort; // 权重
	private String is_delete; //
	private String create_time; //
	private String update_time;//
	public int getSalary_id() {
		return salary_id;
	}
	public SalaryBean setSalary_id(int salary_id) {
		this.salary_id = salary_id;
		return this;
	}
	public String getSalary_range() {
		return salary_range;
	}
	public SalaryBean setSalary_range(String salary_range) {
		this.salary_range = salary_range;
		return this;
	}
	public String getSort() {
		return sort;
	}
	public SalaryBean setSort(String sort) {
		this.sort = sort;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public SalaryBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public SalaryBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public SalaryBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	

}
