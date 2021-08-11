package edu.idat.pe.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.idat.pe.model.Producto;
import edu.idat.pe.model.VentaProducto;
import edu.idat.pe.repository.ProductoRepository;

@Service

public class ProductoService {
	@Autowired
	private ProductoRepository productoRepository;
	// creamos un metodo para listar los productos

	public List<Producto> listarProductos() {
		return productoRepository.listarProductos();

	}

	// categoria
	public List<Producto> getByCategoria(String categoria) {
		return productoRepository.listarCategoria(categoria);
	}
	public Optional<Producto> obtenerPorId(int idproducto) {
		return productoRepository.obtenerPorId(idproducto);
	}
	
	public void editarProductoVenta(VentaProducto productoVenta) {
		productoRepository.actualizarProductoVenta(productoVenta.getIdproducto(),
				productoVenta.getCategoria(),
				 productoVenta.getPreciounitario(),
				 productoVenta.getCantidadtotal(),
				 productoVenta.getPreciototal());
	}
	
	public void eliminarProductoVenta(VentaProducto productoVenta) {
		productoRepository.eliminarProductoVenta(productoVenta.getIdproducto());
	}
	
	public double calcularmonto(List <VentaProducto> listadopedidos) {
		double total=0;
		for(VentaProducto objlista : listadopedidos) {
			total=total+objlista.getPreciototal();
		}
		return total;
	}
	
	public List<VentaProducto> eliminarProductoCarrito(VentaProducto objventaprod, 
			List<VentaProducto> listventaprod) {
		boolean nuevoproducto = false;
		boolean agregarnuevo = false;
		List<VentaProducto> nuevalistaventaproducto = 
				new ArrayList<VentaProducto>();
		if(listventaprod.size() == 0) {
			nuevalistaventaproducto.add(objventaprod);
		}else {
			for(VentaProducto objventa : listventaprod) {
				if(objventa.getIdproducto()==(objventaprod.getIdproducto())) {
					nuevalistaventaproducto.remove(
							new VentaProducto(objventa.getIdproducto(),
									objventa.getCategoria(),objventa.getPreciounitario(),
									objventa.getCantidadtotal()+objventaprod.getCantidadtotal(),
									objventa.getPreciototal() + objventaprod.getPreciototal())

							);
					nuevoproducto= true; agregarnuevo = false;
				} else {
					nuevalistaventaproducto.add(objventa);
					if(nuevoproducto)
						agregarnuevo = false;
					else 
						agregarnuevo = true;
				}
			}
			if(agregarnuevo) {
				nuevalistaventaproducto.add(objventaprod);
			}
		}
		return nuevalistaventaproducto;
	}

	
	
	public Producto buscarProducto(int codproducto) {
		Producto objproducto = null;
		List<Producto> lstproducto = listarProductos();
		for(Producto objprod : lstproducto) {
			if(objprod.getIdproducto()==(codproducto)) {
				objproducto = objprod;
				break;
			}
		}
		return objproducto;
	}

	
	public List<VentaProducto> agregarProducto(VentaProducto objventaprod, 
			List<VentaProducto> listventaprod) {
		boolean nuevoproducto = false;
		boolean agregarnuevo = false;
		List<VentaProducto> nuevalistaventaproducto = 
				new ArrayList<VentaProducto>();
		if(listventaprod.size() == 0) {
			nuevalistaventaproducto.add(objventaprod);
		}else {
			for(VentaProducto objventa : listventaprod) {
				if(objventa.getIdproducto()==(objventaprod.getIdproducto())) {
					nuevalistaventaproducto.add(
							new VentaProducto(objventa.getIdproducto(),
									objventa.getCategoria(),objventa.getPreciounitario(),
									objventa.getCantidadtotal()+objventaprod.getCantidadtotal(),
									objventa.getPreciototal() + objventaprod.getPreciototal())

							);
					nuevoproducto= true; agregarnuevo = false;
				} else {
					nuevalistaventaproducto.add(objventa);
					if(nuevoproducto)
						agregarnuevo = false;
					else 
						agregarnuevo = true;
				}
			}
			if(agregarnuevo) {
				nuevalistaventaproducto.add(objventaprod);
			}
		}
		return nuevalistaventaproducto;
	}

	
	
	public Producto productoPorCategoria(String categoria) {
		return productoRepository.findByCategoria(categoria);
	}
	

}
