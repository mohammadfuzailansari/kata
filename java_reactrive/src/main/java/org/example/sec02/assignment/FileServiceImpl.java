package org.example.sec02.assignment;

import org.example.common.Util;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import  java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileServiceImpl implements  FileService {

    public static final Path FILE_PATH = Path.of("src/main/resources/sec02");
    @Override
    public Mono<String> read(String fileName) {
        return Mono.fromCallable(() -> this.readFile(fileName));
    }

    private String readFile(String fileName){

        try {
            return Files.readString(FILE_PATH.resolve(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Mono<Void> write(String fileName, String content) {
        return Mono.fromRunnable(() -> this.writeFile(fileName,content));
    }

    private void writeFile(String fileName, String content){

        try {
            Files.writeString(FILE_PATH.resolve(fileName),content, StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Mono<Void> delete(String fileName) {
        return Mono.fromRunnable(() -> this.deleteFile(fileName));
    }

    private void deleteFile(String fileName){

        try {
            Files.delete(FILE_PATH.resolve(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String fileName = "sec02.txt";

        FileService fileService = new FileServiceImpl();

        fileService.write(fileName, "Line has been written ")
                        .subscribe(Util.subscriber());
        fileService.read(fileName)
                .subscribe(Util.subscriber());

        fileService.delete(fileName)
                .subscribe(Util.subscriber());

    }

}
