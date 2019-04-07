/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.skatula.terminverwaltung.web;

import de.dhbw.skatula.accounthandler.jpa.Trainer;
import de.dhbw.skatula.helper.Response;
import de.dhbw.skatula.terminverwaltung.ejb.TerminBean;
import de.dhbw.skatula.kursverwaltung.ejb.KursBean;
import de.dhbw.skatula.terminverwaltung.jpa.Termin;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author f_lieb
 */
@WebServlet(name = "TerminAnlegen", urlPatterns = {"/terminAnlegen"})
public class TerminAnlegenServlet extends HttpServlet {

    public final static String URL = "/terminAnlegen";

    @EJB
    protected TerminBean terminBean;

    @EJB
    protected KursBean kursBean;

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/terminAnlegen.jsp").forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String nutzertyp = (String) session.getAttribute("nutzertyp");
        Response<Trainer> trainer = (Response<Trainer>) session.getAttribute("nutzer");
        Termin termin = new Termin();
        System.out.println("Datum: " + request.getParameter("datum"));
        System.out.println("Zeit: " + request.getParameter("time"));
        try {
            termin.setDatum(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("datum")));
            termin.setTime(new SimpleDateFormat("hh:mm").parse(request.getParameter("time")));
        } catch (Exception ex) {

        }
        
        termin.setDauer(Integer.parseInt(request.getParameter("dauer")));

        termin.setKurs(kursBean.findById(Long.parseLong(request.getParameter("kurs"))).getResponse());
        // Auslesen
        //termin.set(Bean.findById(Long.parseLong(request.getParameter("trainer"))).getResponse());
        terminBean.createNewTermin(termin);

        response.sendRedirect(request.getContextPath() + TerminuebersichtServlet.URL);
    }
}
