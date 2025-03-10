package com.java.reactive.day5_Operator;

import com.java.reactive.utils.Singleton;
import com.java.reactive.utils.Student;
import reactor.core.publisher.Flux;

import java.util.function.Function;

public class Transform {

    public static void main(String[] args) {
        getStudents()
                .transform(mapStudent())
                .subscribe(Singleton.subscriber(""));
    }

    private static Function<Flux<Student>, Flux<Student>> mapStudent() {
        return flux -> flux.filter(x -> x.getAge() > 15)
                .doOnNext(x->x.setName(x.getName().toUpperCase()))
                .doOnDiscard(Student.class,x->System.out.println(x.getName()+" and Age: "+ x.getAge()+ " Not Allowed"));
    }

    private static Flux<Student> getStudents() {
        return Flux.range(1, 10).map(x -> new Student());
    }

}
