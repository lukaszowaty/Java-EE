package pl.javastart.usermanager.data;
 
import java.util.List;
 
import javax.ejb.Stateless;
import javax.persistence.*;
 
import pl.javastart.usermanager.model.User;
 
@Stateless
public class UserRepository {
 
    @PersistenceContext
    private EntityManager em;
     
    public void add(User user) {
        em.persist(user);
    }
     
    public List<User> getAll() {
        TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
        return query.getResultList();
    }
     
    public User get(Long id) {
        TypedQuery<User> query = em.createNamedQuery("User.findById", User.class);
        query.setParameter("id", id);
        List<User> resultList = query.getResultList();
        if(resultList.isEmpty())
            return null;
        else
            return resultList.get(0);
    }
}