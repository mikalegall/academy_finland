package java8se.perusteet;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.xml.internal.bind.v2.TODO;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateCalendarLocalTimeI18n {

    public static void main(String[] args) {

        System.out.println("VANHA 'Date':");
/*
         Montako millisekuntia on kulunut ajankohdasta 1.1.1970 klo 0.00 (UTC)
         eli Suomen aikaa Thu Jan 01 02:00:00 EET 1970. Siihen voi kuitenkin antaa
         parametriksi lyhyen vuoden, kun tarkoittaa 1900-lukua eli esim.
         Date vanhaPaivays = new Date(97, 7, 15);
         HUOM! Date-luokalla (Class) kuukausien indeksöinti alkaa nollasta (0), joten
         esim. elokuu on numero 7 (tammikuun ollessa nolla).
*/
        Date vanhaPaivays = new Date();

/*
         sout+tab
         Tulostaa ruudulle ohjelman käynnistämisen aikaisen ajanhetken eli
         "montako millisekuntia on kulunut ajankohdasta..."
*/
        System.out.println("Nyt on:\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + vanhaPaivays);

        // Asettaa millisekuntit aloitushetkeen
        vanhaPaivays.setTime(0);
        // Tulostaa Date-luokan (Class) toteutuksen aloitusajanhetken
        System.out.println("Toteutuksen aloitusajanhetki oli:\t\t\t\t\t\t\t" + vanhaPaivays);

System.out.println("**********************************************************************************************************************************************");

        System.out.println("UUDEMPI 'Calendar':");

        Calendar uudempiCalendar = new GregorianCalendar(97, 7, 15);


        // foo..setTime("Date-olio");                Date -> Calendar
        Date vanhaMuotoPaivayksesta = new Date(73, 03, 01);
        Calendar uudempiMuotoCalendar = new GregorianCalendar();
        uudempiMuotoCalendar.setTime(vanhaMuotoPaivayksesta);

        System.out.println("Oma ilmestymiseni oli:\t\t\t\t\t\t\t\t\t\t" + uudempiMuotoCalendar.getTime());

        // foo..getTime();                   Calendar -> Date
        Date kalenteriDate = uudempiCalendar.getTime();

        System.out.println("Esikoiseni syntyi:\t\t\t\t\t\t\t\t\t\t\t" + kalenteriDate);

System.out.println("**********************************************************************************************************************************************");

        System.out.println("UUSIN 'LocalDate':");

        // Ajankohdan muuntaminen Java8 päivämäärätoteutuksen olioksi
        LocalDate roberto = LocalDate.of(2002, Month.JULY, 20);
        System.out.println("Katraani keskimmäinen syntyi:\t\t\t\t\t\t\t\t" + roberto);
        // Ajankohdan muuntaminen Java8 päivämäärätoteutuksen olioksi
        LocalDate venla = LocalDate.parse("2008-08-18");
        System.out.println("Kuopukseni syntyi:\t\t\t\t\t\t\t\t\t\t\t" + venla);

        Period ikaero = Period.between(roberto, venla);
        System.out.println("Pojan ja nuorimman tyttäreni ikäero on " + ikaero.getYears() + " vuotta, "
                + ikaero.getMonths() + " kuukautta ja " + ikaero.getDays() +" päivää.\n");

        // java.sql.Date.valueOf("Date-olio");  LocalDate -> Date
        Date vanhaPaivaysMuoto = java.sql.Date.valueOf(roberto);
        System.out.println("LocalDate muunnettuna muotoon 'Date':\t\t\t\t\t\t" + vanhaPaivaysMuoto);


        GregorianCalendar uudempiCalendarMuoto = GregorianCalendar.from(venla.atStartOfDay(ZoneId.systemDefault()));
        System.out.println("LocalDate muunnettuna muotoon 'Calendar (Gregorian)':\t\t" + uudempiCalendarMuoto.getTime());

    }
}

// **********************************************************************************************************************************************

// Tekstikenttien muuttaminen .properties-tiedostosta ResourceBundle-luokalla, jossa
// MessageFormat-luokka, jossa ChoiceFormat-luokka
// Päivämäärien muotoilu
// Palkan muotoilu (valuutta)
