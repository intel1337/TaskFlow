package com.taskflow.app.repository;

import com.taskflow.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


//@Repository (Useless since class is extended and implemented with that annnotation)
public interface UserRepository extends JpaRepository<User, Long> {
}
