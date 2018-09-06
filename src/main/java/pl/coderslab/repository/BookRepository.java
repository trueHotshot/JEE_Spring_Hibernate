package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Publisher;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitle(String title);
    List<Book> findAllByCategory(Category category);
    List<Book> findAllByCategoryId(Long id);
    List<Book> findAllByAuthors(Author author);
    List<Book> findAllByPublisher(Publisher publisher);
    List<Book> findAllByRating(Double rating);
    Book findFirstByCategoryOrderByTitle(Category category);
}
