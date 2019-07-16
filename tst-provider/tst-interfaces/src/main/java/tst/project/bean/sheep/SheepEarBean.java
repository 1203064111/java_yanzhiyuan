package tst.project.bean.sheep;

import java.io.Serializable;

public class SheepEarBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int ear_id;
	private String ear_sign;
	private String sheep_kg;
	private String sheep_room;
	private String update_time;
	private String create_time;
	private String is_delete;
	private String is_use;    //是否使用
	private String class_id;  //羊分类
	private String sheep_type;//羊类型
	private int sheep_num;//羊数量
	private String bitch_sheep_id;//分期羊主键
	private String qr_code;
	
	
	
	
	

	public String getQr_code() {
		return qr_code;
	}

	public SheepEarBean setQr_code(String qr_code) {
		this.qr_code = qr_code;
		return this;
	}

	public String getBitch_sheep_id() {
		return bitch_sheep_id;
	}

	public SheepEarBean setBitch_sheep_id(String bitch_sheep_id) {
		this.bitch_sheep_id = bitch_sheep_id;
		return this;
	}

	public int getSheep_num() {
		return sheep_num;
	}

	public SheepEarBean setSheep_num(int sheep_num) {
		this.sheep_num = sheep_num;
		return this;
	}

	public int getEar_id() {
		return ear_id;
	}

	public SheepEarBean setEar_id(int ear_id) {

		this.ear_id = ear_id;
		return this;

	}

	public String getEar_sign() {
		return ear_sign;
	}

	public SheepEarBean setEar_sign(String ear_sign) {
		this.ear_sign = ear_sign;
		return this;
	}

	public String getSheep_kg() {
		return sheep_kg;
	}

	public SheepEarBean setSheep_kg(String sheep_kg) {
		this.sheep_kg = sheep_kg;
		return this;
	}

	public String getSheep_room() {
		return sheep_room;
	}

	public SheepEarBean setSheep_room(String sheep_room) {
		this.sheep_room = sheep_room;
		return this;
	}

	public String getUpdate_time() {
		return update_time;
	}

	public SheepEarBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}

	public String getCreate_time() {
		return create_time;
	}

	public SheepEarBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}

	public String getIs_delete() {
		return is_delete;
	}

	public SheepEarBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}

	public String getIs_use() {
		return is_use;
	}

	public SheepEarBean setIs_use(String is_use) {
		this.is_use = is_use;
		return this;
	}

	public String getClass_id() {
		return class_id;
	}

	public SheepEarBean setClass_id(String class_id) {
		this.class_id = class_id;
		return this;
	}

	public String getSheep_type() {
		return sheep_type;
	}

	public SheepEarBean setSheep_type(String sheep_type) {
		this.sheep_type = sheep_type;
		return this;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
