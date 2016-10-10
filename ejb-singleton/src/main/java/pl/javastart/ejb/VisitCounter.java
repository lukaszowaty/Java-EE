package pl.javastart.ejb;
import java.util.concurrent.atomic.AtomicInteger;
 
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
 
@Singleton
@Startup
public class VisitCounter {
     
    private AtomicInteger visits;
     
    @PostConstruct
    private void init() {
        visits = new AtomicInteger(0);
    }
     
    public int getVisits() {
        return visits.incrementAndGet();
    }
}