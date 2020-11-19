package net.javaguides.springboot.repository;
import org.springframework.data.jpa.repository.Query;
import net.javaguides.springboot.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface bankQueryRepository extends JpaRepository<Bank, Long> {
    

    @Query("SELECT e FROM Bank e WHERE e.id = ?1"
            )
    public Bank bankById(Long id);

    @Query("SELECT e FROM Bank e WHERE e.ifsccode = ?1"
            )
    public List<Bank> bankByIfscCode(String ifsccode);

    @Query("SELECT e FROM Bank e WHERE e.name = ?1"
            )
    public List<Bank> bankByBankName(String bankname);

    @Query("SELECT e FROM Bank e WHERE e.branch = ?1"
            )
    public List<Bank> bankByBranch(String branch);

    @Query("SELECT e FROM Bank e WHERE e.micrnumber = ?1"
            )
    public List<Bank> bankByMicrNumber(String micrnumber);

    @Query("SELECT e FROM Bank e WHERE e.accountnumber = ?1"
            )
    public List<Bank> bankByAccountNumber(String accountnumber);
}