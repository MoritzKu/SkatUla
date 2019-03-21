/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.skatula.jpa;

import de.dhbw.skatula.jpa.ids.BankverbindungId;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Benjamin Kanzler
 */
@Entity
@IdClass(BankverbindungId.class)
public class Bankverbindung implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String bic = "";

    @Id
    private String iban = "";

    private String insitut;

    @OneToOne
    @JoinColumn(name = "adress_id", referencedColumnName = "id")
    private Adresse adresse;

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getInsitut() {
        return insitut;
    }

    public void setInsitut(String insitut) {
        this.insitut = insitut;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.bic);
        hash = 67 * hash + Objects.hashCode(this.iban);
        hash = 67 * hash + Objects.hashCode(this.insitut);
        hash = 67 * hash + Objects.hashCode(this.adresse);
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
        final Bankverbindung other = (Bankverbindung) obj;
        if (!Objects.equals(this.bic, other.bic)) {
            return false;
        }
        if (!Objects.equals(this.iban, other.iban)) {
            return false;
        }
        if (!Objects.equals(this.insitut, other.insitut)) {
            return false;
        }
        if (!Objects.equals(this.adresse, other.adresse)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Bankverbindung{" + "bic=" + bic + ", iban=" + iban + ", insitut=" + insitut + ", adresse=" + adresse + '}';
    }
}
