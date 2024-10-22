/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appfinal_grupo7;

/**
 *
 * @author Franquito Ledesma
 */
public class Mesero {
    
    private int idMesero;
    private boolean cobradp;
    private boolean registrado;

    public Mesero() {
        
    }

    public Mesero(boolean cobradp, boolean registrado) {
        this.cobradp = cobradp;
        this.registrado = registrado;
    }
    
    

    public Mesero(int idMesero, boolean cobradp, boolean registrado) {
        this.idMesero = idMesero;
        this.cobradp = cobradp;
        this.registrado = registrado;
    }

    public int getIdMesero() {
        return idMesero;
    }

    public void setIdMesero(int idMesero) {
        this.idMesero = idMesero;
    }

    public boolean isCobradp() {
        return cobradp;
    }

    public void setCobradp(boolean cobradp) {
        this.cobradp = cobradp;
    }

    public boolean isRegistrado() {
        return registrado;
    }

    public void setRegistrado(boolean registrado) {
        this.registrado = registrado;
    }

    @Override
    public String toString() {
        return idMesero + " " + cobradp + " " + registrado ;
    }
    
    
    
}
