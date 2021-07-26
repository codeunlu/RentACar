package com.codeunlu.rentacar.repository.users;

import com.codeunlu.rentacar.model.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
