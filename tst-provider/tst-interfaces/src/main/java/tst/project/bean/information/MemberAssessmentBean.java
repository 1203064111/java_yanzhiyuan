package tst.project.bean.information;

import java.io.Serializable;

public class MemberAssessmentBean implements Serializable{

	/**
	 * 商家评论用户表
	 */
	private static final long serialVersionUID = 1L;
	private int assessment_id; //评论id
	private int member_id; //商家id
	private int member2_id; //用户id
	
	private int material_id; // 认证id
	private String material_name;//认证名称
	private String assessment_identity; //形象星级
	private String assessment_attitude; //态度星级
	private String assessment_skill; //技能星级
	private String assessment_desc; //评论内容
	private String assessment_imgs;//评论图片(多张逗号相隔)
	private String parent_id;//父评论id
	private String is_delete; //
	private String create_time; //
	private String update_time; //
	

	
	public String getMaterial_name() {
		return material_name;
	}
	public MemberAssessmentBean setMaterial_name(String material_name) {
		this.material_name = material_name;
		return this;
	}
	public int getMember2_id() {
		return member2_id;
	}
	public MemberAssessmentBean setMember2_id(int member2_id) {
		this.member2_id = member2_id;
		return this;
	}
	public int getAssessment_id() {
		return assessment_id;
	}
	public MemberAssessmentBean setAssessment_id(int assessment_id) {
		this.assessment_id = assessment_id;
		return this;
	}
	public int getMember_id() {
		return member_id;
	}
	public MemberAssessmentBean setMember_id(int member_id) {
		this.member_id = member_id;
		return this;
	}
	public int getMaterial_id() {
		return material_id;
	}
	public MemberAssessmentBean setMaterial_id(int material_id) {
		this.material_id = material_id;
		return this;
	}
	
	public String getAssessment_identity() {
		return assessment_identity;
	}
	public MemberAssessmentBean setAssessment_identity(String assessment_identity) {
		this.assessment_identity = assessment_identity;
		return this;
	}
	public String getAssessment_attitude() {
		return assessment_attitude;
	}
	public MemberAssessmentBean setAssessment_attitude(String assessment_attitude) {
		this.assessment_attitude = assessment_attitude;
		return this;
	}
	public String getAssessment_skill() {
		return assessment_skill;
	}
	public MemberAssessmentBean setAssessment_skill(String assessment_skill) {
		this.assessment_skill = assessment_skill;
		return this;
	}
	public String getAssessment_desc() {
		return assessment_desc;
	}
	public MemberAssessmentBean setAssessment_desc(String assessment_desc) {
		this.assessment_desc = assessment_desc;
		return this;
	}
	public String getAssessment_imgs() {
		return assessment_imgs;
	}
	public MemberAssessmentBean setAssessment_imgs(String assessment_imgs) {
		this.assessment_imgs = assessment_imgs;
		return this;
	}
	public String getParent_id() {
		return parent_id;
	}
	public MemberAssessmentBean setParent_id(String parent_id) {
		this.parent_id = parent_id;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public MemberAssessmentBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public MemberAssessmentBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public MemberAssessmentBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	
}
