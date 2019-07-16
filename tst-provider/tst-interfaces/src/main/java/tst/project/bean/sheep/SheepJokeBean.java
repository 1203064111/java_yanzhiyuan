package tst.project.bean.sheep;

import java.io.Serializable;

public class SheepJokeBean  implements Serializable{
	private static final long serialVersionUID=1L;
	private int joke_id;
	private String joke_type;
	private String joke_desc;
	private String is_delete;
	private String create_time;
	private String update_time;
	public int getJoke_id() {
		return joke_id;
	}
	public SheepJokeBean setJoke_id(int joke_id) {
		this.joke_id = joke_id;
		return this;
	}
	public String getJoke_type() {
		return joke_type;
	}
	public SheepJokeBean setJoke_type(String joke_type) {
		this.joke_type = joke_type;
		return this;
	}
	public String getJoke_desc() {
		return joke_desc;
	}
	public SheepJokeBean setJoke_desc(String joke_desc) {
		this.joke_desc = joke_desc;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public SheepJokeBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public SheepJokeBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public SheepJokeBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
