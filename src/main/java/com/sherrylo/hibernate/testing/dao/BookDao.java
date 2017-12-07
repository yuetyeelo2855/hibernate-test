package com.sherrylo.hibernate.testing.dao;

import com.sherrylo.hibernate.testing.beans.Book;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookDao extends BaseDao<Book, Long> {
    @Autowired
    public BookDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
