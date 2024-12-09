/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Kristina
 */
public class TerminSmene implements ApstraktniDomenskiObjekat {

    private int idTerminSmene;
    private int brojSati;
    private int satnica;
    private LocalTime pocetakSmene;
    private LocalTime krajSmene;

    public TerminSmene() {
    }

    public TerminSmene(int idTerminSmene, int brojSati, int satnica, LocalTime pocetakSmene, LocalTime krajSmene) {
        this.idTerminSmene = idTerminSmene;
        this.brojSati = brojSati;
        this.satnica = satnica;
        this.pocetakSmene = pocetakSmene;
        this.krajSmene = krajSmene;
    }

    public int getIdTerminSmene() {
        return idTerminSmene;
    }

    public void setIdTerminSmene(int idTerminSmene) {
        this.idTerminSmene = idTerminSmene;
    }

    public int getBrojSati() {
        return brojSati;
    }

    public void setBrojSati(int brojSati) {
        this.brojSati = brojSati;
    }

    public int getSatnica() {
        return satnica;
    }

    public void setSatnica(int satnica) {
        this.satnica = satnica;
    }

    public LocalTime getPocetakSmene() {
        return pocetakSmene;
    }

    public void setPocetakSmene(LocalTime pocetakSmene) {
        this.pocetakSmene = pocetakSmene;
    }

    public LocalTime getKrajSmene() {
        return krajSmene;
    }

    public void setKrajSmene(LocalTime krajSmene) {
        this.krajSmene = krajSmene;
    }

    @Override
    public String vratiNazivTabele() {
        return "termin_smene";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            int idTerminSmene = rs.getInt("termin_smene.idTerminSmene");
            int brojSati = rs.getInt("termin_smene.brojSati");
            int satnica = rs.getInt("termin_smene.satnica");
            java.sql.Time pocetakSmeneSQL = rs.getTime("termin_smene.pocetakSmene");
            java.sql.Time krajSmeneSQL = rs.getTime("termin_smene.krajSmene");

            LocalTime pocetakSmene;
            if(pocetakSmeneSQL!=null)
                pocetakSmene=pocetakSmeneSQL.toLocalTime();
            else pocetakSmene=null;
            LocalTime krajSmene;
            if(krajSmeneSQL!=null)
                krajSmene=krajSmeneSQL.toLocalTime();
            else krajSmene=null;
            
            TerminSmene ts=new TerminSmene(idTerminSmene, brojSati, satnica, pocetakSmene, krajSmene);
            lista.add(ts);
        }

        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "brojSati, satnica, pocetakSmene, krajSmene";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        String pocetakSmeneString = (pocetakSmene != null) ? "'" + pocetakSmene.toString() + "'" : "NULL";
        String krajSmeneString = (krajSmene != null) ? "'" + krajSmene.toString() + "'" : "NULL";

        return brojSati + ", " + satnica + ", " + pocetakSmeneString + ", " + krajSmeneString;
    }

    @Override
    public String vratiPrmarniKljuc() {
        return "termin_smene.idTerminSmene=" + idTerminSmene;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        String pocetakSmeneString = (pocetakSmene != null) ? "'" + pocetakSmene.toString() + "'" : "NULL";
        String krajSmeneString = (krajSmene != null) ? "'" + krajSmene.toString() + "'" : "NULL";

        return "brojSati=" + brojSati + ", "
                + "satnica=" + satnica + ", "
                + "pocetakSmene=" + pocetakSmeneString + ", "
                + "krajSmene=" + krajSmeneString;
    }

}
