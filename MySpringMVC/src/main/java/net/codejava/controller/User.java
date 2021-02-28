package net.codejava.controller;

public class User {

	String User;
	String Password;
	public User(String User,String Password) {
		this.User=User;
		this.Password=Password;
	}
	public String getUser() {
		return User;
	}
	public void setUser(String user) {
		User = user;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	

	

}

