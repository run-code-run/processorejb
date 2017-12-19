package processorejb.util;

import processorejb.persistence.EOrderEntity;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;


@TransactionManagement(value = TransactionManagementType.BEAN)
public class Utils {


    @PersistenceContext(unitName = "myapp")
    private EntityManagerFactory entityManagerFactory;


    protected void setUp() throws Exception {

        entityManagerFactory = Persistence.createEntityManagerFactory("myapp");

    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void saveToDB(EOrderEntity eOrder) {

        try {
            setUp();
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(eOrder);
            entityManager.getTransaction().commit();
            entityManager.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
