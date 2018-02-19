package com.envios.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.envios.dao.PaqueteDAO;
import com.envios.model.Paquete;

@Service("paqueteService")
@Transactional
public class PaqueteService {
	
	@Autowired
	private PaqueteDAO paqueteDAO;

	public ArrayList<Paquete> selectAllByPlace(String origen, String destino){		
		return paqueteDAO.selectAllByPlace(origen, destino);
		
	}
	
	public ArrayList<Paquete> selectAll(String origen, String destino){		
		return paqueteDAO.selectAll(origen, destino);
		
	}
	
	public void insert (Paquete paquete) {
		
		paqueteDAO.insert(paquete);
		
	}
	
	
}
