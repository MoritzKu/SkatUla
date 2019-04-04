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
import de.dhbw.skatula.helper.PasswordEncryptionHelper;
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
@WebServlet(name = "ChangePasswordServlet", urlPatterns = {"/changePassword"})
public class ChangePasswordServlet extends HttpServlet {

    public static final String URL = "/changePassword";

    @EJB
    protected TrainerBean trainerBean;

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
        request.getRequestDispatcher("WEB-INF/changePassword.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method
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

        String nutzertyp = request.getParameter("nutzertyp");
        Response<Kunde> kunde = new Response<>();
        Response<Trainer> trainer = new Response<>();
        PasswordEncryptionHelper passwordHelper = new PasswordEncryptionHelper();

        if (nutzertyp == "kunde") {
            kunde = (Response<Kunde>) session.getAttribute("nutzer");
            byte[] salt = kunde.getResponse().getSalt();
            try {
                byte[] newPassword = passwordHelper.getEncryptedPassword(request.getParameter("newPassword"), salt);
                String newPasswordConfirmed = request.getParameter("newPasswordConfirmed");
                if (passwordHelper.authenticate(request.getParameter("oldPassword"), kunde.getResponse().getPasswort(), salt)) {
                    if (passwordHelper.authenticate(newPasswordConfirmed, newPassword, salt)) {
                        kunde.getResponse().setPasswort(newPassword);
                        kunde.setStatus(ResponseStatus.ERFOLGREICH);
                    } else {
                        kunde.setStatus(ResponseStatus.ERROR);
                        kunde.setMessage("Die Passwörter stimmem nicht überein");
                    }
                } else {
                    kunde.setStatus(ResponseStatus.ERROR);
                    kunde.setMessage("Das eingegebne alte Passwort war nicht korrekt");
                }
            } catch (Exception e) {
                    kunde.setStatus(ResponseStatus.ERROR);
                    kunde.setMessage("Beim verarbeiten des Passworts ist ein Fehler aufgetreten");
            }
            if (kunde.getStatus() == ResponseStatus.ERFOLGREICH) {
                kunde = kundeBean.updateKunde(kunde.getResponse());
                session.setAttribute("nutzer", kunde);
                session.setAttribute("nutzertyp", "kunde");
            }
        } else if (nutzertyp == "trainer") {
            trainer = (Response<Trainer>) session.getAttribute("nutzer");
            byte[] salt = trainer.getResponse().getSalt();
            try {
                byte[] newPassword = passwordHelper.getEncryptedPassword(request.getParameter("newPassword"), salt);
                String newPasswordConfirmed = request.getParameter("newPasswordConfirmed");
                if (passwordHelper.authenticate(request.getParameter("oldPassword"), kunde.getResponse().getPasswort(), salt)) {
                    if (passwordHelper.authenticate(newPasswordConfirmed, newPassword, salt)) {
                        trainer.getResponse().setPasswort(newPassword);
                    } else {
                        trainer.setStatus(ResponseStatus.ERROR);
                        trainer.setMessage("Die Passwörter stimmem nicht überein");
                    }
                } else {
                    trainer.setStatus(ResponseStatus.ERROR);
                    trainer.setMessage("Das eingegebne alte Passwort war nicht korrekt");
                }
            } catch (Exception e) {
                    trainer.setStatus(ResponseStatus.ERROR);
                    trainer.setMessage("Beim verarbeiten des Passworts ist ein Fehler aufgetreten");
            }
            if (trainer.getStatus() == ResponseStatus.ERFOLGREICH) {
                trainer = trainerBean.updateTrainer(trainer.getResponse());
                session.setAttribute("nutzer", trainer);
                session.setAttribute("nutzertyp", "trainer");
            }
        }
        response.sendRedirect(request.getContextPath() + AccountServlet.URL);
    }
}
