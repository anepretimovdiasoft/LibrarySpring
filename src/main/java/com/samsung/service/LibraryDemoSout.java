package com.samsung.service;

import com.samsung.dao.AuthorDao;
import com.samsung.dao.BookDao;
import com.samsung.dao.CommentDao;
import com.samsung.dao.GenreDao;
import com.samsung.domain.Author;
import com.samsung.domain.Book;
import com.samsung.domain.Comment;
import com.samsung.domain.Genre;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LibraryDemoSout implements LibraryDemo {

    private final AuthorDao authorDao;
    private final GenreDao genreDao;
    private final BookDao bookDao;
    private final CommentDao commentDao;

    @Override
    @Transactional
    public void authorDemo() {

        Author newAuthor = Author.builder()
                .name("Новый Автор")
                .build();

        authorDao.save(newAuthor);

        System.out.println("======Все авторы======");

        for (Author author : authorDao.findAll()) {

            System.out.println(author);
        }

        System.out.println("======================\n");
    }

    @Override
    @Transactional
    public void genreDemo() {

        Genre newGenre = Genre.builder()
                .name("Новый Жанр")
                .build();

        genreDao.save(newGenre);

        System.out.println("======Все жанры======");

        for (Genre genre : genreDao.findAll()) {

            System.out.println(genre);
        }

        System.out.println("======================\n");
    }

    @Override
    @Transactional
    public void commentDemo() {

        System.out.println("======Все комменты======");

        for (Comment comment : commentDao.findAll()) {

            System.out.println(comment.getBook().getName() + " : " + comment.getContent());
        }

        System.out.println("======================\n");
    }

    @Override
    @Transactional
    public void bookDemo() {

        Book book = Book.builder()
                .name("Новая книга")
                .author(authorDao.findByName("Новый Автор"))
                .genre(genreDao.findByName("Новый Жанр"))
                .build();

        bookDao.save(book);

        System.out.println("======Все книги======");

        for (Book book1 : bookDao.findAll()) {

            System.out.println(
                    book1.getName() + " : " +
                            book1.getAuthor().getName() + ", " +
                            book1.getGenre().getName()
            );
        }

        System.out.println("======================\n");

    }

    @Override
    @Transactional
    public void libDemo() {

        authorDemo();
        genreDemo();
        bookDemo();
        commentDemo();

    }
}
