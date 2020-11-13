package net.javaguides.springboot.model;

import java.sql.Date;
import javax.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public int debit;
    public int credit;
    public String transaction_date;

    @ManyToOne
    @JoinColumn(name = "bankid")
    public Bank bank;

    @OneToOne(fetch = FetchType.LAZY,
    cascade =  CascadeType.ALL,
    mappedBy = "transaction")
    public Miscellaneoustransfer miscellaneoustransfer;

    @OneToOne(fetch = FetchType.LAZY,
    cascade =  CascadeType.ALL,
    mappedBy = "transaction")
    public Clientorder clientorder;

    @OneToOne(fetch = FetchType.LAZY,
    cascade =  CascadeType.ALL,
    mappedBy = "transaction")
    public Purchaseorder Purchaseorder;

    public Transaction() {
    }

    public Transaction(String transaction_date, int debit, int credit, Bank bank) {

        this.transaction_date = transaction_date;
        this.debit = debit;
        this.credit = credit;
        this.bank = bank;

    }

    public Long getId() {
        return id;
    }


    public String getTransaction_date() {
        return transaction_date;
    }

    public int getDebit() {
        return debit;
    }

    public int getCredit() {
        return credit;
    }

    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
    }

    public void setDebit(int debit) {
        this.debit = debit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Transaction{");
        sb.append("id=").append(id);
        sb.append(", date='").append(transaction_date).append('\'');
        sb.append(", debit=").append(debit).append('\'');
        sb.append(", credit=").append(credit);
        sb.append('}');
        return sb.toString();
    }
}