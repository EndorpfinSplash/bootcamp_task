package com.bootcamp.userendpoint.controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({"ФИО", "Email", "Role"})
public class UserDto {

    private long id;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY , value = "Фамилия")
    private String surname;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY, value = "Имя")
    private String name;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY, value = "Отчество")
    private String patronymic;
    @JsonProperty("Email")
    private String email;
    @JsonProperty("Role")
    private String role;


    @JsonProperty(value = "ФИО")
    public String getFIO() {
        return surname + ' ' + name + ' ' + patronymic;
    }

    public UserDto() {
    }


    @JsonIgnore
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonIgnore
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @JsonIgnore
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
