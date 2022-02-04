package br.com.erudio.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Book implements Serializable {

    private Long id;
    private String autor;
    private Date lauchDate;
    private Double price;
    private String title;
    private String currency;
    private String enviorment;

    public Book() {
    }

    public Book(Book book) {
        this.id = book.getId();
        this.autor = book.getAutor();
        this.lauchDate = book.getLauchDate();
        this.price = book.getPrice();
        this.title = book.getTitle();
        this.currency = book.getCurrency();
        this.enviorment = book.getEnviorment();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getLauchDate() {
        return lauchDate;
    }

    public void setLauchDate(Date lauchDate) {
        this.lauchDate = lauchDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getEnviorment() {
        return enviorment;
    }

    public void setEnviorment(String enviorment) {
        this.enviorment = enviorment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(autor, book.autor) && Objects.equals(lauchDate, book.lauchDate) && Objects.equals(price, book.price) && Objects.equals(title, book.title) && Objects.equals(currency, book.currency) && Objects.equals(enviorment, book.enviorment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, autor, lauchDate, price, title, currency, enviorment);
    }
}
