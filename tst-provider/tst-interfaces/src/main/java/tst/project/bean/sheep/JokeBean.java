package tst.project.bean.sheep;

import java.io.Serializable;

public class JokeBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int joke_id;
	private String joke_title;
	private String joke_desc;
	private String joke_img;
	private String qr_code;
	private String time;
	private String is_delete;
	private String create_time;
	private String update_time;
	private String sort;
	private String is_use;
	private String is_use_show;
	
	public String getIs_use_show() {
		return is_use_show;
	}
	public JokeBean setIs_use_show(String is_use_show) {
		this.is_use_show = is_use_show;
		return this;
	}
	public int getJoke_id() {
		return joke_id;
	}
	public JokeBean setJoke_id(int joke_id) {
		this.joke_id = joke_id;return this;
	}
	public String getJoke_title() {
		return joke_title;
	}
	public JokeBean setJoke_title(String joke_title) {
		this.joke_title = joke_title;return this;
	}
	public String getJoke_desc() {
		return joke_desc;
	}
	public JokeBean setJoke_desc(String joke_desc) {
		this.joke_desc = joke_desc;return this;
	}
	public String getJoke_img() {
		return joke_img;
	}
	public JokeBean setJoke_img(String joke_img) {
		this.joke_img = joke_img;return this;
	}
	public String getQr_code() {
		return qr_code;
	}
	public JokeBean setQr_code(String qr_code) {
		this.qr_code = qr_code;return this;
	}
	public String getTime() {
		return time;
	}
	public JokeBean setTime(String time) {
		this.time = time;return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public JokeBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public JokeBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public JokeBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getSort() {
		return sort;
	}
	public JokeBean setSort(String sort) {
		this.sort = sort;
		return this;
	}
	public String getIs_use() {
		return is_use;
	}
	public JokeBean setIs_use(String is_use) {
		this.is_use = is_use;
		this.is_use_show="0".equals(is_use)?"未使用":	"使用中"	;
				return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
	
	

}
