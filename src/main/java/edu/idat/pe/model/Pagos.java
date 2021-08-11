package edu.idat.pe.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Table(name = "pagos")
public class Pagos implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idpagos;
	@Column(name="nombres")
	private String nombres;
	@Column(name="apellidos")
	private String apellidos;
	@Email
	@Column(name="email")
	private String email;
	@Column(name="direccion")
	private String direccion;
	@Column(name="departamento")
	private String departamento;
	@Column(name="provincia")
	private String provincia;
	@Column(name="distrito")
	private String distrito;
	@Column(name="telefono")
	private String telefono;
	@Column(name="tipotarjeta")
	private String tipotarjeta;
	@Column(name="nomtarjeta")
	private String nomtarjeta;
	@Column(name="numetarjeta")
	private String numetarjeta;
	@Column(name="expiration")
	private String expiration;
	@Column(name="cvv")
	private int cvv;
	public Pagos(int idpagos, String nombres, String apellidos, String email, String direccion, String departamento,
			String provincia, String distrito, String telefono, String tipotarjeta, String nomtarjeta, String numetarjeta,
			String expiration, int cvv) {
		super();
		this.idpagos = idpagos;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.email = email;
		this.direccion = direccion;
		this.departamento = departamento;
		this.provincia = provincia;
		this.distrito = distrito;
		this.telefono = telefono;
		this.tipotarjeta = tipotarjeta;
		this.nomtarjeta = nomtarjeta;
		this.numetarjeta = numetarjeta;
		this.expiration = expiration;
		this.cvv = cvv;
	}
	public Pagos() {
		super();
	}
	public int getIdpagos() {
		return idpagos;
	}
	public void setIdpagos(int idpagos) {
		this.idpagos = idpagos;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getTipotarjeta() {
		return tipotarjeta;
	}
	public void setTipotarjeta(String tipotarjeta) {
		this.tipotarjeta = tipotarjeta;
	}
	public String getNomtarjeta() {
		return nomtarjeta;
	}
	public void setNomtarjeta(String nomtarjeta) {
		this.nomtarjeta = nomtarjeta;
	}
	
	public String getNumetarjeta() {
		return numetarjeta;
	}
	public void setNumetarjeta(String numetarjeta) {
		this.numetarjeta = numetarjeta;
	}
	
	public String getExpiration() {
		return expiration;
	}
	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	private static final long serialVersionUID = 1L;
}
