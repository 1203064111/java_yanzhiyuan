package tst.project.bean.yinlong;

import java.io.Serializable;

/**

**

*/

public class MaintailServiceTimeBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int service_id;//
	private String service_start_time;//服务开始时间
	private String service_end_time;//服务结束时间
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getService_id(){
		return service_id;
	}
	public MaintailServiceTimeBean setService_id(int service_id){
		this.service_id= service_id;
		return this;
	}
	public String getService_start_time(){
		return service_start_time;
	}
	public MaintailServiceTimeBean setService_start_time(String service_start_time){
		this.service_start_time= service_start_time;
		return this;
	}
	public String getService_end_time(){
		return service_end_time;
	}
	public MaintailServiceTimeBean setService_end_time(String service_end_time){
		this.service_end_time= service_end_time;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public MaintailServiceTimeBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public MaintailServiceTimeBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public MaintailServiceTimeBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
