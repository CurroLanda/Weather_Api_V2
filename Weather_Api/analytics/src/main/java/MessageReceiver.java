import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MessageReceiver {
    private static final String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static final String subject = "sensor.Weather";

    public void ReadMessage(String workingUrl) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.setClientID("Client");

        connection.start();
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic(subject);

        MessageConsumer consumer = session.createDurableSubscriber(topic, "analytics-reader");
        consumer.setMessageListener(message -> {try {
            TextMessage textMessage = (TextMessage) message;

            MesssageSaver manage = new MesssageSaver(textMessage.getText());
            manage.SaveData("jdbc:sqlite:"+workingUrl+"/weather.db", workingUrl);


        }catch (Exception e){
            e.printStackTrace();
        }
        });
    }
}