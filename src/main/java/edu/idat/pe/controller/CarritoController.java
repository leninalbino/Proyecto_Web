package edu.idat.pe.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import edu.idat.pe.entity.Usuario;
import edu.idat.pe.global.GlobalData;
import edu.idat.pe.model.Carrito;
import edu.idat.pe.model.Producto;
import edu.idat.pe.model.VentaProducto;
import edu.idat.pe.repository.ProductoRepository;
import edu.idat.pe.service.ProductoService;
import edu.idat.pe.service.UsuarioService;
import edu.idat.pe.model.response.ResultadoResponse;

@SuppressWarnings("unchecked")
@Controller
@RequestMapping("/Pedido")
public class CarritoController {
	
	@Autowired
	ProductoController productoController;

	/*
	 * @GetMapping("/listarCarrito")
	 * 
	 * @ResponseBody public List<VentaProducto> listarCarrito(final HttpSession
	 * session) { List<VentaProducto> lstcarrito = (List<VentaProducto>)
	 * session.getAttribute("session"); if (lstcarrito==null) { lstcarrito=new
	 * ArrayList<>(); } return lstcarrito; }
	 */

	/*
	 * @DeleteMapping("/EliminarProCarrito")
	 * 
	 * @ResponseBody public ResultadoResponse
	 * EliminarCarrito(@RequestAttribute("idproducto") int idproducto,
	 * HttpServletRequest request) { HttpSession session = request.getSession();
	 * List<VentaProducto> lstcarrito = (List<VentaProducto>)
	 * session.getAttribute("session"); for (VentaProducto d : lstcarrito) { if
	 * (d.getIdproducto() == (idproducto)) { lstcarrito.remove(d); break; } }
	 * session.setAttribute("session", lstcarrito); String mensaje =
	 * "Producto eliminado del carrito correctamente"; Boolean respuesta = true;
	 * return new ResultadoResponse(respuesta, mensaje); };
	 */
	/*
	 * private ArrayList<VentaProducto> obtenerCarrito(HttpServletRequest request) {
	 * ArrayList<VentaProducto> carrito = (ArrayList<VentaProducto>)
	 * request.getSession().getAttribute("carrito"); if (carrito == null) { carrito
	 * = new ArrayList<>(); } return carrito; }
	 */

	/*
	 * @DeleteMapping("/EliminarProCarrito")
	 * 
	 * @ResponseBody public ResultadoResponse eliminarproductoventa(@PathVariable
	 * int idproducto, final HttpSession request, Model model) { String mensaje =
	 * "Producto Eliminado del carrito"; Boolean respuesta = true; try {
	 * List<VentaProducto> lstVentaProducto = this.listarCarrito(request); if
	 * (lstVentaProducto !=null && lstVentaProducto.size()> 0 &&
	 * lstVentaProducto.get(idproducto) != null) {
	 * lstVentaProducto.remove(idproducto); }
	 * 
	 * 
	 * } catch (Exception e) { mensaje = "Producto no Eliminado del Carrito";
	 * respuesta = false; } return new ResultadoResponse(respuesta, mensaje); }
	 */
}
