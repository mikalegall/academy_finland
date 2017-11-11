public class Main {
 
    public static void main(String[] args) {
        // Testaa ohjelmasi toimintaa täällä!
        Kirjasto kirjahylly = new Kirjasto();
  
        kirjahylly.lisaaKirja(new Kirja("Cheese Problems Solved", "Woodhead Publishing", 2007));
        kirjahylly.lisaaKirja(new Kirja("The Stinky Cheese Man and Other Fairly Stupid Tales", "Penguin Group", 1992));
        kirjahylly.lisaaKirja(new Kirja("NHL Hockey", "Stanley Kupp", 1952));
        kirjahylly.lisaaKirja(new Kirja("Battle Axes", "Tom A. Hawk", 1851));
  
        kirjahylly.haeKirjaNimekkeella("Cheese").forEach(k -> System.out.println(k));
  
        System.out.println("---");
        kirjahylly.haeKirjaJulkaisijalla("Pong Group").forEach(k -> System.out.println(k));
  
        System.out.println("---");
        kirjahylly.haeKirjaJulkaisuvuodella(1851).forEach(k -> System.out.println(k));
    }
}