package com.bootcamp.userendpoint.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

@Entity
@Table(name = "users",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
@JsonPropertyOrder({"ФИО", "Email", "Role"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, length = 10)
    private long id;
    @Column(name = "surname", length = 40, nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY , value = "Фамилия")
    private String surname;
    @Column(name = "name", length = 20, nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY, value = "Имя")
    private String name;
    @Column(name = "patronymic", length = 40, nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY, value = "Отчество")
    private String patronymic;
    @Column(name = "email", length = 50, nullable = false, unique = true)
    @JsonProperty("Email")
    private String email;
    @Column(name = "role", length = 50, nullable = false)
    @JsonProperty("Role")
    private String role;


    @JsonProperty(value = "ФИО")
    public String getFIO() {
        return surname + ' ' + name + ' ' + patronymic;
    }

    public User() {
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
