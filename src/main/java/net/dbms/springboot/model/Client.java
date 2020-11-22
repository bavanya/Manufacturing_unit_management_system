package net.javaguides.springboot.model;

import java.util.*;
import javax.persistence.*;


@Entity
@Table(name = "clients")
public class Client{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(nullable=false)
    public String contactnumber;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "firmid", referencedColumnName = "id")
    public Firm firm;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<Clientorder> clientorders = new HashSet<>();

    public Client() {
    }

    public Client(String contactnumber, Firm firm) {

        this.contactnumber = contactnumber;
        this.firm = firm;
    }

    public Long getId() {
        return id;
    }

    public void setFirm(){
        this.firm = firm;
    }

    public Firm getFirm(){
        return this.firm;
    }

    public String getcontactnumber() {
        return contactnumber;
    }

    public void setcontactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Client{");
        sb.append("id=").append(id);
        sb.append(", contactnumber=").append(contactnumber);
        sb.append('}');
        return sb.toString();
    }
}