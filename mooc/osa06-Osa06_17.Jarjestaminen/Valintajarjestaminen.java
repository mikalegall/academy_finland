import java.util.Arrays;
 
public class Valintajarjestaminen {
 
    public int pienin(int[] taulukko) {
        int i = 0;
        int pienin = taulukko[i];
 
        while (i < taulukko.length) {
            if (pienin > taulukko[i]) {
                pienin = taulukko[i];
            }
            i++;
        }
        return pienin;
    }
 
    public int pienimmanIndeksi(int[] taulukko) {
        int indeksi = 0;
        int pienin = Valintajarjestaminen.this.pienin(taulukko);
 
        while (indeksi < taulukko.length) {
            if (taulukko[indeksi] == pienin) {
                break;
            }
            indeksi++;
        }
        return indeksi;
    }
 
    public int pienimmanIndeksiAlkaen(int[] taulukko, int aloitusIndeksi) {
        int i = aloitusIndeksi;
        int pienin = taulukko[i];
 
        while (i < taulukko.length) {
            if (pienin > taulukko[i]) {
                pienin = taulukko[i];
            }
            i++;
        }
 
        int indeksi = aloitusIndeksi;
        while (indeksi < taulukko.length) {
            if (taulukko[indeksi] == pienin) {
                break;
            }
            indeksi++;
        }
        return indeksi;
    }
 
    public void vaihda(int[] taulukko, int indeksi1, int indeksi2) {
        int vaihdaEka = indeksi1;
        int ekanArvo = taulukko[vaihdaEka];
 
        int vaihdaToka = indeksi2;
        int tokanArvo = taulukko[vaihdaToka];
 
        taulukko[vaihdaEka] = tokanArvo;
        taulukko[vaihdaToka] = ekanArvo;
    }
 
    public void jarjesta(int[] taulukko) {
        System.out.println(Arrays.toString(taulukko));
 
        int pieninIndeksi = Valintajarjestaminen.this.pienimmanIndeksi(taulukko);
        Valintajarjestaminen.this.vaihda(taulukko, 0, pieninIndeksi);
        int i = 1;
 
        while (i < taulukko.length) {
            int siirra = Valintajarjestaminen.this.pienimmanIndeksiAlkaen(taulukko, i);
            Valintajarjestaminen.this.vaihda(taulukko, i, siirra);
            System.out.println(Arrays.toString(taulukko));
            i++;
        }
 
    }
 
}