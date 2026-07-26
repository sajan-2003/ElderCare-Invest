package com.eldernest.repository;
import com.eldernest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository
    extends JpaRepository<User, Long>{

    }

