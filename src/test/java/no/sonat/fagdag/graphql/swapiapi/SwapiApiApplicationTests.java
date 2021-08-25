package no.sonat.fagdag.graphql.swapiapi;

import com.google.common.util.concurrent.AbstractListeningExecutorService;
import no.sonat.fagdag.graphql.swapiapi.services.AudioService;
import no.sonat.fagdag.graphql.swapiapi.services.AudioServiceImpl;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SwapiApiApplicationTests {

	@Test
	void contextLoads() {
		AudioServiceImpl audioService = new AudioServiceImpl();

		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(() -> {
			try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String threadName = Thread.currentThread().getName();
			System.out.println("Hello " + threadName);
		});

		System.out.println("goodbye");
	}


}
