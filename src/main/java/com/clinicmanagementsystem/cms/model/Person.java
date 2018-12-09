package com.clinicmanagementsystem.cms.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Person extends Auditable {

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    private String pesel;

    private String emailAddress;

    private String phoneNumber;
}
