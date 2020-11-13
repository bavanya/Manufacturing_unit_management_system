package net.javaguides.springboot.repository;
import org.springframework.data.jpa.repository.Query;
import net.javaguides.springboot.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface pieceQueryRepository extends JpaRepository<Piece, Long> {
     
    
    @Query("SELECT e FROM Piece e WHERE e.item.id = ?1")
    public List<Piece> getPiecesByItemId(Long id);
}