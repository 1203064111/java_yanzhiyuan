package tst.project.bean.sheep;

import java.io.Serializable;

public class SheepSourceBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int source_id;
	private String member_sheep_id;
	private String sheep_imgs;
	private String sheep_kg;
	private String sheep_room;
	private String breed_day;
	private String update_time;
	private String create_time;
	private String is_delete;
	private String source_no;
	private String source_no_show;
	
	
	
	
	
	public String getSource_no() {
		return source_no;
	}
	public SheepSourceBean setSource_no(String source_no) {
		this.source_no = source_no;
		this.source_no_show="第"+source_no+"次采集";
		return this;
	}
	public String getSource_no_show() {
		return source_no_show;
	}
	public SheepSourceBean setSource_no_show(String source_no_show) {
		this.source_no_show = source_no_show;
		return this;
	}
	public int getSource_id() {
		return source_id;
	}
	public SheepSourceBean setSource_id(int source_id) {
		this.source_id = source_id;
		return this;
	}
	public String getMember_sheep_id() {
		return member_sheep_id;
	}
	public SheepSourceBean setMember_sheep_id(String member_sheep_id) {
		this.member_sheep_id = member_sheep_id;
		return this;
	}
	public String getSheep_imgs() {
		return sheep_imgs;
	}
	public SheepSourceBean setSheep_imgs(String sheep_imgs) {
		this.sheep_imgs = sheep_imgs;
		return this;
	}
	public String getSheep_kg() {
		return sheep_kg;
	}
	public SheepSourceBean setSheep_kg(String sheep_kg) {
		this.sheep_kg = sheep_kg;
		return this;
	}
	public String getSheep_room() {
		return sheep_room;
	}
	public SheepSourceBean setSheep_room(String sheep_room) {
		this.sheep_room = sheep_room;
		return this;
	}
	public String getBreed_day() {
		return breed_day;
	}
	public SheepSourceBean setBreed_day(String breed_day) {
		this.breed_day = breed_day;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public SheepSourceBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public SheepSourceBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public SheepSourceBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
