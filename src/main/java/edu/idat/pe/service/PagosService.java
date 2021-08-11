package edu.idat.pe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.idat.pe.model.Pagos;
import edu.idat.pe.repository.PagosRepository;

@Service
public class PagosService {

	@Autowired
	PagosRepository pagosRepository;
	
	public  void guardarPagos(Pagos pagos) {
		pagosRepository.guardarPagos(pagos.getNombres(),
				pagos.getApellidos(),pagos.getEmail(), pagos.getDireccion(),
				pagos.getDepartamento(), pagos.getProvincia(), pagos.getDistrito(),
				pagos.getTelefono(),pagos.getTipotarjeta(),pagos.getNomtarjeta(),
				pagos.getNumetarjeta(), pagos.getExpiration(),pagos.getCvv());
	}
}
