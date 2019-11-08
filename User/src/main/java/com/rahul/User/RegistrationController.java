package com.rahul.User;

import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.JSONException;
import org.json.simple.*;
import java.util.*;
import org.json.simple.*;

import javax.servlet.http.HttpServletRequest;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class RegistrationController {
	
	@Autowired
	RegisterDAO rgDAO;
	
	@Autowired
	UserValidator validator;
	
	  private static List<UserModel> users = new ArrayList<UserModel>();
	  
	  @RequestMapping(value = "/register", method = RequestMethod.GET)
	  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
		  
	    ModelAndView mav = new ModelAndView("register");
	    UserModel um=new UserModel();
	    um.setFirstname("sreedhar Kosaraju");
	    mav.addObject("user", um);
	    return mav;
	  }
	
	  @RequestMapping(value="/registerProcess", method=RequestMethod.POST)
	  public ModelAndView addUser(@ModelAttribute("user") UserModel user, BindingResult result, SessionStatus sstatus) {
		  
		   //Validation code
		    validator.validate(user, result);
		     
		    //Check validation errors
		    if (result.hasErrors()) {
		        return new ModelAndView("register");
		    }
		    
		   //Mark Session Complete
	        sstatus.setComplete();
		  
		  //invoke DAO class
		  int status=rgDAO.registerUser(user);

		  return new ModelAndView("regsuccess", "firstname", user.getFirstname());
	  }
	  
	  @RequestMapping(value = "/multiusers", method = RequestMethod.GET)
	  public ModelAndView showAllUsers(HttpServletRequest request, HttpServletResponse response) {
		  
	    ModelAndView mav = new ModelAndView("multiusers");
	    
	    
		List<UserModel> ulist= rgDAO.getAllUsers();
		
		UsersForm uf=new UsersForm();
		
		uf.setUsersList(ulist);
		
		uf.setThree("hello");
		
		mav.addObject("usersForm", uf);
	    return mav;
	  }
  
	  @RequestMapping(value = "/addUsers", method = RequestMethod.POST)
      public ModelAndView addUsers(@ModelAttribute("usersForm") UsersForm uf) {	
			String me = uf.getOne();
			String me2 = uf.getTwo();
			List<UserModel> ulist = rgDAO.names();	
			 ModelAndView mav = new ModelAndView("multiusers");
			 uf.setNamesList(ulist);
			 uf.setOne(me);
			 //List<UserModel> list=new ArrayList<String>(); 
			// list.add("Ravi");
			 
			 
				mav.addObject("usersForm", uf);

				  return mav;
		}
	  

	  @RequestMapping(value="/hello")
	  @ResponseBody
	  public List oo() {
		  JSONArray jsonArray = rgDAO.names();
		  
		  
		  List new1 = rgDAO.getAllUsers();
		 
	 return new1;
	  }
	  
	  @RequestMapping(value = "/something", method = RequestMethod.GET)
	  @ResponseBody
	  public void helloWorld(HttpServletRequest request,HttpServletResponse response) throws IOException  {  
       JSONArray jsonArray = rgDAO.names(); 
       request.getParameter("three"); 
      // System.out.println(uf.getThree());
       System.out.println(jsonArray);
	    response.getWriter().println(jsonArray);
	  }

	  @RequestMapping(value = "/some")
	  @ResponseBody
	  public void helloWorld1(HttpServletRequest request,HttpServletResponse response) throws IOException  {  
		  String tt=request.getParameter("b"); 
		  System.out.println(tt);
		  
		    JSONArray jsonArray = rgDAO.names(); 
		    response.getWriter().println(jsonArray);

	  }

}




