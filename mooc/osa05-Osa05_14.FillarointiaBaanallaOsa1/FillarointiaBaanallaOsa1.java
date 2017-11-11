import java.util.ArrayList;
import java.util.Scanner;
 
public class FillarointiaBaanallaOsa1 {
 
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
 
        TiedostonLukija tiedLukija = new TiedostonLukija();
        ArrayList<String> pyorailijat = tiedLukija.lueTiedosto("helsingin-pyorailijamaarat.csv");
 
        String vuosi = lukija.nextLine();
 
        int tunteja = 0;
        int pyorailijoita = 0;
 
        String kuukausi = lukija.nextLine();
 
        int indeksi = 1;
        while (indeksi < pyorailijat.size()) {
            String rivi = pyorailijat.get(indeksi);
            indeksi++;
 
            String[] palat = rivi.split(";");
 
            if (!palat[0].contains(vuosi)) {
                continue;
            }
 
            if (!palat[0].contains(kuukausi)) {
                continue;
            }
 
            tunteja++;
 
            if (!palat[palat.length - 1].isEmpty()) {
                pyorailijoita += Integer.parseInt(palat[palat.length - 1]);
            }
        }
 
        System.out.println();
        System.out.println("Pyöräilijöitä keskimäärin tunnissa: " + (1.0 * pyorailijoita / tunteja));
        System.out.println("Pyöräilijöitä keskimäärin päivässä: " + (24.0 * pyorailijoita / tunteja));
    }
}