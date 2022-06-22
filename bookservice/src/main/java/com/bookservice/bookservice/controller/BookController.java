package com.bookservice.bookservice.controller;

import com.bookservice.bookservice.Proxy.CambioProxy;
import com.bookservice.bookservice.model.BookModel;
import com.bookservice.bookservice.repository.BookRepository;
import com.bookservice.bookservice.response.CambioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping("book-service")
@SuppressWarnings("deprecation")
public class BookController {

    @Autowired
    private Environment environment;

    @Autowired
    private BookRepository repository;

    @Autowired
    private CambioProxy proxy;

    @GetMapping(value="/{id}/{currency}")
    public BookModel findBook(@PathVariable("id") Long id,
                              @PathVariable("currency") String currency){

        var bookModel = repository.getById(id);
        if(bookModel ==null) throw new RuntimeException("Book not Found");


        var cambio = proxy.getcambio(bookModel.getPrice(),"USD",currency);

        var port = environment.getProperty("local.server.port");
        bookModel.setEnvironment("Book port: "+ port +"Cambio Port " + cambio.getEnvironment());
        bookModel.setPrice(cambio.getConvertedValue());

        return bookModel;
    }

    /*public BookModel findBook(@PathVariable("id") Long id,
                              @PathVariable("currency") String currency){

        var bookModel = repository.getById(id);
        if(bookModel ==null) throw new RuntimeException("Book not Found");

        HashMap<String, String> params = new HashMap<>();
        params.put("amount",bookModel.getPrice().toString());
        params.put("from","USD");
        params.put("to",currency);

        var response= new RestTemplate()
                .getForEntity("http://localhost:8000/cambio-service/{amount}/{from}/{to}",
                CambioModel.class,
                params);
        var cambio = response.getBody();

        var port = environment.getProperty("local.server.port");
        bookModel.setEnvironment(port);
        bookModel.setPrice(cambio.getConvertedValue());

        return bookModel;
    }*/
}
