/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.skatula.kursverwaltung.rest;

import de.dhbw.skatula.helper.Response;
import de.dhbw.skatula.kursverwaltung.ejb.KursBean;
import de.dhbw.skatula.kursverwaltung.jpa.Kurs;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author MoritzKuttler
 */
@Stateless
@Path("KurseWS/")
@Consumes({"application/json", "text/xml"})
@Produces({"application/json", "text/xml"})
public class KursCollection {

    @EJB
    protected KursBean kursBean;

    @GET
    public Response<Kurs> getKurse() {
        return kursBean.findAll();
    }

}
