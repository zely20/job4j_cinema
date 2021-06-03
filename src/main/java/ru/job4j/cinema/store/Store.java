package ru.job4j.cinema.store;

import ru.job4j.cinema.models.Ticket;

import java.util.List;

public interface Store {

    List<Ticket> findAllTicket();

    Ticket saveTicket(Ticket ticket);
}
