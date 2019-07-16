package tst.project.bean.sheep;

import java.io.Serializable;

public class SheepImportBean implements Serializable {

	private static final long serialVersionUID = 1L; 
	private String import_id;
	private String ear_id;
	private String ear_sign;
	private String sheep_kg;
	private String sheep_room;
	private String bitch_sheep_id;
	private String sheep_type;
	private String qr_code;
	
	
	
	public String getQr_code() {
		return qr_code;
	}
	public SheepImportBean setQr_code(String qr_code) {
		this.qr_code = qr_code;
		return this;
	}
	public String getImport_id() {
		return import_id;
	}
	public SheepImportBean setImport_id(String import_id) {
		this.import_id = import_id;
		return this;
	}
	public String getEar_id() {
		return ear_id;
	}
	public SheepImportBean setEar_id(String ear_id) {
		this.ear_id = ear_id;
		return this;
	}
	public String getEar_sign() {
		return ear_sign;
	}
	public SheepImportBean setEar_sign(String ear_sign) {
		this.ear_sign = ear_sign;
		return this;
	}
	public String getSheep_kg() {
		return sheep_kg;
	}
	public SheepImportBean setSheep_kg(String sheep_kg) {
		this.sheep_kg = sheep_kg;
		return this;
	}
	public String getSheep_room() {
		return sheep_room;
	}
	public SheepImportBean setSheep_room(String sheep_room) {
		this.sheep_room = sheep_room;
		return this;
	}
	public String getBitch_sheep_id() {
		return bitch_sheep_id;
	}
	public SheepImportBean setBitch_sheep_id(String bitch_sheep_id) {
		this.bitch_sheep_id = bitch_sheep_id;
		return this;
	}
	public String getSheep_type() {
		return sheep_type;
	}
	public SheepImportBean setSheep_type(String sheep_type) {
		this.sheep_type = sheep_type;
		return this;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
