/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kristina
 */
public class TipPaketa implements ApstraktniDomenskiObjekat {

    private int idTipPaketa;
    private String naziv;

    public TipPaketa() {
    }

    public TipPaketa(int idTipPaketa, String naziv) {
        this.idTipPaketa = idTipPaketa;
        this.naziv = naziv;
    }

    public int getIdTipPaketa() {
        return idTipPaketa;
    }

    public void setIdTipPaketa(int idTipPaketa) {
        this.idTipPaketa = idTipPaketa;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String vratiNazivTabele() {
        return "tip_paketa";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            int idTipPaketa = rs.getInt("tip_paketa.idTipPaketa");
            String naziv = rs.getString("tip_paketa.naziv");
          
            TipPaketa tp=new TipPaketa(idTipPaketa, naziv);
            lista.add(tp);
        }

        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "naziv";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'naziv'";
    }

    @Override
    public String vratiPrmarniKljuc() {
        return "tip_paketa.idTipPaketa=" + idTipPaketa;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "naziv='" + naziv + "'";
    }

}
