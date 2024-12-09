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
public class Mesto implements ApstraktniDomenskiObjekat {

    private int idMesto;
    private String naziv;
    private String pttBroj;
    private String adresa;

    public Mesto(int idMesto, String naziv, String pttBroj, String adresa) {
        this.idMesto = idMesto;
        this.naziv = naziv;
        this.pttBroj = pttBroj;
        this.adresa = adresa;
    }

    public Mesto() {
    }

    public int getIdMesto() {
        return idMesto;
    }

    public void setIdMesto(int idMesto) {
        this.idMesto = idMesto;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getPttBroj() {
        return pttBroj;
    }

    public void setPttBroj(String pttBroj) {
        this.pttBroj = pttBroj;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public String vratiNazivTabele() {
        return "mesto";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista=new ArrayList<>();
        while(rs.next()){
            int idMesto=rs.getInt("mesto.idMesto");
            String naziv=rs.getString("mesto.naziv");
            String pttBroj=rs.getString("mesto.pttBroj");
            String adresa=rs.getString("mesto.adresa");
            
            Mesto m=new Mesto(idMesto, naziv, pttBroj, adresa);
            lista.add(m);
        }
        
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "naziv,pttBroj,adresa";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'" + naziv + "', '" + pttBroj + "', '" + adresa + "'";
    }

    @Override
    public String vratiPrmarniKljuc() {
        return "mesto.idMesto="+idMesto;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "naziv='"+naziv+"', pttBroj="+pttBroj+", adresa='"+adresa+"'";
    }

}
