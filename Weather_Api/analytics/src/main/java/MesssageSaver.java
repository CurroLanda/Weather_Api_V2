import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

public class MesssageSaver {
    public String message;


    public MesssageSaver(String message){
        this.message=message;
    }

    public void SaveData(String BDurl, String url){
        MessageConverter rawMessage = new MessageConverter(message);
        DataBaseManager dataBase = new DataBaseManager();
        dataBase.insert(BDurl,rawMessage.extract());

        EventQueue.invokeLater(() -> {
            LineChartCreator ex = null;
            try {
                ex = new LineChartCreator(dataBase.select(BDurl), url);
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
            ex.setVisible(false);
        });
    }
}
