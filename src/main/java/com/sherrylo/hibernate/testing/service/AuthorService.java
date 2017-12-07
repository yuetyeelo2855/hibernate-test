package com.sherrylo.hibernate.testing.service;

import com.sherrylo.hibernate.testing.beans.Author;
import com.sherrylo.hibernate.testing.beans.Book;
import com.sherrylo.hibernate.testing.dao.AuthorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class AuthorService {
    @Autowired
    private AuthorDao authorDao;

    public void save(Author author) {
        authorDao.create(author);
    }

    public Author queryById(Long id) {
        return authorDao.read(id);
    }

    public Author queryByBook(Book book) {
        return authorDao.queryByBook(book.getId());
    }
}
