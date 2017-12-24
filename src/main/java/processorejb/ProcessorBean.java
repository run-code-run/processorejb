package processorejb;

import entities.EOrderEntity;

import javax.annotation.Resource;
import javax.ejb.*;
import javax.jms.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.*;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/txrequest"),
        @ActivationConfigProperty(propertyName = "maxSession", propertyValue = "10")
})
@TransactionManagement(value = TransactionManagementType.CONTAINER)
public class ProcessorBean implements MessageListener {


    @PersistenceContext
    EntityManager entityManager;

    @Resource
    UserTransaction utx;


    public ProcessorBean() {
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void onMessage(Message message) {

        ObjectMessage message1 = (ObjectMessage) message;

        try {


            EOrderEntity entity = (EOrderEntity) message1.getObject();
            utx.begin();

//            entityManager.joinTransaction();

            entityManager.persist(entity);

            utx.commit();

            entityManager.close();


        } catch (JMSException | NotSupportedException | SystemException | HeuristicMixedException | RollbackException | HeuristicRollbackException e) {
            e.printStackTrace();
        }
    }
}
