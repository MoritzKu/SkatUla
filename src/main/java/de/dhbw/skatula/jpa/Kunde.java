/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.skatula.jpa;

import de.dhbw.skatula.jpa.ids.LoginDataId;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;

/**
 *
 * @author Benjamin Kanzler
 */
@Entity
@IdClass(LoginDataId.class)
public class Kunde implements Serializable {

    @Id
    private String username = "";
    @Id
    private String pw = "";

    private String vorname;

    private String name;

    private String email;

    @OneToOne()
    @JoinColumn(name = "adress_id", referencedColumnName = "id")
    private Adresse adresse;

    @OneToOne()
    @JoinColumns(value = {
        @JoinColumn(name = "iban", referencedColumnName = "iban"),
        @JoinColumn(name = "bic", referencedColumnName = "bic")}
    )
    private Bankverbindung bankverbindung;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        hash = 41 * hash + Objects.hashCode(this.username);
        hash = 41 * hash + Objects.hashCode(this.pw);
        hash = 41 * hash + Objects.hashCode(this.vorname);
        hash = 41 * hash + Objects.hashCode(this.name);
        hash = 41 * hash + Objects.hashCode(this.email);
        hash = 41 * hash + Objects.hashCode(this.adresse);
        hash = 41 * hash + Objects.hashCode(this.bankverbindung);
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
        final Kunde other = (Kunde) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.pw, other.pw)) {
            return false;
        }
        if (!Objects.equals(this.vorname, other.vorname)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
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
        return "Kunde{" + "username=" + username + ", pw=" + pw + ", vorname=" + vorname + ", name=" + name + ", email=" + email + ", adresse=" + adresse + ", bankverbindung=" + bankverbindung + '}';
    }

}
