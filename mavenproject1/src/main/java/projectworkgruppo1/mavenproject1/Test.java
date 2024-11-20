/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectworkgruppo1.mavenproject1;

/**
 *
 * @author bello
 */
public class Test {
    
    private String cia;

    public Test(String cia) {
        this.cia = cia;
    }
    
    public String get(){
        return cia;
    }
    
    @Override
    public String toString(){
        return cia;
    }
}
