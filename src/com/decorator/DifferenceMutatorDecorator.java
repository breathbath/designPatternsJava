package com.decorator;

import java.util.ArrayList;
import java.util.List;

public class DifferenceMutatorDecorator extends MutatorDecorator {

    public DifferenceMutatorDecorator(RowsIterator rows) {
        super(rows);
    }

    protected ArrayList<String> mutate(ArrayList<String> row) {
        Integer number1 = Integer.valueOf(row.get(2));
        Integer number2 = Integer.valueOf(row.get(3));
        Integer result = number1-number2;
        row.add(6, String.valueOf(result));

        return row;
    }
}
