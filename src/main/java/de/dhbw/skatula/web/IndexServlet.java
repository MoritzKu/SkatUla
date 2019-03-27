/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.skatula.web;

import de.dhbw.skatula.accounthandler.ejb.KundeBean;
import de.dhbw.skatula.helper.Response;
import de.dhbw.skatula.accounthandler.jpa.Kunde;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MoritzKuttler
 */
@WebServlet(urlPatterns = {"/", "/index", "/index.html"}, name = "IndexServlet")
public class IndexServlet extends HttpServlet {

    public static final String URL = "/";

    @EJB
    protected KundeBean kundeBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Response<Kunde> k = new Response<>();
        k.setResponse(new Kunde());
        request.setAttribute("kunde", k);
        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
    }
}
