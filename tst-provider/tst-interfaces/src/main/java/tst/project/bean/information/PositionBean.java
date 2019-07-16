package tst.project.bean.information;

import java.io.Serializable;
import java.util.List;

public class PositionBean implements Serializable{

	/**
	 * 职位信息表
	 */
	private static final long serialVersionUID = 1L;
	
	private int position_id; //职位id
	private String member_id; // 用户id
	private String material_id; //认证资料id
	private String material_name;//认证名称
	private String material_img;//认证头像
	
	private String position_title; //招聘名称/标题
	private String position_type; //招聘类型 0兼职 1全职
	private String position_type_show; //
	private String start_time; //招聘开始时间
	private String position_state; //招聘状态 0 发布中 1 已定人 2 已定实际工作人 3(不定人)提前结束 4活动正常结束
	private String position_state_show; //
	private String position_class_name; //职位分类名
	private String invitation_num; //邀请人数
	private String price; //薪酬
	private String position_specific; //具体要求
	private String position_provider; //省
	private String position_city; //市
	private String position_country; //区
	private String position_address; //详情地址
	private String position_img1;//职位图片 多张用逗号拼接
	private String position_img2;
	private String position_img3;
	private String position_video1;//职位视频 
	private String position_classes_id;//岗位id 多个用逗号拼接
	private String position_salary_names;//薪资内容 多个用逗号拼接
	private String salary_start;//薪资范围的的低价
	private String salary_end;//薪资范围的高价
	private String position_persons_id;//职位投递人id 多个用逗号拼接
	private String position_class_names;//岗位名称 显示用
	private String position_apply;//0上线 1下线
	private String position_apply_show;
	private String refuse_desc;//拒绝理由
	private String online;//0线下 1线上
	private String sex;//m男 w女
	private String weight;//体重
	private String height;//身高
	private String three_size;//三围
	private String age;//年龄
	private String final_price;//单人薪酬减去平台的佣金比例
	
	
	private String end_time;//招聘结束时间
	private String work_specific;//工作内容
	private List<PositionClassesBean> positionClassesBeans;//职位岗位关联表
	private List<PositionPersonsBean> positionPersonsBeans;//职位申请人表
	
	
	private String is_delete;//
	private String create_time; //
	private String update_time;//
	
	private String is_comment;//是否评论
	
	
	
	
	public String getPosition_salary_names() {
		return position_salary_names;
	}
	public PositionBean setPosition_salary_names(String position_salary_names) {
		this.position_salary_names = position_salary_names;
		return this;
	}
	public String getSalary_start() {
		return salary_start;
	}
	public PositionBean setSalary_start(String salary_start) {
		this.salary_start = salary_start;
		return this;
	}
	public String getSalary_end() {
		return salary_end;
	}
	public PositionBean setSalary_end(String salary_end) {
		this.salary_end = salary_end;
		return this;
	}
	public String getFinal_price() {
		return final_price;
	}
	public PositionBean setFinal_price(String final_price) {
		this.final_price = final_price;
		return this;
	}
	public String getIs_comment() {
		return is_comment;
	}
	public PositionBean setIs_comment(String is_comment) {
		this.is_comment = is_comment;
		return this;
	}
	public String getThree_size() {
		return three_size;
	}
	public PositionBean setThree_size(String three_size) {
		this.three_size = three_size;
		return this;
	}
	public String getOnline() {
		return online;
	}
	public PositionBean setOnline(String online) {
		this.online = online;
		return this;
	}
	public String getMaterial_name() {
		return material_name;
	}
	public PositionBean setMaterial_name(String material_name) {
		this.material_name = material_name;
		return this;
	}
	public String getMaterial_img() {
		return material_img;
	}
	public PositionBean setMaterial_img(String material_img) {
		this.material_img = material_img;
		return this;
	}
	public String getSex() {
		return sex;
	}
	public PositionBean setSex(String sex) {
		this.sex = sex;
		return this;
	}
	public String getWeight() {
		return weight;
	}
	public PositionBean setWeight(String weight) {
		this.weight = weight;
		return this;
	}
	public String getHeight() {
		return height;
	}
	public PositionBean setHeight(String height) {
		this.height = height;
		return this;
	}
	public String getAge() {
		return age;
	}
	public PositionBean setAge(String age) {
		this.age = age;
		return this;
	}
	public int getPosition_id() {
		return position_id;
	}
	public PositionBean setPosition_id(int position_id) {
		this.position_id = position_id;
		return this;
	}
	public String getMember_id() {
		return member_id;
	}
	public PositionBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	
	public String getMaterial_id() {
		return material_id;
	}
	public PositionBean setMaterial_id(String material_id) {
		this.material_id = material_id;
		return this;
	}
	public String getPosition_title() {
		return position_title;
	}
	public PositionBean setPosition_title(String position_title) {
		this.position_title = position_title;
		return this;
	}
	public String getPosition_type() {
		return position_type;
	}
	public PositionBean setPosition_type(String position_type) {
		this.position_type = position_type;
		this.position_type_show = "0".equals(position_type)?"兼职":
			"1".equals(position_type)?"全职":"其他";
		return this;
	}
	public String getPosition_type_show() {
		return position_type_show;
	}
	public PositionBean setPosition_type_show(String position_type_show) {
		this.position_type_show = position_type_show;
		return this;
	}
	public String getStart_time() {
		return start_time;
	}
	public PositionBean setStart_time(String start_time) {
		this.start_time = start_time;
		return this;
	}
	public String getPosition_state() {
		return position_state;
	}
	public PositionBean setPosition_state(String position_state) {
		this.position_state = position_state;
		this.position_state_show = "0".equals(position_state)?"发布中":
			"1".equals(position_state)?"已定人":
			"2".equals(position_state)?"已结束":
				"3".equals(position_state)?"(不定人)提前结束":
					"4".equals(position_state)?"活动正常结束":"未知";
		return this;
	}
	public String getPosition_state_how() {
		return position_state_show;
	}
	public PositionBean setPosition_state_how(String position_state_show) {
		this.position_state_show = position_state_show;
		return this;
	}
	public String getPosition_class_name() {
		return position_class_name;
	}
	public PositionBean setPosition_class_name(String position_class_name) {
		this.position_class_name = position_class_name;
		return this;
	}
	public String getInvitation_num() {
		return invitation_num;
	}
	public PositionBean setInvitation_num(String invitation_num) {
		this.invitation_num = invitation_num;
		return this;
	}
	public String getPrice() {
		return price;
	}
	public PositionBean setPrice(String price) {
		this.price = price;
		return this;
	}
	
	public String getPosition_specific() {
		return position_specific;
	}
	public PositionBean setPosition_specific(String position_specific) {
		this.position_specific = position_specific;
		return this;
	}
	public String getPosition_provider() {
		return position_provider;
	}
	public PositionBean setPosition_provider(String position_provider) {
		this.position_provider = position_provider;
		return this;
	}
	public String getPosition_city() {
		return position_city;
	}
	public PositionBean setPosition_city(String position_city) {
		this.position_city = position_city;
		return this;
	}
	public String getPosition_country() {
		return position_country;
	}
	public PositionBean setPosition_country(String position_country) {
		this.position_country = position_country;
		return this;
	}
	public String getPosition_address() {
		return position_address;
	}
	public PositionBean setPosition_address(String position_address) {
		this.position_address = position_address;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public PositionBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public PositionBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public PositionBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getEnd_time() {
		return end_time;
	}
	public PositionBean setEnd_time(String end_time) {
		this.end_time = end_time;
		return this;
	}
	public String getWork_specific() {
		return work_specific;
	}
	public PositionBean setWork_specific(String work_specific) {
		this.work_specific = work_specific;
		return this;
	}
	public List<PositionClassesBean> getPositionClassesBeans() {
		return positionClassesBeans;
	}
	public PositionBean setPositionClassesBeans(List<PositionClassesBean> positionClassesBeans) {
		this.positionClassesBeans = positionClassesBeans;
		return this;
	}
	public List<PositionPersonsBean> getPositionPersonsBeans() {
		return positionPersonsBeans;
	}
	public PositionBean setPositionPersonsBeans(List<PositionPersonsBean> positionPersonsBeans) {
		this.positionPersonsBeans = positionPersonsBeans;
		return this;
	}
	public String getPosition_state_show() {
		return position_state_show;
	}
	public PositionBean setPosition_state_show(String position_state_show) {
		this.position_state_show = position_state_show;
		return this;
	}
	public String getPosition_img1() {
		return position_img1;
	}
	public PositionBean setPosition_img1(String position_img1) {
		this.position_img1 = position_img1;
		return this;
	}
	public String getPosition_img2() {
		return position_img2;
	}
	public PositionBean setPosition_img2(String position_img2) {
		this.position_img2 = position_img2;
		return this;
	}
	public String getPosition_img3() {
		return position_img3;
	}
	public PositionBean setPosition_img3(String position_img3) {
		this.position_img3 = position_img3;
		return this;
	}
	public String getPosition_video1() {
		return position_video1;
	}
	public PositionBean setPosition_video1(String position_video1) {
		this.position_video1 = position_video1;
		return this;
	}
	public String getPosition_classes_id() {
		return position_classes_id;
	}
	public PositionBean setPosition_classes_id(String position_classes_id) {
		this.position_classes_id = position_classes_id;
		return this;
	}
	public String getPosition_persons_id() {
		return position_persons_id;
	}
	public PositionBean setPosition_persons_id(String position_persons_id) {
		this.position_persons_id = position_persons_id;
		return this;
	}
	public String getPosition_class_names() {
		return position_class_names;
	}
	public PositionBean setPosition_class_names(String position_class_names) {
		this.position_class_names = position_class_names;
		return this;
	}
	
	public String getPosition_apply() {
		return position_apply;
	}
	public PositionBean setPosition_apply(String position_apply) {
		this.position_apply = position_apply;
		this.position_apply_show = "0".equals(position_apply)?"上线":
			"1".equals(position_apply)?"下线":"未知";
		return this;
	}
	public String getPosition_apply_show() {
		return position_apply_show;
	}
	public PositionBean setPosition_apply_show(String position_apply_show) {
		this.position_apply_show = position_apply_show;
		return this;
	}
	public String getRefuse_desc() {
		return refuse_desc;
	}
	public PositionBean setRefuse_desc(String refuse_desc) {
		this.refuse_desc = refuse_desc;
		return this;
	}
	
	

	
	
	
	
}
