package ru.job4j.cinema.models;

import java.util.Objects;

public class Ticket {

    private Integer id;
    private Integer session_id = 1;
    private Integer place;
    private Integer row;
    private Integer account_id = 1;

    public Ticket(Integer place, Integer row) {
        this.place = place;
        this.row = row;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSession_id() {
        return session_id;
    }

    public void setSession_id(Integer session_id) {
        this.session_id = session_id;
    }

    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id) &&
                Objects.equals(session_id, ticket.session_id) &&
                Objects.equals(place, ticket.place) &&
                Objects.equals(row, ticket.row);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, session_id, place, row);
    }

    @Override
    public String toString() {
        return "place=" + place +
                ", row=" + row;
    }
}
