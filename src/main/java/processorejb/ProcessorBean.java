package processorejb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

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

        TextMessage message1 = (TextMessage) message;

        try {
            System.out.println(message1.getText());

        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
