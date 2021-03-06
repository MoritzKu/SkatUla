/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.skatula.kursverwaltung.web;

import de.dhbw.skatula.helper.Response;
import de.dhbw.skatula.kursverwaltung.ejb.KursBean;
import de.dhbw.skatula.kursverwaltung.jpa.Kurs;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MoritzKuttler
 */
@WebServlet(name = "KursuebersichtServlet", urlPatterns = {"/kursuebersicht"})
public class KursuebersichtServlet extends HttpServlet{
    
    public final static String URL = "/kursuebersicht";
    
    @EJB
    protected KursBean kursBean;
    
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
        
        request.getRequestDispatcher("WEB-INF/kursuebersicht.jsp").forward(request, response);
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
    
}
