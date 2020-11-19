package net.javaguides.springboot.repository;
import org.springframework.data.jpa.repository.Query;
import net.javaguides.springboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface employeeQueryRepository extends JpaRepository<Employee, Long> {
     
    @Query("SELECT e FROM Employee e WHERE e.name LIKE %?1%"
            + " OR e.status LIKE %?1%"
            + " OR e.designation LIKE %?1%")
    public List<Employee> searchEmployee(String keyword);

    @Query("SELECT e FROM Employee e")
    public List<Employee> getEmployees();

    @Query("SELECT e FROM Employee e WHERE e.id = ?1")
    public Employee employeeById(Long id);

    @Query("SELECT e FROM Employee e WHERE e.designation = ?1")
    public List<Employee> getByDesignation(String dsg);

    @Query("SELECT e FROM Employee e WHERE e.name = ?1")
    public Employee employeeByName(String name);
}