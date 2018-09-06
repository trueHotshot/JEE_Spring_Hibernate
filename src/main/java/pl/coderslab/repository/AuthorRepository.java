package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.Author;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findByEmail(String email);
    Author findByPesel(String pesel);
    List<Author> findAllByLastName(String lastName);

    @Query("SELECT a FROM Author a WHERE a.email LIKE ?1%")
    List<Author> findByEmailStartsWith(@Param("starts") String starts);

    @Query("SELECT a FROM Author a WHERE a.pesel LIKE ?1%")
    List<Author> findByPeselStartsWith(@Param("starts") String starts);
}
