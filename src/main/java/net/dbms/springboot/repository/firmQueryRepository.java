package net.javaguides.springboot.repository;
import org.springframework.data.jpa.repository.Query;
import net.javaguides.springboot.model.Firm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface firmQueryRepository extends JpaRepository<Firm, Long> {
     
    @Query("SELECT e FROM Firm e WHERE e.name LIKE %?1%"
            + " OR e.address LIKE %?1%")
    public List<Firm> searchFirm(String keyword);

    @Query("SELECT e FROM Firm e")
    public List<Firm> getFirms();

    @Query("SELECT e FROM Firm e WHERE e.registrationnumber = ?1")
    public List<Firm> firmByRegistrationNumber(String registrationnumber);

    @Query("SELECT e FROM Firm e WHERE e.name = ?1")
    public List<Firm> firmByName(String name);

    @Query("SELECT e FROM Firm e WHERE e.address = ?1")
    public List<Firm> firmByAddress(String name);

    @Query("SELECT e FROM Firm e WHERE e.gstnumber = ?1")
    public List<Firm> firmByGSTNumber(String gstnumber);

}