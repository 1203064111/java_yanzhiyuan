package tst.project.bean.clue;

import java.io.Serializable;

/**

**

*/

public class ClueMaterialBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int material_id;//
	private String clue_id;//
	private String material_img;//资料封面路径
	private String material_url;//资源链接
	private String material_type;//1:图片 2:语音 3:视频
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getMaterial_id(){
		return material_id;
	}
	public ClueMaterialBean setMaterial_id(int material_id){
		this.material_id= material_id;
		return this;
	}
	public String getClue_id(){
		return clue_id;
	}
	public ClueMaterialBean setClue_id(String clue_id){
		this.clue_id= clue_id;
		return this;
	}
	public String getMaterial_img(){
		return material_img;
	}
	public ClueMaterialBean setMaterial_img(String material_img){
		this.material_img= material_img;
		return this;
	}
	public String getMaterial_url(){
		return material_url;
	}
	public ClueMaterialBean setMaterial_url(String material_url){
		this.material_url= material_url;
		return this;
	}
	public String getMaterial_type(){
		return material_type;
	}
	public ClueMaterialBean setMaterial_type(String material_type){
		this.material_type= material_type;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public ClueMaterialBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public ClueMaterialBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public ClueMaterialBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
