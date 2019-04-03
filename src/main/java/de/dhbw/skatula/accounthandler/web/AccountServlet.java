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
import de.dhbw.skatula.ejb.AdresseBean;
import de.dhbw.skatula.helper.Response;
import de.dhbw.skatula.jpa.Adresse;
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
@WebServlet(urlPatterns = {"/accountdetail"}, name = "AccountServlet")
public class AccountServlet extends HttpServlet {

    public final static String URL = "/accountdetail";

    @EJB
    protected KundeBean kundeBean;

    @EJB
    protected TrainerBean trainerBean;
    
    @EJB
    protected AdresseBean adresseBean;

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
        request.getRequestDispatcher("WEB-INF/accountdetails.jsp").forward(request, response);
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
            //Setzen der Attribute auf dem Kunden
            kunde.getResponse().setName(request.getParameter("nachname"));
            kunde.getResponse().setVorname(request.getParameter("vorname"));
            kunde.getResponse().setEmail(request.getParameter("email"));
            kunde.getResponse().getAdresse().setHausnummer(Integer.parseInt(request.getParameter("hausnr")));
            //Adresse-Objekt erzeugen, falls noch keine Adresse am Kunden hängt
            if(kunde.getResponse().getAdresse() == null){
                kunde.getResponse().setAdresse(new Adresse());
            }
            
            kunde.getResponse().getAdresse().setStrasse(request.getParameter("strasse"));
            kunde.getResponse().getAdresse().setLand(request.getParameter("land"));
            kunde.getResponse().getAdresse().setOrt(request.getParameter("ort"));
            kunde.getResponse().getAdresse().setPlz(request.getParameter("plz"));
            if(kunde.getResponse().getAdresse().getId() == null){
                kunde.getResponse().setAdresse(adresseBean.createNewAdresse(kunde.getResponse().getAdresse()).getResponse());
            } else {
                kunde.getResponse().setAdresse(adresseBean.updateAdresse(kunde.getResponse().getAdresse()).getResponse());
            }
            session.setAttribute("nutzer", kundeBean.updateKunde(kunde.getResponse()));

        } else if (session.getAttribute("nutzertyp") == "trainer") {
            Response<Trainer> trainer = (Response<Trainer>) session.getAttribute("nutzer");
            trainer.getResponse().setName(request.getParameter("nachname"));
            trainer.getResponse().setVorname(request.getParameter("vorname"));
            trainer.getResponse().setEmail(request.getParameter("email"));
            if(trainer.getResponse().getAdresse() == null){
                trainer.getResponse().setAdresse(new Adresse());
            }
            trainer.getResponse().getAdresse().setHausnummer(Integer.parseInt(request.getParameter("hausnr")));
            trainer.getResponse().getAdresse().setStrasse(request.getParameter("strasse"));
            trainer.getResponse().getAdresse().setLand(request.getParameter("land"));
            trainer.getResponse().getAdresse().setOrt(request.getParameter("ort"));
            trainer.getResponse().getAdresse().setPlz(request.getParameter("plz"));
            if(trainer.getResponse().getAdresse().getId() == null){
                trainer.getResponse().setAdresse(adresseBean.createNewAdresse(trainer.getResponse().getAdresse()).getResponse());
            } else {
                trainer.getResponse().setAdresse(adresseBean.updateAdresse(trainer.getResponse().getAdresse()).getResponse());
            }
            session.setAttribute("nutzer", trainerBean.updateTrainer(trainer.getResponse()));
        }
        request.getRequestDispatcher("WEB-INF/accountdetails.jsp").forward(request, response);
    }

}
