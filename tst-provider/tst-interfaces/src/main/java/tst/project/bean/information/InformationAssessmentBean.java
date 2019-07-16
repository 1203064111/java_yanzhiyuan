package tst.project.bean.information;

import java.io.Serializable;
import java.util.List;

public class InformationAssessmentBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int assessment_id; //评论id
	private int member_id; //用户id
	private String member_name;//用户名称
	private String member_img;//用户头像
	private int information_id; // 资讯id
	private String information_title;//传输用
	private String class_id;//传输用
	private String assessment_star; //评论星级
	private String assessment_desc; //评论内容
	private String assessment_imgs;//评论图片(多张逗号相隔)
	private String parent_id;//父评论id
	private String is_delete; //
	private String create_time; //
	private String update_time; //
	
	private List<InformationAssessmentBean> informationAssessmentBeans;//下级回复列表
	
	
	
	
	public String getClass_id() {
		return class_id;
	}
	public InformationAssessmentBean setClass_id(String class_id) {
		this.class_id = class_id;
		return this;
	}
	public String getInformation_title() {
		return information_title;
	}
	public InformationAssessmentBean setInformation_title(String information_title) {
		this.information_title = information_title;
		return this;
	}
	public List<InformationAssessmentBean> getInformationAssessmentBeans() {
		return informationAssessmentBeans;
	}
	public InformationAssessmentBean setInformationAssessmentBeans(List<InformationAssessmentBean> informationAssessmentBeans) {
		this.informationAssessmentBeans = informationAssessmentBeans;
		return this;
	}
	public String getMember_img() {
		return member_img;
	}
	public InformationAssessmentBean setMember_img(String member_img) {
		this.member_img = member_img;
		return this;
	}
	public int getAssessment_id() {
		return assessment_id;
	}
	public InformationAssessmentBean setAssessment_id(int assessment_id) {
		this.assessment_id = assessment_id;
		return this;
	}
	public int getMember_id() {
		return member_id;
	}
	public InformationAssessmentBean setMember_id(int member_id) {
		this.member_id = member_id;
		return this;
	}
	
	
	public String getMember_name() {
		return member_name;
	}
	public InformationAssessmentBean setMember_name(String member_name) {
		this.member_name = member_name;
		return this;
	}
	public int getInformation_id() {
		return information_id;
	}
	public InformationAssessmentBean setInformation_id(int information_id) {
		this.information_id = information_id;
		return this;
	}
	public String getAssessment_star() {
		return assessment_star;
	}
	public InformationAssessmentBean setAssessment_star(String assessment_star) {
		this.assessment_star = assessment_star;
		return this;
	}
	public String getAssessment_desc() {
		return assessment_desc;
	}
	public InformationAssessmentBean setAssessment_desc(String assessment_desc) {
		this.assessment_desc = assessment_desc;
		return this;
	}
	public String getAssessment_imgs() {
		return assessment_imgs;
	}
	public InformationAssessmentBean setAssessment_imgs(String assessment_imgs) {
		this.assessment_imgs = assessment_imgs;
		return this;
	}
	public String getParent_id() {
		return parent_id;
	}
	public InformationAssessmentBean setParent_id(String parent_id) {
		this.parent_id = parent_id;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public InformationAssessmentBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public InformationAssessmentBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public InformationAssessmentBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	
}
