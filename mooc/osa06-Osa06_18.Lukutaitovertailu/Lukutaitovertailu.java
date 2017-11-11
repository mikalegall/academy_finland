import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
 
public class Lukutaitovertailu {
 
    public static void main(String[] args) {
 
        ArrayList<String> luetut = new ArrayList<>();
        // Luetut-niminen lista sisältää CSV-tiedoston,
        // yhdessä listan indeksissä on 1 "excelin" rivi
 
        try {
            Files.lines(Paths.get("lukutaito.csv"))
                    .forEach(rivi -> luetut.add(rivi));
        } catch (Exception e) {
            System.out.println("Tiedoston lukeminen epäonnistui. Virhe: " + e.getMessage());
        }
 
        ArrayList<String> uusiLista = new ArrayList<>();
 
        double lukutaitoprosentti;
        int pienimmanIndeksi = 0;
 
        int indeksi = 0;
        while (true) {
            double pieninLukutaitoProsentti = 101.00;
            int i = 0;
            // Luetut-niminen lista sisältää CSV-tiedoston,
            // yhdessä listan indeksissä on 1 "Excelin" rivi
            while (i < luetut.size()) {
 
                // Haetaan luetut-nimiseltä listalta 1 "excelin" rivi merkkijonoksi
                String pilkottava = luetut.get(i);
 
                // Pilkotaan yhden "excel" rivin sarakkeet oman taulukkoonsa eri indekseihin
                String[] palat = pilkottava.split(",");
                // Hakasulkeiden väliin ilmeistyi näkymätön numero kuvaamaan tietoa
                // joka kertoo montako "lohkoa / palaa" muodostui, kun
                // syötteenä annettu erotinmerkki nappastiin välistä pois
 
                // Otetaan esiin käsiteltävänä olevan valtion eli "excel" rivin lukutaitoprosentti
                lukutaitoprosentti = Double.parseDouble(palat[5]);
 
                if (pieninLukutaitoProsentti > lukutaitoprosentti) {
                    pieninLukutaitoProsentti = lukutaitoprosentti;
                    pienimmanIndeksi = i;
                }
 
                i++;
            }
 
            String lisattava = luetut.get(pienimmanIndeksi);
            uusiLista.add(lisattava);
            luetut.remove(pienimmanIndeksi);
            if (luetut.size() == 0) {
                break;
            }
        }
 
        int print = 0;
        while (print < uusiLista.size()) {
            String merkkijonoRivi = uusiLista.get(print);
            String[] sarake = merkkijonoRivi.split(",");
            String valtio = sarake[3];
            String vuosi = sarake[4];
            String sukupuoli = sarake[2];
            int vika = sukupuoli.indexOf("e ");
            String sukupuoliTulostus = sukupuoli.substring(0, vika + 1);
            String lukutaito = sarake[5];
 
            System.out.println(valtio + " (" + vuosi + ")," + sukupuoliTulostus + ", " + lukutaito);
            print++;
        }
    }
}