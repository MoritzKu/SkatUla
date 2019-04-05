/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.skatula.kursverwaltung.web;

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

/**
 *
 * @author MoritzKuttler
 */
@WebServlet(name = "KursBelegenServlet", urlPatterns = {"/kursBelegen/*"})
public class KursBelegenServlet extends HttpServlet {

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

        long id = -1;
        String pathInfo = request.getPathInfo();

        if (pathInfo != null && pathInfo.length() > 2) {
            try {
                id = Long.parseLong(pathInfo.split("/")[pathInfo.split("/").length - 1]);
                System.out.println("Übergeben ID im Servlet" + id);
                Response<Kurs> kurs = kursBean.findById(id);
                System.out.println("Ausgelesener Kurs" + kurs.getResponse());

                request.setAttribute("kurs", kurs);
                request.getRequestDispatcher("/WEB-INF/kursBelegen.jsp").forward(request, response);
                return;
            } catch (NumberFormatException ex) {
                // request.setAttribute("kurs", null);
                // URL enthält keine gültige Long-Zahl
            }
        }
        response.sendRedirect(request.getContextPath() + IndexServlet.URL);
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
