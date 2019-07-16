package tst.project.bean.setting;

import java.io.Serializable;

public class MsgTypeBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private  String type_id;
	private String msg_type;
	private String msg_name;
	private String msg_desc;
	private String msg_state;
	private String is_delete;
	private String update_time;
	private String create_time;
	public String getType_id() {
		return type_id;
	}
	public MsgTypeBean setType_id(String type_id) {
		this.type_id = type_id;
		return this;
	}
	public String getMsg_type() {
		return msg_type;
	}
	public MsgTypeBean setMsg_type(String msg_type) {
		this.msg_type = msg_type;
		return this;
	}
	public String getMsg_name() {
		return msg_name;
	}
	public MsgTypeBean setMsg_name(String msg_name) {
		this.msg_name = msg_name;
		return this;
	}
	public String getMsg_desc() {
		return msg_desc;
	}
	public MsgTypeBean setMsg_desc(String msg_desc) {
		this.msg_desc = msg_desc;
		return this;
	}
	public String getMsg_state() {
		return msg_state;
	}
	public MsgTypeBean setMsg_state(String msg_state) {
		this.msg_state = msg_state;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public MsgTypeBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public MsgTypeBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public MsgTypeBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
