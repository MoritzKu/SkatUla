/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.skatula.accounthandler.web;

import de.dhbw.skatula.accounthandler.ejb.TrainerBean;
import de.dhbw.skatula.accounthandler.jpa.Kunde;
import de.dhbw.skatula.accounthandler.jpa.Trainer;
import de.dhbw.skatula.enums.ResponseStatus;
import de.dhbw.skatula.helper.Response;
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
 * @author Benjamin Kanzler
 */
@WebServlet(name = "Registrieren", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    public static final String URL = "/register";

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
        request.getRequestDispatcher("WEB-INF/register.jsp").forward(request, response);
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

        String nickname = request.getParameter("nickname");
        String password = request.getParameter("password");
        Integer nutzertyp = Integer.parseInt(request.getParameter("nutzertyp"));
        Response<Kunde> kunde = new Response<>();
        Response<Trainer> trainer = new Response<>();
        if (nutzertyp == 1) {
            Kunde k = new Kunde();
            k.setUsername(nickname);
            k.setPasswort(password);
            session.setAttribute("nutzer", kunde);
        } else if (nutzertyp == 2) {
            Trainer t = new Trainer();
            t.setUsername(nickname);
            t.setPasswort(password);
            createMitarbeiterNo(t);
            session.setAttribute("nutzer", trainer);
        }
    }

    private void createMitarbeiterNo(Trainer t) {
        Double d = Math.random();
        Integer mitNo = (int) (d * 10000);
        String mitarbeiterNr = "tr" + mitNo;
        Response<Trainer> resT = trainerBean.findByMitarbeiterNr(mitarbeiterNr);
        if (resT.getStatus() == ResponseStatus.ERFOLGREICH) {
            createMitarbeiterNo(t);
        } else {
            t.setMitarbeiterNr(mitarbeiterNr);
        }
    }
}
