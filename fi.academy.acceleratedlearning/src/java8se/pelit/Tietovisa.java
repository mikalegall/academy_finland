package java8se.pelit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Tietovisa {

    // Käytetään kantaluokan "java.lang.Object" parametritonta (oletus-)konstruktoria
    public Tietovisa() {
        super();
    }

    // psvm+tab
    public static void main(String[] args) {

        int pistelaskuri = 0;

        /* Käytetään muuttujalle "kysymysPatteristo" käännöksen aikaista viittaustyyppiä "List", jonka
           todelliseksi tyypiksi tulee olion luomisen hetkellä "ArrayList". Näin toimien on tarvittaessa
           helpompaa vaihtaa luontiaikainen tyyppi myöhemmin, jos tarpeet muuttuu.
           Viittaustyypin <Generics> rajoitetaan Kysymys-olioon */
        List<Kysymys> kysymysPatteristo = Alusta.luoKysymykset();

        // Luokka Collections (päättyy s-kirjaimeen) toteuttaa (implements) samannimisen rajapinnan
        // java.util.Collection (ilman s-kirjainta).
        // "kysymysPatteristo" -lista toteutettaa Comparable-rajapinnan
        Collections.shuffle(kysymysPatteristo);

        try (
                Scanner lukija = new Scanner(System.in);
        )
        {
            int i = 0;
            while (i < kysymysPatteristo.size()) {

                Kysymys temp = kysymysPatteristo.get(i);
                String kyssari = temp.getKysymysteksti();
                System.out.print(kyssari);
                System.out.println("Vastausvaihtoehdot ovat");
                System.out.println(temp.getVastausvaihtoehdot());
                System.out.print("Anna vastausvaihtoehdoksi vain numero 1-3: ");
                int vastaus = Integer.parseInt(lukija.nextLine());

                int oikea = temp.getOikeanVaihtoehdonIndeksi();
                if (vastaus != oikea) {
                    System.out.println("Väärin meni");
                    System.out.println("Oikea vastausvaihtoehto olisi ollut: " + temp.getOikeanVaihtoehdonIndeksi());
                } else {
                    System.out.println("Onneksi olkoon, oikea vastaus!");
                    pistelaskuri++;
                }

                System.out.println("Pistetilisaldosi on " + pistelaskuri + "\n");
                i++;
            }
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        System.out.println("Lopputulos on " + pistelaskuri + " pistettä / " + kysymysPatteristo.size() + " mahdollisesta");
    }
}


// ---------------------------------------------------------------------------------------------------------------------


class Alusta{

    static List<Kysymys> luoKysymykset() {
        List<Kysymys> kysymysPatteristo = new ArrayList<>();

        Kysymys k1 = new Kysymys();
        k1.setKysymysteksti("Mikä viikonpäivä tänään on? ");
        k1.setVastausvaihtoehdot("1 = Tiistai", "2 = Torstai", "3 = Tänään");
        k1.setOikeanVaihtoehdonIndeksi(3);
        kysymysPatteristo.add(k1);

        Kysymys k2 = new Kysymys();
        k2.setKysymysteksti("Mitä väriä tietokone nyt ajattelee ");
        k2.setVastausvaihtoehdot("1 = Punainen", "2 = Vihreä", "3 = Keltainen");
        k2.setOikeanVaihtoehdonIndeksi(2);
        kysymysPatteristo.add(k2);

        Kysymys k3 = new Kysymys();
        k3.setKysymysteksti("Miten meni noin niinkuin omasta mielestä? ");
        k3.setVastausvaihtoehdot("1 = Terrific Thursday", "2 = Sama pää kesät talvet", "3 = Paremminkin on mennyt");
        k3.setOikeanVaihtoehdonIndeksi(1);
        kysymysPatteristo.add(k3);

        Kysymys k4 = new Kysymys();
        k4.setKysymysteksti("Paljonko joutuu korvaamaan, kun ei läpise koulutusta? ");
        k4.setVastausvaihtoehdot("1 = 17e", "2 = 17.000e", "3 = 1.700e");
        k4.setOikeanVaihtoehdonIndeksi(2);
        kysymysPatteristo.add(k4);

        return kysymysPatteristo;
    }
}


// ---------------------------------------------------------------------------------------------------------------------


class Kysymys {
    String kysymysteksti;
    List<String> vastausvaihtoehdot;
    int oikeanVaihtoehdonIndeksi;

    public Kysymys() {
    }

    public String getKysymysteksti() {
        return kysymysteksti;
    }

    public void setKysymysteksti(String kysymysteksti) {
        this.kysymysteksti = kysymysteksti;
    }

    public List<String> getVastausvaihtoehdot() {
        return vastausvaihtoehdot;
    }

    public void setVastausvaihtoehdot(String eka, String toka, String kolmas) {
        List temp = new ArrayList();
        temp.add(eka);
        temp.add(toka);
        temp.add(kolmas);
        this.vastausvaihtoehdot = temp;
    }

    public int getOikeanVaihtoehdonIndeksi() {
        return oikeanVaihtoehdonIndeksi;
    }

    public void setOikeanVaihtoehdonIndeksi(int oikeanVaihtoehdonIndeksi) {
        this.oikeanVaihtoehdonIndeksi = oikeanVaihtoehdonIndeksi;
    }
}