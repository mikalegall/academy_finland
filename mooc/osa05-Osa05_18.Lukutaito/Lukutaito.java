import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
 
public class Lukutaito {
 
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
 
        TiedostonLukija tiedLukija = new TiedostonLukija();
        ArrayList<String> luetut = tiedLukija.lueTiedosto("lukutaito.csv");
 
        double miestenKeskiarvo
                = luetut.stream()
                        .map(merkkijono -> merkkijono.split(","))
                        .filter(taulukko -> !taulukko[2].contains("female"))
                        .filter(taulukko -> taulukko[2].contains("male"))
                        .filter(taulukko -> !taulukko[taulukko.length - 1].isEmpty())
                        .mapToDouble(taulukko -> Double.parseDouble(taulukko[taulukko.length - 1]))
                        .average().getAsDouble();
 
        double naistenKeskiarvo
                = luetut.stream()
                        .map(merkkijono -> merkkijono.split(","))
                        .filter(taulukko -> taulukko[2].contains("female"))
                        .filter(taulukko -> !taulukko[taulukko.length - 1].isEmpty())
                        .mapToDouble(taulukko -> Double.parseDouble(taulukko[taulukko.length - 1]))
                        .average().getAsDouble();
 
        System.out.println("Miesten lukutaidon keskiarvo: " + miestenKeskiarvo);
        System.out.println("Naisten lukutaidon keskiarvo: " + naistenKeskiarvo);
         
        double lukutaitoprosentti = 0.0;
 
        double suurin = 0;
        int seuranta = 0;
        int i = 0;
        while (i < luetut.size()) {
            String pilkottava = luetut.get(i);
            String[] palat = pilkottava.split(",");
         
            lukutaitoprosentti = Double.parseDouble(palat[5]);
            if (suurin < lukutaitoprosentti) {
                suurin = lukutaitoprosentti;
                seuranta = i;
            }
            i++;
        }
 
        String pilkottava = luetut.get(seuranta);
        String[] palat = pilkottava.split(",");
        System.out.println("Korkein lukutaito on maassa: " + palat[3]);
 
    }
}