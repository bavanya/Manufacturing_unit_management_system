package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Greeting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface greetingRepository extends CrudRepository<Greeting, Long> {

}