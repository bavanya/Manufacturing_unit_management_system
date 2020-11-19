package net.javaguides.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.*;
import javax.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "item_requirements")
public class ItemMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public int quantity;

    @ManyToOne
    @JoinColumn(name = "itemid")
    public Item item;

    @ManyToOne
    @JoinColumn(name = "materialid")
    public Material material;


    public ItemMaterial() {
    }

    public ItemMaterial(int quantity, Material material, Item item) {

        this.quantity = quantity;
        this.material = material;
        this.item = item;
    }

    public Long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Material getMaterial() {
        return material;
    }

    public Item getItem() {
        return item;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + this.quantity;
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
        final ItemMaterial other = (ItemMaterial) obj;
        if (this.quantity != other.quantity) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Item{");
        sb.append("id=").append(id).append('\'');
        sb.append(", quantity=").append(quantity);
        sb.append('}');
        return sb.toString();
    }
}