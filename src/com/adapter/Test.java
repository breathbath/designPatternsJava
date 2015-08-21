package com.adapter;

import com.command.*;

import java.io.IOException;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws IOException {
        FsQueueAdapter queue = new FsQueueAdapter(new Fs());
        if(!queue.exists("some_key")){
            queue.add("some_key", "some_data", 1);
        }
        System.out.println(queue.get("some_key"));
        queue.delete("some_key");
    }
}
