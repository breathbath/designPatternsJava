package com.decorator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public interface RowsIterator extends Iterator {

    ArrayList<String> next();

}
