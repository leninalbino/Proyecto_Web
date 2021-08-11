package edu.idat.pe.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.idat.pe.global.GlobalData;
import edu.idat.pe.model.Carrito;
import edu.idat.pe.model.Producto;
import edu.idat.pe.model.VentaProducto;
import edu.idat.pe.model.response.ResultadoResponse;
import edu.idat.pe.service.ProductoService;

@SuppressWarnings("unchecked")
@Controller
@RequestMapping("/Producto")
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	@GetMapping("/frmListarProducto")
	public String frmListarProducto(Model model) {
		model.addAttribute("visualizar", false);
		model.addAttribute("listproductos", productoService.listarProductos());
		model.addAttribute("ventaproductoform", new VentaProducto());

		return "Producto/frmListarProducto";
	}
	
	

	@DeleteMapping("/eliminarProductoVenta")
	@ResponseBody
	public ResultadoResponse eliminarproductoventa(@ModelAttribute VentaProducto pedido,
			final HttpServletRequest request, Model model) {
		String mensaje = "Producto Eliminado del carrito";
		Boolean respuesta = true;
		try {
			List<VentaProducto> lstVentaProducto = (List<VentaProducto>) request.getSession().getAttribute("session");
			if (CollectionUtils.isEmpty(lstVentaProducto)) {
				lstVentaProducto.remove(pedido.getIdproducto());
			}
		} catch (Exception e) {
			mensaje = "Producto no Eliminado del Carrito";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}

	/*
	 * @PostMapping("/registrarProducto") public String
	 * registrarProducto(@ModelAttribute("ventaproductoform") VentaProducto
	 * ventaProductoForm, final HttpServletRequest request, Model model) {
	 * List<VentaProducto> lstVentaProducto = (List<VentaProducto>)
	 * request.getSession().getAttribute("session"); if
	 * (CollectionUtils.isEmpty(lstVentaProducto)) { lstVentaProducto = new
	 * ArrayList<VentaProducto>(); } Producto objproducto =
	 * productoService.buscarProducto(ventaProductoForm.getIdproducto()); Double
	 * preciototal = ventaProductoForm.getCantidadtotal() *
	 * objproducto.getPrecioventa(); Double preciounit =
	 * objproducto.getPrecioventa(); String respuesta =
	 * "el Precio Unitario del Producto " + objproducto.getModelo() + " es: " +
	 * objproducto.getPrecioventa() + "el valor total es: " + preciototal;
	 * 
	 * // objproducto es de la entidad producto y ventaProductoForm = Venta Producto
	 * VentaProducto nuevoproducto = new VentaProducto(objproducto.getIdproducto(),
	 * objproducto.getModelo(), ventaProductoForm.getCantidadtotal(), preciounit,
	 * preciototal);
	 * 
	 * request.getSession().setAttribute("session",
	 * productoService.agregarProducto(nuevoproducto, lstVentaProducto));
	 * model.addAttribute("listproductos",productoService.listarProductos());
	 * model.addAttribute("visualizar ", true); model.addAttribute("respuesta",
	 * respuesta); return "Producto/frmListarProducto";
	 * 
	 * }
	 */

	@PostMapping("/registrarProducto")
	@ResponseBody
	public ResultadoResponse registrarpedido(@RequestBody VentaProducto pedido, final HttpServletRequest request) {

		String mensaje = "Se incluyó en carrito";
		Boolean respuesta = true;
		List<VentaProducto> lstVentaProducto = (List<VentaProducto>) request.getSession().getAttribute("session");
		if (CollectionUtils.isEmpty(lstVentaProducto)) {
			lstVentaProducto = new ArrayList<VentaProducto>();
		}
		try {
			request.getSession().setAttribute("session", productoService.agregarProducto(pedido, lstVentaProducto));
		} catch (Exception ex) {
			mensaje = "No se pudo incluir en carrito";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}
	

	@GetMapping("/listarVentaProductos")
	public String listarVentaProductos(Model model, final HttpSession session) {
		List<VentaProducto> lstVentaProducto = (List<VentaProducto>) session.getAttribute("session");
		if (CollectionUtils.isEmpty(lstVentaProducto)) {
			lstVentaProducto = new ArrayList<VentaProducto>();
		}
		model.addAttribute("lstventaproducto", lstVentaProducto);
		return "Producto/listarventaproducto";
	}

	// lista o buscar por categoria
	@GetMapping("/hombre")
	public String categoriaHombre(Model model) {
		model.addAttribute("cartCount", GlobalData.cart.size());
		model.addAttribute("listcategoria", productoService.getByCategoria("hombre"));
		return "Producto/hombre";
	}

	@GetMapping("/mujer")
	public String categoriaMujer(Model model) {
		model.addAttribute("cartCount", GlobalData.cart.size());
		model.addAttribute("listcategoria", productoService.getByCategoria("mujer"));
		return "Producto/mujer";
	}

	@GetMapping("/niño")
	public String categoriaNiño(Model model) {
		model.addAttribute("cartCount", GlobalData.cart.size());
		model.addAttribute("listcategoria", productoService.getByCategoria("niño"));
		return "Producto/niño";
	}

	@GetMapping("/niña")
	public String categoriaNiña(Model model) {
		model.addAttribute("cartCount", GlobalData.cart.size());
		model.addAttribute("listcategoria", productoService.getByCategoria("niña"));
		return "Producto/niña";
	}

	@GetMapping("/buscar")
	public String buscarProducto(@RequestParam String categoria, @ModelAttribute("producto") Producto producto,
			Model model) {

		Producto produc = productoService.productoPorCategoria(categoria);

		if (categoria != null) {

			model.addAttribute("produc", produc);
		}

		if (produc == null) {
			model.addAttribute("productoNoEncontrada", "Sin resultados...");

		}

		return "productoBuscar";
	}

}
