package com.java.reactive.day1;

import com.java.reactive.utils.CountryRepository;
import com.java.reactive.utils.Utils;

public class FakerDemo {
    public static void main(String[] args) {

//       for (int i=0;i<10;i++) {
//           System.out.println(Faker.instance().color().name());
//       }

        CountryRepository.findBtId(6).subscribe(Utils.onNext(), Utils.onError(), Utils.onComplete());


    }
}
