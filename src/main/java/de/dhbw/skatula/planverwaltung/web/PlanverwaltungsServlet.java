/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.skatula.planverwaltung.web;

import de.dhbw.skatula.accounthandler.ejb.KundeBean;
import de.dhbw.skatula.accounthandler.ejb.TrainerBean;
import de.dhbw.skatula.ejb.AdresseBean;
import de.dhbw.skatula.planverwaltung.ejb.PlanBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author f_lieb
 */
@WebServlet(name = "PlanverwaltungsServlet", urlPatterns = {"/PlanverwaltungsServlet"})
public class PlanverwaltungsServlet extends HttpServlet {
    
    public final static String URL = "/planverwaltung";

    @EJB
    protected KundeBean kundeBean;

    @EJB
    protected TrainerBean trainerBean;
    
    @EJB
    protected AdresseBean adresseBean;
    
    @EJB
    protected PlanBean planBean;

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
        request.getRequestDispatcher("WEB-INF/planuebersicht.jsp").forward(request, response);
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
