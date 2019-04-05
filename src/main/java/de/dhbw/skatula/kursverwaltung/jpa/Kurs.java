/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.skatula.kursverwaltung.jpa;

import de.dhbw.skatula.accounthandler.jpa.Kunde;
import de.dhbw.skatula.accounthandler.jpa.Trainer;
import de.dhbw.skatula.enums.Schwierigkeitsgrad;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "kurs_teilnehmer", joinColumns = @JoinColumn(name = "kurs_id"), inverseJoinColumns = @JoinColumn(name = "kunde_id"))
    private Set<Kunde> teilnehmer = new HashSet<>();

    private DateTime startdatum;

    private int anzahl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DateTime getStartdatum() {
        return startdatum;
    }

    public void setStartdatum(DateTime startdatum) {
        this.startdatum = startdatum;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
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

    public Set<Kunde> getTeilnehmer() {
        return teilnehmer;
    }

    public void setTeilnehmer(Set<Kunde> teilnehmer) {
        this.teilnehmer = teilnehmer;
    }

    @Override
    public String toString() {
        return "Kurs{" + "id=" + id + ", bezeichnung=" + bezeichnung + ", maxTeilnehmer=" + maxTeilnehmer + ", aktuelleTeilnehmerzahl=" + aktuelleTeilnehmerzahl + ", schwierigkeitsgrad=" + schwierigkeitsgrad + ", trainer=" + trainer + '}';
    }

}
