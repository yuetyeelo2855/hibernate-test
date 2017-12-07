package com.sherrylo.hibernate.testing.beans;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue
    private Long id;
    private String title;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "author_book",
            inverseJoinColumns = {@JoinColumn(name = "author_id", referencedColumnName = "id", updatable = false)},
            joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "id", updatable = false)})
    private Set<Book> books = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
