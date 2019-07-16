package tst.project.bean.sheep;

import java.io.Serializable;
import java.util.List;

public class VideoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int video_id;
	private String video_title;
	private String video_desc;
	private String video_img;
	private String video_html;
	private String video_type;//house，feed，cut，medicine
	private String is_delete;
	private String create_time;
	private String update_time;
	private String video_app_url;
	private String video_pc_url;
	private String video_type_show;
	private List<CameraBean> cameraBeans;
	
	
	
	public List<CameraBean> getCameraBeans() {
		return cameraBeans;
	}
	public VideoBean setCameraBeans(List<CameraBean> cameraBeans) {
		this.cameraBeans = cameraBeans;
		return this;
	}
	public String getVideo_type_show() {
		return video_type_show;
	}
	public VideoBean setVideo_type_show(String video_type_show) {
		this.video_type_show = video_type_show;
		return this;
	}
	
	public String getVideo_app_url() {
		return video_app_url;
	}
	public VideoBean setVideo_app_url(String video_app_url) {
		this.video_app_url = video_app_url;
		return this;
	}
	public String getVideo_pc_url() {
		return video_pc_url;
	}
	public VideoBean setVideo_pc_url(String video_pc_url) {
		this.video_pc_url = video_pc_url;
		return this;
	}
	public int getVideo_id() {
		return video_id;
	}
	public VideoBean setVideo_id(int video_id) {
		this.video_id = video_id;
		return this;
	}
	public String getVideo_title() {
		return video_title;
	}
	public VideoBean setVideo_title(String video_title) {
		this.video_title = video_title;
		return this;
	}
	public String getVideo_desc() {
		return video_desc;
	}
	public VideoBean setVideo_desc(String video_desc) {
		this.video_desc = video_desc;
		return this;
	}
	public String getVideo_img() {
		return video_img;
	}
	public VideoBean setVideo_img(String video_img) {
		this.video_img = video_img;
		return this;
	}
	public String getVideo_html() {
		return video_html;
	}
	public VideoBean setVideo_html(String video_html) {
		this.video_html = video_html;
		return this;
	}
	public String getVideo_type() {
		return video_type;
	}
	public VideoBean setVideo_type(String video_type) {
		this.video_type = video_type;
		this.video_type_show="house".equals(video_type)?"羊舍直播":
			                 "feed".equals(video_type)?"饲料直播":
			                 "cut".equals(video_type)?"分割直播":
			                 "medicine".equals(video_type)?"药浴直播":
			                 "其他";
			                	 
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public VideoBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public VideoBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public VideoBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
