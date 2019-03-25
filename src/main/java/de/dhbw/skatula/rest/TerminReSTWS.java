/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.skatula.rest;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Benjamin Kanzler
 */
@Stateless
@Path("/Termin/")
@Consumes("application/json")
@Produces("application/json")
public class TerminReSTWS {
    
}
