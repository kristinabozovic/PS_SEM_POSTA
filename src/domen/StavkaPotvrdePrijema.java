/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Kristina
 */
public class StavkaPotvrdePrijema implements ApstraktniDomenskiObjekat {

    private int rb;
    private Date datumDostave;
    private double tezinaPaketa;
    private TipPaketa tipPaketa;

    public StavkaPotvrdePrijema() {
    }

    public StavkaPotvrdePrijema(int rb, Date datumDostave, double tezinaPaketa, TipPaketa tipPaketa) {
        this.rb = rb;
        this.datumDostave = datumDostave;
        this.tezinaPaketa = tezinaPaketa;
        this.tipPaketa = tipPaketa;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public Date getDatumDostave() {
        return datumDostave;
    }

    public void setDatumDostave(Date datumDostave) {
        this.datumDostave = datumDostave;
    }

    public double getTezinaPaketa() {
        return tezinaPaketa;
    }

    public void setTezinaPaketa(double tezinaPaketa) {
        this.tezinaPaketa = tezinaPaketa;
    }

    public TipPaketa getTipPaketa() {
        return tipPaketa;
    }

    public void setTipPaketa(TipPaketa tipPaketa) {
        this.tipPaketa = tipPaketa;
    }

    @Override
    public String vratiNazivTabele() {
        return "stavka_potvrde_prijema";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "rb,idPotvrdaPrijema, datumDostave,tezinaPaketa,idTipPaketa";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String datumDostaveString;
        if (datumDostave != null) {
            datumDostaveString = "'" + sdf.format(datumDostave) + "'";
        } else {
            datumDostaveString = "NULL";
        }
        return rb + ", " + datumDostaveString + ", " + tezinaPaketa + ", " + tipPaketa.getIdTipPaketa();
    }

    @Override
    public String vratiPrmarniKljuc() {
        return "";
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "";
    }

}
