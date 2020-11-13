package net.javaguides.springboot.model;

import java.util.Objects;
import javax.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "suppliers")
public class Supplier{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String contactnumber;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "firmid", referencedColumnName = "id")
    public Firm firm;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<Purchaseorder> purchaseorders = new HashSet<>();

    public Supplier() {
    }

    public Supplier(String contactnumber, Firm firm) {

        this.contactnumber = contactnumber;
        this.firm = firm;
    }

    public Set<Purchaseorder> getPurchaseorders(){
        return purchaseorders;
    }

    public void setPurchaseorders(Set<Purchaseorder> purchaseorders){
        this.purchaseorders = purchaseorders;
    }

    public void setFirm(){
        this.firm = firm;
    }

    public Firm getFirm(){
        return firm;
    }

    public Long getId() {
        return id;
    }

    public String getcontactnumber() {
        return contactnumber;
    }

    public void setcontactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Supplier{");
        sb.append("id=").append(id);
        sb.append(", contactnumber=").append(contactnumber);
        sb.append('}');
        return sb.toString();
    }
}