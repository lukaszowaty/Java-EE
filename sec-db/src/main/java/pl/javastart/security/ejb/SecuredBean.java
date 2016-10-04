package pl.javastart.security.ejb;
 

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
 
@Stateless
@RolesAllowed("admin")
public class SecuredBean {
 
    public String getMessage() {
        return "Secured Message no. " + System.currentTimeMillis();
    }
}