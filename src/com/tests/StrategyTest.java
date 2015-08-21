package com.tests;

import com.strategy.*;
import com.tests.mocks.strategy.ChannelMock;
import com.tests.mocks.strategy.StorageMock;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by breathbath on 30.03.15.
 */
public class StrategyTest extends TestCase {

    private StorageMock storage;

    private ChannelMock channel;

    private Notifier notifier;

    public void setUp(){
        this.storage = new StorageMock("filestorage");
        this.channel = new ChannelMock("email");
        this.notifier = new Notifier(channel, storage);
    }

    public void testStrategyChange() throws Exception {
        boolean result = this.notifier.notify(this.generateRawMessages(1));
        assertTrue(result);
        assertEquals("msgTitle1", this.storage.storedMessage.getTitle());
        assertEquals("msgTitle1", this.channel.sentMessage.getTitle());

        StorageMock newstorage = new StorageMock("cloudstorage");
        ChannelMock newchannel = new ChannelMock("sms");
        this.notifier.setChannel(newchannel);
        this.notifier.setStorage(newstorage);
        this.notifier.notify(this.generateRawMessages(1));
        assertEquals("msgTitle1", newstorage.storedMessage.getTitle());
        assertEquals("msgTitle1", newchannel.sentMessage.getTitle());
    }

    private List<HashMap<String, String>> generateRawMessages(Integer count){
        List<HashMap<String, String>> messageRaw = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map = new HashMap<String, String>();
        for(int i = 0; i < count; i++){
            String counter = String.valueOf(i+1);
            map.put("title", "msgTitle" + counter);
            map.put("body", "msgBody" + counter);
            messageRaw.add(map);
        }
        return messageRaw;
    }
}
