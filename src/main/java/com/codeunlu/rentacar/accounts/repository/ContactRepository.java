package com.codeunlu.rentacar.accounts.repository;

import com.codeunlu.rentacar.accounts.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Long> {
}
