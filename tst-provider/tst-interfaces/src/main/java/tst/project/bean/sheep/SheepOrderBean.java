package tst.project.bean.sheep;

import java.io.Serializable;

public class SheepOrderBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String order_sheep_id;
	private String order_id;
	private String bitch_sheep_id;
	private String sheep_img;
	private String ear_id;
	private String sheep_type;
	private String sheep_name;
	private String sheep_desc;
	private String ear_sign;
	private String sheep_price;
	private String sheep_kg;
	private String sheep_room;
	private String is_delete;
	private String update_time;
	private String create_time;
	private String sheep_breed_time;//养殖结束时间
	private String sheep_end_time;//养殖结束时间
	private String qr_code;
	
	


	public String getQr_code() {
		return qr_code;
	}

	public SheepOrderBean setQr_code(String qr_code) {
		this.qr_code = qr_code;
		return this;
	}

	public String getSheep_img() {
		return sheep_img;
	}

	public SheepOrderBean setSheep_img(String sheep_img) {
		this.sheep_img = sheep_img;
		return this;
	}

	public String getSheep_end_time() {
		return sheep_end_time;
	}

	public SheepOrderBean setSheep_end_time(String sheep_end_time) {
		this.sheep_end_time = sheep_end_time;
		return this;
	}

	public String getSheep_breed_time() {
		return sheep_breed_time;
	}

	public SheepOrderBean setSheep_breed_time(String sheep_breed_time) {
		this.sheep_breed_time = sheep_breed_time;
		return this;
	}

	public String getOrder_sheep_id() {
		return order_sheep_id;
	}

	public SheepOrderBean setOrder_sheep_id(String order_sheep_id) {
		this.order_sheep_id = order_sheep_id;
		return this;

	}

	public String getOrder_id() {
		return order_id;
	}

	public SheepOrderBean setOrder_id(String order_id) {
		this.order_id = order_id;
		return this;
	}

	public String getBitch_sheep_id() {
		return bitch_sheep_id;
	}

	public SheepOrderBean setBitch_sheep_id(String bitch_sheep_id) {
		this.bitch_sheep_id = bitch_sheep_id;
		return this;
	}

	public String getEar_id() {
		return ear_id;
	}

	public SheepOrderBean setEar_id(String ear_id) {
		this.ear_id = ear_id;
		return this;
	}

	public String getSheep_type() {
		return sheep_type;
	}

	public SheepOrderBean setSheep_type(String sheep_type) {
		this.sheep_type = sheep_type;
		return this;
	}

	public String getSheep_name() {
		return sheep_name;
	}

	public SheepOrderBean setSheep_name(String sheep_name) {
		this.sheep_name = sheep_name;
		return this;
	}

	public String getSheep_desc() {
		return sheep_desc;
	}

	public SheepOrderBean setSheep_desc(String sheep_desc) {
		this.sheep_desc = sheep_desc;
		return this;
	}

	public String getEar_sign() {
		return ear_sign;
	}

	public SheepOrderBean setEar_sign(String ear_sign) {
		this.ear_sign = ear_sign;
		return this;
	}

	public String getSheep_price() {
		return sheep_price;
	}

	public SheepOrderBean setSheep_price(String sheep_price) {
		this.sheep_price = sheep_price;
		return this;
	}

	public String getSheep_kg() {
		return sheep_kg;
	}

	public SheepOrderBean setSheep_kg(String sheep_kg) {
		this.sheep_kg = sheep_kg;
		return this;
	}

	public String getSheep_room() {
		return sheep_room;
	}

	public SheepOrderBean setSheep_room(String sheep_room) {
		this.sheep_room = sheep_room;
		return this;
	}

	public String getIs_delete() {
		return is_delete;
	}

	public SheepOrderBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}

	public String getUpdate_time() {
		return update_time;
	}

	public SheepOrderBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}

	public String getCreate_time() {
		return create_time;
	}

	public SheepOrderBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
