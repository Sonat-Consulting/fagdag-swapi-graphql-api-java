package no.sonat.fagdag.graphql.swapiapi.services;

import no.sonat.fagdag.graphql.swapiapi.models.Audio;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class AudioServiceImplTest {

    @Test
    void play() {
        AudioServiceImpl audioService = new AudioServiceImpl();
        Audio audio = audioService.playRandom();

        assert(audio != null);
        assert(audio.getDescription() != null);
    }
}