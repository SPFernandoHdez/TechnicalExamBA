package com.socialnetwork.microservice.api;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.socialnetwork.microservice.entity.Clientes;
import com.socialnetwork.microservice.service.cliente.ClientesServiceImpl;

@RestController
@RequestMapping("api/clientes/v1")
public class ClientesController {

	private static final Logger log = Logger.getLogger(ClientesController.class);
	@Autowired
	private ClientesServiceImpl clientesService;

	@GetMapping("/{id}")
	@ResponseStatus(OK)
	public Clientes leer(@PathVariable("id") String id) {
		log.info(">>> api/clientes/v1 buscando clientes");

		return clientesService.consultarCliente(id);
	}

	@PostMapping
	@ResponseStatus(CREATED)
	public Clientes crear(@RequestBody Clientes cliente) {
		log.info(">>> api/clientes/v1 creando clientes");
		return clientesService.guardarCliente(cliente);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(NO_CONTENT)
	public void borrar(@PathVariable("id") String id) {
		clientesService.borrarCliente(id);
	}

}
