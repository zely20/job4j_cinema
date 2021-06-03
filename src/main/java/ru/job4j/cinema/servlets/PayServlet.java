package ru.job4j.cinema.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PayServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            String name = req.getParameter("username");
            System.out.println(name);
            String phone = req.getParameter("phone");
            System.out.println(phone);
            Integer row = Integer.valueOf(req.getParameter("row"));
            System.out.println(row);
            Integer place = Integer.valueOf(req.getParameter("place"));
            System.out.println(place);
            resp.sendRedirect(req.getContextPath());
    }
}
