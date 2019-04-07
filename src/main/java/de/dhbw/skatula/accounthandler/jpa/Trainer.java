/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.skatula.accounthandler.jpa;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

    @Column(nullable = false, unique = true)
    private String mitarbeiterNr;

    @Column(nullable = false, unique = true)
    private String username;

    private byte[] passwort;
    
    private byte[] salt;

    @Column
    private String email;

    @OneToOne()
    @JoinColumn(name = "adress_id", referencedColumnName = "id")
    private Adresse adresse;

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

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getPasswort() {
        return passwort;
    }

    public void setPasswort(byte[] passwort) {
        this.passwort = passwort;
    }

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
        hash = 43 * hash + Objects.hashCode(this.name);
        hash = 43 * hash + Objects.hashCode(this.vorname);
        hash = 43 * hash + Objects.hashCode(this.mitarbeiterNr);
        hash = 43 * hash + Objects.hashCode(this.username);
        hash = 43 * hash + Arrays.hashCode(this.passwort);
        hash = 43 * hash + Arrays.hashCode(this.salt);
        hash = 43 * hash + Objects.hashCode(this.email);
        hash = 43 * hash + Objects.hashCode(this.adresse);
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
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Trainer{" + "id=" + id + ", name=" + name + ", vorname=" + vorname + ", mitarbeiterNr=" + mitarbeiterNr + ", username=" + username + ", email=" + email + ", adresse=" + adresse + '}';
    }
}
