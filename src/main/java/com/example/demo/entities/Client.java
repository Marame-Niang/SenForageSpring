package com.example.demo.entities;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity 
public class Client implements  Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length=50)
	private String nom;
	@Column(length=150)
	private String adresse;
	@Column(length=14)
	private String telephone;
	@ManyToOne
	@JoinColumn(name="village_id", nullable=false)
	private Village village = new Village();
//	@ManyToOne
//	@JoinColumn(name="user_id", nullable=false)
//	private User user = new User();
	
	
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(int id, String nom, String adresse, String telephone, Village village) {
	super();
	this.id = id;
	this.nom = nom;
	this.adresse = adresse;
	this.telephone = telephone;
	this.village = village;
}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Village getVillage() {
		return village;
	}
	public void setVillage(Village village) {
		this.village = village;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
