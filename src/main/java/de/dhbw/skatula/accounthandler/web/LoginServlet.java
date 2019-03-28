/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.skatula.accounthandler.web;

import de.dhbw.skatula.accounthandler.ejb.KundeBean;
import de.dhbw.skatula.accounthandler.ejb.TrainerBean;
import de.dhbw.skatula.accounthandler.jpa.Kunde;
import de.dhbw.skatula.accounthandler.jpa.Trainer;
import de.dhbw.skatula.enums.ResponseStatus;
import de.dhbw.skatula.helper.Response;
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
 * @author Benjamin Kanzler
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    public static final String URL = "login";

    @EJB
    protected KundeBean kundeBean;

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
        request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
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
        Response<Kunde> kunde;
        Response<Trainer> trainer;
        if (nutzertyp == 1) {
            kunde = kundeBean.findByNick(nickname);
            if (password.equals(kunde.getResponse().getPasswort())) {
                kunde.setMessage("Sie sind erfolgreich angemeldet");
                session.setAttribute("nutzertyp", "kunde");
            } else {
                kunde.setResponse(null);
                kunde.setStatus(ResponseStatus.ERROR);
                kunde.setMessage("Das Passwort stimmt nicht mit dem Nutzer überein");
            }
            session.setAttribute("nutzer", kunde);
        } else if (nutzertyp == 2) {
            trainer = trainerBean.findByNick(nickname);
            if (password.equals(trainer.getResponse().getPasswort())) {
                trainer.setMessage("Sie sind erfolgreich angemeldet");
                session.setAttribute("nutzertyp", "trainer");
            }
            session.setAttribute("nutzer", trainer);
        }
        response.sendRedirect(request.getContextPath() + IndexServlet.URL);
    }
}
