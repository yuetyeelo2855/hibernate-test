package com.sherrylo.hibernate.testing.service;

import com.sherrylo.hibernate.testing.beans.Book;
import com.sherrylo.hibernate.testing.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class BookService {
    @Autowired
    private BookDao bookDao;

    public void save(Book book) {
        bookDao.create(book);
    }
}
