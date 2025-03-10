package com.java.reactive.exercise;

import com.java.reactive.utils.FileReaderService;
import com.java.reactive.utils.Singleton;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFileLineByLine {
    public static void main(String[] args) {


        try (InputStream inputStream = ReadFileLineByLine.class.getClassLoader().getResourceAsStream("file1000.txt")) {
            if (inputStream == null) {
                throw new IllegalArgumentException("Resource file not found");
            }
            Path path = Paths.get(ReadFileLineByLine.class.getClassLoader().getResource("file1000.txt").toURI());

            System.out.println("Path: "+path);
            FileReaderService fileReader = new FileReaderService();
            fileReader.readFile(path).subscribe(Singleton.subscriber("Reading data "));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
