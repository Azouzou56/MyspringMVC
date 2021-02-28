package net.codejava.controller;

public class Produit {
	private int id;
	private String produit;
	private double prix;
	private String Fournisseur;
	
	public Produit(int id,String produit,double prix,String Fournisseur) {
		this.id=id;
		this.produit=produit;
		this.prix=prix;
		this.Fournisseur=Fournisseur;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}



	public String getProduit() {
		return produit;
	}



	public void setProduit(String produit) {
		this.produit = produit;
	}



	public double getPrix() {
		return prix;
	}



	public void setPrix(double prix) {
		this.prix = prix;
	}



	public String getFournisseur() {
		return Fournisseur;
	}



	public void setFournisseur(String fournisseur) {
		Fournisseur = fournisseur;
	}
	
	
	

}
