package com.azul.bookstore.dto;

public class BookDTO {
    private long id;
    private String title;
    private AuthorDTO author;
    private GenreDTO genre;
    private int price;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public GenreDTO getGenre() {
        return genre;
    }

    public int getPrice() {
        return price;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

    public void setGenre(GenreDTO genre) {
        this.genre = genre;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
