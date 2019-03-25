/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.skatula.web;

import de.dhbw.skatula.ejb.KundeBean;
import de.dhbw.skatula.helper.Response;
import de.dhbw.skatula.jpa.Kunde;
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
public class IndexServlet extends HttpServlet{

    @EJB
    protected KundeBean kundeBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Kunde k = new Kunde();
        k.setUsername("Horst");
        k.setEmail("horst@test.de");
        System.out.println("Kunde vor dem schreiben: " + k);
        Response<Kunde> resK = kundeBean.createNewKunde(k);
        System.out.println("Kunde nach dem Persistieren: " + resK.getResponse());
        request.setAttribute("kunde", resK);
        
        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
    }
}
