package com.bootcamp.userendpoint.model;

public enum Role {

    ADMINISTRATOR("Administrator"),
    SALE_USER("Sale User"),
    CUSTOMER_USER("Customer User"),
    SECURE_API_USER("Secure API User");

    private String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
