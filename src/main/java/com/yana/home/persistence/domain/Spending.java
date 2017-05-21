package com.yana.home.persistence.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;


/**
 * Created by Admin on 10.05.2017.
 */
@Entity
public class Spending {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String description;
    private  double amount;
    @Temporal(TemporalType.DATE)
    private Date date;
    @JsonIgnore
    @ManyToOne
    private Category category;
    @JsonIgnore
    @ManyToOne
    private Account accountFrom;
    @JsonIgnore
    @ManyToOne
    private User user;

    public Spending(String description, double amount, Date date,  Account accountFrom) {
        this.description = description;
        this.amount = amount;
        this.date = date;

        this.accountFrom = accountFrom;
    }

    public Spending(String description, double amount, Date date, Category category, Account accountFrom, User user) {
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.category = category;
        this.accountFrom = accountFrom;
        this.user = user;
    }

    public Spending() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public Account getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(Account accountFrom) {
        this.accountFrom = accountFrom;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Spending{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", category=" + category +
                ", accountFrom=" + accountFrom +
                '}';
    }
}
