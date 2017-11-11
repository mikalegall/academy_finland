import java.util.Scanner;
 
public class RoundRobin {
 
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        int[] taulukko = new int[5];
        taulukko[0] = 1;
        taulukko[1] = 3;
        taulukko[2] = 5;
        taulukko[3] = 7;
        taulukko[4] = 9;
 
        while (true) {
            String komento = lukija.nextLine();
 
            if (komento.equals("lopeta")) {
                break;
            }
 
            if (komento.equals("tulosta")) {
                int indeksi = 0;
                while (indeksi < taulukko.length) {
                    System.out.print(taulukko[indeksi] + " ");
                    indeksi++;
                }
                System.out.println("");
            }
 
            // toteuta siirtotoiminnallisuus tänne
            if (komento.equals("siirra")) {
 
                int i = 0;
                while (i < taulukko.length) {
                    int alkion0VanhaArvo = taulukko[i];
                    i++;
                    int alkion1VanhaArvo = taulukko[i];
                    i++;
                    int alkion2VanhaArvo = taulukko[i];
                    i++;
                    int alkion3VanhaArvo = taulukko[i];
                    i++;
                    int alkion4VanhaArvo = taulukko[i];
 
                    taulukko[i] = alkion0VanhaArvo;
                    i--;
                    taulukko[i] = alkion4VanhaArvo;
                    i--;
                    taulukko[i] = alkion3VanhaArvo;
                    i--;
                    taulukko[i] = alkion2VanhaArvo;
                    i--;
                    taulukko[i] = alkion1VanhaArvo;
                    i = 5;
                }
            }
        }
    }
}