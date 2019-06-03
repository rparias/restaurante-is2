package com.ronaldarias.ppmtool.repositories;

import com.ronaldarias.ppmtool.domain.Email;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends CrudRepository<Email, Integer> {
}
