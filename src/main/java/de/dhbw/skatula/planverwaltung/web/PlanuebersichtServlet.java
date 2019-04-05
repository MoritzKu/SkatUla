/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.skatula.planverwaltung.web;

import de.dhbw.skatula.helper.Response;
import de.dhbw.skatula.kursverwaltung.jpa.Kurs;
import de.dhbw.skatula.planverwaltung.ejb.PlanBean;
import de.dhbw.skatula.planverwaltung.jpa.Plan;
import java.io.IOException;
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
@WebServlet(name = "PlanuebersichtServlet", urlPatterns = {"/planuebersicht"})
public class PlanuebersichtServlet extends HttpServlet {
    
    public static final String URL="/planuebersicht";
    
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
        
        Response<Plan> plan = planBean.findAll(); 
        request.setAttribute("PlanList", plan);
        
        request.getRequestDispatcher("/WEB-INF/planuebersicht.jsp").forward(request, response);
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
