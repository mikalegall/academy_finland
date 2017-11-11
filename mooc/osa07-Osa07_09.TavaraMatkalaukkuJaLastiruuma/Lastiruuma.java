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
public class Lastiruuma {
 
    private ArrayList<Matkalaukku> laukut = new ArrayList<>();
    private int maksimipaino;
 
    public Lastiruuma(int maksimi) {
        this.maksimipaino = maksimi;
    }
 
    public void lisaaMatkalaukku(Matkalaukku laukku) {
 
        Matkalaukku apuri;
        int painoSumma = 0;
        for (int i = 0; i < laukut.size(); i++) {
            apuri = laukut.get(i);
            int lisaa = apuri.yhteispaino();
            painoSumma = painoSumma + lisaa;
        }
 
        Matkalaukku tarkastus = laukku;
        int zekkaus = tarkastus.yhteispaino();
 
        if (maksimipaino < painoSumma + zekkaus) {
            return;
        } else {
            laukut.add(laukku);
        }
    }
 
    public String toString() {
 
        Matkalaukku apuri;
        int painoSumma = 0;
        for (int i = 0; i < laukut.size(); i++) {
            apuri = laukut.get(i);
            int lisaa = apuri.yhteispaino();
            painoSumma = painoSumma + lisaa;
        }
 
        return laukut.size() + " matkalaukkua (" + painoSumma + "kg)";
    }
 
    public void tulostaTavarat() {
 
        Matkalaukku apuri;
        for (int i = 0; i < laukut.size(); i++) {
            apuri = laukut.get(i);
            apuri.tulostaTavarat();
        }
 
    }
 
}