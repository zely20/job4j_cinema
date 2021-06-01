package ru.job4j.cinema.models;

import java.util.Objects;

public class Place {

    private Integer place;
    private Integer row;

    public Place(Integer place, Integer row) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place1 = (Place) o;
        return Objects.equals(place, place1.place) && Objects.equals(row, place1.row);
    }

    @Override
    public int hashCode() {
        return Objects.hash(place, row);
    }

    @Override
    public String toString() {
        return "place=" + place +
                ", row=" + row;
    }
}
