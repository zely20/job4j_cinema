package ru.job4j.cinema.servlets;

import org.json.JSONObject;
import ru.job4j.cinema.models.Ticket;
import ru.job4j.cinema.store.PsqlStoreImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PayServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            String name = req.getParameter("username");
            String phone = req.getParameter("phone");
            Integer row = Integer.valueOf(req.getParameter("r"));
            Integer place = Integer.valueOf(req.getParameter("p"));
            Ticket savedTicket = PsqlStoreImpl.instOf().saveTicket(new Ticket(row, place));
            if(savedTicket.getId() != 0) {
            JSONObject json = new JSONObject();
            json.put("answer", "Вы купили билет ряд " + savedTicket.getRow() + " место " + savedTicket.getPlace());
            PrintWriter writer = new PrintWriter(resp.getOutputStream());
            writer.println(json.toString());
            writer.flush();
        }
    }
}
