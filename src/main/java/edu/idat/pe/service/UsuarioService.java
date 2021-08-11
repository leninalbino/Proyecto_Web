package edu.idat.pe.service;

import edu.idat.pe.entity.Usuario;

public interface UsuarioService {
	
	
	public Usuario findByUsername(String username);
	public  Usuario registro(Usuario u);
	
	
	
	
	
}


