package tst.project.bean.yinlong;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**

**

*/

public class MaintailOrderBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int order_id;//
	private String member_id;//下单人id
	private String worker_id;//师傅id
	private String order_no;//订单号
	private String order_state;//0:已取消 1:待指派  2:待上门  3:等待确认服务  4:待付款  5:已付款 
	private String order_state_show;
	private String accept_state;//后台指派出去 师傅接受状态  默认是接受  师傅可以拒绝  1:接受 2:拒绝
	private String accept_state_show;
	private String assessment_state;//评价状态 1:未评价 2:已评价
	private String assessment_state_show;//
	private String order_price;//订单价格  师傅添加完材料计算得到
	private String maintail_remark;//维修问题描述
	private String maintail_imgs;//维修图片路径 多张用逗号隔开
	private String parts_ids;//维修部位id 多个逗号隔开
	private String parts_names;//维修部位名称 多个逗号隔开
	private String service_start_time;//服务开始时间
	private String service_end_time;//服务结束时间
	private String is_guarantee;//是否报修 0:不保 1:保修
	private String is_guarantee_show;//
	private String invoice_state;//1:未申请 2:已申请 3:已寄出 4:拒绝
	private String is_delete;//
	private String create_time;
	private String update_time;
	private String cancel_time;//取消订单时间
	private String pay_time;
	private String out_trade_no;
	private String order_num;//订单数量
	private Map<String,Object> workerBean;//师傅详情
	private MaintailOrderAddressBean maintailOrderAddressBean;//维修地址
	private MemberWorkerBean memberWorkerBean; //维修师傅
	private List<MaintailOrderMaterialBean> maintailOrderMaterialBeans;//材料列表
	private String address_name;  //收货人姓名
	private String address_mobile; //收货人电话
	private String address_detailed; //收货详情地址
	public String getAddress_name() {
		return address_name;
	}
	public MaintailOrderBean setAddress_name(String address_name) {
		this.address_name = address_name;
		return this;
	}
	public String getAddress_mobile() {
		return address_mobile;
	}
	public MaintailOrderBean setAddress_mobile(String address_mobile) {
		this.address_mobile = address_mobile;
		return this;
	}
	public String getAddress_detailed() {
		return address_detailed;
	}
	public MaintailOrderBean setAddress_detailed(String address_detailed) {
		this.address_detailed = address_detailed;
		return this;
	}
	public String getOrder_num() {
		return order_num;
	}
	public MaintailOrderBean setOrder_num(String order_num) {
		this.order_num = order_num;
		return this;
	}
	public int getOrder_id(){
		return order_id;
	}
	public MaintailOrderBean setOrder_id(int order_id){
		this.order_id= order_id;
		return this;
	}
	public String getMember_id(){
		return member_id;
	}
	public MaintailOrderBean setMember_id(String member_id){
		this.member_id= member_id;
		return this;
	}
	public String getWorker_id(){
		return worker_id;
	}
	public MaintailOrderBean setWorker_id(String worker_id){
		this.worker_id= worker_id;
		return this;
	}
	public String getOrder_no(){
		return order_no;
	}
	public MaintailOrderBean setOrder_no(String order_no){
		this.order_no= order_no;
		return this;
	}
	public String getOrder_state(){
		return order_state;
	}
	public MaintailOrderBean setOrder_state(String order_state){
		this.order_state= order_state;
		this.order_state_show="0".equals(order_state)?"已取消":
							  "1".equals(order_state)?"待指派":
							  "2".equals(order_state)?"待上门":
							  "3".equals(order_state)?"等待确认服务":
							  "4".equals(order_state)?"待付款":
							  "5".equals(order_state)?"已完成":"未知状态";
		return this;
	}
	public String getAccept_state_show() {
		return accept_state_show;
	}
	public MaintailOrderBean setAccept_state_show(String accept_state_show) {
		this.accept_state_show = accept_state_show;
		return this;
	}
	public String getOrder_state_show() {
		return order_state_show;
	}
	public MaintailOrderBean setOrder_state_show(String order_state_show) {
		this.order_state_show = order_state_show;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getAccept_state(){
		return accept_state;
	}
	public MaintailOrderBean setAccept_state(String accept_state){
		this.accept_state= accept_state;
		this.accept_state_show="0".equals(accept_state)?"未指派":
							   "1".equals(accept_state)?"已接受":
			  				   "2".equals(accept_state)?"已拒绝":"未知状态";
		return this;
	}
	
	public String getAssessment_state() {
		return assessment_state;
	}
	public MaintailOrderBean setAssessment_state(String assessment_state) {
		this.assessment_state = assessment_state;
		this.assessment_state_show="1".equals(assessment_state)?"未评价":
								   "2".equals(assessment_state)?"已评价":"未知状态";
		return this;
	}
	
	public String getAssessment_state_show() {
		return assessment_state_show;
	}
	public MaintailOrderBean setAssessment_state_show(String assessment_state_show) {
		this.assessment_state_show = assessment_state_show;
		return this;
	}
	public String getOrder_price(){
		return order_price;
	}
	public MaintailOrderBean setOrder_price(String order_price){
		this.order_price= order_price;
		return this;
	}
	public String getMaintail_remark(){
		return maintail_remark;
	}
	public MaintailOrderBean setMaintail_remark(String maintail_remark){
		this.maintail_remark= maintail_remark;
		return this;
	}
	public String getMaintail_imgs(){
		return maintail_imgs;
	}
	public MaintailOrderBean setMaintail_imgs(String maintail_imgs){
		this.maintail_imgs= maintail_imgs;
		return this;
	}
	public String getParts_ids(){
		return parts_ids;
	}
	public MaintailOrderBean setParts_ids(String parts_ids){
		this.parts_ids= parts_ids;
		return this;
	}
	public String getParts_names(){
		return parts_names;
	}
	public MaintailOrderBean setParts_names(String parts_names){
		this.parts_names= parts_names;
		return this;
	}
	public String getService_start_time(){
		return service_start_time;
	}
	public MaintailOrderBean setService_start_time(String service_start_time){
		this.service_start_time= service_start_time;
		return this;
	}
	public String getService_end_time(){
		return service_end_time;
	}
	public MaintailOrderBean setService_end_time(String service_end_time){
		this.service_end_time= service_end_time;
		return this;
	}
	
	public String getIs_guarantee() {
		return is_guarantee;
	}
	public MaintailOrderBean setIs_guarantee(String is_guarantee) {
		this.is_guarantee = is_guarantee;
		this.is_guarantee_show="1".equals(is_guarantee)?"不保修":
								"2".equals(is_guarantee)?"保修":"未知状态";
		return this;
	}
	
	public String getIs_guarantee_show() {
		return is_guarantee_show;
	}
	public MaintailOrderBean setIs_guarantee_show(String is_guarantee_show) {
		this.is_guarantee_show = is_guarantee_show;
		return this;
	}
	public String getInvoice_state() {
		return invoice_state;
	}
	public MaintailOrderBean setInvoice_state(String invoice_state) {
		this.invoice_state = invoice_state;
		return this;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public MaintailOrderBean setIs_delete(String is_delete) {
		this.is_delete = is_delete;
		return this;
	}
	public String getCreate_time() {
		return create_time;
	}
	public MaintailOrderBean setCreate_time(String create_time) {
		this.create_time = create_time;
		return this;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public MaintailOrderBean setUpdate_time(String update_time) {
		this.update_time = update_time;
		return this;
	}
	
	public String getCancel_time() {
		return cancel_time;
	}
	public MaintailOrderBean setCancel_time(String cancel_time) {
		this.cancel_time = cancel_time;
		return this;
	}
	
	public String getPay_time() {
		return pay_time;
	}
	public MaintailOrderBean setPay_time(String pay_time) {
		this.pay_time = pay_time;
		return this;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public MaintailOrderBean setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
		return this;
	}
	public Map<String, Object> getWorkerBean() {
		return workerBean;
	}
	public MaintailOrderBean setWorkerBean(Map<String, Object> workerBean) {
		this.workerBean = workerBean;
		return this;
	}
	public MaintailOrderAddressBean getMaintailOrderAddressBean() {
		return maintailOrderAddressBean;
	}
	public MaintailOrderBean setMaintailOrderAddressBean(MaintailOrderAddressBean maintailOrderAddressBean) {
		this.maintailOrderAddressBean = maintailOrderAddressBean;
		return this;
	}
	public MemberWorkerBean getMemberWorkerBean() {
		return memberWorkerBean;
	}
	public MaintailOrderBean setMemberWorkerBean(MemberWorkerBean memberWorkerBean) {
		this.memberWorkerBean = memberWorkerBean;
		return this;
	}
	public List<MaintailOrderMaterialBean> getMaintailOrderMaterialBeans() {
		return maintailOrderMaterialBeans;
	}
	public MaintailOrderBean setMaintailOrderMaterialBeans(List<MaintailOrderMaterialBean> maintailOrderMaterialBeans) {
		this.maintailOrderMaterialBeans = maintailOrderMaterialBeans;
		return this;
	}
}
