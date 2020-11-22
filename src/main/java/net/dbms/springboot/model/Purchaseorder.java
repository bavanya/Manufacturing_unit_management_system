package net.javaguides.springboot.model;

import javax.persistence.*;


@Entity
@Table(name = "purchaseorders")
public class Purchaseorder{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @ManyToOne
    @JoinColumn(name = "employeeid")
    public Employee employee;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "transactionid", nullable = false)
    public Transaction transaction;

    @ManyToOne
    @JoinColumn(name = "supplierid")
    public Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "materialid")
    public Material material;

    @Column(nullable=false)
    public int quantity_in_units;

    @Column(nullable=false)
    public int rupees_per_unit;

    public Long getId() {
        return id;
    }

    public Supplier getSupplier(){
        return supplier;
    }

    public Purchaseorder() {
    }

    public Purchaseorder(Supplier supplier, Employee employee, Transaction transaction, Material material, int quantity_in_units, int rupees_per_unit) {
        this.supplier = supplier;
        this.employee = employee;
        this.transaction = transaction;
        this.material = material;
        this.quantity_in_units = quantity_in_units;
        this.rupees_per_unit = rupees_per_unit;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee(){
        return employee;
    }

    public void setEmployee(Employee employee){
        this.employee = employee;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Supplierorder{");
        sb.append("id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}