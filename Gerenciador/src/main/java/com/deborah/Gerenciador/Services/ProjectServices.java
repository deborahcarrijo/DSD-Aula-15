package com.deborah.Gerenciador.Services;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.deborah.Gerenciador.Exceptions.ResourceNotFoundException;
import com.deborah.Gerenciador.Model.Project;
import com.deborah.Gerenciador.Repositories.ProjectRepository;

@Service
public class ProjectServices {
	private Logger logger = Logger.getLogger(ProjectServices.class.getName());
	
	@Autowired
	ProjectRepository repository;
	
	public Project findByID(Long id) {

		logger.info("Procurando um projeto!!!");
		return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Não há registros para esse ID"));
	}
	
	public List<Project> findAllProjects() {

		logger.info("Buscando Lista de Projetos");
		return repository.findAll();
	}
	
	public Project Create(Project project) {

		logger.info("Criando uma nova entidade na base de dados");
		return repository.save(project);
	}
	
	public Project Update(Project project) {

		logger.info("Atualizando entidade na base de dados");
		var entity = repository.findById(project.getId()).orElseThrow(()-> new ResourceNotFoundException("Não há registros para esse ID"));

		entity.setName(project.getName());
		entity.setStart_date(project.getStart_date());
		entity.setEnd_date(project.getEnd_date());
		entity.setHours(project.getHours());
		entity.setArtifact(project.getArtifact());
		
		return repository.save(entity);
	}
	
	public void delete(Long id) {
		
		logger.info("removendo Entidade na Base de Dados ID..: " + id);
		var entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Não há Registros com esse ID"));
		repository.delete(entity);
	}
}

