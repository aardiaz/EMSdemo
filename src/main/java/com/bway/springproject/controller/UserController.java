package com.bway.springproject.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bway.springproject.model.User;
import com.bway.springproject.service.IUserService;
import com.bway.springproject.utils.VerifyRecaptcha;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private IUserService  service;

	@GetMapping("/login")
	public String getLogin() {
		return "LoginForm";
	}

	@PostMapping("/login")
	public String postLogin(@ModelAttribute User user, Model model,HttpSession session, @RequestParam("g-recaptcha-response") String gCode) throws IOException {
		
		
		  if(VerifyRecaptcha.verify(gCode)) {
			  
					user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
					User  usr = service.userLogin(user.getUserName(), user.getPassword());
					  if(usr != null) {
						  
						  logger.info("=============login success============");
						  
						 // model.addAttribute("user_name",usr.getFirstName());
						  session.setAttribute("activeUser", usr);
						  session.setMaxInactiveInterval(300);
						  
						  return "Home";
					  }else {
						  logger.info("============== login failed=================");
							model.addAttribute("message","User not found !!");
							return "LoginForm";
					  }
		  }
		
		  model.addAttribute("message","are you Robot? !!");  
		  
		return "LoginForm";
	}

	@GetMapping("/signup")
	public String getSignup() {
		
		return "SignupForm";
	}

	@PostMapping("/signup")
	public String postSignup(@ModelAttribute User user) {
		
		
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		service.userSignup(user);
		
		return "LoginForm";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();//session kill
		logger.info("==============logout success============");
		return "LoginForm";
	}
	
	@GetMapping("/profile")
	public String profile() {
		
		return "Profile";
	}
	
}
