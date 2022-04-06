package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

// Realizando Mapeamento Objeto Relacional com Hibernat

@Entity
public class Users {
	
	@Id
	private Integer id;

	private String username;
	private String firtsName;
	private String lastName;
	private String email;
	private String phone;
	private String signature;
	private String lang;
	private String localZoneid;
	
	public Users() {
		
	}

	public Users(Integer id, String username, String firtsName, String lastName, String email, String phone,
			String signature, String lang, String localZoneid) {
		super();
		this.id = id;
		this.username = username;
		this.firtsName = firtsName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.signature = signature;
		this.lang = lang;
		this.localZoneid = localZoneid;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirtsName() {
		return firtsName;
	}
	public void setFirtsName(String firtsName) {
		this.firtsName = firtsName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public String getLocalZoneid() {
		return localZoneid;
	}
	public void setLocalZoneid(String localZoneid) {
		this.localZoneid = localZoneid;
	}
	
	public String toString() {
		return "username: " + username
				+  "\nfirstName: " + firtsName;
	}
}