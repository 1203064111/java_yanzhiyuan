package tst.project.bean.sheep;

import java.io.Serializable;
import java.util.List;

public class SheepBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int bitch_sheep_id; //分期羊id
	private String sheep_id;    //羊id
	private String sheep_name;
	private String sheep_title;//本期标题
	private String class_id;   //羊分类
	private double sheep_price;//价格
	private int sheep_num;//数量
	private String sheep_img;//图片
	private String sheep_desc;
	private String is_delete;
	private String update_time;
	private String create_time;
	private String sheep_type;//0,1合养、认养
	private String sheep_type_show;
	private String sheep_state;//上下架
	private String sheep_sales;//销量
	private String sheep_bitch;//当前分期
	private String group_type;//2.3.4.5分期
	private String group_type_show;
	private String class_sign;//类别·
	private  SheepBean sheepBean;//总
	private List<SheepBean> sheepBeans;//分期羊
	private String sheep_use_num;//正在上架的数量
	private String sheep_assess;//评价
	private String sheep_assess_num;//评价数
	private String good_assess_num;//好评数
	private String sheep_html_desc;//html页面
	private String sheep_excel_url;
	
	private String sheep_video;//羊视频
	
	private String ear_range;//分期羊耳标范围
	private List<SheepImgBean> sheepImgBeans;
	
	private String sort;
	private String sort_type;
	private String sheep_source;
	private String sheep_assess_show;//好评展示
	private String is_upload ;
	
	
	

	
	
	public String getIs_upload() {
		return is_upload;
	}

	public SheepBean setIs_upload(String is_upload) {
		this.is_upload = is_upload;
		return this;
	}

	public String getSheep_assess_show() {
		return sheep_assess_show;
	}

	public SheepBean setSheep_assess_show(String sheep_assess_show) {
		this.sheep_assess_show = sheep_assess_show;
		return this;
	}

	public String getSort() {
		return sort;
	}

	public SheepBean setSort(String sort) {
		this.sort = sort;
		return this;
	}

	public String getSort_type() {
		return sort_type;
	}

	public SheepBean setSort_type(String sort_type) {
		this.sort_type = sort_type;
		return this;
	}

	public String getSheep_source() {
		return sheep_source;
	}

	public SheepBean setSheep_source(String sheep_source) {
		this.sheep_source = sheep_source;
		return this;
	}

	public List<SheepImgBean> getSheepImgBeans() {
		return sheepImgBeans;
	}

	public SheepBean setSheepImgBeans(List<SheepImgBean> sheepImgBeans) {
		this.sheepImgBeans = sheepImgBeans;
		return this;
	}

	public String getSheep_video() {
		return sheep_video;
	}

	public SheepBean setSheep_video(String sheep_video) {
		this.sheep_video = sheep_video;
		return this;
	}

	public String getSheep_excel_url() {
		return sheep_excel_url;
	}

	public SheepBean setSheep_excel_url(String sheep_excel_url) {
		this.sheep_excel_url = sheep_excel_url;
		return this;
	}

	public String getSheep_html_desc() {
		return sheep_html_desc;
	}

	public SheepBean setSheep_html_desc(String sheep_html_desc) {
		this.sheep_html_desc = sheep_html_desc;
		return this;
	}

	public String getSheep_assess_num() {
		return sheep_assess_num;
	}

	public SheepBean setSheep_assess_num(String sheep_assess_num) {
		this.sheep_assess_num = sheep_assess_num;
		return this;
	}

	public String getGood_assess_num() {
		return good_assess_num;
	}

	public SheepBean setGood_assess_num(String good_assess_num) {
		this.good_assess_num = good_assess_num;
		return this;
	}

	public String getSheep_title() {
		return sheep_title;
	}

	public SheepBean setSheep_title(String sheep_title) {
		this.sheep_title = sheep_title;
		return this;
	}

	public String getEar_range() {
		return ear_range;
	}

	public SheepBean setEar_range(String ear_range) {
		this.ear_range = ear_range;
		return this;
	}

	public String getSheep_assess() {
		sheep_assess=(this.sheep_assess==null||"".equals(sheep_assess))?"未有任何评价信息":sheep_assess;
				
		return sheep_assess;
	}

	public SheepBean setSheep_assess(String sheep_assess) {
		this.sheep_assess = sheep_assess;
		return this;
	}

	public String getSheep_use_num() {
		return sheep_use_num;
	}

	public SheepBean setSheep_use_num(String sheep_use_num) {
		this.sheep_use_num = sheep_use_num;
		return this;
	}

	public String getSheep_type_show() {
		return sheep_type_show;
	}

	public SheepBean setSheep_type_show(String sheep_type_show) {
		this.sheep_type_show = sheep_type_show;
		return this;
	}

	public String getGroup_type_show() {
		return group_type_show;
	}

	public SheepBean setGroup_type_show(String group_type_show) {
		this.group_type_show = group_type_show;
		return this;
	}

	public List<SheepBean> getSheepBeans() {
		return sheepBeans;
	}

	public SheepBean setSheepBeans(List<SheepBean> sheepBeans) {
		this.sheepBeans = sheepBeans;
		return this;
	}

	public String getClass_sign() {
		return class_sign;
	}

	public SheepBean setClass_sign(String class_sign) {
		this.class_sign = class_sign;
		return this;
	}

	public SheepBean getSheepBean() {
		return sheepBean;
	}

	public SheepBean setSheepBean(SheepBean sheepBean) {
		this.sheepBean = sheepBean;
		return this;
	}

	public int getBitch_sheep_id() {
		return bitch_sheep_id;
	}

	public SheepBean setBitch_sheep_id(int bitch_sheep_id) {
		this.bitch_sheep_id = bitch_sheep_id;
		return this;
	}

	public String getSheep_id() {
		return sheep_id;
	}

	public SheepBean setSheep_id(String sheep_id) {
		this.sheep_id = sheep_id;
		return this;
	}

	public String getSheep_name() {
		return sheep_name;
	}

	public SheepBean setSheep_name(String sheep_name) {
		this.sheep_name = sheep_name;
		return this;
	}

	public String getClass_id() {
		return class_id;
	}

	public SheepBean setClass_id(String class_id) {
		this.class_id = class_id;
		return this;
	}

	public double getSheep_price() {
		return sheep_price;
	}

	public SheepBean setSheep_price(double sheep_price) {
		this.sheep_price = sheep_price;
		return this;
	}

	public int getSheep_num() {
		return sheep_num;
	}

	public SheepBean setSheep_num(int sheep_num) {
		this.sheep_num = sheep_num;
		return this;
	}

	public String getSheep_img() {
		return sheep_img;
	}

	public SheepBean setSheep_img(String sheep_img) {
		this.sheep_img = sheep_img;
		return this;
	}

	public String getSheep_desc() {
		return sheep_desc;
	}

	public SheepBean setSheep_desc(String sheep_desc) {
		this.sheep_desc = sheep_desc;
		return this;
	}

	public String getIs_delete() {
		return is_delete;
	}

	public SheepBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}

	public String getUpdate_time() {
		return update_time;
	}

	public SheepBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}

	public String getCreate_time() {
		return create_time;
	}

	public SheepBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}

	public String getSheep_type() {
		return sheep_type;
	}

	public SheepBean setSheep_type(String sheep_type) {
		this.sheep_type = sheep_type;
		this.sheep_type_show="0".equals(sheep_type)?"认养":"合养";
		return this;
	}

	public String getSheep_state() {
		return sheep_state;
	}

	public SheepBean setSheep_state(String sheep_state) {
		this.sheep_state = sheep_state;
		return this;
	}

	public String getSheep_sales() {
		return sheep_sales;
	}

	public SheepBean setSheep_sales(String sheep_sales) {
		this.sheep_sales = sheep_sales;
		return this;
	}

	public String getSheep_bitch() {
		return sheep_bitch;
	}

	public SheepBean setSheep_bitch(String sheep_bitch) {
		this.sheep_bitch = sheep_bitch;
		return this;
	}

	public String getGroup_type() {
		return group_type;
	}

	public SheepBean setGroup_type(String group_type) {
		this.group_type = group_type;
		this.group_type_show=
		"2".equals(this.group_type)?"二人合养":
			"3".equals(this.group_type)?"三人合养":
				"4".equals(this.group_type)?"四人合养":
					"5".equals(this.group_type)?"五人合养":"其它";
			
		return this;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
