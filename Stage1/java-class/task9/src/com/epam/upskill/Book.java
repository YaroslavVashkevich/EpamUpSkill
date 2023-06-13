package com.epam.upskill;

public class Book {
    private int id;
    private String title;
    private String author;
    private String publish;
    private int year;
    private int page;
    private double price;
    private String binding;

    public Book(int id, String title, String author, String publish, int year, int page, double price, String binding) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publish = publish;
        this.year = year;
        this.page = page;
        this.price = price;
        this.binding = binding;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublish() {
        return publish;
    }

    public int getYear() {
        return year;
    }

    public int getPage() {
        return page;
    }

    public double getPrice() {
        return price;
    }

    public String getBinding() {
        return binding;
    }

    @Override
    public String toString() {
        return
                "Id " + id +
                "  '" + title + '\'' +
                "  " + author +
                "  Изд. '" + publish + '\'' +
                "  " + year +
                "  " + page +
                " стр.  Цена " + price +
                " р.  " + binding + " переплёт";

    }
}
