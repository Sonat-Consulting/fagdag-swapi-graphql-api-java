package no.sonat.fagdag.graphql.swapiapi.services;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import no.sonat.fagdag.graphql.swapiapi.models.Audio;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.InputStream;
import java.util.Random;
import javax.sound.sampled.*;

@Component
public class AudioServiceImpl implements AudioService {

    private Clip clip;

    @SneakyThrows
    public Audio playRandom()
    {
        Random random = new Random();

        ObjectMapper mapper = new ObjectMapper();
        InputStream is = this.getClass().getResourceAsStream("/wav/sounds.json");
        Audio[] audios = mapper.readValue(is, Audio[].class);

        Audio audio = audios[random.nextInt(audios.length)];
        this.play(new File(audio.getPath()), 0);

        return audio;
    }

    public void play(File file, int loop)
    {
        try
        {
            clip = (Clip)AudioSystem.getLine(new Line.Info(Clip.class));

            clip.addLineListener(new LineListener()
            {
                @Override
                public void update(LineEvent event)
                {
                    if (event.getType() == LineEvent.Type.STOP)
                        clip.close();
                }
            });

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            AudioFormat format = audioInputStream.getFormat();

            clip.open(audioInputStream);
            clip.loop(loop);
            clip.start();

            Thread.sleep( (long) (((float) file.length() / (format.getFrameSize() * format.getFrameRate())) * 1000) * ( 1 + loop));
        }
        catch (Exception exc)
        {
            exc.printStackTrace(System.out);
        }
    }

    public void stop() {
        clip.stop();
    }

    @SneakyThrows
    @Override
    public void run() {
        Random random = new Random();

        ObjectMapper mapper = new ObjectMapper();
        InputStream is = this.getClass().getResourceAsStream("/wav/sounds.json");
        Audio[] audios = mapper.readValue(is, Audio[].class);

        Audio audio = audios[random.nextInt(audios.length)];
        this.play(new File(audio.getPath()), 0);
    }

}
