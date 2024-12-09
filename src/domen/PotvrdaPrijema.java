/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Kristina
 */
public class PotvrdaPrijema implements ApstraktniDomenskiObjekat {

    private int idPotvrdaPrijema;
    private Date datum;
    private double ukTezinaPaketa;
    private Postar postar;
    private Primalac primalac;
    private List<StavkaPotvrdePrijema> stavke;

    public PotvrdaPrijema() {
    }

    public PotvrdaPrijema(int idPotvrdaPrijema, Date datum, double ukTezinaPaketa, Postar postar, Primalac primalac, List<StavkaPotvrdePrijema> stavke) {
        this.idPotvrdaPrijema = idPotvrdaPrijema;
        this.datum = datum;
        this.ukTezinaPaketa = ukTezinaPaketa;
        this.postar = postar;
        this.primalac = primalac;
        this.stavke = stavke;
    }

    public int getIdPotvrdaPrijema() {
        return idPotvrdaPrijema;
    }

    public void setIdPotvrdaPrijema(int idPotvrdaPrijema) {
        this.idPotvrdaPrijema = idPotvrdaPrijema;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public double getUkTezinaPaketa() {
        return ukTezinaPaketa;
    }

    public void setUkTezinaPaketa(double ukTezinaPaketa) {
        this.ukTezinaPaketa = ukTezinaPaketa;
    }

    public Postar getPostar() {
        return postar;
    }

    public void setPostar(Postar postar) {
        this.postar = postar;
    }

    public Primalac getPrimalac() {
        return primalac;
    }

    public void setPrimalac(Primalac primalac) {
        this.primalac = primalac;
    }

    public List<StavkaPotvrdePrijema> getStavke() {
        return stavke;
    }

    public void setStavke(List<StavkaPotvrdePrijema> stavke) {
        this.stavke = stavke;
    }

    @Override
    public String vratiNazivTabele() {
        return "potvrda_prijema";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            int idPotvrdaPrijema = rs.getInt("potvrda_prijema.idPotvrdaPrijema");
            java.sql.Date datumSQL = rs.getDate("potvrda_prijema.datum");
            Date datum;
            if (datumSQL != null) {
                datum = new Date(datumSQL.getTime());
            } else {
                datum = null;
            }
            double ukTezinaPaketa = rs.getDouble("potvrda_prijema.ukTezinaPaketa");

            int idPostar = rs.getInt("postar.idPostar");
            String imePOS = rs.getString("postar.ime");
            String prezimePOS = rs.getString("postar.prezime");
            String korisnickoIme = rs.getString("postar.korisnickoIme");
            String sifra = rs.getString("postar.sifra");
            int dnevnica = rs.getInt("postar.dnevnica");
            Postar pos = new Postar(idPostar, imePOS, prezimePOS, korisnickoIme, sifra, dnevnica);

            int idPrimalac = rs.getInt("primalac.idPrimalac");
            String imePRIM = rs.getString("primalac.ime");
            String prezimePRIM = rs.getString("primalac.prezime");
            String email = rs.getString("primalac.email");
            String brojTelefona = rs.getString("primalac.brojTelefona");
            Primalac prim=new Primalac(idPrimalac, imePRIM, prezimePRIM, email, brojTelefona);
            
            PotvrdaPrijema pp=new PotvrdaPrijema(idPotvrdaPrijema, datum, ukTezinaPaketa, pos, prim, null); //PROVERI ZA STAVKE
            lista.add(pp);
        }

        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "datum,ukTezinaPaketa,postar,primalac";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String datumString;
        if (datum != null) {
            datumString = "'" + sdf.format(datum) + "'";
        } else {
            datumString = "NULL";
        }
        return datum + ", " + ukTezinaPaketa + ", " + postar.getIdPostar() + ", " + primalac.getIdPrimalac();
    }

    @Override
    public String vratiPrmarniKljuc() {
        return "potvrda_prijema.idPotvrdaPrijema=" + idPotvrdaPrijema;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String datumString;
        if (datum != null) {
            datumString = "'" + sdf.format(datum) + "'";
        } else {
            datumString = "NULL";
        }
        return "datum=" + datum + ", ukTezinaPaketa=" + ukTezinaPaketa + ", postar=" + postar.getIdPostar() + ", primalac=" + primalac.getIdPrimalac();
    }

}
