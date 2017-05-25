package com.yana.home.persistence.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Admin on 10.05.2017.
 */
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String name;
    private  double amount;
    private  String icon;
    @ManyToOne
@JsonIgnore
    private  Currency currency;
    @ManyToOne
    @JsonIgnore
    private User user;
    @OneToMany(mappedBy = "accountFrom", fetch = FetchType.EAGER )
    private List<Spending> spendings;
    @OneToMany(mappedBy = "accountTo",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private  List<Income> incomes;

    public Account(String name, double amount, String icon) {
        this.name = name;
        this.amount = amount;
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Account(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public Account(String name, double amount,String icon, Currency currency) {
        this.name = name;
        this.amount = amount;
        this.icon= icon;
        this.currency = currency;
    }

    public Account() {
    }

    public Account(String name, double amount, String icon, Currency currency, User user) {
        this.name = name;
        this.amount = amount;
        this.icon = icon;
        this.currency = currency;
        this.user = user;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Spending> getSpendings() {
        return spendings;
    }

    public void setSpendings(List<Spending> spendings) {
        this.spendings = spendings;
    }

    public List<Income> getIncomes() {
        return incomes;
    }

    public void setIncomes(List<Income> incomes) {
        this.incomes = incomes;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", icon='" + icon + '\'' +



                '}';
    }
}
