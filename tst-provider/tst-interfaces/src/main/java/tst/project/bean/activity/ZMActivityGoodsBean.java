package tst.project.bean.activity;

import java.io.Serializable;

/**

**

*/

/**
 * @author liyong
 *
 */
public class ZMActivityGoodsBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int activity_goods_id;//
	private String activity_id;//
	private String goods_id;//
	private String goods_name;//
	private String activity_people; //需要参加活动的参与人数
	private String activity_people_win; //此参加活动中奖人数
	private String create_time;
	private String update_time;
	private String merchants_id;
	private String goods_img;
	private String order_count; //参加活动的人数
	private String goods_now_price; //商品原价
	private String goods_url_desc; //富文本编辑字段
	
	public String getGoods_url_desc() {
		return goods_url_desc;
	}
	public ZMActivityGoodsBean setGoods_url_desc(String goods_url_desc) {
		this.goods_url_desc = goods_url_desc;
		return this;
	}
	public String getGoods_now_price() {
		return goods_now_price;
	}
	public ZMActivityGoodsBean setGoods_now_price(String goods_now_price) {
		this.goods_now_price = goods_now_price;
		return this;
	}
	public String getActivity_people() {
		return activity_people;
	}
	public ZMActivityGoodsBean setActivity_people(String activity_people) {
		this.activity_people = activity_people;
		return this;
	}
	public String getActivity_people_win() {
		return activity_people_win;
	}
	public ZMActivityGoodsBean setActivity_people_win(String activity_people_win) {
		this.activity_people_win = activity_people_win;
		return this;
	}
	
	public String getOrder_count() {
		return order_count;
	}
	public ZMActivityGoodsBean setOrder_count(String order_count) {
		this.order_count = order_count;
		return this;
	}
	
	public String getGoods_img() {
		return goods_img;
	}
	public ZMActivityGoodsBean setGoods_img(String goods_img) {
		this.goods_img = goods_img;
		return this;
	}
	public String getMerchants_id() {
		return merchants_id;
	}
	public ZMActivityGoodsBean setMerchants_id(String merchants_id) {
		this.merchants_id = merchants_id;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public ZMActivityGoodsBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public ZMActivityGoodsBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public int getActivity_goods_id(){
		return activity_goods_id;
	}
	public ZMActivityGoodsBean setActivity_goods_id(int activity_goods_id){
		this.activity_goods_id= activity_goods_id;
		return this;
	}
	public String getActivity_id(){
		return activity_id;
	}
	public ZMActivityGoodsBean setActivity_id(String activity_id){
		this.activity_id= activity_id;
		return this;
	}
	public String getGoods_id(){
		return goods_id;
	}
	public ZMActivityGoodsBean setGoods_id(String goods_id){
		this.goods_id= goods_id;
		return this;
	}
	public String getGoods_name(){
		return goods_name;
	}
	public ZMActivityGoodsBean setGoods_name(String goods_name){
		this.goods_name= goods_name;
		return this;
	}
}
