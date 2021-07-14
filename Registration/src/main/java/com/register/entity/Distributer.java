package com.register.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "distributer")
public class Distributer {

	@Id
    @Column(name="did")
    private String did;
	@Column(name = "user_name")
    private String userName;  //email ID
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "user_password")
    private String userPassword; //password of users
    @Column(name = "phone")
    private String phone;
    @Column(name = "adhar")
    private String adhar;
    @Column(name = "city")
    private String city;
	public Distributer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Distributer(String did, String userName, String name, String address, String userPassword, String phone,
			String adhar, String city) {
		super();
		this.did = did;
		this.userName = userName;
		this.name = name;
		this.address = address;
		this.userPassword = userPassword;
		this.phone = phone;
		this.adhar = adhar;
		this.city = city;
	}
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAdhar() {
		return adhar;
	}
	public void setAdhar(String adhar) {
		this.adhar = adhar;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Distributer [did=" + did + ", userName=" + userName + ", name=" + name + ", address=" + address
				+ ", userPassword=" + userPassword + ", phone=" + phone + ", adhar=" + adhar + ", city=" + city + "]";
	}
    
    
}
