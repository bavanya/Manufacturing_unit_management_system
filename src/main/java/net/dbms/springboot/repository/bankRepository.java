package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Bank;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface bankRepository extends CrudRepository<Bank, Long> {

}