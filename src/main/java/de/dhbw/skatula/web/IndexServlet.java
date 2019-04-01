/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.skatula.web;

import de.dhbw.skatula.enums.ResponseStatus;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MoritzKuttler
 */
@WebServlet(urlPatterns = {"/index", "/index.html"}, name = "IndexServlet")
public class IndexServlet extends HttpServlet {

    public static final String URL = "/";

    private ResponseStatus responseStatus;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("responseStatus") == null) {
            session.setAttribute("responseStatus", responseStatus.values());
        }
        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
    }
}
