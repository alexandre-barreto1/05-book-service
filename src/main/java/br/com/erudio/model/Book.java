package br.com.erudio.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity(name = "book")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "author", nullable = false, length = 180)
    private String autor;

    @Column(name = "launch_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date lauchDate;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false, length = 250)
    private String title;

    @Transient
    private String currency;

    @Transient
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
