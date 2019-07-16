package tst.project.bean.sheep;

import java.io.Serializable;

import tst.project.bean.setting.HtmlBean;
import tst.project.bean.setting.PercentBean;

public class SheepHtmlBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String html_type;//获取协议的类型
	private HtmlBean htmlBean;
	private PercentBean percentBean;
	private String html_desc;
	private int html_id;
	
	
	public String getHtml_desc() {
		return html_desc;
	}
	public SheepHtmlBean setHtml_desc(String html_desc) {
		this.html_desc = html_desc;
		return this;
	}
	public int getHtml_id() {
		return html_id;
	}
	public SheepHtmlBean setHtml_id(int html_id) {
		this.html_id = html_id;
		return this;
	}
	public String getHtml_type() {
		return html_type;
	}
	public SheepHtmlBean setHtml_type(String html_type) {
		this.html_type = html_type;
		return this;
	}
	public HtmlBean getHtmlBean() {
		return htmlBean;
	}
	public SheepHtmlBean setHtmlBean(HtmlBean htmlBean) {
		this.htmlBean = htmlBean;
		return this;
	}
	public PercentBean getPercentBean() {
		return percentBean;
	}
	public SheepHtmlBean setPercentBean(PercentBean percentBean) {
		this.percentBean = percentBean;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
