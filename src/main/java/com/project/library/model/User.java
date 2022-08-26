package com.project.library.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue
    @NotBlank
    @Column(name = "user_id")
    private Long id;

    @NotBlank
    @Column(name = "user_Nickname")
    private String username;

    @NotBlank
    @Column(name = "user_name")
    private String name;
    @NotBlank
    @Column(name = "user_lastname")
    private String lastname;
    @NotBlank
    @Column(name = "user_password")
    private String password;

    @NotBlank
    @Column(name = "user_role")
    private String role;

    @Column(name = "user_blocked")
    private boolean blocked;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Subscription> subscriptions;

    public User() {
        this.orders = new ArrayList<>();
        this.subscriptions = new ArrayList<>();
        this.role = "";
    }

    public User(long id, String username, String name, String lastname, String password, String role, boolean state, List<Order> orders, List<Subscription> subscriptions) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.lastname = lastname;
        this.password = password;
        this.role = role;
        this.blocked = state;
        this.orders = orders;
        this.subscriptions = subscriptions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
