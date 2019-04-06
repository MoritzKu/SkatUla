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

    public Response<KursKunde> createNewKursKunde(KursKunde k, Kunde kunde, Kurs kurs) {

        Response<KursKunde> response = new Response<>();
        try {
            k.setKunde(kunde);
            k.setKurs(kurs);
            em.persist(k);
            
            kunde.getKursKunde().add(k);
            em.merge(kunde);
            
            kurs.getKursKunde().add(k);
            em.merge(kurs);
            
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
