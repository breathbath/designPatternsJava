package com.decorator;


import com.sun.rowset.internal.Row;

import java.util.List;

import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        try {
            final String ds = File.separator;
            String path = new java.io.File(".").getCanonicalPath() + ds + "src" + ds + "com" + ds + "decorator" + ds + "test.csv";
            RowsIterator csvRows = new CsvRowsCollection(path);
            RowsIterator filteredDecoratedRows = new EvenNumberFilterDecorator(csvRows, 0);
            RowsIterator differenceCalculatedRows = new DifferenceMutatorDecorator(filteredDecoratedRows);
            while(differenceCalculatedRows.hasNext()){
                List<String> row = differenceCalculatedRows.next();
                if(row==null){
                    continue;
                }
                row.stream().forEach(e -> System.out.print(e + " "));
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
