/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.oop.persone;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author bello
 */
public class AnagraficaStudenti {
    private String descrizione;
    private Map<String,Studente> anagrafica;

    public AnagraficaStudenti(String descrizione) {
        this.descrizione = descrizione;
        this.anagrafica = new HashMap();
    }
    
    
    
    public void aggiungi(Studente s){
         anagrafica.putIfAbsent(s.getMatricola(),s);
    }
    
    public Studente cerca(String matricola){
        
        return anagrafica.get(matricola);
    }
    
    public String toString(){
        StringBuffer sb=new StringBuffer("Anagrafica:"+descrizione+"\n");
        for(Studente s: anagrafica.values()){
            sb.append(s+"\n");
        }
        
        return sb.toString();
    }
    
    public void scriviDOS(String filename) throws FileNotFoundException, IOException{
        FileOutputStream fos=new FileOutputStream(filename);
        
        DataOutputStream dos=new DataOutputStream(fos);
        
        dos.writeUTF(descrizione);
        
        for(Studente s:anagrafica.values()){
            dos.writeUTF(s.getNome());
            dos.writeUTF(s.getCognome());
            dos.writeUTF(s.getCodiceFiscale());
            dos.writeUTF(s.getMatricola());
            dos.writeFloat(s.getVotoMedio());
        }
        
        dos.close();
    }
    
    public static AnagraficaStudenti leggiDIS(String nomeFile) throws FileNotFoundException, IOException{
     
       FileInputStream fis=new FileInputStream(nomeFile); 
       
       BufferedInputStream bis=new BufferedInputStream(fis);
       
       DataInputStream dis=new DataInputStream(bis);
       
       String descrizione=dis.readUTF();
       
       AnagraficaStudenti a=new AnagraficaStudenti(descrizione);
       
       try{
           while(true){
            String nome=dis.readUTF();
            String cognome=dis.readUTF();
            String codFiscale=dis.readUTF();
            String matricola=dis.readUTF();
            Float votoMedio=dis.readFloat();
            
            Studente s=new Studente(nome,cognome,codFiscale,matricola,votoMedio);
            
            a.aggiungi(s);
            
           }
      
       }
       catch(EOFException ex){
           dis.close();
           return a;
           
       }

//  AnagraficaStudenti a=new AnagraficaStudenti("");
    }
}


