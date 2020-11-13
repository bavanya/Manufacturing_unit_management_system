package net.javaguides.springboot.repository;
import org.springframework.data.jpa.repository.Query;
import net.javaguides.springboot.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface materialQueryRepository extends JpaRepository<Material, Long> {
     
    @Query("SELECT e FROM Material e WHERE e.name LIKE %?1%"
            + " OR e.description LIKE %?1%")
    public List<Material> searchMaterial(String keyword);

    @Query("SELECT e FROM Material e")
    public List<Material> getMaterials();

    @Query("SELECT e FROM Material e WHERE e.id = ?1")
    public Material materialById(Long id);

    @Query("SELECT e FROM Material e WHERE e.name = ?1")
    public List<Material> materialByName(String name);

    @Query("SELECT e FROM Material e WHERE e.description = ?1")
    public List<Material> materialByDescription(String description);
}