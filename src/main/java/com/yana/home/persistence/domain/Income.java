package com.yana.home.persistence.domain;


        import com.fasterxml.jackson.annotation.JsonIgnore;

        import javax.persistence.*;
        import java.util.Date;


/**
 * Created by Admin on 10.05.2017.
 */
@Entity
public class Income {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private  double amount;
    private String description;
 @Temporal(TemporalType.DATE)
    private Date date;
 @JsonIgnore
    @ManyToOne
    private  Account accountTo;
 @JsonIgnore
    @ManyToOne
    private User user;

    public Income(String description, Date date, Account accountTo) {
        this.description = description;
        this.date = date;
        this.accountTo = accountTo;
    }

    public Income(double amount, String description) {
        this.amount = amount;
        this.description = description;
    }

    public Income(double amount, String description, Date date, Account accountTo, User user) {
        this.amount = amount;
        this.description = description;
        this.date = date;
        this.accountTo = accountTo;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Income() {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Account getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(Account accountTo) {
        this.accountTo = accountTo;
    }



    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    @Override
    public String toString() {
        return "Income{" +
                "id=" + id +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", date=" + date +

                '}';
    }
}
