package tst.project.bean.loushanglou;

import java.io.Serializable;

/**

**

*/

public class AppointmentBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int appointment_id;//
	private String member_id;//用户id
	private String appointment_name;//姓名
	private String appointment_sex;//m:男 w:女
	private String appointment_mobile;//手机号
	private String appointment_remark;//备注
	private String appointment_time;//预约时间
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	public int getAppointment_id(){
		return appointment_id;
	}
	public AppointmentBean setAppointment_id(int appointment_id){
		this.appointment_id= appointment_id;
		return this;
	}
	public String getMember_id(){
		return member_id;
	}
	public AppointmentBean setMember_id(String member_id){
		this.member_id= member_id;
		return this;
	}
	public String getAppointment_name(){
		return appointment_name;
	}
	public AppointmentBean setAppointment_name(String appointment_name){
		this.appointment_name= appointment_name;
		return this;
	}
	public String getAppointment_sex(){
		return appointment_sex;
	}
	public AppointmentBean setAppointment_sex(String appointment_sex){
		this.appointment_sex= appointment_sex;
		return this;
	}
	public String getAppointment_mobile(){
		return appointment_mobile;
	}
	public AppointmentBean setAppointment_mobile(String appointment_mobile){
		this.appointment_mobile= appointment_mobile;
		return this;
	}
	public String getAppointment_remark(){
		return appointment_remark;
	}
	public AppointmentBean setAppointment_remark(String appointment_remark){
		this.appointment_remark= appointment_remark;
		return this;
	}
	public String getAppointment_time(){
		return appointment_time;
	}
	public AppointmentBean setAppointment_time(String appointment_time){
		this.appointment_time= appointment_time;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public AppointmentBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public AppointmentBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public AppointmentBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
