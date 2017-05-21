package com.yana.home.persistence.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Admin on 10.05.2017.
 */

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private  String name;
    private String icon;
    private  double amount;
    @OneToMany(mappedBy = "category",fetch =FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Spending> spendingList;
    @JsonIgnore
    @ManyToOne
    private User user;




    public Category(String name, String icon) {
        this.name = name;
        this.icon = icon;
    }

    public Category(String name, String icon, User user) {
        this.name = name;
        this.icon = icon;
        this.user = user;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<Spending> getSpendingList() {
        return spendingList;
    }

    public void setSpendingList(List<Spending> spendingList) {
        this.spendingList = spendingList;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", amount=" + amount +
                ", user=" + user +
                '}';
    }
}
