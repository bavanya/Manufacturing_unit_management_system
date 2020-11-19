package net.javaguides.springboot.model;

import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "firms")
public class Firm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String address;
    public String name;
    public String registrationnumber;
    public String gstnumber;
    
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bankid", nullable = false)
    public Bank bank;

    @OneToOne(
    mappedBy = "firm")
    public Client client;

    public Firm() {
    }

    public Firm(String address, String name, String registrationnumber, String gstnumber, Bank bank) {
        this.name = name;
        this.address = address;
        this.registrationnumber = registrationnumber;
        this.gstnumber = gstnumber;
        this.bank = bank;

    }

    public Long getId() {
        return id;
    }

    public Bank getBank(){
        return bank;
    }

    public void setBank(Bank bank){
        this.bank = bank;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getRegistrationnumber() {
        return registrationnumber;
    }

    public String getGstnumber() {
        return gstnumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRegistrationnumber(String registrationnumber) {
        this.registrationnumber = registrationnumber;
    }

    public void setGstnumber(String gstnumber) {
        this.gstnumber = gstnumber;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Firm{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", registrationnumber=").append(registrationnumber).append('\'');
        sb.append(", gstnumber=").append(gstnumber);
        sb.append('}');
        return sb.toString();
    }
}