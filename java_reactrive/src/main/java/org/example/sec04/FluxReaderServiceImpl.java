package org.example.sec04;

import org.example.common.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class FluxReaderServiceImpl implements FileReaaderService {
    private static BufferedReader readLine(BufferedReader bufferedReader, SynchronousSink<String> stringSynchronousSink) {
        try {
            String line = bufferedReader.readLine();
            if (Objects.isNull(line))
                stringSynchronousSink.complete();
            else
                stringSynchronousSink.next(line);
            return  bufferedReader;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void closeFile(BufferedReader bufferedReader) {
        try {
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Flux<String> read(Path path ) {

        return Flux.generate(() -> readFile(path),
                FluxReaderServiceImpl::readLine,
                FluxReaderServiceImpl::closeFile
                );
    }

    private BufferedReader readFile(Path path) {

        try {
            return Files.newBufferedReader(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

      new FluxReaderServiceImpl()
                .read(Path.of("src/main/resources/sec04/assignment.txt"))
                .takeUntil(s -> !s.equalsIgnoreCase("tata"))
                .subscribe(Util.subscriber());


        //fluxNo();


    }

    private static void fluxNo() {
        Flux.<Integer>create(fluxSink -> {

            for (int i = 0; i < 10; i++) {
                fluxSink.next(i);

            }
        }).takeUntil(o -> o > 5)
        .subscribe(Util.subscriber());
    }
}
