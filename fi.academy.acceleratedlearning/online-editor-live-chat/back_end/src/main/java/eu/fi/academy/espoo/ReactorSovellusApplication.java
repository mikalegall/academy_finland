/*
package eu.fi.academy.espoo;

// https://spring.io/guides/gs/messaging-reactor/
// Lopputulos printtaantuu konsoliin

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import reactor.Environment;
import reactor.bus.EventBus;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static reactor.bus.selector.Selectors.$;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class ReactorSovellusApplication implements CommandLineRunner {

    private static final int NUMBER_OF_QUOTES = 10;

    @Bean
    Environment env() {
        return Environment.initializeIfEmpty()
                .assignErrorJournal();
    }

    @Bean // The Reactor environment is defined with the environment() method.
        // The environment gets fed into the reactor() method to create an asynchronous reactor.
        // In this case, you are using the THREAD_POOL dispatcher.
        // HUOM! Event loop is used when you need all events on the exact same thread.
    EventBus createEventBus(Environment env) {
        return EventBus.create(env, Environment.THREAD_POOL);
    }
//    Reactor has four dispatchers to pick from: synchronous, ring buffer, thread pool, and event loop.
//    Synchronous is typically used inside a consumer, especially if you use Stream s and Promise s.
//    Ring buffer is used for large volumes of non-blocking events and is based on the LMAX disruptor.
//    Thread pool is ideal for longer running tasks that might be IO bound, and when it doesn’t matter what thread they are run on.
//    Event loop is used when you need all events on the exact same thread.

    @Autowired
    private EventBus eventBus;

    @Autowired
    private ReactorVastaanottaja receiver;

    @Autowired
    private ReactorJulkaisija publisher;

    @Bean
    public CountDownLatch latch() {
        return new CountDownLatch(NUMBER_OF_QUOTES);
    }

    @Override
    public void run(String... args) throws Exception {
        eventBus.on($("quotes"), receiver);
        publisher.publishQuotes(NUMBER_OF_QUOTES);
    }

    //  "Main-metodi noutaa reactorin (Environment) ja Receiverin"
    //  Lopputulos printtaantuu konsoliin
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext app = SpringApplication.run(ReactorSovellusApplication.class, args);

        app.getBean(CountDownLatch.class).await(1, TimeUnit.SECONDS);

        app.getBean(Environment.class).shutdown();
    }

}*/
