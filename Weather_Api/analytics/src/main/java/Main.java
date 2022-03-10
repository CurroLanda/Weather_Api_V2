import javax.jms.JMSException;

public class Main {
    public static void main(String[] args) {
        DataBaseCreator dataBase = new DataBaseCreator(args[0]);
        dataBase.createNewDatabase();
        dataBase.createNewTable();

        MessageReceiver message = new MessageReceiver();

        try {
            message.ReadMessage(args[0]);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
