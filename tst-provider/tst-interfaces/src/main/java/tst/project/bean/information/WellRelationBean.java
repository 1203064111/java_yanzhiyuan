package tst.project.bean.information;

import java.io.Serializable;

public class WellRelationBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int relation_id;//点赞关系表id
	private String member_id;//用户id
	private String information_id;//资讯id
	private String is_delete;//
	private String create_time;
	private String update_time;
	public int getRelation_id() {
		return relation_id;
	}
	public WellRelationBean setRelation_id(int relation_id) {
		this.relation_id = relation_id;
		return this;
	}
	public String getMember_id() {
		return member_id;
	}
	public WellRelationBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getInformation_id() {
		return information_id;
	}
	public WellRelationBean setInformation_id(String information_id) {
		this.information_id = information_id;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public WellRelationBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public WellRelationBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public WellRelationBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	
	
	

}
