package tst.project.bean.sheep;

import java.io.Serializable;

public class CameraBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int camera_id;
	private String  camera_no;
	private String camera_name;
	private String camera_app_url;
	private String camera_pc_url;
	private String is_delete;
	private String update_time;
	private String create_time;
	private String video_id;
	private String sheep_room;//羊栏
	
	
	
	
	public String getSheep_room() {
		return sheep_room;
	}
	public CameraBean setSheep_room(String sheep_room) {
		this.sheep_room = sheep_room;
		return this;
	}
	public String getVideo_id() {
		return video_id;
	}
	public CameraBean setVideo_id(String video_id) {
		this.video_id = video_id;
		return this;
	}
	public int getCamera_id() {
		return camera_id;
	}
	public CameraBean setCamera_id(int camera_id) {
		this.camera_id = camera_id;
		return this;
	}
	public String getCamera_no() {
		return camera_no;
	}
	public CameraBean setCamera_no(String camera_no) {
		this.camera_no = camera_no;
		return this;
	}
	public String getCamera_name() {
		return camera_name;
	}
	public CameraBean setCamera_name(String camera_name) {
		this.camera_name = camera_name;
		return this;
	}
	public String getCamera_app_url() {
		return camera_app_url;
	}
	public CameraBean setCamera_app_url(String camera_app_url) {
		this.camera_app_url = camera_app_url;
		return this;
	}
	public String getCamera_pc_url() {
		return camera_pc_url;
	}
	public CameraBean setCamera_pc_url(String camera_pc_url) {
		this.camera_pc_url = camera_pc_url;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public CameraBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public CameraBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public CameraBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
