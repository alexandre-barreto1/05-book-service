package br.com.erudio.controller;

import br.com.erudio.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("book-service)")
public class BookController {

    @Autowired
    private Environment environment;

    @GetMapping(value = "/{id}/{currency}")
    public Book findBook(@PathVariable("id") Long id, @PathVariable String currency) {
        var port = environment.getProperty("local.server.port");

        Book book = new Book();

        book.setId(1L);
        book.setAutor("Nigel Poulton");
        book.setTitle("Docker deep Dive");
        book.setLauchDate(new Date());
        book.setPrice(Double.valueOf(13.7));
        book.setCurrency(currency);
        book.setEnviorment(port);

        return book;
    }
}
