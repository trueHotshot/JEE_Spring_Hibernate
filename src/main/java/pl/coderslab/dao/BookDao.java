package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    EntityManager entityManager;

    public void save(Book entity) {
        entityManager.persist(entity);
    }

    public void update(Book entity) {
        entityManager.merge(entity);
    }

    public Book findById(long id) {
        Book result = entityManager.find(Book.class, id);
        return result;
    }

    public void delete(long id) {
        Book entity = findById(id);
        entity.getPublisher().getBooks().remove(entity);
        entityManager.remove(entity);
    }

    public void propositionDelete(long id) {
        Book entity = findById(id);
        System.out.println(entity.getPublisher());
        if(entity.getPublisher() != null) {
            entity.getPublisher().getBooks().remove(entity);
        }
        entityManager.remove(entity);
    }

    public List<Book> findAll() {

        return entityManager.createQuery("SELECT b FROM Book b").getResultList();
    }

}