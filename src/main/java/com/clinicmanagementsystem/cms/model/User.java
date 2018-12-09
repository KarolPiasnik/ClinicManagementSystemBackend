package com.clinicmanagementsystem.cms.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Document
public class User extends Auditable implements UserDetails {
    @JsonSerialize(using = ToStringSerializer.class)
    @Id
    ObjectId id;

    private  Person personalInfo;

    private List<SimpleGrantedAuthority> authorities;

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    private Boolean active;

    @NotBlank
    private String password;

    @NotBlank
    @Indexed(unique = true)
    private String username;

    @NotBlank
    @Indexed(unique = true)
    private String email;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Person getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(Person personalInfo) {
        this.personalInfo = personalInfo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<SimpleGrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<SimpleGrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public User(String username, String password, List<SimpleGrantedAuthority> authorities){
       super();
       this.username = username;
       this.authorities = authorities;
       this.password = password;
    }
}
