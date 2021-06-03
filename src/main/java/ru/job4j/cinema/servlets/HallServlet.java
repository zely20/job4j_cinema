package ru.job4j.cinema.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.job4j.cinema.models.Ticket;
import ru.job4j.cinema.store.PsqlStoreImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HallServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Ticket> occupiedTickets = PsqlStoreImpl.instOf().findAllTicket();
        ObjectMapper mapper = new ObjectMapper();
        String string = mapper.writeValueAsString(occupiedTickets);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.getWriter().write(string);
    }
}
