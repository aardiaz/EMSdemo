package com.bway.springproject.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GalleryController {
	
	@GetMapping("/gallery")
	public String gallery(Model model) {
		
		 String[]  imgeNames = new File("src/main/resources/static/images").list();
		 model.addAttribute("imageNameList",imgeNames);
		
		return "GalleryForm";
	}

}
