import java.util.ArrayList;
import java.util.Scanner;
 
public class FillarointiaBaanallaOsa2 {
 
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
 
        TiedostonLukija tiedLukija = new TiedostonLukija();
        ArrayList<String> pyorailijat = tiedLukija.lueTiedosto("helsingin-pyorailijamaarat.csv");
 
        String vuosi = lukija.nextLine();
        String kuukausi = lukija.nextLine();
         
        double keskiarvo
                = // luodaan virta listasta pyorailijat 
                pyorailijat.stream()
                        // muunnetaan listan merkkijonot merkkijonotaulukoiksi
                        // muunnos tapahtuu merkkijonon metodilla split
                        .map(merkkijono -> merkkijono.split(";"))
                        // nyt virta sisältää merkkijonotaulukkoja
                        // huomioidaan vain ne merkkijonotaulukot, joissa ensimmäisessä
                        // indeksissä (pvm) merkkijono "2014"
                        .filter(taulukko -> taulukko[0].contains(vuosi))
                        // huomioidaan vain ne merkkijonotaulukot, joissa ensimmäisessä
                        // indeksissä (pvm) merkkijono "tammi"
                        .filter(taulukko -> taulukko[0].contains(kuukausi))
                        // taulukon indeksissä 2 on kaisaniemen pyöräilijätilastot
                        // varmistetaan, että otamme huomioon vain ne rivit, joissa
                        // kaisaniemeen liittyen dataa
                        .filter(taulukko -> !taulukko[taulukko.length - 1].isEmpty())
                        // muunnetaan kaisaniemen pyöräilijöiden lukumäärä
                        // kokonaisluvuksi, ja tehdään virrasta lukuvirta
                        .mapToInt(taulukko -> Integer.parseInt(taulukko[taulukko.length - 1]))
                        // kutsutaan lukuvirralle average-metodia. metodi kerää kaikki
                        // jäljellä olevat luvut yhteen ja laskee niiden keskiarvon
                        .average()
                        // double-tyyppinen keskiarvo saadaan lopulta keskiarvon
                        // metodilla getAsDouble
                        .getAsDouble();
 
        System.out.println();
        System.out.println("Pyöräilijöitä keskimäärin tunnissa: " + keskiarvo);
        System.out.println("Pyöräilijöitä keskimäärin päivässä: " + (24.0 * keskiarvo));
    }
}