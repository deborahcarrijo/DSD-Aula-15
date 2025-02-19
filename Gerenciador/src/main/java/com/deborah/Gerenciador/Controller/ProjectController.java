package com.deborah.Gerenciador.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.deborah.Gerenciador.Exceptions.UnsupportedOperationException;
import com.deborah.Gerenciador.Model.Project;
import com.deborah.Gerenciador.Services.ProjectServices;
import com.deborah.Gerenciador.Services.VerificaNumberService;

@RestController
@RequestMapping("/project")
public class ProjectController {
	@Autowired
	private ProjectServices service;
	
	@Autowired
	private VerificaNumberService verifica;

	@GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Project findById(@PathVariable (value = "id") String id) throws Exception{

		if(!verifica.isNumeric(id)) {
			throw new UnsupportedOperationException("Não é um ID válido");
		}
		
		Long idBD = verifica.convertToLong(id);
		return service.findByID(idBD);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Project> findAllProjects(){
		return service.findAllProjects();
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
				consumes = MediaType.APPLICATION_JSON_VALUE)
	public Project create(@RequestBody Project project) {
		return service.Create(project);
	}
	
	@PutMapping(produces=MediaType.APPLICATION_JSON_VALUE,
				consumes=MediaType.APPLICATION_JSON_VALUE)
	public Project update(@RequestBody Project project) {
		return service.Update(project);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<?>delete(@PathVariable (value = "id") String id) throws Exception{
		
		if(!verifica.isNumeric(id)) {
			throw new UnsupportedOperationException("Não é um ID válido");
		}

		Long idBD = verifica.convertToLong(id);
		service.delete(idBD);
		return ResponseEntity.noContent().build();
	}
}

