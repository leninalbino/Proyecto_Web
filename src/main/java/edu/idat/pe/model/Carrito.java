package edu.idat.pe.model;

import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edu.idat.pe.entity.Usuario;

@Entity
@Table(name="carrito")
public class Carrito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idcarrito;
	
	
	@ManyToOne
	@JoinColumn(name="idproducto")
	private Producto producto;
	
	@ManyToOne
	@JoinColumn(name="id")
	private Usuario usuario;

	@Column(name="cantidad")
	private int  cantidad;
	
	

	public Carrito(Producto producto, Usuario usuario, int cantidad) {
		super();
		this.producto = producto;
		this.usuario = usuario;
		this.cantidad = cantidad;
	}



	public Carrito(Integer idcarrito, Producto producto, Usuario usuario, int cantidad) {
		super();
		this.idcarrito = idcarrito;
		this.producto = producto;
		this.usuario = usuario;
		this.cantidad = cantidad;
	}

	



	public Carrito(Producto producto, int cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}



	public Carrito(Optional<Producto> obtenerPorId, int i) {
		// TODO Auto-generated constructor stub

	}



	



	public Integer getIdcarrito() {
		return idcarrito;
	}

	public void setIdcarrito(Integer idcarrito) {
		this.idcarrito = idcarrito;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	
}
