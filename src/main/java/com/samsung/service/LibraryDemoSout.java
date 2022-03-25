package com.samsung.service;

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

    private final AuthorService authorService;
    private final GenreService genreService;
    private final BookService bookService;
    private final CommentService commentService;

    @Override
    public void authorDemo() {

        Author newAuthor = Author.builder()
                .name("Новый Автор")
                .build();

        authorService.insert(newAuthor);

        System.out.println("======Все авторы======");

        for (Author author : authorService.getAll()) {

            System.out.println(author);
        }

        System.out.println("======================\n");
    }

    @Override
    public void genreDemo() {

        Genre newGenre = Genre.builder()
                .name("Новый Жанр")
                .build();

        genreService.insert(newGenre);

        System.out.println("======Все жанры======");

        for (Genre genre : genreService.getAll()) {

            System.out.println(genre);
        }

        System.out.println("======================\n");
    }

    @Override
    @Transactional
    public void commentDemo() {

        System.out.println("======Все комменты======");

        for (Comment comment : commentService.getAll()) {

            System.out.println(comment.getBook().getName() + " : " + comment.getContent());
        }

        System.out.println("======================\n");
    }

    @Override
    @Transactional
    public void bookDemo() {

        bookService.insert("Новая книга", "Новый Жанр", "Новый Автор");

        System.out.println("======Все книги======");

        for (Book book1 : bookService.getAll()) {

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
