import java.util.ArrayList;
import java.util.Scanner;
 
public class Hirsipuu {
 
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
 
        ArrayList<String> arvattavaSanaChar = new ArrayList<>();
        ArrayList<String> tulostusRuudukko = new ArrayList<>();
        ArrayList<String> arvatutChar = new ArrayList<>();
        int laskuri = 0;
 
        System.out.print("Mitä merkkijonoa arvataan? ");
        String arvattavaSana = lukija.nextLine();
 
        int pituus = arvattavaSana.length() - 1;
        // Luodaan tyhjät merkit arvattaville kirjaimille
        int loop = 0;
        while (loop <= pituus) {
            tulostusRuudukko.add("_");
            loop++;
        }
 
        // Lisää arvattavan sanan jokaisen merkin irrallisena taulukkoon
        // nimeltä: arvattavaSanaChar
        int kieppi = 0;
        char lisaaChar = arvattavaSana.charAt(kieppi);
        while (kieppi <= pituus) {
            lisaaChar = arvattavaSana.charAt(kieppi);
            String lisaaString = String.valueOf(lisaaChar);
            arvattavaSanaChar.add(lisaaString);
            kieppi++;
        }
 
        int yritys = arvattavaSana.length() +1;
 
        System.out.print("Sana: ");
        int i = 0;
        while (i <= pituus) {
            System.out.print(tulostusRuudukko.get(i) + " ");
            i++;
        }
        System.out.println("\nArvauksia jäljellä: " + (yritys-1));
        yritys--;
        System.out.println("Arvatut:");
        System.out.print("Arvaus: ");
        String arvaus = lukija.nextLine();
 
        arvatutChar.add(arvaus);
 
        while (yritys != 0) {
 
            System.out.print("Sana: ");
 
            int indeksi = 0;
            while (indeksi <= pituus) {
                String org = arvattavaSanaChar.get(indeksi);
 
                if (org.equals(arvaus)) {
                    tulostusRuudukko.remove(indeksi);
                    tulostusRuudukko.add(indeksi, org);
                    laskuri++;
                }
                System.out.print(tulostusRuudukko.get(indeksi) + " ");
                indeksi++;
            }
            int testi = arvattavaSana.length();
            if (laskuri == testi) {
                System.out.println("\n\nVoitit!");
                break;
            }
            System.out.println("\nArvauksia jäljellä: " + (yritys-1));
            yritys--;
            System.out.print("Arvatut: ");
 
            int seuranta = 0;
            int kohde = arvatutChar.size();
            while (seuranta < kohde) {
                System.out.print(arvatutChar.get(seuranta) + " ");
                seuranta++;
            }
            System.out.println("");
 
            System.out.print("Arvaus: ");
            arvaus = lukija.nextLine();
 
            arvatutChar.add(arvaus);
 
            if (yritys == 0) {
                System.out.println("\nHävisit!");
                break;
            }
 
        }
 
    }
}