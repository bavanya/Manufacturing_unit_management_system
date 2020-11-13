package net.javaguides.springboot.dao;
import java.util.*;
import javax.persistence.*;
import net.javaguides.springboot.model.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.Size;

public class EmployeeDao {
    
    @NotNull(message="Please fill the field")
    @Min(1)
    @Max(32)
    public String name;

    @NotNull(message="Please fill the field")
    public int monthly_salary;

    @NotNull(message="Please fill the field")
    @Min(1)
    @Max(15)
    public String designation;

    @NotNull(message="Please fill the field")
    @Min(1)
    @Max(15)
    public String status;

    @Pattern(regexp = "^[A-Za-z]{4}0[A-za-z0-9]{6}$")
    @NotNull(message="Please fill the field")
    public String ifsccode;

    @NotNull(message="Please fill the field")
    @Min(1)
    @Max(15)
    public String bank;

    @NotNull(message="Please fill the field")
    @Min(1)
    @Max(32)
    public String branch;

    @Pattern(regexp = "^[0-9]{9}$")
    @NotNull(message="Please fill the field")
    public String micrnumber;

    public String accountnumber;


    public String getAccountnumber(){
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber){
        this.accountnumber = accountnumber;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getMonthly_salary() {
        return monthly_salary;
    }

    public void setMonthly_salary(int monthly_salary) {
        this.monthly_salary = monthly_salary;
    }

    public String getDesignation(){
        return designation;
    }

    public void setDesignation(String designation){
        this.designation = designation;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getBranch() {
        return branch;
    }

    public String getMicrnumber() {
        return micrnumber;
    }

    public String getBank() {
        return bank;
    }

    public String getIfsccode() {
        return ifsccode;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setMicrnumber(String micrnumber) {
        this.micrnumber = micrnumber;
    }

    public void setIfsccode(String ifsccode) {
        this.ifsccode = ifsccode;
    }


}