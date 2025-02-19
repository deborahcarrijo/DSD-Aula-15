package com.deborah.Gerenciador.Services;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.deborah.Gerenciador.Exceptions.ResourceNotFoundException;
import com.deborah.Gerenciador.Model.User;
import com.deborah.Gerenciador.Repositories.UserRepository;

@Service
public class UserServices {
private Logger logger = Logger.getLogger(UserServices.class.getName());
	
	@Autowired
	UserRepository repository;
	
	public User findByID(Long id) {

		logger.info("Procurando um usuário!!!");
		return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Não há registros para esse ID"));
	}
	
	public List<User> findAllUsers() {

		logger.info("Buscando Lista de Usuários");
		return repository.findAll();
	}
	
	public User Create(User user) {

		logger.info("Criando uma nova entidade na base de dados");
		return repository.save(user);

	}
	
	public User Update(User user) {

		logger.info("Atualizando entidade na base de dados");
		var entity = repository.findById(user.getId()).orElseThrow(()-> new ResourceNotFoundException("Não há registros para esse ID"));

		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setResponsibility(user.getResponsibility());
		entity.setFirm(user.getFirm());	
		
		return repository.save(entity);
	}
	
	public void delete(Long id) {
		
		logger.info("removendo Entidade na Base de Dados ID..: " + id);
		var entity = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Não há Registros com esse ID"));
		repository.delete(entity);
	}
}
