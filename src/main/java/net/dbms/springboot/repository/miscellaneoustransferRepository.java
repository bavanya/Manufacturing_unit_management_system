package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Miscellaneoustransfer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface miscellaneoustransferRepository extends CrudRepository<Miscellaneoustransfer, Long> {

}