package com.decorator;

import java.util.ArrayList;
import java.util.List;

import java.util.Iterator;

public abstract class MutatorDecorator implements RowsIterator {

    private RowsIterator rows;

    public MutatorDecorator(RowsIterator rows) {
        this.rows = rows;
    }

    protected abstract ArrayList<String> mutate(ArrayList<String> row);

    public boolean hasNext() {
        return this.rows.hasNext();
    }

    public ArrayList<String> next() {
        return this.mutate(this.rows.next());
    }
}
