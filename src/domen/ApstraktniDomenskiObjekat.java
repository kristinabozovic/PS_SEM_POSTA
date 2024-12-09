/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.sql.*;
import java.util.List;

/**
 *
 * @author Kristina
 */
public interface ApstraktniDomenskiObjekat extends Serializable {

    public String vratiNazivTabele();

    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception;

    public String vratiKoloneZaUbacivanje(); //INSERT INTO __VALUES()

    public String vratiVrednostiZaUbacivanje();

    public String vratiPrmarniKljuc(); //WHERE id=

    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception; //npr za login kad vracam 1 obj

    public String vratiVrednostiZaIzmenu(); //UPDATE SET __ ime=""...

}
