package net.javaguides.springboot.model;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name = "banks")
public class Bank{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String ifsccode;

    public String name;

    public String branch;

    public String micrnumber;
    
    @Column(unique=true, nullable=false)
    public String accountnumber;

    @OneToOne(fetch = FetchType.LAZY,
    cascade =  CascadeType.ALL,
    mappedBy = "bank")
    public Firm firm;

    @OneToOne(fetch = FetchType.LAZY,
    cascade =  CascadeType.ALL,
    mappedBy = "bank")
    public Employee employee;

    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<Transaction> transactions = new HashSet<>();

    public Bank() {
    }

    public Bank(String ifsccode, String name, String branch, String micrnumber, String accountnumber) {

        this.name = name;
        this.branch = branch;
        this.micrnumber = micrnumber;
        this.ifsccode = ifsccode;
        this.accountnumber = accountnumber;

    }

    public String getAccountnumber(){
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber){
        this.accountnumber = accountnumber;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBranch() {
        return branch;
    }

    public String getMicrnumber() {
        return micrnumber;
    }

    public String getIfsccode() {
        return ifsccode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setMicrnumber(String micrnumber) {
        this.micrnumber = micrnumber;
    }

    public void setIfsccode(String ifsccode) {
        this.ifsccode = ifsccode;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Bank{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", branch='").append(branch).append('\'');
        sb.append(", micrnumber=").append(micrnumber).append('\'');
        sb.append(", ifsccode=").append(ifsccode);
        sb.append('}');
        return sb.toString();
    }
}