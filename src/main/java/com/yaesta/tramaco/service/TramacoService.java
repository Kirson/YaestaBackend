package com.yaesta.tramaco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Service;

import dmz.comercial.servicio.cliente.dto.EntityContrato;
import dmz.comercial.servicio.cliente.dto.EntityLocalidad;
import dmz.comercial.servicio.cliente.dto.EntityProducto;
import dmz.comercial.servicio.cliente.dto.EntityServicio;
import dmz.comercial.servicio.cliente.dto.EntradaAutenticarWs;
import dmz.comercial.servicio.cliente.dto.RespuestaAutenticarWs;
import dmz.comercial.servicio.cliente.dto.SalidaAutenticarWs;
import dmz.comercial.servicio.cliente.impl.ServicioAutenticar;

@Service
public class TramacoService {

	@Autowired
	PropertySourcesPlaceholderConfigurer propertyConfigurer;

	private @Value("${tramaco.url}") String tramacoUrl;
	private @Value("${tramaco.port}") String tramacoPort;
	private @Value("${tramaco.user}") String tramacoUser;
	private @Value("${tramaco.password}") String tramacoPassword;

	public String authService(){

		String response = "ok";
		
		System.out.println("Inicio auhtService"); 

		try{
			String url = "http://"+tramacoUrl+":"+tramacoPort+"/";
			System.out.println("URL:"+url); 
			System.out.println("USER:"+tramacoUser);
			System.out.println("PASSWORD:"+tramacoPassword);
			ServicioAutenticar client = new ServicioAutenticar(url);
			

			/**
			 * Datos de entrada
			 */
			EntradaAutenticarWs entAut = new EntradaAutenticarWs();
			entAut.setLogin(tramacoUser);
			entAut.setPassword(tramacoPassword);
			/*Consumo*/
			RespuestaAutenticarWs respuestaAutenticarWs = client.autenticarCliente(entAut);

			/**
			 * Datos de salida
			 */
			if (respuestaAutenticarWs != null) {
				if (respuestaAutenticarWs.getCuerpoRespuesta() != null) {
					System.out.println("CODIGO:" +
							respuestaAutenticarWs.getCuerpoRespuesta().getCodigo());
					System.out.println("MENSAJE:" +
							respuestaAutenticarWs.getCuerpoRespuesta().getMensaje());
					System.out.println("EXCEPCION:" +
							respuestaAutenticarWs.getCuerpoRespuesta().getExcepcion());
				}
				if (respuestaAutenticarWs.getSalidaAutenticarWs() != null) {
					SalidaAutenticarWs salida = respuestaAutenticarWs.getSalidaAutenticarWs();
					System.out.println("CONTRATOS:");
					for (EntityContrato contrato : salida.getLstContrato()) {
						System.out.println("ID:" + contrato.getId() + " NUMERO:" + contrato.getNumero());
					}
					System.out.println("LOCALIDADES:");
					for (EntityLocalidad localidad : salida.getLstLocalidad()) {
						System.out.println("ID:" + localidad.getId() + " NOMBRE:" +
								localidad.getNombre());
					}
					System.out.println("PRODUCTOS:");
					for (EntityProducto producto : salida.getLstProducto()) {
						System.out.println("ID:" + producto.getId() + " NOMBRE:" + producto.getNombre()
						+ " TIPO:" + producto.getTipo());
					}
					System.out.println("SERVICIOS:");
					for (EntityServicio servicio : salida.getLstServicio()) {
						System.out.println("ID:" + servicio.getId() + " NOMBRE:" + servicio.getNombre() +
								" TIPO:" + servicio.getTipo());
					}
				}
			}

		}catch(Exception e){

			System.out.println("Error al consumir servicio tramaco Auth");

			response= "error";
		}

		return response;
	}

}
