package edu.idat.pe.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.idat.pe.dao.UsuarioDao;
import edu.idat.pe.entity.Usuario;
import edu.idat.pe.service.UsuarioService;

@Service

public class UsuarioServiceImp implements UsuarioService {
		@Autowired
		private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	public Usuario findByUsername(String username) {
		return usuarioDao.findByUsername(username);
	}

	@Override
	public Usuario registro(Usuario u) {
		u.setPassword(passwordEncoder.encode(u.getPassword()));
		return usuarioDao.save(u);
	}

}
