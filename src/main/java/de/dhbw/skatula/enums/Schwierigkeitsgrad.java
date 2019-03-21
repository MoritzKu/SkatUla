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
public enum Schwierigkeitsgrad {
    
    EINSTEIGER("Einsteiger"),
    FORTGESCHRITTEN("Fortgeschritten"),
    ERFAHREN("Erfahren");
    
    private String bezeichnung;
    
    private Schwierigkeitsgrad(String bez){
        this.bezeichnung = bez;
    }
    
}
