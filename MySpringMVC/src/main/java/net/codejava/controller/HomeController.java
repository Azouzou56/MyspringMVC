package net.codejava.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;









@Controller
@RequestMapping(value="/")
public class HomeController {
	@RequestMapping(method=RequestMethod.GET)
	public String home1(HttpServletResponse response,Model model) throws IOException{
		model.addAttribute("Erreur","ggg");
		return "index";
	}
	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	 public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
			  @ModelAttribute("login") User user) {
		ModelAndView mav = null;

		ConnectBD bd=new ConnectBD();
		 
        String username = request.getParameter("uname");
        String password = request.getParameter("psw");
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        
		
			User user1 = null;
			try {
				user1 = bd.findUser(username,password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    if (null != user1) {
	    mav = new ModelAndView("produit");
	    ArrayList<Produit> listProduits = null;
	    try {
			listProduits=bd.findAllProduit() ;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    mav.addObject("lol",listProduits);
	    } else {
	    mav = new ModelAndView("index");
	    mav.addObject("Erreur", "Username or Password is wrong!!");
	    }

	    return mav;
	  
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String test(@PathVariable String name,@PathVariable String psw,Model model,HttpServletResponse response) throws IOException{
		ConnectBD bd=new ConnectBD();
		User user = null;
		try {
			user = bd.findUser(name,psw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(user!=null)
		

			return "produit";
			
			
		 
		else {
			
			model.addAttribute("Erreur","no");
    	}
		
		return "index";
	}
	@RequestMapping(value="/home")
	public String home(HttpServletResponse response) throws IOException{
		return "home";
	}
	@RequestMapping(value="/produit")
	public String produit(HttpServletResponse response) throws IOException{
		return "produit";
	}
}
