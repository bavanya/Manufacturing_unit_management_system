package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Material;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface materialRepository extends CrudRepository<Material, Long> {

}