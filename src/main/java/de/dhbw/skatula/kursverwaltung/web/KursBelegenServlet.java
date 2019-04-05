/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.skatula.kursverwaltung.web;

import de.dhbw.skatula.accounthandler.ejb.KundeBean;
import de.dhbw.skatula.accounthandler.jpa.Kunde;
import de.dhbw.skatula.enums.Schwierigkeitsgrad;
import de.dhbw.skatula.helper.Response;
import de.dhbw.skatula.kursverwaltung.ejb.KursBean;
import de.dhbw.skatula.kursverwaltung.jpa.Kurs;
import de.dhbw.skatula.web.IndexServlet;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.ejb.EJB;
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
@WebServlet(name = "KursBelegenServlet", urlPatterns = {"/kursBelegen/*"})
public class KursBelegenServlet extends HttpServlet {

    Schwierigkeitsgrad sg;

    @EJB
    protected KursBean kursBean;
    
    @EJB
    protected KundeBean kundeBean;

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

        Schwierigkeitsgrad[] sgList = sg.values();
        request.setAttribute("schwierigkeitsgrad", sgList);

        long id = -1;
        String pathInfo = request.getPathInfo();

        if (pathInfo != null && pathInfo.length() > 2) {
            try {
                id = Long.parseLong(pathInfo.split("/")[pathInfo.split("/").length - 1]);
                Response<Kurs> kurs = kursBean.findById(id);
                request.setAttribute("kurs", kurs);
                request.getRequestDispatcher("/WEB-INF/kursBelegen.jsp").forward(request, response);
                return;
            } catch (NumberFormatException ex) {
                // request.setAttribute("kurs", null);
                // URL enthält keine gültige Long-Zahl
            }
        }
        response.sendRedirect(request.getContextPath() + IndexServlet.URL);
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
        if (session.getAttribute("nutzertyp") == "kunde") {
            //Kunde aus der Session lesen
            Response<Kunde> kunde = (Response<Kunde>) session.getAttribute("nutzer");
            kunde = kundeBean.findById(kunde.getResponse().getId());
            long id = -1;
            String pathInfo = request.getPathInfo();

            if (pathInfo != null && pathInfo.length() > 2) {
                try {
                    id = Long.parseLong(pathInfo.split("/")[pathInfo.split("/").length - 1]);
                    Response<Kurs> kurs = kursBean.findById(id);
                    if (kurs.getResponse().getTeilnehmer() == null) {
                        Set<Kunde> teilnehmer = new HashSet<>();
                        teilnehmer.add(kunde.getResponse());
                        kurs.getResponse().setTeilnehmer(teilnehmer);
                        if(kunde.getResponse().getKurse() == null){
                            kunde.getResponse().setKurse(new HashSet<Kurs>());
                        }
                        kunde.getResponse().getKurse().add(kurs.getResponse());
                        kundeBean.updateKunde(kunde.getResponse());
                    } else {
                        kurs.getResponse().getTeilnehmer().add(kunde.getResponse());
                    }
                    kurs.getResponse().setAktuelleTeilnehmerzahl(kurs.getResponse().getAktuelleTeilnehmerzahl()+1);
                    kurs = kursBean.updateKurs(kurs.getResponse());
                } catch (NumberFormatException ex) {
                    // request.setAttribute("kurs", null);
                    // URL enthält keine gültige Long-Zahl
                }
            }

        }
        response.sendRedirect(request.getContextPath() + KursuebersichtServlet.URL);

    }

}
