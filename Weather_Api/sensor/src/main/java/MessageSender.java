import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageSender {
    public static String broker = ActiveMQConnection.DEFAULT_BROKER_URL;
    public void Send(String messageToSend) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(broker);
        Connection connection = connectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createTopic("sensor.Weather");

        MessageProducer producer = session.createProducer(destination);
        TextMessage message = session.createTextMessage((messageToSend));
        producer.send(message);

        connection.close();
    }
}