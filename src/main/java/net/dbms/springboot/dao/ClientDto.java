package net.javaguides.springboot.dao;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import net.javaguides.springboot.model.Firm;

public class ClientDto{

    @NotNull(message="Please fill the field")
    @Pattern(regexp = "^[0-9]{3}-[0-9]{3}-[0-9]{4}$")
    public String contactnumber;

    @NotNull(message="Please fill the field")
    @Min(1)
    @Max(100)
    public String address;

    @NotNull(message="Please fill the field")
    @Min(1)
    @Max(15)
    public String name;

    @Pattern(regexp = "^[LU]{1}[0-9]{5}[A-Z]{2}[0-9]{4}[A-Z]{3}[0-9]{6}$")
    @NotNull(message="Please fill the field")
    public String registrationnumber;

    @Pattern(regexp = "^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Za-z]{1}[0-9]{1}[A-Za-z]{1}[0-9]{1}$")
    @NotNull(message="Please fill the field")
    public String gstnumber;

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

    public String getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
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