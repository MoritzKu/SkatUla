/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.skatula.accounthandler.ejb;

import de.dhbw.skatula.enums.ResponseStatus;
import de.dhbw.skatula.helper.Response;
import de.dhbw.skatula.accounthandler.jpa.Trainer;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Benjamin Kanzler
 */
@Stateless
public class TrainerBean {

    @PersistenceContext
    EntityManager em;

    public Response<Trainer> createNewBankverbindung(Trainer t) {
        Response<Trainer> response = new Response<>();
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

    public Response<Trainer> updateBankverbindung(Trainer t) {
        Response<Trainer> response = new Response<>();
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

    public Response<Trainer> findAll() {
        Response<Trainer> response = new Response<>();
        try {
            response.setResponseList(em.createQuery("SELECT t FROM Trainer t").getResultList());
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

    public Response<Trainer> findById(Long id) {
        Response<Trainer> response = new Response<>();
        try {
            response.setResponse(em.find(Trainer.class, id));
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

    public Response<Trainer> findByNick(String nickname) {
        Response<Trainer> response = new Response<>();
        try {
            response.setResponse((Trainer) em.createQuery("SELECT t FROM Trainer t WHERE t.mitarbeiterNr = :MNR")
                    .setParameter("MNR", nickname)
                    .getSingleResult());
            response.setStatus(ResponseStatus.ERFOLGREICH);
        } catch (Exception ex){
            response.setStatus(ResponseStatus.ERROR);
            response.setException(ex.getClass().getName());
            response.setMessage(ex.getMessage());
            response.setStackTrace(ex.getStackTrace());
        }finally{
            return response;
        }
    }

    public Response<Trainer> deleteBankverbingung(Trainer t) {
        Response<Trainer> response = new Response<>();
        try {
            em.remove(t);
            response.setResponse(t);
            response.setStatus(ResponseStatus.ERFOLGREICH);
            response.setMessage("Die Bankverbindung\n" + t + "\nwurde erfolgreich gelöscht.");
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
