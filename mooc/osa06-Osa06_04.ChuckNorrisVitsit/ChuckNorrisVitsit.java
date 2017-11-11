import java.net.URL;
import java.util.Scanner;
 
public class ChuckNorrisVitsit {
 
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
 
        // Toteuta vitsien lukeminen tässä
        while (true) {
            System.out.println("Jos haluat sulkea ohjelman, kirjoita lopeta.\nJos haluta arvotun vitsin, kirjoita satunnainen.\nJos haluat tietyn vitsin, anna sen numero:");
            String luettu = lukija.nextLine();
 
            if (luettu.equals("lopeta")) {
                break;
            }
 
            if (luettu.equals("satunnainen")) {
                try (Scanner noutaja = new Scanner(new URL("http://api.icndb.com/jokes/random").openStream())) {
 
                    System.out.println(noutaja.nextLine());
                    return;
                } catch (Exception e) {
                    System.out.println("Tiedoston lukeminen epäonnistui. Virhe: " + e.getMessage());
                }
 
            } else {
                int id = Integer.parseInt(luettu);
                try (Scanner noutaja = new Scanner(new URL("http://api.icndb.com/jokes/" + id).openStream())) {
 
                    System.out.println(noutaja.nextLine());
                    return;
                } catch (Exception e) {
                    System.out.println("Tiedoston lukeminen epäonnistui. Virhe: " + e.getMessage());
                }
            }
        }
    }
}