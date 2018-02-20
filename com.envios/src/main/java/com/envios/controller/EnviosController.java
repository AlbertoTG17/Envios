package com.envios.controller;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.envios.model.Paquete;
import com.envios.service.PaqueteService;

@Controller
public class EnviosController {
	
	@Autowired
	private PaqueteService paqueteService;
	
	@RequestMapping(value="/inicio")
	public String principal() {
		//Redireccion hacia el jsp del formulario
		return "redirect:index.jsp";
	}
	
	
	
//	private Twitter twitter;
//
//    private ConnectionRepository connectionRepository;
//	
//	@Inject
//    public EnviosController(Twitter twitter, ConnectionRepository connectionRepository) {
//        this.twitter = twitter;
//        this.connectionRepository = connectionRepository;
//    }
	
	@RequestMapping(value="/entregar")
	public String entregas() {
		//Redireccion hacia el form de entrega
		return "entregar";
	}
	
	@RequestMapping(value="/buscarPaquetes")
	public String buscarPaquetes() {
		//Redireccion hacia el form de entrega
		return "llevar";
	}
	
	@RequestMapping(value="/listarPaquetesLugar")
	public String listarPaquetesLugar(HttpServletRequest req, Model model) {
		//Redireccion hacia la lista de paquetes disponibles
		String origen = req.getParameter("origen");
		String destino = req.getParameter("destino");
		
		model.addAttribute("listaPaquetes",paqueteService.selectAllByPlace(origen, destino));
		
		//llamar a service --> dao
		
		return "lista";
	}
	
	@RequestMapping(value="/listarPaquetes")
	public String listarPaquetes(HttpServletRequest req, Model model) {
		//Redireccion hacia la lista de paquetes disponibles
		String origen = req.getParameter("origen");
		String destino = req.getParameter("destino");
		
		model.addAttribute("listaPaquetes",paqueteService.selectAll(origen, destino));
		
		return "lista";
	}
	
	//MAPEOS DE ENTREGAR
	
	@RequestMapping(value="/resistrar")
	public String registry(Model model) {
				
				
		return "";
	}
	
	@RequestMapping(value="/entregarPaquete")
	public String entregarPaquete(Authentication auth) {
		
		auth.getPrincipal();
		//Redireccion hacia el form de insertar paquetes
		return "insertPaquete";
	}
	
	@RequestMapping(value="/error")
	public String error() {
 		return "access-denied";
 	}
		
	
	@RequestMapping(value="/registrarPaquete")
	public String registrarPaquete(HttpServletRequest request) {
		
		String tamaño = request.getParameter("medida");
		String fechaEntrega = request.getParameter("fechaEntrega");
		String origen = request.getParameter("origen");
		String destino = request.getParameter("destino");
		
		
		//Parseo de fecha
		DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		
		Date fecha = null;
		
		try {
			fecha = formato.parse(fechaEntrega);
		} catch (ParseException e) {			
			e.printStackTrace();
		}
		
		Paquete paquete = new Paquete(tamaño, fecha, origen, destino);
						
		paqueteService.insert(paquete);
		
		System.out.println("----> Registro insertado");
		
		return "redirect:index.jsp";
	}
	

}
