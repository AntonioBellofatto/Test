/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.oop.persone;

/**
 *
 * @author lucagreco
 */
public class Docente extends PersonaUnisa {
    
    private String insegnamento;

    public Docente(String nome, String cognome, String codiceFiscale, String matricola, String insegnamento) {
        super(nome, cognome, codiceFiscale, matricola);
        
        this.insegnamento = insegnamento;
    }
    
    
    

    @Override
    public String getRuolo() {
        
        return "Docente";
        
        }
    
    
}
