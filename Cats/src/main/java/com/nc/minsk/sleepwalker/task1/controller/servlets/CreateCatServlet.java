package com.nc.minsk.sleepwalker.task1.controller.servlets;

import com.nc.minsk.sleepwalker.task1.model.entity.Cat;
import com.nc.minsk.sleepwalker.task1.model.entity.Sex;
import com.nc.minsk.sleepwalker.task1.service.CatService;
import com.nc.minsk.sleepwalker.task1.service.CatServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create")
public class CreateCatServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("createButton") != null) {
            Cat cat = new Cat();
            cat.setNickname(request.getParameter("nickname"));
            cat.setSex(Sex.valueOf(request.getParameter("sex")));
            cat.setColor(request.getParameter("color"));
            cat.setAge(Integer.parseInt(request.getParameter("age")));
            cat.setMotherId(Integer.parseInt(request.getParameter("motherId")));
            cat.setFatherId(Integer.parseInt(request.getParameter("fatherId")));
            try (CatService catService = new CatServiceImpl()) {
                String id = request.getParameter("id");
                if ("generated".equals(id)) {
                    catService.save(cat);
                    response.sendRedirect("/cats");
                } else {
                    cat.setId(Integer.parseInt(id));
                    catService.change(cat);
                    response.sendRedirect("/cats/getAll");
                }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/create.jsp").forward(request, response);
    }
}
