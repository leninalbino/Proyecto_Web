package edu.idat.pe.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.idat.pe.entity.Usuario;
import edu.idat.pe.service.UsuarioService;

@Controller
public class LoginController {
	@Autowired
	private UsuarioService usuarioService;

//el control  + z
	@GetMapping("/auth/login")
	public String login (Model model) {
		model.addAttribute("usuario", new Usuario());
		return "login";
	}
	//por si falla el login crontrol+ z nomas
	@GetMapping("/auth/registro")
	public String registroFrom(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "registro";
	}// guarda a la base de datos

@PostMapping("/auth/registro")
public String registro(@Valid @ModelAttribute  Usuario usuario , BindingResult result, Model model) {
	if(result.hasErrors()) {
		//model.addAttribute("titulo","formulario usuario");
		return "redirect:/auth/registro";
	}else {
		model.addAttribute("usuario", usuarioService.registro(usuario));
	}
	return "redirect:/auth/login";
}
}
