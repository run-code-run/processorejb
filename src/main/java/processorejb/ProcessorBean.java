package processorejb;

import processorejb.persistence.EOrderEntity;
import processorejb.util.Utils;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.*;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/txrequest"),
        @ActivationConfigProperty(propertyName = "maxSession", propertyValue = "10")
})
public class ProcessorBean implements MessageListener {


    public ProcessorBean() {
    }

    @Override
    public void onMessage(Message message) {

        ObjectMessage message1 = (ObjectMessage) message;

        try {

            new Utils().saveToDB((EOrderEntity) message1.getObject());
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
