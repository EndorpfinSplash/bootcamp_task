package com.bootcamp.userendpoint.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, length = 10)
    private long id;
    @Column(name = "surname", length = 40, nullable = false)
    private String surname;
    @Column(name = "name", length = 20, nullable = false)
    private String name;
    @Column(name = "patronymic", length = 40, nullable = false)
    private String patronymic;
    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;
    @Column(name = "role", length = 50, nullable = false)
    private String role;


    public String getFIO() {
        return surname + ' ' + name + ' ' + patronymic;
    }

    public UserEntity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
