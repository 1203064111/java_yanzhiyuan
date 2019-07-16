package tst.project.bean.system;

import java.io.Serializable;

public class SystemLogBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int log_id;
	private String account_id;//账户id
	private String account_name;//账户名称
	private String operate_type; //增insert删delete改update查select
	private String operate_type_show;
	private String operate_desc;//日志描述
	private String module_name;//模块名称
	private String module_id;//操作的业务id
	private String is_delete;
	private String create_time;
	private String start_time;
	private String end_time;
	private String update_time;
	
	
	
	public String getModule_id() {
		return module_id;
	}
	public SystemLogBean setModule_id(String module_id) {
		this.module_id = module_id;
		return this;
	}
	public String getStart_time() {
		return start_time;
	}
	public SystemLogBean setStart_time(String start_time) {
		this.start_time = start_time;
		return this;
	}
	public String getEnd_time() {
		return end_time;
	}
	public SystemLogBean setEnd_time(String end_time) {
		this.end_time = end_time;
		return this;
	}
	public String getOperate_type_show() {
		return operate_type_show;
	}
	public SystemLogBean setOperate_type_show(String operate_type_show) {
		this.operate_type_show = operate_type_show;
		return this;
	}
	public String getModule_name() {
		return module_name;
	}
	public SystemLogBean setModule_name(String module_name) {
		this.module_name = module_name;
		return this;
	}
	public String getAccount_name() {
		return account_name;
	}
	public SystemLogBean setAccount_name(String account_name) {
		this.account_name = account_name;
		return this;
	}
	public int getLog_id() {
		return log_id;
	}
	public SystemLogBean setLog_id(int log_id) {
		this.log_id = log_id;
		return this;
	}
	public String getAccount_id() {
		return account_id;
	}
	public SystemLogBean setAccount_id(String account_id) {
		this.account_id = account_id;
		return this;
	}
	public String getOperate_type() {
		return operate_type;
	}
	public SystemLogBean setOperate_type(String operate_type) {
		this.operate_type = operate_type;
		return this;
	}
	public String getOperate_desc() {
		return operate_desc;
	}
	public SystemLogBean setOperate_desc(String operate_desc) {
		this.operate_desc = operate_desc;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public SystemLogBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public SystemLogBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public SystemLogBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	

}
