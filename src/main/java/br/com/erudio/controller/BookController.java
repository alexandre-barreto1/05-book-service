package br.com.erudio.controller;

import br.com.erudio.model.Book;
import br.com.erudio.proxy.CambioProxy;
import br.com.erudio.repository.BookRepository;
import br.com.erudio.response.Cambio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Objects;

@RestController
@RequestMapping("book-service")
public class BookController {

    @Autowired
    private Environment environment;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CambioProxy cambioProxy;

    @GetMapping(value = "/{id}/{currency}")
    public Book findBook(@PathVariable("id") Long id, @PathVariable String currency) {
        var book = bookRepository.getById(id);
        if(Objects.isNull(book)){
            throw new RuntimeException("book not found)");
        }

        var cambio = cambioProxy.getCambio(book.getPrice(), "USD", currency);
        var port = environment.getProperty("local.server.port");
        book.setPrice(cambio.getConvertedValue());
        book.setEnviorment(port + "FEIGN");

        return book;
    }

    /*
    @GetMapping(value = "/{id}/{currency}")
    public Book findBook(@PathVariable("id") Long id, @PathVariable String currency) {
        var book = bookRepository.getById(id);
        if(Objects.isNull(book)){
            throw new RuntimeException("book not found)");
        }

        HashMap<String, String> params = new HashMap<>();
        params.put("amount", book.getPrice().toString());
        params.put("from", "USD");
        params.put("to", currency);

        var response = new RestTemplate().
                getForEntity("http://localhost:8001/cambio-service/{amount}/{from}/{to}",
                Cambio.class,
                        params);

        var cambio = response.getBody();
        var port = environment.getProperty("local.server.port");
        book.setPrice(cambio.getConvertedValue());
        book.setEnviorment(port);

        return book;
    }
     */

}
