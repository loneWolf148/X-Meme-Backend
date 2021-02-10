package com.lonewolf.memeStream.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This class acts as {@link org.springframework.stereotype.Controller} for
 * mapping route to API Home Page ("/")
 * 
 * @author Subham Das
 * @version 1.0
 * @see {@link com.lonewolf.memeStream.controller.MemeController}
 */
@Controller
public class HomeController {

	/**
	 * This method is responsible for mapping "/" request sent to API and calling
	 * home.jsp page to be displayed on browser
	 * 
	 * @return calls JSP Page - "home.jsp" present in webapp folder of project
	 */
	@RequestMapping("/")
	public String homePage() {
		return "home.jsp";
	}
}
