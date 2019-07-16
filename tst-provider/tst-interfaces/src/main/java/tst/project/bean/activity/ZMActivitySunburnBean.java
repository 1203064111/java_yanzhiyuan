package tst.project.bean.activity;

import java.io.Serializable;
import java.util.List;

/**

**

*/

public class ZMActivitySunburnBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int sunburn_id;//晒单表id
	private String activity_id;//
	private String goods_id;//
	private String goods_name;//
	private String evaluate_text;//评价文字
	private String member_id;
	private String member_name;
	private String is_show;
	private String order_id;
	
	private String sunburn_img;
	
	private String[] sunburn_imgs;
	
	private String sunburn_ids;	
		
	public String[] getSunburn_imgs() {
		return sunburn_imgs;
	}
	public ZMActivitySunburnBean setSunburn_imgs(String[] sunburn_imgs) {
		this.sunburn_imgs = sunburn_imgs;
		return this;
	}
	
	public String getSunburn_img() {
		return sunburn_img;
	}
	public ZMActivitySunburnBean setSunburn_img(String sunburn_img) {
		this.sunburn_img = sunburn_img;
		return this;
	}
	public String getSunburn_ids() {
		return sunburn_ids;
	}
	public ZMActivitySunburnBean setSunburn_ids(String sunburn_ids) {
		this.sunburn_ids = sunburn_ids;
		return this;
	}
	
	public String getOrder_id() {
		return order_id;
	}
	public ZMActivitySunburnBean setOrder_id(String order_id) {
		this.order_id = order_id;
		return this;
	}
	public String getIs_show() {
		return is_show;
	}
	public ZMActivitySunburnBean setIs_show(String is_show) {
		this.is_show = is_show;
		return this;
	}
	public String getMember_id() {
		return member_id;
	}
	public ZMActivitySunburnBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getMember_name() {
		return member_name;
	}
	public ZMActivitySunburnBean setMember_name(String member_name) {
		this.member_name = member_name;
		return this;
	}
	public int getSunburn_id(){
		return sunburn_id;
	}
	public ZMActivitySunburnBean setSunburn_id(int sunburn_id){
		this.sunburn_id= sunburn_id;
		return this;
	}
	public String getActivity_id(){
		return activity_id;
	}
	public ZMActivitySunburnBean setActivity_id(String activity_id){
		this.activity_id= activity_id;
		return this;
	}
	public String getGoods_id(){
		return goods_id;
	}
	public ZMActivitySunburnBean setGoods_id(String goods_id){
		this.goods_id= goods_id;
		return this;
	}
	public String getGoods_name(){
		return goods_name;
	}
	public ZMActivitySunburnBean setGoods_name(String goods_name){
		this.goods_name= goods_name;
		return this;
	}
	public String getEvaluate_text(){
		return evaluate_text;
	}
	public ZMActivitySunburnBean setEvaluate_text(String evaluate_text){
		this.evaluate_text= evaluate_text;
		return this;
	}
}
