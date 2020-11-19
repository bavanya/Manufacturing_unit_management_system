package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.ItemMaterial;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface itemmaterialRepository extends CrudRepository<ItemMaterial, Long> {

}