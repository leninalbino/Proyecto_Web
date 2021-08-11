package edu.idat.pe.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.idat.pe.entity.Usuario;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Long> {
	public Usuario findByUsername(String username);

}
