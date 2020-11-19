package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface transactionRepository extends CrudRepository<Transaction, Long> {

}