package com.anil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.anil.dao.Login_Dao;

@Controller
public class Login_Controller {
	@RequestMapping("/login")
	public ModelAndView logincontrol(@RequestParam("uid1") String uid,@RequestParam("pass1") String pass, HttpServletRequest request,HttpServletResponse response)
	{
		//System.out.println("hello  "+mn1);
		ModelAndView mav = new ModelAndView();
		Login_Dao login_Dao = new Login_Dao();
		if(login_Dao.check_login_request(uid,pass))
		{
			mav.setViewName("welcome.jsp");
			mav.addObject("uid", uid);
		}
		else
		{
			mav.setViewName("index.jsp");
		}
		
		return mav;
		
	}
	

}
