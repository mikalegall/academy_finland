package eu.fi.hki.maven;

public class ViestiUlosTilaajille {

    private String lahettaja;
    private String viestinteksti;
    private String aika;

    public ViestiUlosTilaajille(String lahettaja, String viestinteksti, String aika) {
        this.lahettaja = lahettaja;
        this.viestinteksti = viestinteksti;
        this.aika = aika;
    }

    public String getLahettaja() {
        return lahettaja;
    }

    public String getViestinteksti() {
        return viestinteksti;
    }

    public String getAika() {
        return aika;
    }
}
