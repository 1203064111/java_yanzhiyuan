package tst.project.bean.information;

import java.io.Serializable;

public class JobsAssessmentBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int assessment_id; //
	private int member_id; //用户id
	private int jobs_id; // 简历id
	private String assessment_star; //评论星级
	private String assessment_desc; //评论内容
	private String assessment_imgs;//评论图片(多张逗号相隔)
	private String is_delete; //
	private String create_time; //
	private String update_time; //
	public int getAssessment_id() {
		return assessment_id;
	}
	public JobsAssessmentBean setAssessment_id(int assessment_id) {
		this.assessment_id = assessment_id;
		return this;
	}
	public int getMember_id() {
		return member_id;
	}
	public JobsAssessmentBean setMember_id(int member_id) {
		this.member_id = member_id;
		return this;
	}
	public int getJobs_id() {
		return jobs_id;
	}
	public JobsAssessmentBean setJobs_id(int jobs_id) {
		this.jobs_id = jobs_id;
		return this;
	}
	public String getAssessment_star() {
		return assessment_star;
	}
	public JobsAssessmentBean setAssessment_star(String assessment_star) {
		this.assessment_star = assessment_star;
		return this;
	}
	public String getAssessment_desc() {
		return assessment_desc;
	}
	public JobsAssessmentBean setAssessment_desc(String assessment_desc) {
		this.assessment_desc = assessment_desc;
		return this;
	}
	public String getAssessment_imgs() {
		return assessment_imgs;
	}
	public JobsAssessmentBean setAssessment_imgs(String assessment_imgs) {
		this.assessment_imgs = assessment_imgs;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public JobsAssessmentBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public JobsAssessmentBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public JobsAssessmentBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	
}
