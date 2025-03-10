package com.java.reactive.utils;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class FileReaderService {

    private Callable<BufferedReader> openReader(Path path) throws IOException {
        return ()-> Files.newBufferedReader(path);
    }

    private BiFunction<BufferedReader, SynchronousSink<String>,BufferedReader> read() throws IOException{
        return (reader,sink)->{
            try{
                String line=reader.readLine();
                if(Objects.isNull(line)){
                    sink.complete();
                }
                sink.next(line);
                Utils.delay(1);
            }catch (Exception e){
               sink.error(new RuntimeException(e.getMessage()));
            }
            return reader;
        };
    }

    private Consumer<BufferedReader> closeReader(){
        return (reader)->{
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public Flux<String> readFile(Path path) throws Exception {
        return  Flux.generate(openReader(path),read(),closeReader());
    }
}
