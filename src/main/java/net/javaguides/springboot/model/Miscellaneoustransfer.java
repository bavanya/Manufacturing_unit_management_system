package net.javaguides.springboot.model;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "miscellaneoustransfers")
public class Miscellaneoustransfer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String description;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "transactionid", nullable = false)
    public Transaction transaction;

    public Miscellaneoustransfer() {
    }

    public Miscellaneoustransfer(String description) {

        this.description = description;
    }

    public Long getId() {
        return id;
    }

   public String getDescription(){
       return description;
   }

    public void setDescription(){
        this.description = description;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Miscellaneoustransfer{");
        sb.append("id=").append(id);
        sb.append(", description='").append(description);
        sb.append('}');
        return sb.toString();
    }
}