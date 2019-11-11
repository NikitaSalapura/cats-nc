package com.nc.minsk.sleepwalker.task1.controller.servlets;

import com.nc.minsk.sleepwalker.task1.model.entity.Cat;
import com.nc.minsk.sleepwalker.task1.model.entity.Container;
import com.nc.minsk.sleepwalker.task1.service.CatService;
import com.nc.minsk.sleepwalker.task1.service.CatServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("searchButton") != null) {
            Container<Cat> container = new Container<>();
            String field = request.getParameter("field");
            try (CatService catService = new CatServiceImpl()) {
                String value = request.getParameter("value");
                if ("id".equals(field)) {
                    container.add(catService.getById(Integer.parseInt(value)));
                } else if ("nickname".equals(field)) {
                    container = catService.getByName(value);
                } else if ("color".equals(field)) {

                    container = catService.getByColor(value);
                } else if ("age".equals(field)) {

                    container = catService.getByAge(Integer.parseInt(value));
                }
            }
            request.setAttribute("container", container);
        }
        getServletContext().getRequestDispatcher("/jsp/search.jsp").forward(request, response);
    }
}
