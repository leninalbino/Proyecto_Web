package edu.idat.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.idat.pe.model.Pagos;

@Repository
public interface PagosRepository extends JpaRepository<Pagos, Integer>{
	
	@Query(value="{call guardarPagos(:nombresIn,:apellidosIn,:emailIn,:direccionIn,:departamentoIn,:provinciaIn, :distritoIn, :telefonoIn, :tipotarjetaIn,:nomtarjetaIn,:numetarjetaIn, :expirationI, :cvvIn)}",nativeQuery=true)
	void guardarPagos(
			@Param("nombresIn")String nombreIn,
			@Param("apellidosIn")String apellidoIn,
			@Param("emailIn")String emailIn,
			@Param("direccionIn")String direccionIn,
			@Param("departamentoIn")String departamentoIn,
			@Param("provinciaIn")String provinciaIn,
			@Param("distritoIn")String distritoIn,
			@Param("telefonoIn")String telefonoIn,
			@Param("tipotarjetaIn")String tipotarjetaIn,
			@Param("nomtarjetaIn")String nomtarjetaIn,
			@Param("numetarjetaIn")String numetarjetaIn,
			@Param("expirationI")String expirationI,
			@Param("cvvIn")int cvvIn
			);
}
