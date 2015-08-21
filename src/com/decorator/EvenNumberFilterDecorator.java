package com.decorator;

import java.util.ArrayList;

public class EvenNumberFilterDecorator extends FilterDecorator {

    private Integer numberColumn;

    public EvenNumberFilterDecorator(RowsIterator rows, Integer numberColumn) {
        super(rows);
        this.numberColumn = numberColumn;
    }

    protected boolean matches(ArrayList<String> row) {
        String Number = row.get(this.numberColumn);
        Integer intNumber = Integer.valueOf(Number);
        return intNumber % 2 == 0;
    }
}
