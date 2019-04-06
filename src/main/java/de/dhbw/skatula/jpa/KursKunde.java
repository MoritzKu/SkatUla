/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.skatula.jpa;

import de.dhbw.skatula.accounthandler.jpa.Kunde;
import de.dhbw.skatula.kursverwaltung.jpa.Kurs;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Benjamin Kanzler
 */
@Entity
public class KursKunde implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    @JoinColumn(name = "kurs_id")
    Kurs kurs;

    @ManyToOne
    @JoinColumn(name = "kunde_id")
    Kunde kunde;

    @Temporal(TemporalType.TIMESTAMP)
    Date zeitstempel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Kurs getKurs() {
        return kurs;
    }

    public void setKurs(Kurs kurs) {
        this.kurs = kurs;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public Date getZeitstempel() {
        return zeitstempel;
    }

    public void setZeitstempel(Date zeitstempel) {
        this.zeitstempel = zeitstempel;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.kurs);
        hash = 71 * hash + Objects.hashCode(this.kunde);
        hash = 71 * hash + Objects.hashCode(this.zeitstempel);
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
        final KursKunde other = (KursKunde) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.kurs, other.kurs)) {
            return false;
        }
        if (!Objects.equals(this.kunde, other.kunde)) {
            return false;
        }
        if (!Objects.equals(this.zeitstempel, other.zeitstempel)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "KursKunde{" + "id=" + id + ", kurs=" + kurs + ", kunde=" + kunde + ", zeitstempel=" + zeitstempel + '}';
    }
}
