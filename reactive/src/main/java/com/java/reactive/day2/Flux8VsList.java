package com.java.reactive.day2;

import com.github.javafaker.Faker;
import com.java.reactive.utils.Utils;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class Flux8VsList {
    public static void main(String[] args) {
        System.out.println("Loading.........");
       // List<String> colors = generateColorsWithList(5);
       // System.out.println(colors);

        Flux<String> fluxColors= generateColorsWithFlux(5);
        fluxColors.subscribe(x->System.out.println("getting: "+x));


    }


    //Using with Flux get 1 return 1 to caller
    public static Flux<String> generateColorsWithFlux(int count) {
        Flux<String> colorFlux = Flux.range(1,count).map(x->getColour());
        return colorFlux;
    }


    //Using with List wait for all results the return
    public static List<String> generateColorsWithList(int colors) {
        List<String> colorsList = new ArrayList<String>();
        for (int i = 0; i < colors; i++) {
            colorsList.add(getColour());
        }
        return colorsList;
    }

    public static String getColour() {
        String color = Faker.instance().color().name();
        Utils.delay(1);
        return color;
    }
}

