package com.envios.dao;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.envios.model.Paquete;

@Repository("paqueteDAO")
@Transactional
public class PaqueteDAO {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@SuppressWarnings("unchecked")
	public ArrayList<Paquete> selectAllByPlace(String origen, String destino){
		
		//Criteria criteria = getSession().createCriteria("");
		return (ArrayList<Paquete>) hibernateTemplate.find("from Paquete where origen like '"+ origen + "%' and "
				+ "destino like '" + destino + "%'");
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Paquete> selectAll(String origen, String destino){
		
		//Criteria criteria = getSession().createCriteria("");
		return (ArrayList<Paquete>) hibernateTemplate.find("from Paquete");
	}
	
	public void insert (Paquete paquete) {
		
		hibernateTemplate.persist(paquete);
		
	}

}
