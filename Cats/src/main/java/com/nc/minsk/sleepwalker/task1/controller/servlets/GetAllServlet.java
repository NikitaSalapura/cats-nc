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

@WebServlet("/getAll")
public class GetAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String choice = request.getParameter("choice");
        int id = Integer.parseInt(choice);
        try (CatService catService = new CatServiceImpl()) {
            if (request.getParameter("deleteButton") != null) {
                catService.remove(id);
                doGet(request, response);
            } else if (request.getParameter("updateButton") != null) {
                request.setAttribute("id", choice);
//                response.sendRedirect("/cats/create");
//                response.sendRedirect("/cats/jsp/create.jsp");
                getServletContext().getRequestDispatcher("/jsp/create.jsp").forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (CatService catService = new CatServiceImpl()) {
            Container<Cat> all = catService.getAll();
            request.setAttribute("container", all);
            getServletContext().getRequestDispatcher("/jsp/getAll.jsp").forward(request, response);

//            for (Cat cat : all) {
//                printWriter.println("<h2>" + cat + "</h2>");
//            }
        }
    }
}

