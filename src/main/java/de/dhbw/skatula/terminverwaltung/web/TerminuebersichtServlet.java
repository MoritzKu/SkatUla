/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.skatula.terminverwaltung.web;

import de.dhbw.skatula.accounthandler.jpa.Kunde;
import de.dhbw.skatula.accounthandler.jpa.Trainer;
import de.dhbw.skatula.helper.Response;
import de.dhbw.skatula.jpa.KursKunde;
import de.dhbw.skatula.terminverwaltung.ejb.TerminBean;
import de.dhbw.skatula.terminverwaltung.jpa.Termin;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "TerminuebersichtServlet", urlPatterns = {"/terminuebersicht"})
public class TerminuebersichtServlet extends HttpServlet {

    public static final String URL = "/terminuebersicht";

    @EJB
    protected TerminBean terminBean;

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

        HttpSession session = request.getSession();
        Response<Termin> termin = terminBean.findAll();
        String nutzertyp = (String) session.getAttribute("nutzertyp");
        if (nutzertyp.equals("kunde")) {
            Response<Kunde> resK = new Response<>();
            resK = (Response<Kunde>) session.getAttribute("nutzer");
            List<Termin> terminList = new ArrayList<>();
            for (Termin t : termin.getResponseList()) {
                for (KursKunde kk : t.getKurs().getKursKunde()) {
                    if (kk.getKunde().getId() == resK.getResponse().getId()) {
                        terminList.add(t);
                    }
                }
            }
            termin.setResponseList(terminList);
        } else if (nutzertyp.equals("trainer")) {
            Response<Trainer> rest = new Response<>();
            rest = (Response<Trainer>) session.getAttribute("nutzer");
            List<Termin> terminList = new ArrayList<>();
            for (Termin t : termin.getResponseList()) {
                if (t.getKurs().getTrainer().getId() == rest.getResponse().getId()) {
                    terminList.add(t);
                }
            }
            termin.setResponseList(terminList);

        } else {
            termin.setResponseList(null);
        }
        request.setAttribute("terminList", termin);

        request.getRequestDispatcher("WEB-INF/terminuebersicht.jsp").forward(request, response);
    }

}
