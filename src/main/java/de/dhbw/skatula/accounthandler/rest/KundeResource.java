/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.skatula.accounthandler.rest;

import de.dhbw.skatula.accounthandler.ejb.KundeBean;
import de.dhbw.skatula.accounthandler.jpa.Kunde;
import de.dhbw.skatula.enums.ResponseStatus;
import de.dhbw.skatula.helper.Response;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Benjamin Kanzler
 */
@Stateless
@Path("accountdetailsKundeWS/{nutzerId}/")
@Consumes({"application/json", "text/xml"})
@Produces({"application/json", "text/xml"})
public class KundeResource {

    @EJB
    protected KundeBean kundeBean;

    @GET
    public Response<Kunde> getKunde(@PathParam("nutzerId") String nutzerId) {
        return kundeBean.findById(Long.parseLong(nutzerId));
    }

    @PUT
    public Response<Kunde> updateKunde(Kunde kunde) {
        return kundeBean.updateKunde(kunde);
    }

    @POST
    public Response<Kunde> createNewKunde(Kunde kunde) {
        return kundeBean.createNewKunde(kunde);
    }
}
