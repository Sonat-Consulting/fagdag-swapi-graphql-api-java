package no.sonat.fagdag.graphql.swapiapi.services;

import java.io.File;

public interface AudioService extends Runnable {
    static void playRandom() {}
    static void play(File file, int loop) { }
    static void stop() { }
}
