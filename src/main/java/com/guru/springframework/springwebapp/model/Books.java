package com.guru.springframework.springwebapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
class Books
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private int isbn;
    private String publisher;

    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    Books()
    {
        System.out.println("No arg constructor for Books");
    }

    Books(String title, int isbn, String publisher)
    {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
    }

    Books(String title, int isbn, String publisher, Set<Author> authors)
    {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.authors = authors;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public int getIsbn()
    {
        return this.isbn;
    }

    public void setIsbn(int isbn)
    {
        this.isbn = isbn;
    }

    public String getPublisher()
    {
        return this.publisher;
    }

    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }

    public Set<Author> getAuthors()
    {
        return this.authors;
    }

    public void setAuthors(Set<Author> authors)
    {
        this.authors = authors;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Books books = (Books) o;
        return Objects.equals(id, books.id);
    }

    @Override
    public int hashCode()
    {

        return Objects.hash(id);
    }

    @Override
    public String toString()
    {
        return "Books{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn=" + isbn +
                ", publisher='" + publisher + '\'' +
                ", authors=" + authors +
                '}';
    }
}
