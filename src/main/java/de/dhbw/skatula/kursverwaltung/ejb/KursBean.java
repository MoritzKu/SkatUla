/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.skatula.kursverwaltung.ejb;

import de.dhbw.skatula.enums.ResponseStatus;
import de.dhbw.skatula.helper.Response;
import de.dhbw.skatula.kursverwaltung.jpa.Kurs;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Benjamin Kanzler
 */
@Stateless
public class KursBean {
    
    @PersistenceContext
    EntityManager em;

    public Response<Kurs> createNewBankverbindung(Kurs k) {
        Response<Kurs> response = new Response<>();
        try {
            em.persist(k);
            response.setResponse(em.merge(k));
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

    public Response<Kurs> updateBankverbindung(Kurs k) {
        Response<Kurs> response = new Response<>();
        try {
            response.setResponse(em.merge(k));
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
    
    public Response<Kurs> findAll(){
        Response<Kurs> response = new Response<>();
        try {
            response.setResponseList(em.createQuery("SELECT k FROM Kurs k").getResultList());
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
    
    public Response<Kurs> findById(Long id){
        Response<Kurs> response = new Response<>();
        try {
            response.setResponse(em.find(Kurs.class, id));
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
    
    public Response<Kurs> deleteBankverbingung(Kurs k){
        Response<Kurs> response = new Response<>();
        try {
            em.remove(k);
            response.setResponse(k);
            response.setStatus(ResponseStatus.ERFOLGREICH);
            response.setMessage("Die Bankverbindung\n" + k + "\nwurde erfolgreich gelöscht.");
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
