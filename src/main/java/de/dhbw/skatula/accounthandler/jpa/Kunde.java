/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.skatula.accounthandler.jpa;

import de.dhbw.skatula.jpa.KursKunde;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Benjamin Kanzler
 */
@Entity
public class Kunde implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private byte[] passwort;

    @Column(nullable = false)
    private byte[] salt;

    private String vorname;

    private String name;

//    @Column(nullable = true, unique = true)
    private String email;

    @OneToOne()
    @JoinColumn(name = "adress_id", referencedColumnName = "id")
    private Adresse adresse;

    @OneToMany(mappedBy = "kunde")
    private Set<KursKunde> kursKunde = new HashSet<>();
    
    public void addKursKunde(KursKunde kursKunde){
        this.kursKunde.add(kursKunde);
        kursKunde.setKunde(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Set<KursKunde> getKursKunde() {
        return kursKunde;
    }

    public void setKursKunde(Set<KursKunde> kursKunde) {
        this.kursKunde = kursKunde;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.username);
        hash = 59 * hash + Arrays.hashCode(this.passwort);
        hash = 59 * hash + Arrays.hashCode(this.salt);
        hash = 59 * hash + Objects.hashCode(this.vorname);
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.email);
        hash = 59 * hash + Objects.hashCode(this.adresse);
        hash = 59 * hash + Objects.hashCode(this.kursKunde);
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
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Kunde{" + "id=" + id + ", username=" + username + ", passwort=" + passwort + ", salt=" + salt + ", vorname=" + vorname + ", name=" + name + ", email=" + email + ", adresse=" + adresse + ", kurse=" + kursKunde + '}';
    }

}
