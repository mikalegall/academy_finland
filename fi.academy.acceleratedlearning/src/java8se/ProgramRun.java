package fi.academy.acceleratedlearning.java8se;

import fi.academy.acceleratedlearning.java8se.kryptologia.Caesar;
import fi.academy.acceleratedlearning.java8se.pelit.Tietovisa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * JetBrains: IntelliJ Ultimate
 */

public class ProgramRun {

    // psvm+tab
    public static void main(String[] args) {

        // sout+tab
        System.out.println("Valitse käynnistettävä ohjelma numerovalinnalla\n1. Arvauspeli\t2. Salakirjoitus");

        String valinta = null;
        try (
                // Input tai output välineen avaaminen tässä aiheuttaa try-lohkosta poistuttaessa
                // avatun välineen automaattisen sulkemisen, ettei se vahingossa jää sulkematta "in.close();"
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ) {
            // Luetaan käyttäjän antama syöte ja asetetaan se vastaukseksi (valinnaksi)
            // käyttäjälle esitettyyn kysymykseen
            valinta = in.readLine();
        } catch (IOException e) {
            System.out.println("Syötteenlukijassa tapahtui jotain odottamatonta...\nYritä uudelleen");
        }

        // Huvikseen switch-ehtolause vaikka se on jostain ohjelmointikielestä jopa poistettu tietoisella päätöksellä
        switch (valinta) {
            case "1":
                aja1();
                break;
            case "2":
                aja2();
                break;
            default:
                System.out.println("Syötteeksi kelpaa vain ilmoitettu numero, yritä uudelleen");
        }
    }

    private static void aja1() {
        Tietovisa.main(null);
    }

    private static void aja2() {
        Caesar.kaynnista();
    }

}

// (cast) on tyyppimuunnos esim. String merkki = "" + 6;
// List<Tyyppi> Arrays.asList(taulukko)     // primitiivityypit eivät käy
// String[] taulukko = lista.toArray();
// Luokan täytyy implements java.io.Serializable jos halutaan siirtää esim. HashMap
// verkon yli siten että tallennetut avain-arvo-parit säilyvät
// Vinkki literaaliarvon vertailuun: Kirjoita mieluummin
//"foo".equals(muuttuja) kuin toisinpäin
// Tällöin vältetään mahdollinen NullPointerException-poikkeus
// Comparator
