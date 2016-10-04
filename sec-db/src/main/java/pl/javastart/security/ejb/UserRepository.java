package pl.javastart.security.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pl.javastart.security.entity.User;

@Stateless
public class UserRepository {
 
    @PersistenceContext
    private EntityManager em;
     
    public void add(User user) {
        em.persist(user);
    }
}