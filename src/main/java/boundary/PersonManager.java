package boundary;

import java.util.List;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;

import entity.Person;

@ApplicationScoped
public class PersonManager {

    private static final Logger LOGGER = Logger.getLogger(PersonManager.class.getName());

    @Inject
    EntityManager em;

    public Person findById(UUID personId) {
        return this.em.find(Person.class, personId);
    }

    public List<Person> findByLastName(String name) {
        try {
            return this.em.createNamedQuery(Person.findByLastName, Person.class)
                    .setParameter("name", name)
                    .getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.DEBUG, e.toString(), e);
            return null;
        }
    }

    public List<Person> getAll() {
        try {
            return this.em.createNamedQuery(Person.getAll, Person.class)
                    .getResultList();
        } catch (Exception e) {
            LOGGER.log(Level.DEBUG, e.toString(), e);
            return null;
        }
    }

}
