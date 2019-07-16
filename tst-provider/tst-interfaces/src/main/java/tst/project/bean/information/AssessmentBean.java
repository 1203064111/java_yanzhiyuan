package tst.project.bean.information;

import java.io.Serializable;

public class AssessmentBean implements Serializable{

	/**
	 * 用户评论商家表
	 */
	private static final long serialVersionUID = 1L;
	private int assessment_id; //评论id
	private int member_id; //用户id
	private String member_name;//用户名称
	private int material_id; // 认证id
	private String assessment_star; //评论星级
	private String assessment_desc; //评论内容
	private String assessment_imgs;//评论图片(多张逗号相隔)
	private String parent_id;//父评论id
	private String is_delete; //
	private String create_time; //
	private String update_time; //
	public int getAssessment_id() {
		return assessment_id;
	}
	public AssessmentBean setAssessment_id(int assessment_id) {
		this.assessment_id = assessment_id;
		return this;
	}
	public int getMember_id() {
		return member_id;
	}
	public AssessmentBean setMember_id(int member_id) {
		this.member_id = member_id;
		return this;
	}
	
	
	public String getMember_name() {
		return member_name;
	}
	public AssessmentBean setMember_name(String member_name) {
		this.member_name = member_name;
		return this;
	}
	public int getMaterial_id() {
		return material_id;
	}
	public AssessmentBean setMaterial_id(int material_id) {
		this.material_id = material_id;
		return this;
	}
	public String getAssessment_star() {
		return assessment_star;
	}
	public AssessmentBean setAssessment_star(String assessment_star) {
		this.assessment_star = assessment_star;
		return this;
	}
	public String getAssessment_desc() {
		return assessment_desc;
	}
	public AssessmentBean setAssessment_desc(String assessment_desc) {
		this.assessment_desc = assessment_desc;
		return this;
	}
	public String getAssessment_imgs() {
		return assessment_imgs;
	}
	public AssessmentBean setAssessment_imgs(String assessment_imgs) {
		this.assessment_imgs = assessment_imgs;
		return this;
	}
	public String getParent_id() {
		return parent_id;
	}
	public AssessmentBean setParent_id(String parent_id) {
		this.parent_id = parent_id;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public AssessmentBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public AssessmentBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public AssessmentBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	
}
