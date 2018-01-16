package eu.fi.academy.espoo;

// MIKA: application.properties tiedosto sisältää käyttäjätunnuksen ja salasanan paikalliseen SQL-kantaan "editorlive" (create database editorlive;)
import javax.persistence.*;

@Entity
/*
MIKA: @Entity ilmoittaa Hibernatelle, että tee tästä Java-luokasta tietokantataulu. Tässä Java-luokassa on oltava julkinen tai
protected-näkyvyydelle määritelty parametriton konstruktori (oletuskonstruktori riittää),
tämä luokka ei voi olla final tai enum (etukäteen määritellyt tyypit omaava), tälle luokalle täytyy luoda getterit ja setterit
*/

@Access(AccessType.PROPERTY)
/*
MIKA: @Access(AccessType.PROPERTY) muuttaa Java-luokan ja tietokantataulun yhdistämisen
tehtäväksi gettereiden perusteella (eikä normaaliin tapaan jäsenmuuttujien perusteella).
Tämän vuoksi annotaatiota @Id ja sen mukana olevaa tietoa yksilöllisestä
avaimesta @GeneratedValue(strategy= GenerationType.AUTO)
ei sidota jäsenmuuttujaan vaan getteriin
*/


// MIKA: Tässä voidaan antaa tietokantataulun nimi mikäli se ei vastaa Java-luokan nimeä eli halutaan käyttää aliasta
@Table(name = "ASIAKIRJA") // Hibernate natiivilla ilman nimeämistä oletusarvoinen taulu luotaisiin nimellä EVENT
public class Asiakirja {

    // MIKA: Tästä on poistettu annotattio @Id, koska @Access(AccessType.PROPERTY)
    private int id;

    @Transient// MIKA: Pyrkimys tulkita tietokantaan tallennettava teksti muodossa String eikä StringBuilder (toimii 11.12.2017 ilman tätäkin).
    private StringBuilder sb;
    private String tiedostonNimi;
    private String aiheenNimi;

    // Konstruktori
    public Asiakirja() {
        this.sb = new StringBuilder();
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Lob // MIKA: String on oletusarvoisesti VARCHAR(255), lisäämällä annotaation @Lob tulee tyypiksi TEXT (voi tosin olla tietokanta spesifi!)
    public String getText() {
        return sb.toString();
    }

    public void setText(String text) {
        this.sb = new StringBuilder(text);
    }

    public String getAiheenNimi() {
        return aiheenNimi;
    }

    public void setAiheenNimi(String aiheenNimi) {
        this.aiheenNimi = aiheenNimi;
    }

    public String getTiedostonNimi() {
        return tiedostonNimi;
    }

    public void setTiedostonNimi(String tiedostonNimi) {
        this.tiedostonNimi = tiedostonNimi;
    }


    public void delete(int start, int end) {
        sb.delete(start, end);
    }

    public void insert(int offset, String insertText) {
        sb.insert(offset, insertText);
    }

    public void insert(int start, int end, String insertText) {
        delete(start, end);
        insert(start, insertText);

    }


}


