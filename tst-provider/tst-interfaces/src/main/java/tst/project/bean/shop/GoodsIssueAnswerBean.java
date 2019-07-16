package tst.project.bean.shop;

import java.io.Serializable;

public class GoodsIssueAnswerBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int issue_answer_id;
	private int goods_issue_id;//问题id
	private String member_id;//用户id 
	private String member_name;//传输用
	private String member_img;//传输用
	private String goods_name;//传输用
	private String goods_id;//商品id
	private String answer_desc;//回答内容
	private String answer_type;//回答类型
	private String is_delete;
	private String create_time;
	private String update_time;
	
	
	public String getMember_img() {
		return member_img;
	}
	public GoodsIssueAnswerBean setMember_img(String member_img) {
		this.member_img = member_img;
		return this;
	}
	public String getMember_name() {
		return member_name;
	}
	public GoodsIssueAnswerBean setMember_name(String member_name) {
		this.member_name = member_name;
		return this;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public GoodsIssueAnswerBean setGoods_name(String goods_name) {
		this.goods_name = goods_name;
		return this;
	}
	public int getIssue_answer_id() {
		return issue_answer_id;
	}
	public GoodsIssueAnswerBean setIssue_answer_id(int issue_answer_id) {
		this.issue_answer_id = issue_answer_id;
		return this;
	}
	public int getGoods_issue_id() {
		return goods_issue_id;
	}
	public GoodsIssueAnswerBean setGoods_issue_id(int goods_issue_id) {
		this.goods_issue_id = goods_issue_id;
		return this;
	}
	public String getMember_id() {
		return member_id;
	}
	public GoodsIssueAnswerBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getGoods_id() {
		return goods_id;
	}
	public GoodsIssueAnswerBean setGoods_id(String goods_id) {
		this.goods_id = goods_id;
		return this;
	}
	public String getAnswer_desc() {
		return answer_desc;
	}
	public GoodsIssueAnswerBean setAnswer_desc(String answer_desc) {
		this.answer_desc = answer_desc;
		return this;
	}
	public String getAnswer_type() {
		return answer_type;
	}
	public GoodsIssueAnswerBean setAnswer_type(String answer_type) {
		this.answer_type = answer_type;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public GoodsIssueAnswerBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public GoodsIssueAnswerBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public GoodsIssueAnswerBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	

}
