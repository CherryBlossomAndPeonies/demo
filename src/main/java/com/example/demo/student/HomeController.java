package com.example.demo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class HomeController {

    @GetMapping
    public GreetResponse Greetings(){
        return new GreetResponse("Hello", List.of("Java", "C#", "Kotlin"), new Person("Devid", 18, 30000));
    }
    record Person(String name, int age, double savings){};
    record GreetResponse(String message, List<String> favSubjects, Person person){};
}
