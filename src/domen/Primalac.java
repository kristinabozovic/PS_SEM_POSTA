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
public class Primalac implements ApstraktniDomenskiObjekat {

    private int idPrimalac;
    private String ime;
    String prezime;
    private String email;
    private String brojTelefona;

    public Primalac() {
    }

    public Primalac(int idPrimalac, String ime, String prezime, String email, String brojTelefona) {
        this.idPrimalac = idPrimalac;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.brojTelefona = brojTelefona;
    }

    public int getIdPrimalac() {
        return idPrimalac;
    }

    public void setIdPrimalac(int idPrimalac) {
        this.idPrimalac = idPrimalac;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    @Override
    public String vratiNazivTabele() {
        return "primalac";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            int idPrimalac = rs.getInt("primalac.idPrimalac");
            String ime = rs.getString("primalac.ime");
            String prezime = rs.getString("primalac.prezime");
            String email = rs.getString("primalac.email");
            String brojTelefona = rs.getString("primalac.brojTelefona");

            Primalac p=new Primalac(idPrimalac, ime, prezime, email, brojTelefona);
            lista.add(p);
        }

        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "ime,prezime,email,brojTelefona";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'" + ime + "', '" + prezime + "', '" + email + "', '" + brojTelefona + "'";
    }

    @Override
    public String vratiPrmarniKljuc() {
        return "primalac.idPrimalac=" + idPrimalac;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "ime='" + ime + "',prezime='" + prezime + "',email='" + email + "',brojTelefona='" + brojTelefona + "'";
    }

}
