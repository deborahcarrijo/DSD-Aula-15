package com.deborah.Gerenciador.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.deborah.Gerenciador.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

