package net.javaguides.springboot.repository;
import org.springframework.data.jpa.repository.Query;
import net.javaguides.springboot.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface itemQueryRepository extends JpaRepository<Item, Long> {
     
    @Query("SELECT e FROM Item e WHERE e.name LIKE %?1%"
            + " OR e.description LIKE %?1%")
    public List<Item> searchItem(String keyword);

    @Query("SELECT e FROM Item e")
    public List<Item> getItems();

    @Query("SELECT e FROM Item e WHERE e.id = ?1")
    public Item itemById(Long id);

    @Query("SELECT e FROM Item e WHERE e.name = ?1")
    public List<Item> itemByName(String name);

    @Query("SELECT e FROM Item e WHERE e.description = ?1")
    public List<Item> itemByDescription(String description);
}