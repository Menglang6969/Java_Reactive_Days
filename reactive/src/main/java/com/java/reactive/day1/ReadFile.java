package com.java.reactive.day1;

import com.java.reactive.utils.ReadText;
import com.java.reactive.utils.Utils;

public class ReadFile {
    public static void main(String[] args) {
        ReadText.read("file.txt")
                .subscribe(Utils.onNext(),Utils.onError(),Utils.onComplete());
    }
}
