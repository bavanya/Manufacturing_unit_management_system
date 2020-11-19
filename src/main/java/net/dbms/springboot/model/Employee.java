package net.javaguides.springboot.model;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String name;
    public int monthly_salary;
    public String designation;
    public String status;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bankid", nullable = false)
    public Bank bank;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<Clientorder> clientorders = new HashSet<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<Purchaseorder> purchaseorders = new HashSet<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<Piece> pieces = new HashSet<>();

    public Employee() {
    }

    public Employee(String name, int monthly_salary, String designation, String status, Bank bank) {
        this.name = name;
        this.monthly_salary = monthly_salary;
        this.designation = designation;
        this.status = status;
        this.bank = bank;
    }

    public Long getId() {
        return id;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank() {
        this.bank = bank;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getMonthly_salary() {
        return monthly_salary;
    }

    public void setMonthly_salary(int monthly_salary) {
        this.monthly_salary = monthly_salary;
    }

    public String getDesignation(){
        return designation;
    }

    public void setDesignation(String designation){
        this.designation = designation;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + this.monthly_salary;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if (this.monthly_salary != other.monthly_salary) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", monthly_salary=").append(monthly_salary).append('\'');
        sb.append(", String=").append(status).append('\'');
        sb.append(", String='").append(designation);
        sb.append('}');
        return sb.toString();
    }
}