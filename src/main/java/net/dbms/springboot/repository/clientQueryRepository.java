package net.javaguides.springboot.repository;
import org.springframework.data.jpa.repository.Query;
import net.javaguides.springboot.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface clientQueryRepository extends JpaRepository<Client, Long> {
     
    @Query("SELECT e FROM Client e WHERE e.firm.name LIKE %?1%"
            )
    public List<Client> searchClient(String keyword);

    @Query("SELECT e FROM Client e "
            )
    public List<Client> getClients();

    @Query("SELECT e FROM Client e WHERE e.id = ?1"
            )
    public Client clientById(Long id);

    @Query("SELECT e.firm.bank FROM Client e WHERE e.id = ?1")
    public Bank bankByClientId(Long id);

    @Query("SELECT e FROM Client e WHERE e.contactnumber = ?1")
    public List<Client> clientByContactNumber(String contactnumber);
}