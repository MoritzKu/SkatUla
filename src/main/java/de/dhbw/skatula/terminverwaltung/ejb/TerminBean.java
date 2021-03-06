/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.skatula.terminverwaltung.ejb;

import de.dhbw.skatula.enums.ResponseStatus;
import de.dhbw.skatula.helper.Response;
import de.dhbw.skatula.terminverwaltung.jpa.Termin;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Benjamin Kanzler
 */
@Stateless
public class TerminBean {
    
    @PersistenceContext
    EntityManager em;

    public Response<Termin> createNewTermin(Termin t) {
        Response<Termin> response = new Response<>();
        try {
            em.persist(t);
            response.setResponse(em.merge(t));
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

    public Response<Termin> updateTermin(Termin t) {
        Response<Termin> response = new Response<>();
        try {
            response.setResponse(em.merge(t));
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
    
    public Response<Termin> findAll(){
        Response<Termin> response = new Response<>();
        try {
            response.setResponseList(em.createQuery("SELECT t FROM Termin t").getResultList());
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
    
    public Response<Termin> findById(Long id){
        Response<Termin> response = new Response<>();
        try {
            response.setResponse(em.find(Termin.class, id));
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
    
    public Response<Termin> deleteTermin(Termin t){
        Response<Termin> response = new Response<>();
        try {
            em.remove(t);
            response.setResponse(t);
            response.setStatus(ResponseStatus.ERFOLGREICH);
            response.setMessage("Der Termin" + t + "\nwurde erfolgreich gelöscht.");
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
