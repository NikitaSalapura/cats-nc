package com.nc.minsk.sleepwalker.task1.controller.servlets;

import com.nc.minsk.sleepwalker.task1.service.CatService;
import com.nc.minsk.sleepwalker.task1.service.CatServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (CatService catService = new CatServiceImpl()) {
            catService.remove(Integer.parseInt(request.getParameter("id")));
        }
        getServletContext().getRequestDispatcher("/getAll").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/delete.jsp").forward(request, response);
    }
}
