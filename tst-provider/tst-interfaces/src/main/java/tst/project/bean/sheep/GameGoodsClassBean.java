package tst.project.bean.sheep;

import java.io.Serializable;
import java.util.List;

public class GameGoodsClassBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String class_id;
	private String class_name;
	private String class_desc;
	private String class_img;
	private String is_delete;
	private String create_time;
	private String update_time;
	
	private List<GameGoodsBean> gameGoodsBeans;

	public String getClass_id() {
		return class_id;
	}

	public GameGoodsClassBean setClass_id(String class_id) {
		this.class_id = class_id;
		return this;
	}

	public String getClass_name() {
		return class_name;
	}

	public GameGoodsClassBean setClass_name(String class_name) {
		this.class_name = class_name;
		return this;
	}

	public String getClass_desc() {
		return class_desc;
	}

	public GameGoodsClassBean setClass_desc(String class_desc) {
		this.class_desc = class_desc;
		return this;
	}

	public String getClass_img() {
		return class_img;
	}

	public GameGoodsClassBean setClass_img(String class_img) {
		this.class_img = class_img;
		return this;
	}

	public String getIs_delete() {
		return is_delete;
	}

	public GameGoodsClassBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}

	public String getCreate_time() {
		return create_time;
	}

	public GameGoodsClassBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}

	public String getUpdate_time() {
		return update_time;
	}

	public GameGoodsClassBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}

	public List<GameGoodsBean> getGameGoodsBeans() {
		return gameGoodsBeans;
	}

	public GameGoodsClassBean setGameGoodsBeans(List<GameGoodsBean> gameGoodsBeans) {
		this.gameGoodsBeans = gameGoodsBeans;
		return this;
	}
	
	

}
