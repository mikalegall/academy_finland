/*
package eu.fi.academy.espoo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reactor.bus.Event;
import reactor.fn.Consumer;

import java.util.concurrent.CountDownLatch;

@Service // Implementoidaan Consumer rajapinta toteuttamalla accept() metodi, joka reagoi tapahtumiin
class ReactorVastaanottaja implements Consumer<Event<Integer>> {

    @Autowired
    CountDownLatch latch;

    RestTemplate restTemplate = new RestTemplate();

    // Aina kun vastaanotetaan Integer, niin laukaistaan metodi
    public void accept(Event<Integer> ev) {

        // Tämä ilmeisesti muokattaisiin ViestiSisaan -olioksi
        ReactorQuoteResource quoteResource =

              // Noutaa JSON-olion ja mäppää sen ReactorQuoteResource-olioksi (ORM-operaatio)
                                                // Tämä ilmeisesti muokattaisiin "/viestit_sisaan"
                restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", ReactorQuoteResource.class);

                                        // getViestinteksti();
        System.out.println("Quote " + ev.getData() + ": " + quoteResource.getValue().getQuote());
        latch.countDown();
    }

}

*/
