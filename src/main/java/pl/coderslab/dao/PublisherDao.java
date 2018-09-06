package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class PublisherDao {
    @PersistenceContext
    EntityManager entityManager;

    public void save(Publisher entity) {
        entityManager.persist(entity);
    }

    public Publisher findById(Long id) {
        return entityManager.find(Publisher.class, id);
    }

    public void update(Publisher entity) {
        entityManager.merge(entity);
    }

    public void delete(Publisher entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity)); }

    @SuppressWarnings("unchecked")
    public List<Publisher> getAll() {
        return entityManager.createQuery("SELECT b FROM Publisher b").getResultList();
    }
}