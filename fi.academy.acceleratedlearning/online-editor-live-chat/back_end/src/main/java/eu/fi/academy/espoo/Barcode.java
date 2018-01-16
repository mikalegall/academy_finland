package eu.fi.academy.espoo;

import java.io.*;

public class Barcode {

    private String upc, ean, asin;

    public static void main(String[] args) {


        String source = null;
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ) {
            source = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private String lookupUPC(String name) {


        return x;
    }
// https://www.mkyong.com/java/how-to-send-http-request-getpost-in-java/
    private void sendOut(String foo) {
        try (
                ObjectOutputStream op = new ObjectOutputStream(new FileOutputStream("URL"));
        )
        {
            //	int ekaNumeraali = 73;
            //	double tokaDesimaali = 172.5;
            //	String merkkijono = "Opi koodaamaan 12 viikossa ja saa varma työpaikka";
            //	ArrayList<String> tekstiLista = new ArrayList<>();
            //		tekstiLista.add("Vihreä");
            //		tekstiLista.add("Sininen");
            // Murupolkuun ulostaminen alkaa
            //	op.writeInt(ekaNumeraali);
            //	op.writeDouble(tokaDesimaali);
            //	op.writeBytes(merkkijono);
            //	op.writeObject(tekstiLista);
            // Murupolkuun ulostaminen loppuu


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
