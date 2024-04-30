package br.com.neander.greeting;

import br.com.neander.greeting.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /**
     * Método Greeting da classe Greeting criado para Retornar uma Saudação
     *
     * @param name - Valor da variável criada e passada por parâmetro passado para o Metodo HTTP
     * @return -
     */
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.getAndIncrement(), String.format(template, name));
    }
}
