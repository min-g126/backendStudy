package com.ohgiraffers.mapping.section02.embedded;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_book")
public class Book {

    @Id
    @Column(name = "book_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookNo;

    @Column(name = "book_title")
    private String bookTitle;

    @Column(name = "author")
    private String author;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "published_date")
    private LocalDate publishedDate;

//    @Column(name = "regular_price")
//    private int regularPrice;
//
//    @Column(name = "discount_rate")
//    private double discountRate;

    @Embedded
    private Price price;

    protected Book() {}

    public Book(String bookTitle, String author, String publisher, LocalDate publishedDate, Price price) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.price = price;
    }

    public int getBookNo() {
        return bookNo;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public Price getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookNo=" + bookNo +
                ", bookTitle='" + bookTitle + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publishedDate=" + publishedDate +
                ", price=" + price +
                '}';
    }
}
