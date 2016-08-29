
package fontededados;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class FabricaEntityManager {
    
    public static EntityManagerFactory emf;
    
    private FabricaEntityManager(){}
    
    public static EntityManagerFactory getEntityManagerFactory(){
        
        if (emf == null){
            emf = Persistence.createEntityManagerFactory("tfm?zeroDateTimeBehavior=convertToNullPU");
        
        }
        return emf; 
    }
    
    
}
