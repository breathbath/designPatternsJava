package com.strategy;

import java.util.HashMap;
import java.util.List;

/**
 * Created by breathbath on 29.03.15.
 */
public class Notifier {

    private NotificationChannel channel;

    private Storage storage;

    public Notifier(NotificationChannel channel, Storage storage) {
        this.channel = channel;
        this.storage = storage;
    }

    public void setChannel(NotificationChannel channel) {
        this.channel = channel;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    /**
     * @param dataToSend List<HashMap<String, String>>
     * @return boolean
     */
    public boolean notify(List<HashMap<String, String>> dataToSend){
        boolean result = false;
        for(HashMap<String, String> values: dataToSend){
            String title = values.get("title");
            String body = values.get("body");
            if(title != null && body !=null){
                Message msq = new Message(title, body);
                if(this.processMessage(msq)){
                    result = true;
                }
            }
        }
        return result;
    }

    /**
     * @param message Message
     * @return boolean
     */
    private boolean processMessage (Message message){
        return this.channel.send(message) && this.storage.save(message);
    }
}
