package net.javaguides.springboot.model;

import javax.persistence.*;

@Entity
@Table(name = "pieces")
public class Piece {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(nullable=false)
    public String startdate;

    public String enddate;

    @ManyToOne
    @JoinColumn(name = "itemid")
    public Item item;

    @ManyToOne
    @JoinColumn(name = "engineerid")
    public Employee employee;

    public String status;

    public Piece() {
    }

    public Piece(String startdate, String enddate, Item item, Employee employee, String status) {

        this.startdate = startdate;
        this.enddate = enddate;
        this.item = item;
        this.employee = employee;
        this.status = status;

    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }

    public Long getId() {
        return id;
    }

    public String getStartdate() {
        return startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public Item getItem(){
        return item;
    }

    public Employee getEmployee(){
        return employee;
    }

    public void setEmployee(Employee employee){
        this.employee = employee;
    }

    public void setItem(Item item){
        this.item = item;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Transaction{");
        sb.append("id=").append(id);
        sb.append(", start String='").append(startdate).append('\'');
        sb.append(", end String=").append(enddate);
        sb.append('}');
        return sb.toString();
    }
}