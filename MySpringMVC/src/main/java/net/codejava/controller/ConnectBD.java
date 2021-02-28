package net.codejava.controller;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import com.mysql.jdbc.Statement;



public class ConnectBD {

	String url="jdbc:mysql://localhost:3306/BDProduit";
	String login="root";
	String password="";
	
	public Boolean deleteProduct(int id) throws SQLException {
		Boolean result;
		Connection con=  (Connection) DriverManager.getConnection(  url,login,password);  
		String strQuery = "DELETE FROM `produits` WHERE idProduit="+id+"";
		Statement stmt = (Statement) con.createStatement();
		int rowDeleted=stmt.executeUpdate(strQuery);
		System.out.println(strQuery.toString()+"\n");
		con.close();
		if(rowDeleted>0)result=true;
		else result=false;
		return result;
	}
	public Boolean InsertProduct(String prduit,String prix,String fourniseur) throws SQLException {
		Boolean result;
		Connection con=  (Connection) DriverManager.getConnection(  url,login,password);  
		String strQuery = "INSERT INTO `produits`( `Produit`, `Prix`, `Fournisseur`) VALUES ('"+prduit+"',"+prix+",'"+fourniseur+"')";
		Statement stmt = (Statement) con.createStatement();
		int rowinsert=stmt.executeUpdate(strQuery);
		System.out.println(strQuery.toString()+"\n");
		con.close();
		if(rowinsert>0)result=true;
		else result=false;
		return result;
	}
	public Boolean UpdateProduct(int id,String prduit,String prix,String fourniseur) throws SQLException {
		Boolean result;
		Connection con=  (Connection) DriverManager.getConnection(  url,login,password); 
		
		String strQuery = "UPDATE `produits` SET `Produit`='"+prduit+"',`Prix`="+prix+",`Fournisseur`='"+fourniseur+"' WHERE `idProduit`="+id;
		Statement stmt = (Statement) con.createStatement();
		int rowupdate=stmt.executeUpdate(strQuery);
		System.out.println(strQuery.toString());
		con.close();
		if(rowupdate>0)result=true;
		else result=false;
		return result;
	}
	public  User findUser(String User,String Password)throws SQLException {
		User user=null;;
		try{  
			ResultSet rs;
			Connection con=  (Connection) DriverManager.getConnection(  url,login,password);  
			String strQuery = "select user,password from users where user=? and password=?";
			PreparedStatement preparedStatement= (PreparedStatement) con.prepareStatement(strQuery);
			preparedStatement.setString(1,User);
			
			preparedStatement.setString(2,Password);
			 rs = preparedStatement.executeQuery();
			while(rs.next()) { 
			    user=new User(rs.getString(1),rs.getString(2));}
			con.close();  
			}catch(Exception e){ System.out.println(e);
			} 
		return user;
		}
	
	
	public  ArrayList<Produit>    findAllProduit()throws SQLException {
		ArrayList<Produit> listProduits=new ArrayList<Produit>()  ;
		try{
		ResultSet rs;
		Connection con=  (Connection) DriverManager.getConnection(  url,login,password);  
		String strQuery = "select * from produits";
		PreparedStatement preparedStatement= (PreparedStatement) con.prepareStatement(strQuery);
		rs = preparedStatement.executeQuery();
		while(rs.next()) { Produit produit=new Produit(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4));
		listProduits.add(produit);
		    }
		System.out.println(listProduits.size()+"it works"+listProduits.get(1).getProduit());
		con.close();  
		}catch(Exception e){ System.out.println(e);
		} 
		
		return listProduits;
	}
	

}
