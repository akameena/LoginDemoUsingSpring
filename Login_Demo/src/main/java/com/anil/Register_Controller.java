package com.anil;

import org.apache.catalina.connector.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.anil.dao.User_Dao;
import com.anil.model.User;
import com.anil.service.Register_Service;

@Controller
public class Register_Controller {
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public ModelAndView register(@RequestParam("rmn") String rmn,@RequestParam("rpass1") String rpass1, @RequestParam("rpass2") String rpass2)
	{
		//System.out.println("helllooooooooooooo_________");
		
		Register_Service register_service = new Register_Service();
		ModelAndView mav = new ModelAndView();
		if(register_service.match_password(rpass1, rpass2))
		{
			User user =  new User();
			user.setMobile_number(rmn);
			user.setPassword(rpass1);
			User_Dao ud  = new User_Dao();
			ud.user_in_db(user);
			mav.setViewName("register_confirm.jsp");
			mav.addObject("rmn", rmn);
			
		}
		
		else
		{
			
			mav.setViewName("register_page.jsp");
			
		}
		return mav;
	}

}
