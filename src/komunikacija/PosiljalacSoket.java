/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import domen.ApstraktniDomenskiObjekat;
import domen.ApstraktniDomenskiObjekat;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kristina
 */
public class PosiljalacSoket {//moze samo da salje zahtev

    private Socket s;

    public PosiljalacSoket(Socket s) {
        this.s = s;
    }

    public void posalji(Object obj) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            out.writeObject(obj);
            out.flush();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    

}
