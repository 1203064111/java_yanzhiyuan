package tst.project.bean.member;

import java.io.Serializable;

public class CompanyBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int company_id;//公司id
	private String company_name;//公司名称
	private String company_linkman;//公司联系人
	private String company_phone;//公司联系电话
	private String company_address;//公司地址
	private String company_logo;//公司logo
	private String company_information;//公司资料
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getCompany_id() {
		return company_id;
	}
	public CompanyBean setCompany_id(int company_id) {
		this.company_id = company_id;
		return this;
	}
	public String getCompany_name() {
		return company_name;
	}
	public CompanyBean setCompany_name(String company_name) {
		this.company_name = company_name;
		return this;
	}
	public String getCompany_linkman() {
		return company_linkman;
	}
	public CompanyBean setCompany_linkman(String company_linkman) {
		this.company_linkman = company_linkman;
		return this;
	}
	public String getCompany_phone() {
		return company_phone;
	}
	public CompanyBean setCompany_phone(String company_phone) {
		this.company_phone = company_phone;
		return this;
	}
	public String getCompany_address() {
		return company_address;
	}
	public CompanyBean setCompany_address(String company_address) {
		this.company_address = company_address;
		return this;
	}
	public String getCompany_logo() {
		return company_logo;
	}
	public CompanyBean setCompany_logo(String company_logo) {
		this.company_logo = company_logo;
		return this;
	}
	public String getCompany_information() {
		return company_information;
	}
	public CompanyBean setCompany_information(String company_information) {
		this.company_information = company_information;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public CompanyBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public CompanyBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public CompanyBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	
}
