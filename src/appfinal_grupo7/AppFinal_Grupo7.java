/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appfinal_grupo7;

import appfinal_grupo7.AccesoADatos.MeseroData;
import appfinal_grupo7.Entidades.Mesero;
import java.sql.SQLException;

/**
 *
 * @author Franquito Ledesma
 */
public class AppFinal_Grupo7 {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        
        Mesero pepe = new Mesero(6,"Juan", "Puto", true);
        MeseroData mesero = new MeseroData();
        mesero.modificarMesero(pepe);    
        mesero.eliminarMesero(5);
        mesero.eliminarMesero(6);
        mesero.eliminarMesero(7);        
    }
    
}
