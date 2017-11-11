import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
/**
 *
 * @author Lare
 */
public class Sensuroija {
 
    private String sensuroitavaSana;
    private ArrayList<String> rivit = new ArrayList<>();
     
    public Sensuroija(String sensuroitavaSana) {
        this.sensuroitavaSana = sensuroitavaSana;
    }
 
    public void sensuroi(String lahdetiedosto, String kohdetiedosto) {
        this.rivit = new ArrayList<>();
        try {
            Files.lines(Paths.get(lahdetiedosto), StandardCharsets.UTF_8)
                    .forEach(rivi -> rivit.add(rivi));
        } catch (Exception e) {
            System.out.println("Tiedoston lukeminen epäonnistui. Virhe: " + e.getMessage());
        }
 
         
         
        ArrayList<String> tuotos = new ArrayList<>();
 
        int i = 0;
        while (i < this.rivit.size()){
             
                String verrattava = this.rivit.get(i);
                tuotos.add(verrattava);
 
                 
                    if (verrattava.contains(this.sensuroitavaSana)){
                        tuotos.remove(tuotos.size()-1);
                    }
                        
                i++;
            }
             
 
        try {
            Files.write(Paths.get(kohdetiedosto), tuotos, StandardCharsets.UTF_8);
        } catch (Exception e) {
                System.out.println("Tiedoston kirjoittaminen epäonnistui. Virhe: " + e.getMessage());
        }
    }  
}