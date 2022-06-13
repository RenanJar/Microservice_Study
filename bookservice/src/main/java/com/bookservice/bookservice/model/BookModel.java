package com.bookservice.bookservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@Entity(name = "book")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class BookModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "author",nullable = false,length = 180)
    private String author;

    @Column(name = "lauch_date",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date lauchDate;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false,length = 250)
    private String title;

    @Transient
    private String currency;

    @Transient
    private String environment;

    public BookModel(){}

    public BookModel(Long id, String author,String title, Date lauchDate, Double price, String currency, String environment) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.lauchDate = lauchDate;
        this.price = price;
        this.currency = currency;
        this.environment = environment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookModel bookModel = (BookModel) o;
        return Objects.equals(id, bookModel.id) && Objects.equals(author, bookModel.author) && Objects.equals(lauchDate, bookModel.lauchDate) && Objects.equals(price, bookModel.price) && Objects.equals(title, bookModel.title) && Objects.equals(currency, bookModel.currency) && Objects.equals(environment, bookModel.environment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, lauchDate, price, title, currency, environment);
    }

}
