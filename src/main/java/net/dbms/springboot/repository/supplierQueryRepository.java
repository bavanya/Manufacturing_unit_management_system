package net.javaguides.springboot.repository;
import org.springframework.data.jpa.repository.Query;
import net.javaguides.springboot.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface supplierQueryRepository extends JpaRepository<Supplier, Long> {
     
    @Query("SELECT e FROM Supplier e WHERE e.firm.name LIKE %?1%"
            )
    public List<Supplier> searchSupplier(String keyword);
    
    @Query("SELECT e FROM Supplier e ")
    public List<Supplier> getSuppliers();

    @Query("SELECT e FROM Supplier e WHERE e.id = ?1")
    public Supplier supplierById(Long id);

    @Query("SELECT e.firm.bank FROM Supplier e WHERE e.id = ?1")
    public Bank bankBySupplierId(Long id);

    @Query("SELECT e FROM Supplier e WHERE e.contactnumber = ?1")
    public List<Supplier> supplierByContactNumber(String contactnumber);
}