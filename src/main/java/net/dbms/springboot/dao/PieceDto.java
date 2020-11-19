package net.javaguides.springboot.dao;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class PieceDto {

    //@Pattern(regexp="^(?=\\s*\\S).*$", message="Please select a department")
    //@Min(10)
    //@Max(40)
    //@Pattern(regexp = "^(?:(?:31(\/|-|\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-|\.)(?:0?[13-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-|\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-|\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$", message="SSN must use numbers in this format: XXX-YY-ZZZZ")
    //@Size(min=1, max=32, message="First name must be between 1 and 32 characters")

    @NotNull
    @Pattern(regexp = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$")
    public String startdate;

    @NotNull
    @Pattern(regexp = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$")
    public String enddate;

    @NotNull(message="Please fill the field")
    @Min(1)
    @Max(32)
    public String engineername;

    @NotNull(message="Please fill the field")
    @Min(1)
    @Max(15)
    public String status;

    public String getEngineername() {
        return engineername;
    }

    public void setEngineername(String engineername){
        this.engineername = engineername;
    }

    public String getStartdate(){
        return startdate;
    }

    public void setStartdate(String startdate){
        this.startdate = startdate;
    }

    public String getEnddate(){
        return enddate;
    }

    public void setEnddate(String enddate){
        this.enddate = enddate;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }

}