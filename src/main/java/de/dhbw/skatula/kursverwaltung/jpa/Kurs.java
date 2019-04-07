/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.skatula.kursverwaltung.jpa;

import de.dhbw.skatula.accounthandler.jpa.Trainer;
import de.dhbw.skatula.enums.Schwierigkeitsgrad;
import de.dhbw.skatula.jpa.KursKunde;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
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
public class Kurs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String bezeichnung;

    private int maxTeilnehmer;

    private int aktuelleTeilnehmerzahl;

    private Schwierigkeitsgrad schwierigkeitsgrad;

    @OneToOne()
    @JoinColumn(name = "trainer_id", referencedColumnName = "id")
    private Trainer trainer;

    @OneToMany(mappedBy = "kurs")
    private Set<KursKunde> kursKunde = new HashSet<>();

    public void addKursKunde(KursKunde kursKunde){
        this.kursKunde.add(kursKunde);
        kursKunde.setKurs(this);
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public int getMaxTeilnehmer() {
        return maxTeilnehmer;
    }

    public void setMaxTeilnehmer(int maxTeilnehmer) {
        this.maxTeilnehmer = maxTeilnehmer;
    }

    public int getAktuelleTeilnehmerzahl() {
        return aktuelleTeilnehmerzahl;
    }

    public void setAktuelleTeilnehmerzahl(int aktuelleTeilnehmerzahl) {
        this.aktuelleTeilnehmerzahl = aktuelleTeilnehmerzahl;
    }

    public Schwierigkeitsgrad getSchwierigkeitsgrad() {
        return schwierigkeitsgrad;
    }

    public void setSchwierigkeitsgrad(Schwierigkeitsgrad schwierigkeitsgrad) {
        this.schwierigkeitsgrad = schwierigkeitsgrad;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Set<KursKunde> getTeilnehmer() {
        return kursKunde;
    }

    public void setTeilnehmer(Set<KursKunde> kursKunde) {
        this.kursKunde = kursKunde;
    }

    public Set<KursKunde> getKursKunde() {
        return kursKunde;
    }

    public void setKursKunde(Set<KursKunde> kursKunde) {
        this.kursKunde = kursKunde;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.bezeichnung);
        hash = 97 * hash + this.maxTeilnehmer;
        hash = 97 * hash + this.aktuelleTeilnehmerzahl;
        hash = 97 * hash + Objects.hashCode(this.schwierigkeitsgrad);
        hash = 97 * hash + Objects.hashCode(this.trainer);
        hash = 97 * hash + Objects.hashCode(this.kursKunde);
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
        final Kurs other = (Kurs) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Kurs{" + "id=" + id + ", bezeichnung=" + bezeichnung + ", maxTeilnehmer=" + maxTeilnehmer + ", aktuelleTeilnehmerzahl=" + aktuelleTeilnehmerzahl + ", schwierigkeitsgrad=" + schwierigkeitsgrad + ", trainer=" + trainer + ", kursKunde=" + kursKunde + '}';
    }

}
