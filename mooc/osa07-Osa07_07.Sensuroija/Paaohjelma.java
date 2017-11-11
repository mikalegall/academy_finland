public class Paaohjelma {
 
    public static void main(String[] args) {
 
        String lahdeTiedosto = "src/pienilista.txt";
        String kohdeTiedosto = "src/pienilista-sensuroitu.txt";
        // kaikki sanat tiedostossa src/sanalista.txt
 
        // Voit kokeilla sensurointia seuraavalla esimerkillä kun olet
        // toteuttanut luokan Sensuroija
         Sensuroija sensuroija = new Sensuroija("aal");
         sensuroija.sensuroi(lahdeTiedosto, kohdeTiedosto);
        System.out.println(sensuroija);
    }
}