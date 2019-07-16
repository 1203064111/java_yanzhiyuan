package tst.project.bean.shop;

import java.io.Serializable;

/**

**

*/

public class ActivityBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int activity_id;//
	private String merchants_id;
	private String activity_name;//活动名称
	private String activity_desc;//活动描述
	private String activity_img;//活动封面
	private String activity_type;//1:满赠 2:满减 3:直降 4:限时抢购
	private String activity_state;//0:关闭 1:开启
	private String start_time;//开始时间
	private String end_time;//结束时间
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	private ActivityGiveBean activityGiveBean;
	private ActivityReduceBean activityReduceBean;
	private ActivityDescendingBean activityDescendingBean;
	private ActivityShoppingBean activityShoppingBean;
	
	public ActivityShoppingBean getActivityShoppingBean() {
		return activityShoppingBean;
	}
	public ActivityBean setActivityShoppingBean(ActivityShoppingBean activityShoppingBean) {
		this.activityShoppingBean = activityShoppingBean;
		return this;
	}
	
	public int getActivity_id(){
		return activity_id;
	}
	public ActivityBean setActivity_id(int activity_id){
		this.activity_id= activity_id;
		return this;
	}
	
	public String getMerchants_id() {
		return merchants_id;
	}
	public ActivityBean setMerchants_id(String merchants_id) {
		this.merchants_id = merchants_id;
		return this;
	}
	public String getActivity_name(){
		return activity_name;
	}
	public ActivityBean setActivity_name(String activity_name){
		this.activity_name= activity_name;
		return this;
	}
	public String getActivity_desc(){
		return activity_desc;
	}
	public ActivityBean setActivity_desc(String activity_desc){
		this.activity_desc= activity_desc;
		return this;
	}
	public String getActivity_type(){
		return activity_type;
	}
	public ActivityBean setActivity_type(String activity_type){
		this.activity_type= activity_type;
		return this;
	}
	
	public String getActivity_state() {
		return activity_state;
	}
	public ActivityBean setActivity_state(String activity_state) {
		this.activity_state = activity_state;
		return this;
	}
	public String getActivity_img() {
		return activity_img;
	}
	public ActivityBean setActivity_img(String activity_img) {
		this.activity_img = activity_img;
		return this;
	}
	public String getStart_time(){
		return start_time;
	}
	public ActivityBean setStart_time(String start_time){
		this.start_time= start_time;
		return this;
	}
	public String getEnd_time(){
		return end_time;
	}
	public ActivityBean setEnd_time(String end_time){
		this.end_time= end_time;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public ActivityBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public ActivityBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public ActivityBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
	public ActivityGiveBean getActivityGiveBean() {
		return activityGiveBean;
	}
	public ActivityBean setActivityGiveBean(ActivityGiveBean activityGiveBean) {
		this.activityGiveBean = activityGiveBean;
		return this;
	}
	public ActivityReduceBean getActivityReduceBean() {
		return activityReduceBean;
	}
	public ActivityBean setActivityReduceBean(ActivityReduceBean activityReduceBean) {
		this.activityReduceBean = activityReduceBean;
		return this;
	}
	public ActivityDescendingBean getActivityDescendingBean() {
		return activityDescendingBean;
	}
	public ActivityBean setActivityDescendingBean(ActivityDescendingBean activityDescendingBean) {
		this.activityDescendingBean = activityDescendingBean;
		return this;
	}
	
}
