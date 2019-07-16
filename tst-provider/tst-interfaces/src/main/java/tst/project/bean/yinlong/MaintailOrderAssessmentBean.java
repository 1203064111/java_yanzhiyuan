package tst.project.bean.yinlong;

import java.io.Serializable;
import java.util.List;

/**

**

*/

public class MaintailOrderAssessmentBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int assessment_id;//
	private String member_id;//
	private String order_id;//
	private String assessment_star1;//评论星级1
	private String assessment_star2;//评论星级2
	private String assessment_desc;//评论内容
	private String assessment_imgs;//评论图片(多张逗号相隔)
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	private MaintailOrderBean maintailOrderBean;//订单详情

	public MaintailOrderBean getMaintailOrderBean() {
		return maintailOrderBean;
	}
	public MaintailOrderAssessmentBean setMaintailOrderBean(MaintailOrderBean maintailOrderBean) {
		this.maintailOrderBean = maintailOrderBean;
		return this;
	}
	public int getAssessment_id(){
		return assessment_id;
	}
	public MaintailOrderAssessmentBean setAssessment_id(int assessment_id){
		this.assessment_id= assessment_id;
		return this;
	}
	public String getMember_id(){
		return member_id;
	}
	public MaintailOrderAssessmentBean setMember_id(String member_id){
		this.member_id= member_id;
		return this;
	}
	public String getOrder_id(){
		return order_id;
	}
	public MaintailOrderAssessmentBean setOrder_id(String order_id){
		this.order_id= order_id;
		return this;
	}
	public String getAssessment_star1(){
		return assessment_star1;
	}
	public MaintailOrderAssessmentBean setAssessment_star1(String assessment_star1){
		this.assessment_star1= assessment_star1;
		return this;
	}
	public String getAssessment_star2(){
		return assessment_star2;
	}
	public MaintailOrderAssessmentBean setAssessment_star2(String assessment_star2){
		this.assessment_star2= assessment_star2;
		return this;
	}
	public String getAssessment_desc(){
		return assessment_desc;
	}
	public MaintailOrderAssessmentBean setAssessment_desc(String assessment_desc){
		this.assessment_desc= assessment_desc;
		return this;
	}
	public String getAssessment_imgs(){
		return assessment_imgs;
	}
	public MaintailOrderAssessmentBean setAssessment_imgs(String assessment_imgs){
		this.assessment_imgs= assessment_imgs;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public MaintailOrderAssessmentBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public MaintailOrderAssessmentBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public MaintailOrderAssessmentBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
