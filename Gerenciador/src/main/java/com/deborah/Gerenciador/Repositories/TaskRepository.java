package com.deborah.Gerenciador.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.deborah.Gerenciador.Model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
