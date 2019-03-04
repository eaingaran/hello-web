package xyz.aingaran.gradle.hello.bootstrap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {

    private Logger log = LogManager.getLogger(ProductLoader.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("Application Loaded");
    }
}
