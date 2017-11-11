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
public class Matkalaukku {
 
    private ArrayList<Tavara> tavarat;
    private int maksimipaino;
 
    public Matkalaukku(int maksimi) {
        this.tavarat = new ArrayList<>();
        this.maksimipaino = maksimi;
    }
 
    public void lisaaTavara(Tavara tavara) {
 
        Tavara apuri;
        int painoSumma = 0;
        for (int i = 0; i < tavarat.size(); i++) {
            apuri = tavarat.get(i);
            int lisaa = apuri.getPaino();
            painoSumma = painoSumma + lisaa;
        }
 
        Tavara tarkastus = tavara;
        int zekkaus = tarkastus.getPaino();
 
        if (maksimipaino < painoSumma + zekkaus) {
            return;
        } else {
            tavarat.add(tavara);
        }
 
    }
 
    public String toString() {
 
        Tavara apuri;
        int painoSumma = 0;
        for (int i = 0; i < tavarat.size(); i++) {
            apuri = tavarat.get(i);
            int lisaa = apuri.getPaino();
            painoSumma = painoSumma + lisaa;
        }
 
        if (tavarat.size() == 0) {
            return "ei tavaroita (" + painoSumma + "kg)";
        } else if (tavarat.size() == 1) {
            return tavarat.size() + " tavara (" + painoSumma + "kg)";
        } else {
            return tavarat.size() + " tavaraa (" + painoSumma + "kg)";
        }
    }
 
    public void tulostaTavarat() {
        Tavara apuri;
        for (int i = 0; i < tavarat.size(); i++) {
            apuri = tavarat.get(i);
            System.out.println(apuri);
        }
    }
 
    public int yhteispaino() {
 
        Tavara apuri;
        int painoSumma = 0;
 
        for (int i = 0; i < tavarat.size(); i++) {
            apuri = tavarat.get(i);
            int lisaa = apuri.getPaino();
            painoSumma = painoSumma + lisaa;
        }
 
        return painoSumma;
    }
 
    public Tavara raskainTavara() {
        if (tavarat.size() == 0) {
            return null;
        }
 
        Tavara alku = tavarat.get(0);
        int painavin = alku.getPaino();
        int painavinIndeksi = 0;
 
        Tavara apuri;
        for (int i = 0; i < tavarat.size(); i++) {
            apuri = tavarat.get(i);
            int paino = apuri.getPaino();
 
            if (painavin < paino) {
                painavin = paino;
                painavinIndeksi = i;
            }
        }
        return tavarat.get(painavinIndeksi);
    }
}