package no.sonat.fagdag.graphql.swapiapi.services;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class AudioServiceImplTest {

    @Test
    void play() {
        AudioServiceImpl audioService = new AudioServiceImpl();
        audioService.play(new File("src/main/resources/wav/R2D2-do.wav"), 0);

    }
}