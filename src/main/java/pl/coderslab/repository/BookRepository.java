package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Publisher;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>,  BookRepositoryCustom {
    // List<Book> findByTitle(String title);
    List<Book> findAllByCategory(Category category);
    List<Book> findAllByCategoryId(Long id);
    List<Book> findAllByAuthors(Author author);
    List<Book> findAllByPublisherName(String name);
    List<Book> findAllByRating(Double rating);
    // Book findFirstByCategoryOrderByTitle(Category category);

    @Query ("SELECT b FROM Book b WHERE title = :title")
    List<Book> findByTitle(@Param("title") String title);

    @Query("SELECT b FROM Book b WHERE b.category = :category")
    List<Book> findByCategory(@Param("category") Category category);

    @Query("SELECT b FROM Book b WHERE b.rating BETWEEN :min AND :max")
    List<Book> findByRatingBetweenMinAndMax(@Param("min") Double min, @Param("max") Double max);

    @Query("SELECT b FROM Book b WHERE b.publisher = :publisher")
    List<Book> findByPublisher(@Param("publisher") Publisher publisher);

    @Query(value = "SELECT * FROM books WHERE category_id = ?1 ORDER BY title ASC LIMIT 1", nativeQuery = true)
    Book findFirstByCategoryOrderByTitle(@Param("category") Category category);

}
