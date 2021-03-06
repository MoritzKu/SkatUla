/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.skatula.accounthandler.ejb;

import de.dhbw.skatula.enums.ResponseStatus;
import de.dhbw.skatula.helper.Response;
import de.dhbw.skatula.accounthandler.jpa.Kunde;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Benjamin Kanzler
 */
@Stateless
public class KundeBean {

    @PersistenceContext
    EntityManager em;

    public Response<Kunde> createNewKunde(Kunde k) {
        Response<Kunde> response = new Response<>();
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

    public Response<Kunde> updateKunde(Kunde k) {
        Response<Kunde> response = new Response<>();
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

    public Response<Kunde> findAll() {
        Response<Kunde> response = new Response<>();
        try {
            response.setResponseList(em.createQuery("SELECT k FROM Kunde K").getResultList());
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

    public Response<Kunde> findById(Long id) {
        Response<Kunde> response = new Response<>();
        try {
            response.setResponse(em.find(Kunde.class, id));
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

    public Response<Kunde> findByNick(String nick) {
        Response<Kunde> response = new Response<>();
        try {
            response.setResponse((Kunde) em.createQuery("SELECT k FROM Kunde k WHERE k.username LIKE :NICK")
                    .setParameter("NICK", nick)
                    .getSingleResult());
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

    public Response<Kunde> deleteKunde(Kunde k) {
        Response<Kunde> response = new Response<>();
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
