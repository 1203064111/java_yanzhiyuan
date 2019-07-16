package tst.project.bean.shop;

import java.io.Serializable;
import java.util.List;

public class GoodsIssueBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int goods_issue_id;
	private String member_id;//用户id
	private String member_name;//传输用
	private String member_img;//传输用
	private String goods_id;//商品id
	private String goods_name;//传输用
	private String merchants_id;//传输用
	private String issue_desc;//问题描述
	private String issue_type;//1：问题 2:回答
	private String is_delete;
	private String create_time;
	private String update_time;
	private GoodsIssueAnswerBean goodsIssueAnswerBean;
	private List<GoodsIssueAnswerBean> goodsIssueAnswerBeans;//该问题回答列表
	
	
	
	
	
	public String getMember_img() {
		return member_img;
	}
	public GoodsIssueBean setMember_img(String member_img) {
		this.member_img = member_img;
		return this;
	}
	public String getMerchants_id() {
		return merchants_id;
	}
	public GoodsIssueBean setMerchants_id(String merchants_id) {
		this.merchants_id = merchants_id;
		return this;
	}
	public String getMember_name() {
		return member_name;
	}
	public GoodsIssueBean setMember_name(String member_name) {
		this.member_name = member_name;
		return this;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public GoodsIssueBean setGoods_name(String goods_name) {
		this.goods_name = goods_name;
		return this;
	}
	public int getGoods_issue_id() {
		return goods_issue_id;
	}
	public GoodsIssueBean setGoods_issue_id(int goods_issue_id) {
		this.goods_issue_id = goods_issue_id;
		return this;
	}
	public String getMember_id() {
		return member_id;
	}
	public GoodsIssueBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getGoods_id() {
		return goods_id;
	}
	public GoodsIssueBean setGoods_id(String goods_id) {
		this.goods_id = goods_id;
		return this;
	}
	public String getIssue_desc() {
		return issue_desc;
	}
	public GoodsIssueBean setIssue_desc(String issue_desc) {
		this.issue_desc = issue_desc;
		return this;
	}
	public String getIssue_type() {
		return issue_type;
	}
	public GoodsIssueBean setIssue_type(String issue_type) {
		this.issue_type = issue_type;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public GoodsIssueBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public GoodsIssueBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public GoodsIssueBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public GoodsIssueAnswerBean getGoodsIssueAnswerBean() {
		return goodsIssueAnswerBean;
	}
	public GoodsIssueBean setGoodsIssueAnswerBean(GoodsIssueAnswerBean goodsIssueAnswerBean) {
		this.goodsIssueAnswerBean = goodsIssueAnswerBean;
		return this;
	}
	public List<GoodsIssueAnswerBean> getGoodsIssueAnswerBeans() {
		return goodsIssueAnswerBeans;
	}
	public GoodsIssueBean setGoodsIssueAnswerBeans(List<GoodsIssueAnswerBean> goodsIssueAnswerBeans) {
		this.goodsIssueAnswerBeans = goodsIssueAnswerBeans;
		return this;
	}
	
	

}
