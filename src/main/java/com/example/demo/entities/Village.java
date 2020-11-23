package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.sun.istack.NotNull;

@Entity
public class Village implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private int id;
	
	@Column(length=150)
	@NotNull
	private String nom;
	@OneToMany(mappedBy = "village")
	private Collection<Client> clients;

	public Village() {
		super();
		// TODO Auto-generated constructor stub
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Village(int id, String nom, Collection<Client> clients) {
		super();
		this.id = id;
		this.nom = nom;
		this.clients = clients;
	}
	public Collection<Client> getClients() {
		return clients;
	}
	public void setClients(Collection<Client> clients) {
		this.clients = clients;
	}
	
}