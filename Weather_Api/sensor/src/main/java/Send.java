import javax.jms.JMSException;

public class Send {

    public Send(WeatherExtractor cleanMessage){
        MessageWriter message = new MessageWriter();
        MessageSender jsonMessage = new MessageSender();
        try {
            jsonMessage.Send(message.Write(cleanMessage.extract()));
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}