package com.codeunlu.rentacar.repository;

import com.codeunlu.rentacar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
