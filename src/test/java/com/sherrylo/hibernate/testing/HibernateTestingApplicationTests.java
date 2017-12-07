package com.sherrylo.hibernate.testing;

import com.sherrylo.hibernate.testing.beans.Author;
import com.sherrylo.hibernate.testing.beans.Book;
import com.sherrylo.hibernate.testing.service.AuthorService;
import com.sherrylo.hibernate.testing.service.BookService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestSpringConfiguration.class)
public class HibernateTestingApplicationTests {
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;

    @Test
    public void testHibernate() {
        Book book = new Book();
        book.setTitle("TestBook");
        bookService.save(book);

        Author author = new Author();
        author.setTitle("TestAuthor");
        author.getBooks().add(book);
        authorService.save(author);

        Author author1 = authorService.queryByBook(book);
        Assert.assertNotNull(author1);
        Assert.assertEquals(author.getId(), author1.getId());
        Assert.assertEquals(author.getTitle(), author1.getTitle());
    }
}
