package eu.fi.academy.espoo;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class NaruistaVetelijaKontrolleri {

    // Koska pistokkeen eli WebSocketin konfiguraatiossa on määritelty ns. juuren murupoluksi "/pistoke",
    // vastaanottaa tämä Spring Kontrollerin metodi "send" murupolkuun "pistoke/viestit_sisaan" saapuvat viestilähetykset
    // selaimen STOMP-protokollan asiakkaalta eli HTML:n index-sivulla JavaScriptissä
    // Stomp.over(new SockJS('/rekisteroidy'))
        @MessageMapping("/viestit_sisaan")
    // Saapunut viesti käsitellään ja sen jälkeen se lähetetään tässä määriteltyyn osoitteeseen,
    @SendTo("/keskustelunaihe_ulos/viestisanoma")
    // josta kaikki keskusteluaiheen seuraajat (tilaajat) vastaanottavat lähetyksen
    public ViestiUlosTilaajille kasitteleSaapuvaViestiUlosLahetettavaksi(ViestiSisaan sanoma) throws Exception {
        return new ViestiUlosTilaajille(sanoma.getViestinteksti());
    }
}
