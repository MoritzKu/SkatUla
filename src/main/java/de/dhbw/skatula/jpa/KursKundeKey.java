/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.skatula.jpa;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Benjamin Kanzler
 */
@Embeddable
public class KursKundeKey implements Serializable{
    
    @Column(name ="kurs_id")
    Long kursId;
    
    @Column(name= "kunde_id")
    Long kundeId;

    public Long getKursId() {
        return kursId;
    }

    public void setKursId(Long kursId) {
        this.kursId = kursId;
    }

    public Long getKundeId() {
        return kundeId;
    }

    public void setKundeId(Long kundeId) {
        this.kundeId = kundeId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.kursId);
        hash = 23 * hash + Objects.hashCode(this.kundeId);
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
        final KursKundeKey other = (KursKundeKey) obj;
        if (!Objects.equals(this.kursId, other.kursId)) {
            return false;
        }
        if (!Objects.equals(this.kundeId, other.kundeId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "KursKundeKey{" + "kursId=" + kursId + ", kundeId=" + kundeId + '}';
    }
}
