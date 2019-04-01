/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.skatula.accounthandler.rest;

import de.dhbw.skatula.accounthandler.ejb.TrainerBean;
import de.dhbw.skatula.accounthandler.jpa.Trainer;
import de.dhbw.skatula.helper.Response;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Benjamin Kanzler
 */
@Stateless
@Path("accountdetailsTrainerWS/")
@Consumes({"application/json", "text/xml"})
@Produces({"application/json", "text/xml"})
public class TrainerCollection {

    @EJB
    protected TrainerBean trainerBean;

    @GET
    public Response<Trainer> getTrainer() {
        return trainerBean.findAll();
    }
}
