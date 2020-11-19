package net.javaguides.springboot.model;

import java.util.Objects;
import javax.persistence.*;


@Entity
@Table(name = "clientorders")
public class Clientorder{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @ManyToOne
    @JoinColumn(name = "clientid")
    public Client client;

    @ManyToOne
    @JoinColumn(name = "employeeid")
    public Employee employee;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "transactionid", nullable = false)
    public Transaction transaction;

    @ManyToOne
    @JoinColumn(name = "itemid")
    public Item item;

    public int quantity_in_units;

    public int rupees_per_unit;

    public Long getId() {
        return id;
    }

    public Client getClient(){
        return client;
    }

    public Employee getEmployee(){
        return employee;
    }

    public void setEmployee(Employee employee){
        this.employee = employee;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Clientorder{");
        sb.append("id=").append(id);
        sb.append('}');
        return sb.toString();
    }
    
    public Clientorder() {
    }

    public Clientorder(Client client, Employee employee, Transaction transaction, Item item, int quantity_in_units, int rupees_per_unit) {
        this.client = client;
        this.employee = employee;
        this.transaction = transaction;
        this.item = item;
        this.quantity_in_units = quantity_in_units;
        this.rupees_per_unit = rupees_per_unit;
    }

}