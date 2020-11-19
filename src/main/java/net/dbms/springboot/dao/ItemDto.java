package net.javaguides.springboot.dao;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ItemDto {

    @Size(min=1, max=15, message="Name must be between 1 and 32 characters")
    @NotNull(message="Please enter the Item's name")
    public String name;

    public int quantity;

    @Size(min=1, max=32, message="Description must be between 1 and 32 characters")
    @NotNull(message="Please enter the Item's name")
    public String description;

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
}