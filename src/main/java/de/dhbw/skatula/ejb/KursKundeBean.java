/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.skatula.ejb;

import de.dhbw.skatula.enums.ResponseStatus;
import de.dhbw.skatula.helper.Response;
import de.dhbw.skatula.jpa.KursKunde;
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
    
    public Response<KursKunde> createNewKursKunde(KursKunde k){
        
        Response<KursKunde> response = new Response<>();
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
}
