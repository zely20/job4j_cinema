package ru.job4j.cinema.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.job4j.cinema.models.Place;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "/hall")
public class HallServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Place> occupiedPlaces = List.of(new Place(1, 1), new Place(2, 1));
        ObjectMapper mapper = new ObjectMapper();
        String string = mapper.writeValueAsString(occupiedPlaces);
        System.out.println(string);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("json");
        resp.getWriter().write(string);
    }
}
