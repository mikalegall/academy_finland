public class Tulostin {
 
    public void tulostaTaulukkoTahtina(int[] taulukko) {
        // Kirjoita tulostuskoodi tänne
 
        int i = 0;
 
        while (i < taulukko.length) {
            int kpl = taulukko[i];
 
            int indeksi = 0;
            while (indeksi < kpl) {
                System.out.print("*");
                indeksi++;
            }
            System.out.println("");
            i++;
        }
    }
}