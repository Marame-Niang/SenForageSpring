package com.example.demo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
 

@Entity
public class Roles implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7366631243524509322L;
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String nom;
	@ManyToMany(fetch=FetchType.LAZY, mappedBy = "roles")
	private List<User> users = new ArrayList<User>();
	
	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Roles(int id, String nom, List<User> users) {
		super();
		this.id = id;
		this.nom = nom;
		this.users = users;
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
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
}
