package tst.project.bean.shop;

import java.io.Serializable;
import java.util.List;

public class GoodsAssessmentBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int assessment_id;//
	private String member_id;//用户id 回复时作为商家的id
	private String member_name;
	private String goods_id;//商品id
	private String goods_name;
	private String assessment_desc;//评论内容
	private String assessment_star;//评论星级
	private String assessment_imgs;//评论图片 多张用逗号拼接
	private String assessment_video;//评论视频 
	private String parent_id;//父id
	private String is_delete;//
	private String apply_state;//评价是否上架 0下架 1上架
	private String create_time;
	private String update_time;
	private String merchants_id;//传输用
	
	private List<GoodsAssessmentBean> goodsAssessmentBeans;
	
	
	
	public String getAssessment_video() {
		return assessment_video;
	}
	public GoodsAssessmentBean setAssessment_video(String assessment_video) {
		this.assessment_video = assessment_video;
		return this;
	}
	public List<GoodsAssessmentBean> getGoodsAssessmentBeans() {
		return goodsAssessmentBeans;
	}
	public GoodsAssessmentBean setGoodsAssessmentBeans(List<GoodsAssessmentBean> goodsAssessmentBeans) {
		this.goodsAssessmentBeans = goodsAssessmentBeans;
		return this;
	}
	public String getMerchants_id() {
		return merchants_id;
	}
	public GoodsAssessmentBean setMerchants_id(String merchants_id) {
		this.merchants_id = merchants_id;
		return this;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public GoodsAssessmentBean setGoods_name(String goods_name) {
		this.goods_name = goods_name;
		return this;
	}
	public String getApply_state() {
		return apply_state;
	}
	public GoodsAssessmentBean setApply_state(String apply_state) {
		this.apply_state = apply_state;
		return this;
	}
	public int getAssessment_id() {
		return assessment_id;
	}
	public GoodsAssessmentBean setAssessment_id(int assessment_id) {
		this.assessment_id = assessment_id;
		return this;
	}
	public String getMember_id() {
		return member_id;
	}
	public GoodsAssessmentBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getMember_name() {
		return member_name;
	}
	public GoodsAssessmentBean setMember_name(String member_name) {
		this.member_name = member_name;
		return this;
	}
	public String getGoods_id() {
		return goods_id;
	}
	public GoodsAssessmentBean setGoods_id(String goods_id) {
		this.goods_id = goods_id;
		return this;
	}
	public String getAssessment_desc() {
		return assessment_desc;
	}
	public GoodsAssessmentBean setAssessment_desc(String assessment_desc) {
		this.assessment_desc = assessment_desc;
		return this;
	}
	public String getAssessment_star() {
		return assessment_star;
	}
	public GoodsAssessmentBean setAssessment_star(String assessment_star) {
		this.assessment_star = assessment_star;
		return this;
	}
	public String getAssessment_imgs() {
		return assessment_imgs;
	}
	public GoodsAssessmentBean setAssessment_imgs(String assessment_imgs) {
		this.assessment_imgs = assessment_imgs;
		return this;
	}
	public String getParent_id() {
		return parent_id;
	}
	public GoodsAssessmentBean setParent_id(String parent_id) {
		this.parent_id = parent_id;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public GoodsAssessmentBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public GoodsAssessmentBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public GoodsAssessmentBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	

}
