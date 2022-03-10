import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MessageReceiver {
    private static final String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static final String subject = "sensor.Weather";

    public void ReadMessage(String directory) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.setClientID("Client_datalake");

        connection.start();
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic(subject);

        MessageConsumer consumer = session.createDurableSubscriber(topic, "datalake-builder");
        consumer.setMessageListener(message -> {try {
            TextMessage textMessage = (TextMessage) message;

            FileWriter file = new FileWriter();
            file.Write(textMessage.getText(), directory );

        }catch (Exception e){
            e.printStackTrace();
        }
        });
    }
}