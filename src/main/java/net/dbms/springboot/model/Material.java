package net.javaguides.springboot.model;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "materials")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(unique=true, nullable=false)
    public String name;

    public int quantity;

    @Column(unique=true)
    public String description;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<Purchaseorder> purchaseorders = new HashSet<>();

    @OneToMany(mappedBy = "material", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<ItemMaterial> itemmaterials = new HashSet<>();

    public Material() {
    }

    public Material(String name, String description, int quantity) {

        this.name = name;
        this.quantity = quantity;
        this.description = description;
    }

    public void setPurchaseorders(Set<Purchaseorder> itemmaterials){
        this.purchaseorders = itemmaterials;
    }

    public Set<Purchaseorder> getPurchaseorders(){
        return purchaseorders;
    }

    public void setItemmaterials(Set<ItemMaterial> itemmaterials){
        this.itemmaterials = itemmaterials;
    }

    public Set<ItemMaterial> getItemmaterials(){
        return itemmaterials;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.description);
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
        final Material other = (Material) obj;
        if (this.quantity != other.quantity) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Material{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", quantity=").append(quantity);
        sb.append('}');
        return sb.toString();
    }
}