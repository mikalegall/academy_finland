package eu.fi.hki.maven;

// Javan luokkakirjasto java.net on verkkoliikenne, pistokkeet (socket) ja URL

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker // Luo viestinvälittäjän ja mahdollistaa websocketien käytön
public class KonfigurointiWebSocketPistoke extends AbstractWebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {

        // Määrittelee STOMP-protokollalle osoitteen, johon selain ottaa yhteyttä rekisteröityäkseen
        registry.addEndpoint("/rekisteroidy");

        // Määrittelee SockJS fallback-tuen, jota käytetään mikäli käyttäjän selain ei tue websocketteja
        registry.addEndpoint("rekisteroidy").withSockJS();
    }


    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {

        // Sisääntulokanava, johon tullut liikenne ohjataan edelleen viestinvälittäjälle
        config.setApplicationDestinationPrefixes("/pistoke");

        // Luo viestinvälittäjälle murupolun, jota pitkin vastaukset lähetetään käyttäjälle
        config.enableSimpleBroker("/keskustelunaihe_ulos");
    }
}