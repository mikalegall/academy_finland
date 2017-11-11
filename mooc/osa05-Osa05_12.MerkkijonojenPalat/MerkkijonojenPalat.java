import java.util.Scanner;
 
public class MerkkijonojenPalat {
 
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
 
        String pilkottava = lukija.nextLine();
 
        String[] poistettava = pilkottava.split(" ");
 
        int i = 0;
        while (i < poistettava.length) {
            String pala = poistettava[i];
            System.out.println(pala);
            i++;
        }
 
    }
}