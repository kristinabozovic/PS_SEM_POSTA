/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Kristina
 */
public class Postar implements ApstraktniDomenskiObjekat {

    private int idPostar;
    private String ime;
    String prezime;
    private String korisnickoIime;
    private String sifra;
    private int dnevnica;

    public Postar() {
    }

    public Postar(int postarId, String ime, String prezime, String korisnickoIime, String sifra, int dnevnica) {
        this.idPostar = postarId;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIime = korisnickoIime;
        this.sifra = sifra;
        this.dnevnica = dnevnica;
    }

    public int getIdPostar() {
        return idPostar;
    }

    public void setIdPostar(int postarId) {
        this.idPostar = postarId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorisnickoIime() {
        return korisnickoIime;
    }

    public void setKorisnickoIime(String korisnickoIime) {
        this.korisnickoIime = korisnickoIime;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public int getDnevnica() {
        return dnevnica;
    }

    public void setDnevnica(int dnevnica) {
        this.dnevnica = dnevnica;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.korisnickoIime);
        hash = 37 * hash + Objects.hashCode(this.sifra);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Postar other = (Postar) obj;
        if (!Objects.equals(this.korisnickoIime, other.korisnickoIime)) {
            return false;
        }
        return Objects.equals(this.sifra, other.sifra);
    }

    @Override
    public String vratiNazivTabele() {
        return "postar";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            int idPostar = rs.getInt("postar.idPostar");
            String ime = rs.getString("postar.ime");
            String prezime = rs.getString("postar.prezime");
            String korisnickoIme = rs.getString("postar.korisnickoIme");
            String sifra = rs.getString("postar.sifra");
            int dnevnica = rs.getInt("postar.dnevnica");

            Postar p=new Postar(idPostar, ime, prezime, korisnickoIime, sifra, dnevnica);
            lista.add(p);
        }

        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "ime,prezime,korisnickoIme,sifra,dnevnica";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'" + ime + "', '" + prezime + "', '" + korisnickoIime + "', '" + sifra + "'" + dnevnica;
    }

    @Override
    public String vratiPrmarniKljuc() {
        return "postar.idPostar=" + idPostar;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "ime='" + ime + "',prezime='" + prezime + "',korisnickoIme='" + korisnickoIime + "',sifra='" + sifra + "',dnevnica=" + dnevnica;
    }

}
