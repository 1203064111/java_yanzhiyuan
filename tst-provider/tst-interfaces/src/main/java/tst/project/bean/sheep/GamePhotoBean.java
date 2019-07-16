package tst.project.bean.sheep;

import java.io.Serializable;

public class GamePhotoBean implements Serializable {

	private static final long serialVersionUID=1l;
	private int photo_id;
	private String photo_type;
	private String photo_img;
	private String photo_desc;
	private String is_delete;
	private String create_time;
	private String update_time;
	private String member_id;
	
	
	
	public String getMember_id() {
		return member_id;
	}
	public GamePhotoBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public int getPhoto_id() {
		return photo_id;
	}
	public GamePhotoBean setPhoto_id(int photo_id) {
		this.photo_id = photo_id;
		return this;
	}
	public String getPhoto_type() {
		return photo_type;
	}
	public GamePhotoBean setPhoto_type(String photo_type) {
		this.photo_type = photo_type;
		return this;
	}
	public String getPhoto_img() {
		return photo_img;
	}
	public GamePhotoBean setPhoto_img(String photo_img) {
		this.photo_img = photo_img;
		return this;
	}
	public String getPhoto_desc() {
		return photo_desc;
	}
	public GamePhotoBean setPhoto_desc(String photo_desc) {
		this.photo_desc = photo_desc;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public GamePhotoBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public GamePhotoBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public GamePhotoBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
