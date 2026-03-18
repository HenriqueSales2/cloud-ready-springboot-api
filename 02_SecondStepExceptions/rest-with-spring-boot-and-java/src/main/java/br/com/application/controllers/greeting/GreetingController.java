package br.com.application.controllers.greeting;

import br.com.application.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong(); // vamos mocar um id, pois ainda não irei utilizar banco de dados nesse projeto

    // https://localhost:8080/greeting?name=user
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "Word") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name)); // esse incrementAndGet vai incrementar e retornar um valor maior a cada vez
    }

}
