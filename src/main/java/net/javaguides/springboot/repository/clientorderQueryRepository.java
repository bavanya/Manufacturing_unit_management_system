package net.javaguides.springboot.repository;
import org.springframework.data.jpa.repository.Query;
import net.javaguides.springboot.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface clientorderQueryRepository extends JpaRepository<Clientorder, Long> {
     
    @Query("SELECT e FROM Clientorder e WHERE e.client.id=?1")
    public List<Clientorder> getProjectsByClientId(Long id);
    
}