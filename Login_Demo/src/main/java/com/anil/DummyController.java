package com.anil;

import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anil.dao.DummyDao;
import com.anil.dao.DummyFatchDao;
import com.anil.model.Dummy_Data;

@Controller
public class DummyController {
	@RequestMapping("/dummy")
	public ModelAndView  fun()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("DummyShow.jsp");
		return mv;
	}
	@RequestMapping("/dummy/{pid}")
	public ModelAndView dummyShow(@PathVariable int pid)
	{
		ModelAndView mav = new ModelAndView();
		
		//below code used for insert dummy data in table
		
		DummyFatchDao dummyFatchDao = new DummyFatchDao();
		List<Dummy_Data> dummy_list = dummyFatchDao.fatchDummy(pid);
		//System.out.println(dummy_list.size());
		
		
		/*
		DummyDao dd = new DummyDao();
		Session session = dd.openConnection();
		Random rand = new Random();
		for(int i=1;i<=1000;i++)
		{
			Dummy_Data duser = new Dummy_Data();
			System.out.println("I= "+i);
			int rollNo = rand.nextInt(100000);
			duser.setRollno(rollNo);
			duser.setName("name"+"_"+i+"_"+rollNo);
			
			dd.saveDummy(duser, session);
		}
		
		dd.closeConnection(session);
		*/
		
		
		mav.setViewName("/DummyShow.jsp");
		mav.addObject("list", dummy_list);
		System.out.println(pid);
		return mav;
	}

}
