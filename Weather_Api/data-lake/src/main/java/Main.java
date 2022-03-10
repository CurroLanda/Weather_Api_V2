import javax.jms.JMSException;

public class Main {
    public static void main(String[] args) {
        DirectoryManager directory = new DirectoryManager();
        directory.setWorkingDirectory(args[0]);

        MessageReceiver message = new MessageReceiver();
        try {
            message.ReadMessage(directory.getWorkindDirectory());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}