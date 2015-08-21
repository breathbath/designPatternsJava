package com.adapter;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileSystemInterface {

    public void create(String data, String fileName) throws FileNotFoundException, IOException;

    public String read(String fileName) throws FileNotFoundException, IOException;

    public void write(String data, String fileName) throws IOException;

    public void remove(String fileName);

    public boolean exists(String fileName);

    public boolean mkDir(String dirName) throws IOException;

    public boolean rmDir(String dirName);
}
