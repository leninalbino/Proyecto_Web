package edu.idat.pe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ventaproducto")
public class VentaProducto {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idproducto;
	
	@Column(name="categoria")
	private String categoria;
	
	@Column(name="cantidadtotal")
	private int cantidadtotal;
	
	
	@Column(name="preciounitario")
	private Double preciounitario;
	
	@Column(name="preciototal")
	private Double preciototal;


	public VentaProducto(int idproducto, String categoria, Double preciounitario, int cantidadtotal,
			Double preciototal) {
		super();
		this.idproducto = idproducto;
		this.categoria = categoria;
		this.cantidadtotal = cantidadtotal;
		this.preciounitario = preciounitario;
		this.preciototal = preciototal;
	}



	public VentaProducto() {
		// TODO Auto-generated constructor stub
	}



	public int getIdproducto() {
		return idproducto;
	}



	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}



	public String getCategoria() {
		return categoria;
	}



	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getCantidadtotal() {
		return cantidadtotal;
	}



	public void setCantidadtotal(int cantidadtotal) {
		this.cantidadtotal = cantidadtotal;
	}



	public Double getPreciounitario() {
		return preciounitario;
	}



	public void setPreciounitario(Double preciounitario) {
		this.preciounitario = preciounitario;
	}



	public Double getPreciototal() {
		return preciototal;
	}



	public void setPreciototal(Double preciototal) {
		this.preciototal = preciototal;
	}



	
}
