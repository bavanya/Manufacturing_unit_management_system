package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Supplier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface supplierRepository extends CrudRepository<Supplier, Long> {

}