/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.skatula.ejb;

import de.dhbw.skatula.accounthandler.jpa.Kunde;
import de.dhbw.skatula.enums.ResponseStatus;
import de.dhbw.skatula.helper.Response;
import de.dhbw.skatula.jpa.KursKunde;
import de.dhbw.skatula.kursverwaltung.jpa.Kurs;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Benjamin Kanzler
 */
@Stateless
public class KursKundeBean {

    @PersistenceContext
    protected EntityManager em;

    public Response<KursKunde> findAll() {
        Response<KursKunde> kk = new Response<>();
        kk.setResponseList(em.createQuery("SELECT k FROM KursKunde k").getResultList());
        return kk;
    }

    public Response<KursKunde> findByKunde(Kunde kunde) {
        Response<KursKunde> response = new Response<>();
        try {
            response.setResponseList(em.createQuery("SELECT k FROM KursKunde k WHERE k.kunde = :KUNDE")
                    .setParameter("KUNDE", kunde)
                    .getResultList());
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
    
    public Response<KursKunde> findByKurs(Kurs kurs) {
        Response<KursKunde> response = new Response<>();
        try {
            response.setResponseList(em.createQuery("SELECT k FROM KursKunde k WHERE k.kurs = :KURS")
                    .setParameter("KURS", kurs)
                    .getResultList());
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

    public Response<KursKunde> createNewKursKunde(KursKunde k, Kunde kunde, Kurs kurs) {

        Response<KursKunde> response = new Response<>();
        try {
            k.setKunde(kunde);
            k.setKurs(kurs);
            em.persist(k);

            kunde.getKursKunde().add(k);
            kunde = em.merge(kunde);

            kurs.getKursKunde().add(k);
            kurs = em.merge(kurs);

            k = em.merge(k);
            response.setResponse(k);
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
}
