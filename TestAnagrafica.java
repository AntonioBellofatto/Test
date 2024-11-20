/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.oop.persone;

import java.io.IOException;

/**
 *
 * @author bello
 */
public class TestAnagrafica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        AnagraficaStudenti a=new AnagraficaStudenti("OOP");
        
        a.aggiungi(new Studente("Mario","Rossi","MR001","0612708",28.5F));
        a.aggiungi(new Studente("Ernesto","Bianchi","ERS987","0612707",28.5F));
        a.aggiungi(new Studente("Stefano","Rossi","STS023","0612706",28.5F));
        
       // System.out.println(a);
        
        a.scriviDOS("anagrafica.bin");
        
       AnagraficaStudenti a2= AnagraficaStudenti.leggiDIS("anagrafica.bin");
        
        System.out.println(a2);
        
    }
    
}
