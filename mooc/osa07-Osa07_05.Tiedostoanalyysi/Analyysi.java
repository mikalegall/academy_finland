/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
/**
 *
 * @author Lare
 */
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
 
public class Analyysi {
 
    private String tiedosto;
 
    public Analyysi(String tiedosto) {
        this.tiedosto = tiedosto;
 
    }
 
    public int rivimaara() {
        ArrayList<String> rivit = new ArrayList<>();
        try {
            Files.lines(Paths.get(this.tiedosto))
                    .forEach(rivi -> rivit.add(rivi));
        } catch (Exception e) {
            System.out.println("Tiedoston lukeminen epäonnistui. Virhe: " + e.getMessage());
        }
 
        return rivit.size();
    }
 
    public int merkkeja() {
        ArrayList<String> merkeiksi = new ArrayList<>();
        try {
            Files.lines(Paths.get(this.tiedosto))
                    .forEach(rivi -> merkeiksi.add(rivi));
        } catch (Exception e) {
            System.out.println("Tiedoston lukeminen epäonnistui. Virhe: " + e.getMessage());
        }
 
        int merkkimaara = 0;
        int i = 0;
        while (i <= merkeiksi.size() - 1) {
            int pituus = merkeiksi.get(i).length();
            merkkimaara = merkkimaara + pituus;
            i++;
        }
        merkkimaara = merkkimaara + merkeiksi.size();
        return merkkimaara;
    }
}