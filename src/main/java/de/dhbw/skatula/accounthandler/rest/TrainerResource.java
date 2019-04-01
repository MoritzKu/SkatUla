/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.skatula.accounthandler.rest;

import de.dhbw.skatula.accounthandler.ejb.TrainerBean;
import de.dhbw.skatula.accounthandler.jpa.Kunde;
import de.dhbw.skatula.accounthandler.jpa.Trainer;
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
@Path("accountdetailsTrainerWS/{nutzerId}/")
@Consumes({"application/json", "text/xml"})
@Produces({"application/json", "text/xml"})
public class TrainerResource {

    @EJB
    protected TrainerBean trainerBean;

    @GET
    public Response<Trainer> getTrainer(@PathParam("nutzerId") String nutzerId) {
        return trainerBean.findById(Long.parseLong(nutzerId));
    }

    @PUT
    public Response<Trainer> updateKunde(Trainer trainer) {
        return trainerBean.updateTrainer(trainer);
    }

    @POST
    public Response<Trainer> createNewTrainer(Trainer trainer) {
        return trainerBean.createNewTrainer(trainer);
    }
}
