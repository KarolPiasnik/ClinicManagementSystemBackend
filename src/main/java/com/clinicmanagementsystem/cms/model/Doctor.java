package com.clinicmanagementsystem.cms.model;

import com.clinicmanagementsystem.cms.model.enums.DoctorFunctionEnum;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document(collection = "user")
@TypeAlias("doctor")
public class Doctor extends User {

    public DoctorFunctionEnum getFunction() {
        return function;
    }

    public void setFunction(DoctorFunctionEnum function) {
        this.function = function;
    }

    @NotBlank
    private DoctorFunctionEnum function;

}
