package com.java.reactive.day8_combine_publisher;

import com.java.reactive.utils.Singleton;
import com.java.reactive.utils.StringGenerator;

public class CombinePublisher_StartWith {
    public static void main(String[] args) {

        StringGenerator generator = new StringGenerator();
        generator.getName()
                .take(2)
                .subscribe(Singleton.subscriber("Menglang==>"));

        generator.getName().take(3).subscribe(Singleton.subscriber("Jinglong==>"));
    }


}
