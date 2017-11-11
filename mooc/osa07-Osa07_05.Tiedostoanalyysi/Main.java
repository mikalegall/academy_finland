import java.io.File;
 
public class Main {
 
    public static void main(String[] args) {
        // testaa luokkasi toimintaa täällä
 
        /* rivejä tässä on 3 ja merkkejä
        koska rivinvaihdotkin ovat
        merkkejä
         */
        String tiedosto = "src/testitiedosto.txt";
 
        //       File tiedosto = new File("src/testitiedosto.txt");
        Analyysi analyysi = new Analyysi(tiedosto);
        System.out.println("Rivejä: " + analyysi.rivimaara());
        System.out.println("Merkkejä: " + analyysi.merkkeja());
    }
}