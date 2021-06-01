package ru.job4j.cinema.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.job4j.cinema.models.Ticket;

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
        Ticket ticket1 = new Ticket(1, 1);
        Ticket ticket2 = new Ticket(2, 1);
        List<Ticket> occupiedTickets = new ArrayList<>(0);
        occupiedTickets.add(ticket1);
        occupiedTickets.add(ticket2);
        ObjectMapper mapper = new ObjectMapper();
        String string = mapper.writeValueAsString(occupiedTickets);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.getWriter().write(string);
    }
}
