public class Lukutulostin {
 
    /*   
 
public void PERUSRUNKO(int luku) {
        int i = 0;
        int rivinumero = 0;
        while (rivinumero < luku) {
        System.out.print((rivinumero + 1) + " ");
                                     
                                    while (i <= rivinumero) {
                                        System.out.print("loppupötkö");
                                        i++;
                                    }
        System.out.println();
        rivinumero++;
        }
    }   
     
     */
    public void lukuporras(int luku) {
        int rivinumero = 0;
        while (rivinumero < luku) {
            int i = 0;
            while (i <= rivinumero) {
                System.out.print((i + 1) + " ");
                i++;
            }
            System.out.println();
            rivinumero++;
        }
    }
 
    public void jatkuvaLukuporras(int luku) {
        /*
    1 (1): 1
    2 (2): 2  3
    3 (3): 4  5  6
    4 (4): 7  8  9  10
    5 (5): 11 12 13 14 15
    6 (6): 16 17 18 19 20 21
         */
        int tulosta = 1;
        int rivinumero = 0;
        while (rivinumero < luku) {
 
            int i = 0;
 
            while (i <= rivinumero) {
 
                System.out.print(tulosta + " ");
 
                i++;
                tulosta++;
            }
 
            System.out.println();
 
            rivinumero++;
        }
    }
 
    public void kertokolmio(int luku) {
        int i = 0;
        int rivinumero = 0;
 
        while (rivinumero < luku) {
 
            System.out.print((rivinumero + 1) + " ");
 
            while (i < rivinumero) {
 
                int indeksi = 0;
                int tulosta = (rivinumero + 1) + (rivinumero + 1);
                while (indeksi < rivinumero) {
 
                    System.out.print(tulosta + " ");
                    indeksi++;
                    tulosta = tulosta + (rivinumero + 1);
 
                }
 
                i++;
            }
            System.out.println();
            rivinumero++;
        }
    }
}