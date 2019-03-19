/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.skatula.enums;

/**
 *
 * @author Benjamin Kanzler
 */
public enum ResponseStatus {
    ERROR("Error"),
    WARNUNG("Warnung"),
    FATALERROR("fataler Error"),
    ERFOLGREICH("Erfolgreich"),
    GELOESCHT("Gelöscht");
    
    
    private String bezeichnung;
    
    private ResponseStatus(String bezeichnung){
        this.bezeichnung = bezeichnung;
    }
}
