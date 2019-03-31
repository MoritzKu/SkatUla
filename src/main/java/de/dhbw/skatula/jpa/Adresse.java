/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.skatula.jpa;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Benjamin Kanzler
 */
@Entity
public class Adresse implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String strasse;
    
    @Column(length = 5)
    private String plz;
    
    private String ort;
    
    @Column(length = 3)
    private int hausnummer;
    
    @Column(length = 2)
    private String hausnummerzusatz;
    
    private String postfach;
    
    private String land;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getPostfach() {
        return postfach;
    }

    public void setPostfach(String postfach) {
        this.postfach = postfach;
    }

    public int getHausnummer() {
        return hausnummer;
    }

    public void setHausnummer(int hausnummer) {
        this.hausnummer = hausnummer;
    }

    public String getHausnummerzusatz() {
        return hausnummerzusatz;
    }

    public void setHausnummerzusatz(String hausnummerzusatz) {
        this.hausnummerzusatz = hausnummerzusatz;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.strasse);
        hash = 79 * hash + Objects.hashCode(this.plz);
        hash = 79 * hash + Objects.hashCode(this.ort);
        hash = 79 * hash + this.hausnummer;
        hash = 79 * hash + Objects.hashCode(this.hausnummerzusatz);
        hash = 79 * hash + Objects.hashCode(this.postfach);
        hash = 79 * hash + Objects.hashCode(this.land);
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
        final Adresse other = (Adresse) obj;
        if (this.hausnummer != other.hausnummer) {
            return false;
        }
        if (!Objects.equals(this.strasse, other.strasse)) {
            return false;
        }
        if (!Objects.equals(this.plz, other.plz)) {
            return false;
        }
        if (!Objects.equals(this.ort, other.ort)) {
            return false;
        }
        if (!Objects.equals(this.hausnummerzusatz, other.hausnummerzusatz)) {
            return false;
        }
        if (!Objects.equals(this.postfach, other.postfach)) {
            return false;
        }
        if (!Objects.equals(this.land, other.land)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
