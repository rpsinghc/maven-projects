package com.rpsingh.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value="/index")
	public ModelAndView login(@ModelAttribute Login login) {
		ModelAndView mv = new ModelAndView("register");
		mv.addObject("login", login);
		return mv;
	}
	
}
