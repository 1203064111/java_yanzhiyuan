package tst.project.bean.system;

import java.io.Serializable;

/**

**

*/

public class SystemAccountBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int account_id;//
	private String system_name;//
	private String system_account;//
	private String system_img;//
	private String system_password;//
	private String system_token;//
	private String system_type;//1:系统账号 2:店铺 3分销商
	private String role_id;//账户角色
	private String hx_account;//
	private String hx_pass;//
	private String hx_nick_name;//
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	private String merchants_id;
	private String merchants_name;
	
	
	public String getMerchants_id() {
		return merchants_id;
	}
	public SystemAccountBean setMerchants_id(String merchants_id) {
		this.merchants_id = merchants_id;
		return this;
	}
	public String getMerchants_name() {
		return merchants_name;
	}
	public SystemAccountBean setMerchants_name(String merchants_name) {
		this.merchants_name = merchants_name;
		return this;
	}
	
	public int getAccount_id(){
		return account_id;
	}
	public SystemAccountBean setAccount_id(int account_id){
		this.account_id= account_id;
		return this;
	}
	public String getSystem_name(){
		return system_name;
	}
	public SystemAccountBean setSystem_name(String system_name){
		this.system_name= system_name;
		return this;
	}
	public String getSystem_account(){
		return system_account;
	}
	public SystemAccountBean setSystem_account(String system_account){
		this.system_account= system_account;
		return this;
	}
	public String getSystem_img(){
		return system_img;
	}
	public SystemAccountBean setSystem_img(String system_img){
		this.system_img= system_img;
		return this;
	}
	public String getSystem_password(){
		return system_password;
	}
	public SystemAccountBean setSystem_password(String system_password){
		this.system_password= system_password;
		return this;
	}
	public String getSystem_token(){
		return system_token;
	}
	public SystemAccountBean setSystem_token(String system_token){
		this.system_token= system_token;
		return this;
	}
	public String getSystem_type(){
		return system_type;
	}
	public SystemAccountBean setSystem_type(String system_type){
		this.system_type= system_type;
		return this;
	}
	public String getRole_id(){
		return role_id;
	}
	public SystemAccountBean setRole_id(String role_id){
		this.role_id= role_id;
		return this;
	}
	public String getHx_account(){
		return hx_account;
	}
	public SystemAccountBean setHx_account(String hx_account){
		this.hx_account= hx_account;
		return this;
	}
	public String getHx_pass(){
		return hx_pass;
	}
	public SystemAccountBean setHx_pass(String hx_pass){
		this.hx_pass= hx_pass;
		return this;
	}
	public String getHx_nick_name(){
		return hx_nick_name;
	}
	public SystemAccountBean setHx_nick_name(String hx_nick_name){
		this.hx_nick_name= hx_nick_name;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public SystemAccountBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public SystemAccountBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public SystemAccountBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
