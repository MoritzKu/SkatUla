/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.skatula.planverwaltung.jpa;

import de.dhbw.skatula.accounthandler.jpa.Kunde;
import de.dhbw.skatula.jpa.Termin;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Benjamin Kanzler
 */
@Entity
public class Plan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToMany
    private List<Termin> termine;
    
    @OneToOne
    private Kunde kunde;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Termin> getTermine() {
        return termine;
    }

    public void setTermine(List<Termin> termine) {
        this.termine = termine;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.termine);
        hash = 97 * hash + Objects.hashCode(this.kunde);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Plan other = (Plan) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.termine, other.termine)) {
            return false;
        }
        if (!Objects.equals(this.kunde, other.kunde)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Plan{" + "id=" + id + ", termine=" + termine + ", kunde=" + kunde + '}';
    }
}
