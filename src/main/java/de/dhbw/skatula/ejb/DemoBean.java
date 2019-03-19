/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.skatula.ejb;

import de.dhbw.skatula.helper.Response;
import de.dhbw.skatula.jpa.DemoEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Benjamin Kanzler
 */
@Stateless
public class DemoBean {
    
    @PersistenceContext
    EntityManager em;
    
    public Response<DemoEntity> findAll(Long id){
        Response<DemoEntity> response = new Response<>();
        response.setResponseList(em.createQuery("SELECT e FROM DemoEntity e").getResultList());
        return response;
    }
}
