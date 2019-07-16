package tst.project.bean.yinlong;

import java.io.Serializable;

import tst.project.bean.member.MemberBean;

/**

**

*/

public class MemberWorkerBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String member_id;//
	private String member_phone;//紧急联系电话
	private String member_name;//紧急联系人
	private String member_provider;//省
	private String member_city;//市
	private String member_country;//区
	private String assessment_star;//评论平均星级
	private String assessment_total_star;//评价历史总星级
	private String assessment_count;//评论总数
	private String worker_type; //工种
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	private MemberBean memberBean;
	private String member_state;//是否禁用用户
	
	public String getMember_state() {
		return member_state;
	}
	public MemberWorkerBean setMember_state(String member_state) {
		this.member_state = member_state;
		return this;
	}
	public String getWorker_type() {
		return worker_type;
	}
	public MemberWorkerBean setWorker_type(String worker_type) {
		this.worker_type = worker_type;
		return this;
	}
	public MemberBean getMemberBean() {
		return memberBean;
	}
	public MemberWorkerBean setMemberBean(MemberBean memberBean) {
		this.memberBean = memberBean;
		return this;
	}
	public String getMember_id() {
		return member_id;
	}
	public MemberWorkerBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getMember_phone(){
		return member_phone;
	}
	public MemberWorkerBean setMember_phone(String member_phone){
		this.member_phone= member_phone;
		return this;
	}
	public String getMember_name(){
		return member_name;
	}
	public MemberWorkerBean setMember_name(String member_name){
		this.member_name= member_name;
		return this;
	}
	public String getMember_provider(){
		return member_provider;
	}
	public MemberWorkerBean setMember_provider(String member_provider){
		this.member_provider= member_provider;
		return this;
	}
	public String getMember_city(){
		return member_city;
	}
	public MemberWorkerBean setMember_city(String member_city){
		this.member_city= member_city;
		return this;
	}
	public String getMember_country(){
		return member_country;
	}
	public MemberWorkerBean setMember_country(String member_country){
		this.member_country= member_country;
		return this;
	}
	
	public String getAssessment_star() {
		return assessment_star;
	}
	public MemberWorkerBean setAssessment_star(String assessment_star) {
		this.assessment_star = assessment_star;
		return this;
	}
	public String getAssessment_total_star() {
		return assessment_total_star;
	}
	public MemberWorkerBean setAssessment_total_star(String assessment_total_star) {
		this.assessment_total_star = assessment_total_star;
		return this;
	}
	public String getAssessment_count() {
		return assessment_count;
	}
	public MemberWorkerBean setAssessment_count(String assessment_count) {
		this.assessment_count = assessment_count;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public MemberWorkerBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public MemberWorkerBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public MemberWorkerBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
