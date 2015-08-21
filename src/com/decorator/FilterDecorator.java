package com.decorator;

import java.util.ArrayList;
import java.util.List;

import java.util.Iterator;

public abstract class FilterDecorator implements RowsIterator {

    private RowsIterator rows;

    public FilterDecorator(RowsIterator rows) {
        this.rows = rows;
    }

    protected abstract boolean matches(ArrayList<String> row);

    public boolean hasNext() {
        return this.rows.hasNext();
    }

    public ArrayList<String> next() {
        ArrayList<String> currRow;
        do {
            currRow = this.rows.next();
            if (this.matches(currRow)) {
                return currRow;
            }
        }
        while (this.rows.hasNext());
        return null;
    }
}
