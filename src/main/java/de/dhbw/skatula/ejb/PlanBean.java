/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.skatula.ejb;

import de.dhbw.skatula.enums.ResponseStatus;
import de.dhbw.skatula.helper.Response;
import de.dhbw.skatula.jpa.Plan;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Benjamin Kanzler
 */
@Stateless
public class PlanBean {
    
    @PersistenceContext
    EntityManager em;

    public Response<Plan> createNewBankverbindung(Plan p) {
        Response<Plan> response = new Response<>();
        try {
            em.persist(p);
            response.setResponse(em.merge(p));
            response.setStatus(ResponseStatus.ERFOLGREICH);
        } catch (Exception ex) {
            response.setStatus(ResponseStatus.ERROR);
            response.setException(ex.getClass().getName());
            response.setMessage(ex.getMessage());
            response.setStackTrace(ex.getStackTrace());
        } finally {
            return response;
        }
    }

    public Response<Plan> updateBankverbindung(Plan p) {
        Response<Plan> response = new Response<>();
        try {
            response.setResponse(em.merge(p));
            response.setStatus(ResponseStatus.ERFOLGREICH);
        } catch (Exception ex) {
            response.setStatus(ResponseStatus.ERROR);
            response.setException(ex.getClass().getName());
            response.setMessage(ex.getMessage());
            response.setStackTrace(ex.getStackTrace());
        } finally {
            return response;
        }
    }
    
    public Response<Plan> findAll(){
        Response<Plan> response = new Response<>();
        try {
            response.setResponseList(em.createQuery("SELECT p FROM Plan p").getResultList());
            response.setStatus(ResponseStatus.ERFOLGREICH);
        } catch (Exception ex) {
            response.setStatus(ResponseStatus.ERROR);
            response.setException(ex.getClass().getName());
            response.setMessage(ex.getMessage());
            response.setStackTrace(ex.getStackTrace());
        } finally {
            return response;
        }
    }
    
    public Response<Plan> findById(Long id){
        Response<Plan> response = new Response<>();
        try {
            response.setResponse(em.find(Plan.class, id));
            response.setStatus(ResponseStatus.ERFOLGREICH);
        } catch (Exception ex) {
            response.setStatus(ResponseStatus.ERROR);
            response.setException(ex.getClass().getName());
            response.setMessage(ex.getMessage());
            response.setStackTrace(ex.getStackTrace());
        } finally {
            return response;
        }
    }
    
    public Response<Plan> deleteBankverbingung(Plan p){
        Response<Plan> response = new Response<>();
        try {
            em.remove(p);
            response.setResponse(p);
            response.setStatus(ResponseStatus.ERFOLGREICH);
            response.setMessage("Die Bankverbindung\n" + p + "\nwurde erfolgreich gelöscht.");
        } catch (Exception ex) {
            response.setStatus(ResponseStatus.ERROR);
            response.setException(ex.getClass().getName());
            response.setMessage(ex.getMessage());
            response.setStackTrace(ex.getStackTrace());
        } finally {
            return response;
        }
    }
    

}
