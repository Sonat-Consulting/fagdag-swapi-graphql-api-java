package no.sonat.fagdag.graphql.swapiapi.scheduledtasks;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import no.sonat.fagdag.graphql.swapiapi.services.SwapiClientImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cache.CacheManager;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    @Autowired
    CacheManager cacheManager;

    @Autowired
    SwapiClientImpl swapiClient;

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);


    @EventListener(ApplicationReadyEvent.class)
    public void primeFilmCacheForExampleQuery() {
        log.info("Priming some of the data for demo purposes");
        swapiClient.getFilms();
    }

    @Scheduled(fixedRate = 3600000)
    public void evictAllcaches() {
        this.clearCache();
        this.primeFilmCacheForExampleQuery();
    }

    private void clearCache(){

        if (cacheManager.getCacheNames().size() == 0) {
            log.info("Cache empty");
            return;
        }

        log.info("Clearing {} cache entries", cacheManager.getCacheNames());

        for(String name:cacheManager.getCacheNames()){
            Objects.requireNonNull(cacheManager.getCache(name)).clear();
        }

    }
}
