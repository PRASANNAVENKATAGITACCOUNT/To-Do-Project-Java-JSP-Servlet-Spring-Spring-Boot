package com.webdevelopemnt.SpringWeb.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	AuthenticationService authenticationService;
	
	public LoginController(AuthenticationService authenticationService) {
		this.authenticationService=authenticationService;
	}
	
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	
//	@RequestMapping("login")
//	public String showLoginPage(@RequestParam String name, ModelMap model) {
//		model.put("name",name);
//		//System.out.println(name);// Not Recommended
//		// useing expression Language
//  <p>Hello ${name}</p> html code//  <p>Hello ${name}</p> html code
//		//logger.debug("Name Query -> {}",name);
//		return "login";
//	}
	
//	@RequestMapping(value="login",method=RequestMethod.GET)
	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String goToWelcome(@RequestParam String name,
			@RequestParam String password, ModelMap model) {
		model.put("name",name);
		model.put("password",password);
		if(authenticationService.authenticate(name, password)) {
			return "welcome";
		}
		model.put("errorMessage","Invalid Credentials Try again");
		return "login";
	}
	
}
