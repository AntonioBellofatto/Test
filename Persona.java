/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.oop.persone;

import java.util.Objects;

/**
 *
 * @author lucagreco
 */
public class Persona implements Clonabile<Persona>, Comparable<Persona> {
    
    private String nome;
    private String cognome;
    private String codiceFiscale;
    private int eta;
    
    
    public Persona(String nome, String cognome, String codiceFiscale) {
    
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
    
    }
    
    public void setEta(int eta) {
    
        this.eta = eta;
    
    }
    
    public String getNome() {
    
        return this.nome;
    }
    
    public String getCognome() {
    
       return this.cognome;
    
    }
    
    public int getEta() {
    
        return this.eta;
    }
    
    public final String getCodiceFiscale() {
    
        return this.codiceFiscale;
    
    
    }
    
    
   @Override
   public boolean equals(Object obj) {
   
       if(obj == null) return false;
       
       if(this == obj) return true;
       
       if(this.getClass() != obj.getClass()) return false; // simmetrica
    
        //if(!(obj instanceof Persona)) return false; // non simmetrico
    
       Persona p = (Persona) obj;
       
       return p.codiceFiscale.equals(this.codiceFiscale);
       
       
   
   
   } 
   
   @Override
   public int hashCode(){
       
       int code = this.codiceFiscale == null ? 0: this.codiceFiscale.hashCode();
   
       return code;
   
   } 

   /* // versione con più attributi
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.nome.hashCode();
        hash = 29 * hash + this.cognome.hashCode();
        hash = 29 * hash + this.codiceFiscale.hashCode();
        return hash;
    }
   
*/
   
   
   
   
   
   
    
   @Override
    public String toString() {
    
    
        return this.nome + " " + this.cognome + " " + this.codiceFiscale;
        
    
    }

    @Override
    public Persona clona() {
      
        return new Persona(this.nome, this.cognome, this.codiceFiscale);
        
    }

    @Override
    public int compareTo(Persona o) {
        
     //   if(!this.cognome.equals(o.cognome))           // ordina per cognome, a parità di cognome per codice fiscale
       //     return this.cognome.compareTo(o.cognome);

       return this.codiceFiscale.compareTo(o.codiceFiscale); 
      
     // return this.eta - o.eta; // confronto eta
     
   //  return Integer.compare(this.eta, o.eta);  //alternativa per confronto età  basata su wrapper class
        
         }
    
    
    
}
