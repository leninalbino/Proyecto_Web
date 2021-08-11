package edu.idat.pe.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.idat.pe.global.GlobalData;
import edu.idat.pe.model.Producto;
import edu.idat.pe.repository.ProductoRepository;
import edu.idat.pe.service.ProductoService;


@Controller
public class InicioController {
	
	@Autowired ProductoService productoService;

@GetMapping("/")
public String inicio(Model model) {
	
	return "inicio";
}

/*
 * @PostMapping("/buscar") public String buscarPelicula(@RequestParam String
 * categoria, @ModelAttribute("producto")Producto producto, Model model) {
 * 
 * Producto produc = productoService.productoPorCategoria(categoria);
 * 
 * if(categoria != null) {
 * 
 * model.addAttribute("produc", produc); }
 * 
 * if(produc == null) { model.addAttribute("productoNoEncontrada",
 * "Sin resultados...");
 * 
 * }
 * 
 * 
 * 
 * 
 * return "productoBuscar"; }
 */
}
