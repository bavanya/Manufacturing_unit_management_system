package net.javaguides.springboot.dao;
import java.sql.Date;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.Size;

public class ClientOrderDto {

    @NotNull(message="Please fill the field")
    @Min(1)
    @Max(32)
    public String employee_name;

    @NotNull(message="Please fill the field")
    public int debit;

    @NotNull(message="Please fill the field")
    public int credit;

    @NotNull(message="Please fill the field")
    @Pattern(regexp = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$")
    public String transaction_date;

    @NotNull(message="Please fill the field")
    public int rupees_per_unit;

    @NotNull(message="Please fill the field")
    public int quantity_in_units;

    @NotNull(message="Please fill the field")
    @Min(1)
    @Max(32)
    public String material_name;

    public int getQuantity_in_units() {
        return quantity_in_units;
    }

    public void setQuantity_in_units(int quantity_in_units) {
        this.quantity_in_units = quantity_in_units;
    }

    public int getRupees_per_unit() {
        return rupees_per_unit;
    }

    public void setRupees_per_unit(int rupees_per_unit) {
        this.rupees_per_unit = rupees_per_unit;
    }

    public String getMaterial_name(){
        return material_name;
    }

    public void setMaterial_name(String material_name){
        this.material_name = material_name;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
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

}