package com.spring_boot_course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@SpringBootApplication
//@ComponentScan(basePackages = "com.spring_boot_course")
//@EnableAutoConfiguration
@RestController
public class Main_old {
    public static void main(String[] args) {
        SpringApplication.run(Main_old.class, args);
    }

    @GetMapping("/")
    public GreatResponse great() {
        return new GreatResponse(
                "Hello World",
                List.of("Java", "Python"),
                new Person("test", 30, 100.00)
        );
    }

    record Person(String name, int age, double savings) {}

    record GreatResponse(
            String great,
            List<String> favProgramingLanguages,
            Person person
    ) {

    }

//    class GreatResponse {
//
//        private final String greet;
//        public GreatResponse(String greet) {
//            this.greet = greet;
//        }
//
//        public String getGreet() {
//            return greet;
//        }
//
//        @Override
//        public String toString() {
//            return "GreatResponse{" +
//                    "graet='" + greet + '\'' +
//                    '}';
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (o == null || getClass() != o.getClass()) return false;
//            GreatResponse that = (GreatResponse) o;
//            return Objects.equals(greet, that.greet);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hashCode(greet);
//        }
//    }
}
