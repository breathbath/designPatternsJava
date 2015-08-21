package com.adapter;

import java.io.FileNotFoundException;
import java.io.IOException;

public class FsQueueAdapter implements CacheInterface {

    private FileSystemInterface fs;

    public FsQueueAdapter(FileSystemInterface fs) throws IOException {
        this.fs = fs;
        if(!this.fs.exists("/tmp/queue")){
            this.fs.mkDir("/tmp/queue");
        }
    }

    @Override
    public void add(String key, String data, int timeout) throws IOException {
        if(this.fs.exists(this.getPath(key))){
            return;
        }
        this.fs.create(data, this.getPath(key));
    }

    @Override
    public String get(String key) throws IOException {
        if(!this.fs.exists(this.getPath(key))){
            return "";
        }
        return this.fs.read(this.getPath(key));
    }

    @Override
    public void delete(String key) {
        if(this.fs.exists(this.getPath(key))){
            this.fs.remove(this.getPath(key));
        }
    }

    @Override
    public boolean exists(String key) {
        return this.fs.exists(this.getPath(key));
    }

    private String getPath(String key){
        return "/tmp/queue/" + "queue_" + key;
    }
}
