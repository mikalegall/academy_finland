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
public class Kirjasto {
  
    private ArrayList<Kirja> teokset;
  
    public Kirjasto() {
        this.teokset = new ArrayList<>();
    }
  
    public void lisaaKirja(Kirja uusiKirja) {
        this.teokset.add(uusiKirja);
    }
  
    public ArrayList<Kirja> haeKirjaNimekkeella(String nimeke) {
        ArrayList<Kirja> loydetytNimikkeet = new ArrayList<>();
        int i = 0;
        while (i <= this.teokset.size() - 1) {
            Kirja tutkittava = this.teokset.get(i);
  
            if (tutkittava.nimeke().contains(nimeke)) {
                loydetytNimikkeet.add(tutkittava);
            }
            i++;
        }
  
        return loydetytNimikkeet;
    }
  
    public ArrayList<Kirja> haeKirjaJulkaisijalla(String julkaisija) {
        ArrayList<Kirja> loydetytJulkaisijat = new ArrayList<>();
        int i = 0;
        while (i <= this.teokset.size() - 1) {
            Kirja tutkittava = this.teokset.get(i);
  
            if (tutkittava.julkaisija().contains(julkaisija)) {
                loydetytJulkaisijat.add(tutkittava);
            }
            i++;
        }
  
        return loydetytJulkaisijat;
  
    }
  
    public ArrayList<Kirja> haeKirjaJulkaisuvuodella(int julkaisuvuosi) {
        ArrayList<Kirja> loydetytJulkaisuvuosi = new ArrayList<>();
        int i = 0;
        while (i < this.teokset.size()) {
            Kirja tutkittava = this.teokset.get(i);
  
            if (tutkittava.julkaisuvuosi() == julkaisuvuosi) {
                loydetytJulkaisuvuosi.add(tutkittava);
            }
            i++;
        }
  
        return loydetytJulkaisuvuosi;
  
    }
  
    public void tulostaKirjat() {
  
        for (int i = 0; i <= this.teokset.size() - 1; i++) {
            System.out.println(this.teokset.get(i));
        }
    }
  
    public void tulostaKirat() {
  
        for (int i = 0; i <= this.teokset.size() - 1; i++) {
            System.out.println(this.teokset.get(i));
        }
    }
}