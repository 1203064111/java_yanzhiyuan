package tst.project.bean.member;

import java.io.Serializable;

/**

**

*/

public class CertificationBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String certification_id;//
	private String member_id;//
	private String member_name;//邀请人姓名
	private String member_mobile;//邀请人电话
	private String enterprise_img1;//企业认证资料
	private String enterprise_img2;
	private String enterprise_img3;
	private String enterprise_img4;
	private String submit_state;//认证状态
	private String submit_state_show;
	private String refuse_cause;//审核拒绝原因
	private String is_delete;
	private String create_time;
	private String update_time;
	
	public String getCertification_id(){
		return certification_id;
	}
	public CertificationBean setCertification_id(String certification_id){
		this.certification_id= certification_id;
		return this;
	}
	public String getMember_id(){
		return member_id;
	}
	public CertificationBean setMember_id(String member_id){
		this.member_id= member_id;
		return this;
	}
	public String getMember_name(){
		return member_name;
	}
	public CertificationBean setMember_name(String member_name){
		this.member_name= member_name;
		return this;
	}
	public String getMember_mobile(){
		return member_mobile;
	}
	public CertificationBean setMember_mobile(String member_mobile){
		this.member_mobile= member_mobile;
		return this;
	}
	public String getEnterprise_img1() {
		return enterprise_img1;
	}
	public CertificationBean setEnterprise_img1(String enterprise_img1) {
		this.enterprise_img1 = enterprise_img1;
		return this;
		
	}
	public String getEnterprise_img2() {
		return enterprise_img2;
	}
	public CertificationBean setEnterprise_img2(String enterprise_img2) {
		this.enterprise_img2 = enterprise_img2;
		return this;
	}
	public String getEnterprise_img3() {
		return enterprise_img3;
	}
	public CertificationBean setEnterprise_img3(String enterprise_img3) {
		this.enterprise_img3 = enterprise_img3;
		return this;
	}
	public String getEnterprise_img4() {
		return enterprise_img4;
	}
	public CertificationBean setEnterprise_img4(String enterprise_img4) {
		this.enterprise_img4 = enterprise_img4;
		return this;
	}
	public String getSubmit_state() {
		return submit_state;
	}
	public CertificationBean setSubmit_state(String submit_state) {
		this.submit_state = submit_state;
		this.submit_state_show = "0".equals(submit_state)?"未提交":
								("1".equals(submit_state)?"已提交":
								("2".equals(submit_state)?"已认证":"已拒绝"));
		return this;
	}
	public String getSubmit_state_show() {
		return submit_state_show;
	}
	public CertificationBean setSubmit_state_show(String submit_state_show) {
		this.submit_state_show = submit_state_show;
		return this;
	}
	public String getRefuse_cause(){
		return refuse_cause;
	}
	public CertificationBean setRefuse_cause(String refuse_cause){
		this.refuse_cause= refuse_cause;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public CertificationBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public CertificationBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public CertificationBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	
}
