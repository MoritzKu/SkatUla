/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.skatula.kursverwaltung.web;

import de.dhbw.skatula.accounthandler.ejb.TrainerBean;
import de.dhbw.skatula.accounthandler.jpa.Trainer;
import de.dhbw.skatula.enums.Schwierigkeitsgrad;
import de.dhbw.skatula.helper.Response;
import de.dhbw.skatula.kursverwaltung.ejb.KursBean;
import de.dhbw.skatula.kursverwaltung.jpa.Kurs;
import de.dhbw.skatula.web.IndexServlet;
import java.io.IOException;
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
@WebServlet(name = "KursAnlegen", urlPatterns = {"/kursAnlegen"})
public class KursAnlegenServlvet extends HttpServlet {

    Schwierigkeitsgrad sg;

    public final static String URL = "/kursAnlegen";

    @EJB
    protected KursBean kursBean;

    @EJB
    protected TrainerBean trainerBean;

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

        Response<Trainer> trainer = trainerBean.findAll();
        for (Trainer t : trainer.getResponseList()) {
            t.setPasswort(null);
            t.setSalt(null);
        }
        request.setAttribute("trainerList", trainer.getResponseList());

        request.getRequestDispatcher("WEB-INF/kursAnlegen.jsp").forward(request, response);
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
        Kurs kurs = new Kurs();
        kurs.setBezeichnung(request.getParameter("bezeichnung"));
        kurs.setMaxTeilnehmer(Integer.parseInt(request.getParameter("maxTeilnehmer")));
        //kurs.setSchwierigkeitsgrad(request.getParameter("schwierigkeitsgrad"));
        kurs.setTrainer(trainer.getResponse());
        Response<Kurs> kursResponse = kursBean.createNewKurs(kurs);
        // Auslesen
        kurs.setSchwierigkeitsgrad(Enum.valueOf(Schwierigkeitsgrad.class, request.getParameter("schwierigkeitsgrad")));
        kurs.setTrainer(trainerBean.findById(Long.parseLong(request.getParameter("trainer"))).getResponse());
        kursBean.createNewKurs(kurs);
        
        response.sendRedirect(request.getContextPath() + KursuebersichtServlet.URL);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
