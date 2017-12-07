package com.sherrylo.hibernate.testing.dao;

import com.sherrylo.hibernate.testing.beans.Author;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorDao extends BaseDao<Author, Long> {

    @Autowired
    public AuthorDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Author queryByBook(Long bookId) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Author.class);
        criteria.createAlias("books", "book")
                .add(Restrictions.eq("book.id", bookId));
        return (Author) criteria.getExecutableCriteria(getSession()).uniqueResult();
    }
}
