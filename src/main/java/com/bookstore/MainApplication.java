package com.bookstore;

import com.bookstore.entity.Book;
import com.bookstore.service.BookstoreService;
import java.util.List;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    private final BookstoreService bookstoreService;

    public MainApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            System.out.println("\nInsert new book to an author ...");
            System.out.println("---------------------------------------------");
            bookstoreService.insertNewBook();
            System.out.println("---------------------------------------------");
            
            System.out.println("\nList all books of an author ...");
            System.out.println("---------------------------------------------");
            bookstoreService.fetchBooksOfAuthorById();            
            System.out.println("---------------------------------------------");
            
            System.out.println("\nList a page books (first page with two books) of an author ...");
            System.out.println("---------------------------------------------");
            bookstoreService.fetchPageBooksOfAuthorById();            
            System.out.println("---------------------------------------------");
            
            System.out.println("\nFetch a list of books and add new book ...");
            System.out.println("---------------------------------------------");
            bookstoreService.fetchBooksOfAuthorByIdAndAddNewBook();
            System.out.println("---------------------------------------------");
            
            System.out.println("\nFetch a list of books and delete the first book ...");
            System.out.println("---------------------------------------------");
            bookstoreService.fetchBooksOfAuthorByIdAndDeleteFirstBook();
            System.out.println("---------------------------------------------");
        };
    }
}
/*
 * 
 * ow Efficient Is Just @OManyToOne

Note: The @ManyToOne association maps exactly to the one-to-many table relationship. The underlying foreign key is under child-side control in unidirectional or bidirectional relationship.

Description: This application shows that using only @ManyToOne is quite efficient. On the other hand, using only @OneToMany is far away from being efficient. Always, prefer bidirectional @OneToMany or unidirectional @ManyToOne. Consider two entities, Author and Book in a unidirectional @ManyToOne relationship.

Key points:

Adding a new book is efficient
Fetching all books of an author is efficient via a JPQL
Pagination of books is efficient
Remove a book is efficient
Even if the fetched collection is not managed, dirty checking mechanism works as expected
 * 
 */
