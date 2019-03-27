/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.skatula.web;

import de.dhbw.skatula.accounthandler.ejb.KundeBean;
import de.dhbw.skatula.enums.ResponseStatus;
import de.dhbw.skatula.helper.Response;
import de.dhbw.skatula.accounthandler.jpa.Kunde;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MoritzKuttler
 */
@WebServlet(urlPatterns = {"/", "/index", "/index.html"}, name = "IndexServlet")
public class IndexServlet extends HttpServlet {

    @EJB
    protected KundeBean kundeBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Kunde erstellen
        Kunde k = new Kunde();
        k.setUsername("Horst");
        k.setEmail("horst@test.de");
        k.setVorname("Horst");
        k.setName("Horstensen");
        k.setPasswort("123");
        Response<Kunde> resK = kundeBean.findByNick(k.getUsername());
        if (resK.getStatus() != ResponseStatus.ERFOLGREICH) {
            resK = kundeBean.createNewKunde(k);
        } else {
            k.setId(resK.getResponse().getId());
            resK = kundeBean.updateKunde(k);
        }
        request.setAttribute("kunde", resK);

        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
    }
}
