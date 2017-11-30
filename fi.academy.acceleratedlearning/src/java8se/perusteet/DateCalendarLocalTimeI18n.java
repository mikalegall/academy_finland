package java8se.perusteet;

import com.sun.xml.internal.bind.v2.TODO;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateCalendarLocalTimeI18n {

    public static void main(String[] args) {

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
        System.out.println(vanhaPaivays);

        // Asettaa millisekuntit aloitushetkeen
        vanhaPaivays.setTime(0);
        // Tulostaa Date-luokan (Class) toteutuksen aloitusajanhetken
        System.out.println(vanhaPaivays);

System.out.println("**********************************************************************************************************************************************");

        Calendar uudempiCalendar = new GregorianCalendar(97, 7, 15);

        // TODO: Muunna Date-oliosta --> Calendar-olioksi
        // foo..setTime("Date-olio");                Date -> Calendar
//        Calendar kalenteriCalendar = uudempiCalendar.setTime(vanhaPaivays);

        // foo..getTime();                   Calendar -> Date
        Date kalenteriDate = uudempiCalendar.getTime();

        System.out.println(kalenteriDate);

System.out.println("**********************************************************************************************************************************************");

        // Ajankohdan muuntaminen Java8 päivämäärätoteutuksen olioksi
        LocalDate roberto = LocalDate.of(2002, Month.JULY, 20);
        System.out.println(roberto);
        // Ajankohdan muuntaminen Java8 päivämäärätoteutuksen olioksi
        LocalDate venla = LocalDate.parse("2008-08-18");
        System.out.println(venla);

        Period ikaero = Period.between(roberto, venla);
        System.out.println("Pojan ja tytön ikäero on " + ikaero.getYears() + " vuotta, "
                + ikaero.getMonths() + " kuukautta ja " + ikaero.getDays() +" päivää.");
    }
}

// **********************************************************************************************************************************************

// Tekstikenttien muuttaminen .properties-tiedostosta ResourceBundle-luokalla, jossa
// MessageFormat-luokka, jossa ChoiceFormat-luokka
// Päivämäärien muotoilu
// Palkan muotoilu (valuutta)
