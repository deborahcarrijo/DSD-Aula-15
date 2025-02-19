package com.deborah.Gerenciador.Services;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.deborah.Gerenciador.Exceptions.ResourceNotFoundException;
import com.deborah.Gerenciador.Model.Task;
import com.deborah.Gerenciador.Repositories.TaskRepository;

@Service
public class TaskServices {
	private Logger logger = Logger.getLogger(TaskServices.class.getName());
	
	@Autowired
	TaskRepository repository;
	
	public Task findByID(Long id) {

		logger.info("Procurando uma tarefa!!!");
		return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Não há registros para esse ID"));
	}
	
	public List<Task> findAllTasks() {

		logger.info("Buscando Lista de Tarefas");
		return repository.findAll();
	}
	
	public Task Create(Task task) {

		logger.info("Criando uma nova entidade na base de dados");
		return repository.save(task);
	}
	
	public Task Update(Task task) {

		logger.info("Atualizando entidade na base de dados");
		var entity = repository.findById(task.getId()).orElseThrow(()-> new ResourceNotFoundException("Não há registros para esse ID"));

		entity.setTitle(task.getTitle());
		entity.setStart_date(task.getStart_date());
		entity.setEnd_date(task.getEnd_date());
		entity.setStatus(task.getStatus());
		entity.setHours(task.getHours());
		entity.setProject(task.getProject());
		entity.setUser(task.getUser());
		
		return repository.save(entity);
	}
	
	public void delete(Long id) {
		
		logger.info("removendo Entidade na Base de Dados ID..: " + id);
		var entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Não há Registros com esse ID"));
		repository.delete(entity);
	}
}

