package com.cloud.thymleaf.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cloud.thymleaf.entity.Person;

@Controller
public class IndexController {
	
	@GetMapping("/")
	public ModelAndView index(HttpServletRequest request, @ModelAttribute("person") Person person) {
		
	    Calendar cal = Calendar.getInstance();
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("todayDate", cal);
		mv.addObject("person", person);
		return mv;
	}

	@RequestMapping(value="/date")
	public ModelAndView date(HttpServletRequest request, @ModelAttribute("person") Person person) {
		
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
	    Calendar cal = Calendar.getInstance();
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("todayDate", dateFormat.format(cal.getTime()));
		mv.addObject("person", person);
		return mv;
	}


}
