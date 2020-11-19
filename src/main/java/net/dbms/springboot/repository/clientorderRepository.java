package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Clientorder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface clientorderRepository extends CrudRepository<Clientorder, Long> {

}