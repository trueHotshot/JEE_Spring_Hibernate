package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.PersonDetails;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional
public class PersonDetailsDao {
    @PersistenceContext
    EntityManager entityManager;

    public void save(PersonDetails entity) {
        entityManager.persist(entity);
    }

    public PersonDetails findById(long id) {
        return entityManager.find(PersonDetails.class, id);
    }

    public void update(PersonDetails entity) {
        entityManager.merge(entity);
    }

    public void delete(PersonDetails entity) {
        entityManager.remove(entityManager.contains(entity) ?
                entity : entityManager.merge(entity)); }
}