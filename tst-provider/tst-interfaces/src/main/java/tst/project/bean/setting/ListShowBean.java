package tst.project.bean.setting;

import java.io.Serializable;

/**

**

*/

public class ListShowBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;//
	private String name;//
	private String flex;//
	private String list_key;//
	private String sort;//
	private String is_delete;//
	private String type;//
	private String list_type;//
	private String list_keys;//
	private String state;//
	public int getId(){
		return id;
	}
	public ListShowBean setId(int id){
		this.id= id;
		return this;
	}
	public String getName(){
		return name;
	}
	public ListShowBean setName(String name){
		this.name= name;
		return this;
	}
	public String getFlex(){
		return flex;
	}
	public ListShowBean setFlex(String flex){
		this.flex= flex;
		return this;
	}
	public String getList_key(){
		return list_key;
	}
	public ListShowBean setList_key(String list_key){
		this.list_key= list_key;
		return this;
	}
	public String getSort(){
		return sort;
	}
	public ListShowBean setSort(String sort){
		this.sort= sort;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public ListShowBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getType(){
		return type;
	}
	public ListShowBean setType(String type){
		this.type= type;
		return this;
	}
	public String getList_type(){
		return list_type;
	}
	public ListShowBean setList_type(String list_type){
		this.list_type= list_type;
		return this;
	}
	public String getList_keys(){
		return list_keys;
	}
	public ListShowBean setList_keys(String list_keys){
		this.list_keys= list_keys;
		return this;
	}
	public String getState(){
		return state;
	}
	public ListShowBean setState(String state){
		this.state= state;
		return this;
	}
}
