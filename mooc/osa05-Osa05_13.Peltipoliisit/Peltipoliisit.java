import java.util.ArrayList;
import java.util.Scanner;
 
public class Peltipoliisit {
 
    public static void main(String[] args) {
 
        Scanner lukija = new Scanner(System.in);
 
        ArrayList<String> lista = new ArrayList<>();
 
        while (true) {
            String syote = lukija.nextLine();
            if (syote.isEmpty()) {
                break;
            }
            lista.add(syote);
        }
 
        int iAluksi = 0;
 
        String tutkittavaRivialuksi = lista.get(iAluksi);
        int indeksiAluksi = tutkittavaRivialuksi.indexOf(";");
        int pieninNopeus = Integer.parseInt(tutkittavaRivialuksi.substring(indeksiAluksi + 1));
 
        int suurinNopeus = Integer.parseInt(tutkittavaRivialuksi.substring(indeksiAluksi + 1));
 
        int summa = 0;
 
        int i = 0;
        int tulostusIndeksi = 0;
        int printIndeksi = 0;
        while (i < lista.size()) {
            if (i == lista.size()) {
                break;
            }
 
            String tutkittavaRivi = lista.get(i);
            int indeksi = tutkittavaRivi.indexOf(";");
            int nopeus = Integer.parseInt(tutkittavaRivi.substring(indeksi + 1));
            summa = summa + nopeus;
 
            if (pieninNopeus > nopeus) {
                pieninNopeus = nopeus;
                tulostusIndeksi = i;
            }
 
            if (suurinNopeus < nopeus) {
                suurinNopeus = nopeus;
                printIndeksi = i;
            }
 
            i++;
        }
 
        String suurin = lista.get(printIndeksi);
        String tutkittavaRivi = suurin;
        String[] palat = tutkittavaRivi.split(";");
        System.out.println("Suurin: " + palat[0] + ", " + palat[1]);
 
        String pienin = lista.get(tulostusIndeksi);
        String tutkittavaLine = pienin;
        String[] alkiot = tutkittavaLine.split(";");
        System.out.println("Pienin: " + alkiot[0] + ", " + alkiot[1]);
 
//        System.out.println("Pienin: " + pienin.replace(';', ','));
        System.out.println("Keskiarvo: " + (double) summa / lista.size());
    }
}