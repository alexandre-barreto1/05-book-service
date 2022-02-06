package br.com.erudio.controller;

import br.com.erudio.model.Book;
import br.com.erudio.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("book-service")
public class BookController {

    @Autowired
    private Environment environment;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping(value = "/{id}/{currency}")
    public Book findBook(@PathVariable("id") Long id, @PathVariable String currency) {
        var book = bookRepository.getById(id);
        if(Objects.isNull(book)){
            throw new RuntimeException("book not found)");
        }
        var port = environment.getProperty("local.server.port");
        book.setEnviorment(port);

        return book;
    }
}
