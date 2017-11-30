package java8se.kryptologia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Caesar {

    public static void kaynnista() {

        System.out.print("Anna salattava: ");
        String merkkijono = null;
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ) {
            merkkijono = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Caesar salaaja = new Caesar();
        String salattu = salaaja.salaa(merkkijono);
        System.out.println("Salattuna se on: " + salattu.toUpperCase());

        String purettu = salaaja.pura(salattu);
        System.out.println("Salaus purettuna se on: " + purettu.toUpperCase());
    }


    String salaa(String salattava) {

        String salattu = "";

        int pituus = salattava.length();
        for (int i = 0; i < pituus; i++) {
            int merkki = (int) salattava.charAt(i);

            if (merkki >= 65 && merkki <= 122) {

                merkki = merkki + 3;
                char muunnos = (char) merkki;
                salattu = (String) salattu + muunnos;
            }
        }
        return salattu;
    }


    String pura(String purettava) {

        String purettu = "";

        int pituus = purettava.length();
        for (int i = 0; i < pituus; i++) {
            int merkki = (int) purettava.charAt(i);
            merkki = merkki - 3;
            char muunnos = (char) merkki;
            purettu = (String) purettu + muunnos;
        }
        return purettu;
    }
}

