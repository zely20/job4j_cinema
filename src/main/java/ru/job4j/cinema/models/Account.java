package ru.job4j.cinema.models;

import java.util.Objects;

public class Account {

    private Integer id;
    private String userName;
    private String email;
    private String phone;
    private Ticket ticket;

    public Account(Integer id, String userName, String email, String phone, Ticket ticket) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.ticket = ticket;
    }

    public Account() {
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) &&
                Objects.equals(userName, account.userName) &&
                Objects.equals(email, account.email) &&
                Objects.equals(phone, account.phone) &&
                Objects.equals(ticket, account.ticket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, email, phone, ticket);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", ticket=" + ticket +
                '}';
    }
}
