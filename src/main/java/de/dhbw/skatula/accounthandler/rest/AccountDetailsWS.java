/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.skatula.accounthandler.rest;

import de.dhbw.skatula.accounthandler.ejb.KundeBean;
import de.dhbw.skatula.accounthandler.jpa.Kunde;
import de.dhbw.skatula.helper.Response;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Benjamin Kanzler
 */
@Stateless
@Path("/accountdetailsREST")
@Consumes("application/json")
@Produces("application/json")
public class AccountDetailsWS {
    
    @EJB
    protected KundeBean kundeBean;
    
    @GET
    @Path("findById/{nutzerId}")
    public Response<Kunde> findDetailsById (@PathParam("nutzerId") String nutzerId){
        return kundeBean.findById(Long.parseLong(nutzerId));
    }
    
    @GET
    @Path("findAllKunden")
    public Response<Kunde> findAllKunden(){
        return kundeBean.findAll();
    }
}
