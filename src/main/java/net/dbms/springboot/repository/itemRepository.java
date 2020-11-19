package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface itemRepository extends CrudRepository<Item, Long> {

}