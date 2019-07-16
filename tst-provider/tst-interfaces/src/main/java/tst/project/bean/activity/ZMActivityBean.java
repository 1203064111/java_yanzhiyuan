package tst.project.bean.activity;

import java.io.Serializable;

/**

**

*/

public class ZMActivityBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int activity_id;//
	private String activity_name;//
	private String activity_state;//活动状态 0: 开启 1: 关闭
	private String activity_desc;//
	private String activity_img;//
	private String start_time;//
	private String end_time;//
	private String activity_people_num;//
	private String activity_people_win;//
	private String activity_price;//
	private String freight_id;
	private String create_time;
	private String update_time;
	
	
	public String getCreate_time() {
		return create_time;
	}
	public ZMActivityBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public ZMActivityBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	
	public int getActivity_id() {
		return activity_id;
	}
	public ZMActivityBean setActivity_id(int activity_id) {
		this.activity_id = activity_id;
		return this;
	}
	public String getActivity_name(){
		return activity_name;
	}
	public ZMActivityBean setActivity_name(String activity_name){
		this.activity_name= activity_name;
		return this;
	}
	public String getActivity_state(){
		return activity_state;
	}
	public ZMActivityBean setActivity_state(String activity_state){
		this.activity_state= activity_state;
		return this;
	}
	public String getActivity_desc(){
		return activity_desc;
	}
	public ZMActivityBean setActivity_desc(String activity_desc){
		this.activity_desc= activity_desc;
		return this;
	}
	public String getActivity_img(){
		return activity_img;
	}
	public ZMActivityBean setActivity_img(String activity_img){
		this.activity_img= activity_img;
		return this;
	}
	public String getStart_time(){
		return start_time;
	}
	public ZMActivityBean setStart_time(String start_time){
		this.start_time= start_time;
		return this;
	}
	public String getEnd_time(){
		return end_time;
	}
	public ZMActivityBean setEnd_time(String end_time){
		this.end_time= end_time;
		return this;
	}
	public String getActivity_people_num(){
		return activity_people_num;
	}
	public ZMActivityBean setActivity_people_num(String activity_people_num){
		this.activity_people_num= activity_people_num;
		return this;
	}
	public String getActivity_people_win(){
		return activity_people_win;
	}
	public ZMActivityBean setActivity_people_win(String activity_people_win){
		this.activity_people_win= activity_people_win;
		return this;
	}
	public String getActivity_price(){
		return activity_price;
	}
	public ZMActivityBean setActivity_price(String activity_price){
		this.activity_price= activity_price;
		return this;
	}
	public String getFreight_id() {
		return freight_id;
	}
	public ZMActivityBean setFreight_id(String freight_id) {
		this.freight_id = freight_id;
		return this;
	}
	
	
}
