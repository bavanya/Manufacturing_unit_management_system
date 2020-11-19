package net.javaguides.springboot.dao;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RelationDto {

    public Long item_id;
    public Long material_id;

    public int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getItem_Id() {
        return item_id;
      }
    
      public void setItem_Id(long item_id) {
        this.item_id = item_id;
      }

      public long getMaterial_Id() {
        return material_id;
      }
    
      public void setMaterial_Id(long material_id) {
        this.material_id = material_id;
      }
}
