package com.envios.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="paquetes")
public class Paquete {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_paquete")	
	private int id;
	
	@Column(name="medida")	
	private String tamaño;
	
	@Column(name="fecha_entrega")	
	private Date fechaEntrega;
	
	@Column(name="origen")	
	private String origen;
	
	@Column(name="destino")	
	private String destino;
	
	//C
	
	public Paquete() {}
	
	public Paquete(String tamaño, Date fechaEntrega, String origen, String destino) {
		super();
		this.tamaño = tamaño;
		this.fechaEntrega = fechaEntrega;
		this.origen = origen;
		this.destino = destino;
	}
	
	//GET Y SET
	public int getId() {
		return id;
	}

	

	public void setId(int id) {
		this.id = id;
	}

	public String getTamaño() {
		return tamaño;
	}

	public void setTamaño(String tamaño) {
		this.tamaño = tamaño;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

}
