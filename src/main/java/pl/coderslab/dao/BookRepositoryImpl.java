package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.repository.BookRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Repository
@Transactional
public class BookRepositoryImpl implements BookRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void resetRating(double rating) {
        Query q = entityManager.createQuery("UPDATE Book b SET b.rating = :newRating");
        q.setParameter("newRating", rating).executeUpdate();

    }
}
