package com.syed.accountexample.domain;

import javax.persistence.*;

@Entity
public class AccountDB {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String first_name;
    private String last_name;
    private int account_number;

    public AccountDB(){}

    public AccountDB(String first_name, String last_name, int account_number) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.account_number = account_number;
    }

    public String getFirst_name() {
        return first_name;

    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getAccount_number() {
        return account_number;
    }

    public void setAccount_number(int account_number) {
        this.account_number = account_number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AccountDB{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", account_number=" + account_number +
                '}';
    }
}
