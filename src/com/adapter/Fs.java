package com.adapter;

import java.io.*;
import java.util.HashMap;

public class Fs implements FileSystemInterface {

    private HashMap<String, File> cachedFiles;

    public Fs() {
        this.cachedFiles = new HashMap<String, File>();
    }

    @Override
    public void create(String data, String fileName) throws IOException {
        File file = this.getFile(fileName);
        if(file.exists()){
            return;
        }
        file.createNewFile();
        BufferedWriter output = new BufferedWriter(new FileWriter(file));
        output.write(data);
        output.flush();
        output.close();
    }

    @Override
    public String read(String fileName) throws IOException {
        File file = this.getFile(fileName);
        InputStream stream = new FileInputStream(file);
        int size = stream.available();
        String result = "";
        for(int i=0; i< size; i++){
            result+=(char)stream.read();
        }
        stream.close();
        return result;
    }

    @Override
    public void write(String data, String fileName) throws IOException {
        File file = this.getFile(fileName);
        if(!file.exists()){
            return;
        }
        BufferedWriter output = new BufferedWriter(new FileWriter(file, true));
        output.write(data);
        output.close();
    }

    @Override
    public void remove(String fileName) {
        if(!this.exists(fileName)){
            return;
        }
        File file = this.getFile(fileName);
        file.delete();
    }

    @Override
    public boolean exists(String fileName) {
        File file = this.getFile(fileName);
        return file.exists();
    }

    @Override
    public boolean mkDir(String dirName) throws IOException {
        File dir = this.getFile(dirName);
        if(dir.exists()){
            return false;
        }
        return dir.mkdirs();
    }

    @Override
    public boolean rmDir(String dirName) {
        File dir = this.getFile(dirName);
        if(!dir.exists()){
            return false;
        }
        return dir.delete();
    }

    private File getFile(String fileName){
        File file = this.cachedFiles.get(fileName);
        if(file == null){
            this.cachedFiles.put(fileName, new File(fileName));
            return this.cachedFiles.get(fileName);
        }
        return file;
    }
}
