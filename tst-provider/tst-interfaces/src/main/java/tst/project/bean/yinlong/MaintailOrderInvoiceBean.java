package tst.project.bean.yinlong;

import java.io.Serializable;

/**

**

*/

public class MaintailOrderInvoiceBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int order_invoice_id;//
	private String member_id;//
	private String order_id;//
	private String invoice_id;//
	private String invoice_type;//类型 1:个人 2:公司
	private String invoice_name;//抬头内容
	private String invoice_no;//税号
	private String invoice_company_name;//公司名称
	private String invoice_company_address;//企业地址
	private String invoice_company_phone;//企业电话
	private String invoice_bank_name;//开户银行
	private String invoice_bank_no;//银行账号
	private String invoice_email;//
	private String is_default;//是否默认
	private String is_delete;//
	private String create_time;//
	private String update_time;//
	private String order_price;//订单价格
	private String order_no;//订单号
	public int getOrder_invoice_id(){
		return order_invoice_id;
	}
	public MaintailOrderInvoiceBean setOrder_invoice_id(int order_invoice_id){
		this.order_invoice_id= order_invoice_id;
		return this;
	}
	
	public String getMember_id() {
		return member_id;
	}
	public MaintailOrderInvoiceBean setMember_id(String member_id) {
		this.member_id = member_id;
		return this;
	}
	public String getOrder_id(){
		return order_id;
	}
	public MaintailOrderInvoiceBean setOrder_id(String order_id){
		this.order_id= order_id;
		return this;
	}
	public String getInvoice_id(){
		return invoice_id;
	}
	public MaintailOrderInvoiceBean setInvoice_id(String invoice_id){
		this.invoice_id= invoice_id;
		return this;
	}
	public String getInvoice_type(){
		return invoice_type;
	}
	public MaintailOrderInvoiceBean setInvoice_type(String invoice_type){
		this.invoice_type= invoice_type;
		return this;
	}
	public String getInvoice_name(){
		return invoice_name;
	}
	public MaintailOrderInvoiceBean setInvoice_name(String invoice_name){
		this.invoice_name= invoice_name;
		return this;
	}
	public String getInvoice_no(){
		return invoice_no;
	}
	public MaintailOrderInvoiceBean setInvoice_no(String invoice_no){
		this.invoice_no= invoice_no;
		return this;
	}
	public String getInvoice_company_name(){
		return invoice_company_name;
	}
	public MaintailOrderInvoiceBean setInvoice_company_name(String invoice_company_name){
		this.invoice_company_name= invoice_company_name;
		return this;
	}
	public String getInvoice_company_address(){
		return invoice_company_address;
	}
	public MaintailOrderInvoiceBean setInvoice_company_address(String invoice_company_address){
		this.invoice_company_address= invoice_company_address;
		return this;
	}
	public String getInvoice_company_phone(){
		return invoice_company_phone;
	}
	public MaintailOrderInvoiceBean setInvoice_company_phone(String invoice_company_phone){
		this.invoice_company_phone= invoice_company_phone;
		return this;
	}
	public String getInvoice_bank_name(){
		return invoice_bank_name;
	}
	public MaintailOrderInvoiceBean setInvoice_bank_name(String invoice_bank_name){
		this.invoice_bank_name= invoice_bank_name;
		return this;
	}
	public String getInvoice_bank_no(){
		return invoice_bank_no;
	}
	public MaintailOrderInvoiceBean setInvoice_bank_no(String invoice_bank_no){
		this.invoice_bank_no= invoice_bank_no;
		return this;
	}
	public String getInvoice_email(){
		return invoice_email;
	}
	public MaintailOrderInvoiceBean setInvoice_email(String invoice_email){
		this.invoice_email= invoice_email;
		return this;
	}
	public String getIs_default(){
		return is_default;
	}
	public MaintailOrderInvoiceBean setIs_default(String is_default){
		this.is_default= is_default;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public MaintailOrderInvoiceBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public MaintailOrderInvoiceBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public MaintailOrderInvoiceBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
	public String getOrder_price() {
		return order_price;
	}
	public MaintailOrderInvoiceBean setOrder_price(String order_price) {
		this.order_price = order_price;
		return this;
	}
	public String getOrder_no() {
		return order_no;
	}
	public MaintailOrderInvoiceBean setOrder_no(String order_no) {
		this.order_no = order_no;
		return this;
	}
	
}
