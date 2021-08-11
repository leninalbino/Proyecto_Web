package edu.idat.pe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.idat.pe.model.Producto;
import edu.idat.pe.model.VentaProducto;



@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {


	@Transactional
	@Query (value = "{call usp_listarProductos()}",
	nativeQuery = true)
	List<Producto> listarProductos();
	
	//buscar por categoria 
	
	@Query(value="{call usp_listarCategoria(:categoriaIn)}",
			nativeQuery=true)
	List<Producto>listarCategoria(@Param ("categoriaIn" )String categoriaIn);
	
	
	@Query(value="{call usp_obtenerPorId(:_idproducto)}",nativeQuery=true)
	public Optional <Producto>obtenerPorId(@Param ("_idproducto" )int _idproducto);
	
	
	
	@Query(value="{call usp_actualizarProductoVenta(:_idproducto,  :_categoria, "
			+ "  :_preciounitario,:_cantidadtotal, :_preciototal)}",
			nativeQuery=true)
	void actualizarProductoVenta(
			@Param ("_idproducto" )int _idproducto,
			@Param ("_categoria" )String _categoria,
			@Param ("_preciounitario" )double _preciounitario,
			@Param ("_cantidadtotal" )int _cantidadtotal,
			@Param ("_preciototal" )double _preciototal
			
			);
	
	
	@Query(value="{call usp_eliminaProductoVenta(:_idproducto)}",nativeQuery=true)
	void eliminarProductoVenta(@Param ("_idproducto" )int _idproducto);
	
	@Override
	default Producto getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	default Producto  findByCategoria(String categoria) {
		return null;
	}
	
	
	default Producto buscarProducto(int codproducto) {
		return null ;
	}
	
	public default  List <VentaProducto> agregarProducto(VentaProducto objventaprod,
			List <VentaProducto> listventaprod) {
				return listventaprod;
		
	}
	
	
}
