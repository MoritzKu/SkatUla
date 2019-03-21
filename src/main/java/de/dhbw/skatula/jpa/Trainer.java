/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.skatula.jpa;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;

/**
 *
 * @author Benjamin Kanzler
 */
@Entity
public class Trainer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String vorname;

    private String mitarbeiterNr;

    private String passwort;

    @OneToOne()
    @JoinColumn(name = "adress_id", referencedColumnName = "id")
    private Adresse adresse;

    @JoinColumns(value = {
        @JoinColumn(name = "iban", referencedColumnName = "iban"),
        @JoinColumn(name = "bic", referencedColumnName = "bic")}
    )
    private Bankverbindung bankverbindung;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getMitarbeiterNr() {
        return mitarbeiterNr;
    }

    public void setMitarbeiterNr(String mitarbeiterNr) {
        this.mitarbeiterNr = mitarbeiterNr;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Bankverbindung getBankverbindung() {
        return bankverbindung;
    }

    public void setBankverbindung(Bankverbindung bankverbindung) {
        this.bankverbindung = bankverbindung;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
        hash = 31 * hash + Objects.hashCode(this.name);
        hash = 31 * hash + Objects.hashCode(this.vorname);
        hash = 31 * hash + Objects.hashCode(this.mitarbeiterNr);
        hash = 31 * hash + Objects.hashCode(this.passwort);
        hash = 31 * hash + Objects.hashCode(this.adresse);
        hash = 31 * hash + Objects.hashCode(this.bankverbindung);
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
        final Trainer other = (Trainer) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.vorname, other.vorname)) {
            return false;
        }
        if (!Objects.equals(this.mitarbeiterNr, other.mitarbeiterNr)) {
            return false;
        }
        if (!Objects.equals(this.passwort, other.passwort)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.adresse, other.adresse)) {
            return false;
        }
        if (!Objects.equals(this.bankverbindung, other.bankverbindung)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Trainer{" + "id=" + id + ", name=" + name + ", vorname=" + vorname + ", mitarbeiterNr=" + mitarbeiterNr + ", passwort=" + passwort + ", adresse=" + adresse + ", bankverbindung=" + bankverbindung + '}';
    }
}
