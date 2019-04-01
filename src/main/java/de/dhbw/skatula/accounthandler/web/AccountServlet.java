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

    public final static String URL = "accoutdetail";
    
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
            Response<Kunde> resKunde = (Response<Kunde>) session.getAttribute("nutzer");
            Kunde kunde = new Kunde();
            kunde.setName((String) request.getAttribute("nachname"));
            kunde.setVorname((String) request.getAttribute("vorname"));
            kunde.setEmail((String) request.getAttribute("email"));

            Adresse adresse = new Adresse();
            adresse.setHausnummer(Integer.parseInt((String) request.getAttribute("hausnr")));
            adresse.setStrasse((String) request.getAttribute("strasse"));
            adresse.setLand((String) request.getAttribute("land"));
            adresse.setOrt((String) request.getAttribute("ort"));
            adresse.setPlz((String) request.getAttribute("plz"));

            kunde.setAdresse(adresse);
            kunde.setId(resKunde.getResponse().getId());
            kunde.setUsername(resKunde.getResponse().getUsername());
            kunde.setPasswort(resKunde.getResponse().getPasswort());
            
            session.setAttribute("nutzer", kundeBean.updateKunde(kunde));
            
        } else if (session.getAttribute("nutzertyp") == "trainer") {
            Response<Trainer> resTrainer = (Response<Trainer>) session.getAttribute("nutzer");
            Trainer trainer = new Trainer();
            trainer.setName((String) request.getAttribute("nachname"));
            trainer.setVorname((String) request.getAttribute("vorname"));
            trainer.setEmail((String) request.getAttribute("email"));

            Adresse adresse = new Adresse();
            adresse.setHausnummer(Integer.parseInt((String) request.getAttribute("hausnr")));
            adresse.setStrasse((String) request.getAttribute("strasse"));
            adresse.setLand((String) request.getAttribute("land"));
            adresse.setOrt((String) request.getAttribute("ort"));
            adresse.setPlz((String) request.getAttribute("plz"));

            trainer.setAdresse(adresse);
            trainer.setId(resTrainer.getResponse().getId());
            trainer.setUsername(resTrainer.getResponse().getUsername());
            trainer.setPasswort(resTrainer.getResponse().getPasswort());
            
            session.setAttribute("nutzer", trainerBean.updateTrainer(trainer));
        
        }
        request.getRequestDispatcher("WEB-INF/accountdetails.jsp").forward(request, response);
    }

}
