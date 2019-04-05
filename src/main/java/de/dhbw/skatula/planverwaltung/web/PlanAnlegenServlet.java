/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.skatula.planverwaltung.web;

import de.dhbw.skatula.planverwaltung.ejb.PlanBean;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.ejb.EJB;

/**
 *
 * @author f_lieb
 */
@WebServlet(name = "PlanAnlegen", urlPatterns = {"/planAnlegen"})
public class PlanAnlegenServlet extends HttpServlet {
    
    public final static String URL = "/planAnlegen";
    
    @EJB
    protected PlanBean planBean;
    
}
