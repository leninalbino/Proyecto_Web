package edu.idat.pe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.idat.pe.global.GlobalData;

@Controller
@RequestMapping("/public")
public class PublicController {

	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute(	"cartCount", GlobalData.cart.size());
		return "lagout";
	}
}
