package tst.project.bean.clue;

import java.io.Serializable;
import java.util.List;

/**

**

*/

public class ClueBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int clue_id;//
	private String industry_id;//行业id
	private String industry_name;//行业名称
	private String clue_name;//线索名称
	private String clue_desc;//线索描述
	private String clue_price;//线索价格
	private String clue_num;//线索可供几个人购买
	private String clue_buy_num;//线索已经购买数
	private String clue_mobile;
	private String is_delete;//0:未删除 1:删除
	private String create_time;//
	private String update_time;//
	private List<ClueMaterialBean> clueImgMaterialBeans;
	private List<ClueMaterialBean> clueVoiceMaterialBeans;
	private List<ClueMaterialBean> clueVideoMaterialBeans;
	
	
	
	public String getClue_mobile() {
		return clue_mobile;
	}
	public ClueBean setClue_mobile(String clue_mobile) {
		this.clue_mobile = clue_mobile;
		return this;
	}
	public List<ClueMaterialBean> getClueImgMaterialBeans() {
		return clueImgMaterialBeans;
	}
	public ClueBean setClueImgMaterialBeans(List<ClueMaterialBean> clueImgMaterialBeans) {
		this.clueImgMaterialBeans = clueImgMaterialBeans;
		return this;
	}
	public List<ClueMaterialBean> getClueVoiceMaterialBeans() {
		return clueVoiceMaterialBeans;
	}
	public ClueBean setClueVoiceMaterialBeans(List<ClueMaterialBean> clueVoiceMaterialBeans) {
		this.clueVoiceMaterialBeans = clueVoiceMaterialBeans;
		return this;
	}
	public List<ClueMaterialBean> getClueVideoMaterialBeans() {
		return clueVideoMaterialBeans;
	}
	public ClueBean setClueVideoMaterialBeans(List<ClueMaterialBean> clueVideoMaterialBeans) {
		this.clueVideoMaterialBeans = clueVideoMaterialBeans;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getClue_id(){
		return clue_id;
	}
	public ClueBean setClue_id(int clue_id){
		this.clue_id= clue_id;
		return this;
	}
	public String getIndustry_id(){
		return industry_id;
	}
	public ClueBean setIndustry_id(String industry_id){
		this.industry_id= industry_id;
		return this;
	}
	
	
	public String getIndustry_name() {
		return industry_name;
	}
	public ClueBean setIndustry_name(String industry_name) {
		this.industry_name = industry_name;
		return this;
	}
	public String getClue_name(){
		return clue_name;
	}
	public ClueBean setClue_name(String clue_name){
		this.clue_name= clue_name;
		return this;
	}
	public String getClue_desc(){
		return clue_desc;
	}
	public ClueBean setClue_desc(String clue_desc){
		this.clue_desc= clue_desc;
		return this;
	}
	public String getClue_price(){
		return clue_price;
	}
	public ClueBean setClue_price(String clue_price){
		this.clue_price= clue_price;
		return this;
	}
	public String getClue_num(){
		return clue_num;
	}
	public ClueBean setClue_num(String clue_num){
		this.clue_num= clue_num;
		return this;
	}
	public String getClue_buy_num(){
		return clue_buy_num;
	}
	public ClueBean setClue_buy_num(String clue_buy_num){
		this.clue_buy_num= clue_buy_num;
		return this;
	}
	public String getIs_delete(){
		return is_delete;
	}
	public ClueBean setIs_delete(String is_delete){
		this.is_delete= is_delete;
		return this;
	}
	public String getCreate_time(){
		return create_time;
	}
	public ClueBean setCreate_time(String create_time){
		this.create_time= create_time;
		return this;
	}
	public String getUpdate_time(){
		return update_time;
	}
	public ClueBean setUpdate_time(String update_time){
		this.update_time= update_time;
		return this;
	}
}
