package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Piece;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface pieceRepository extends CrudRepository<Piece, Long> {

}