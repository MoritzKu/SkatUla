/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.skatula.kursverwaltung.web;

import de.dhbw.skatula.accounthandler.ejb.KundeBean;
import de.dhbw.skatula.accounthandler.jpa.Kunde;
import de.dhbw.skatula.ejb.KursKundeBean;
import de.dhbw.skatula.enums.ResponseStatus;
import de.dhbw.skatula.enums.Schwierigkeitsgrad;
import de.dhbw.skatula.helper.Response;
import de.dhbw.skatula.jpa.KursKunde;
import de.dhbw.skatula.kursverwaltung.ejb.KursBean;
import de.dhbw.skatula.kursverwaltung.jpa.Kurs;
import de.dhbw.skatula.web.IndexServlet;
import java.io.IOException;
import java.util.Date;
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

    @EJB
    protected KursKundeBean kursKundeBean;

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
            Response<Kunde> resKunde = (Response<Kunde>) session.getAttribute("nutzer");
            resKunde = kundeBean.findById(resKunde.getResponse().getId());
            long id = -1;
            String pathInfo = request.getPathInfo();

            if (pathInfo != null && pathInfo.length() > 2) {
                try {
                    id = Long.parseLong(pathInfo.split("/")[pathInfo.split("/").length - 1]);
                    Response<Kurs> resKurs = kursBean.findById(id);
                    Response<KursKunde> checkKursKunde = kursKundeBean.findByKunde(resKunde.getResponse());
                    boolean schonbelegt = false;
                    for (KursKunde tmpKursKunde : checkKursKunde.getResponseList()) {
                        if (tmpKursKunde.getKurs().equals(resKurs.getResponse())) {
                            schonbelegt = true;
                        }
                    }
                    if (!schonbelegt) {
                        KursKunde kursKunde = new KursKunde();
                        kursKunde.setZeitstempel(new Date());
                        kursKundeBean.createNewKursKunde(kursKunde, resKunde.getResponse(), resKurs.getResponse());
                        resKurs.getResponse().setAktuelleTeilnehmerzahl(resKurs.getResponse().getAktuelleTeilnehmerzahl() + 1);
                        resKurs = kursBean.updateKurs(resKurs.getResponse());
                    } else {
                        resKunde.setStatus(ResponseStatus.ERROR);
                        resKunde.setMessage("Sie haben diesen Kurs schon belegt, eine Doppelbelegung ist nicht zulässig.");
                    }
                } catch (Exception ex) {
                    resKunde.setStatus(ResponseStatus.ERROR);
                    resKunde.setException(ex.getClass().getName());
                    resKunde.setMessage(ex.getMessage());
                } finally {
                    session.setAttribute("nutzer", resKunde);
                }
            }
            response.sendRedirect(request.getContextPath() + KursuebersichtServlet.URL);
        }
    }

}
