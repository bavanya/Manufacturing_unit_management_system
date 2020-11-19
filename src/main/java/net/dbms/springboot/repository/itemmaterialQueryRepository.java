package net.javaguides.springboot.repository;
import org.springframework.data.jpa.repository.Query;
import net.javaguides.springboot.model.*;
import net.javaguides.springboot.dao.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface itemmaterialQueryRepository extends JpaRepository<ItemMaterial, Long> {
     
    @Query("SELECT e FROM ItemMaterial e WHERE e.item.id = ?1 and e.material.name = ?2")
    ItemMaterial getByItemIdAndMaterialName(Long item_id, String materialName);

    @Query("SELECT e FROM ItemMaterial e WHERE e.item.id = ?1 and e.material.name = ?2")
    ItemMaterial getItemMaterialByMaterial(Long item_id, String materialName);
}