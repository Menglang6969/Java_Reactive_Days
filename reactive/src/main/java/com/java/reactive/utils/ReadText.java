package com.java.reactive.utils;

import reactor.core.publisher.Mono;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReadText {
    public static Mono<String> read(String filename) {
        System.out.println("Reading " + filename + ".....");
        return Mono.fromSupplier(() -> readFile(filename));
    }

//    public static String readFile(String fileName) {
//        Path path = Paths.get("src/main/resources");
//        try {
//            // Read the content of the file and return it
//            return Files.readString(path.resolve(fileName));
//        } catch (IOException e) {
//            // Throw a runtime exception with the message
//            throw new RuntimeException("Error reading file: " +e.getMessage());
//        }
//    }

    public static String readFile(String fileName) {
        try (InputStream inputStream = ReadText.class.getClassLoader().getResourceAsStream(fileName)) {
            if (inputStream == null) {
                throw new RuntimeException("File not found: " + fileName);
            }

            // Use Scanner to read the file content
            Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8);
            return scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + fileName, e);
        }
    }
}