package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Firm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface firmRepository extends CrudRepository<Firm, Long> {

}