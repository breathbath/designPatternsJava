package com.decorator;

import java.io.*;
import java.util.*;

public class CsvRowsCollection implements RowsIterator {

    private String csvFilePath;
    private Scanner reader;
    private String csvSplitBy = ",";

    public CsvRowsCollection(String csvFilePath, String csvSplitBy) {
        this.csvFilePath = csvFilePath;
        this.csvSplitBy = csvSplitBy;
    }

    public CsvRowsCollection(String csvFilePath) {
        this.csvFilePath = csvFilePath;
    }

    public boolean hasNext() {
        try {
            Scanner reader = this.getReader();
            boolean hasNext = reader.hasNextLine();
            if (!hasNext) {
                reader.close();
            }
            return hasNext;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<String> next() {
        Scanner currReader = null;
        try {
            String line = "";
            currReader = this.getReader();
            line = currReader.nextLine();
            if (line == null) {
                return null;
            }
            String[] row = line.split(this.csvSplitBy);
            return new ArrayList<String>(Arrays.asList(row));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Scanner getReader() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(this.csvFilePath);
        if (this.reader != null) {
            return this.reader;
        }

        this.reader = new Scanner(fis);
        return this.reader;
    }
}
