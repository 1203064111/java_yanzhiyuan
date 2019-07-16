package tst.project.bean.member;

import java.io.Serializable;

public class MemberReportBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int report_id;
	private String information_id;//资讯id
	private String member_id;//用户
	private String update_time;
	private String create_time;
	private String report_desc;//举报内容
	private String is_delete;



	public String getInformation_id() {
			return information_id;
    }
	public MemberReportBean setInformation_id(String information_id) {
			this.information_id = information_id;
	        return this;
    }

	public String getMember_id() {
			return member_id;
    }
	public MemberReportBean setMember_id(String member_id) {
			this.member_id = member_id;
	        return this;
    }

	public String getUpdate_time() {
			return update_time;
    }
	public MemberReportBean setUpdate_time(String update_time) {
			this.update_time = update_time;
	        return this;
    }

	public String getCreate_time() {
			return create_time;
    }
	public MemberReportBean setCreate_time(String create_time) {
			this.create_time = create_time;
	        return this;
    }

	public int getReport_id() {
			return report_id;
    }
	public MemberReportBean setReport_id(int report_id) {
			this.report_id = report_id;
	        return this;
    }

	public String getReport_desc() {
			return report_desc;
    }
	public MemberReportBean setReport_desc(String report_desc) {
			this.report_desc = report_desc;
	        return this;
    }

	public String getIs_delete() {
			return is_delete;
    }
	public MemberReportBean setIs_delete(String is_delete) {
			this.is_delete = is_delete;
	        return this;
    }

		

}
