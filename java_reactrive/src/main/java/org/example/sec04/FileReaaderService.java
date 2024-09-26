package org.example.sec04;

import reactor.core.publisher.Flux;

import java.nio.file.Path;

public interface FileReaaderService {

    Flux<String> read(Path path);
}
