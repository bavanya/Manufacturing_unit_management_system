package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface clientRepository extends CrudRepository<Client, Long> {

}