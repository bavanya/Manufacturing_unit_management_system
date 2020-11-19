package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Purchaseorder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface purchaseorderRepository extends CrudRepository<Purchaseorder, Long> {

}