package com.practice.data.structures.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class NestedIterator implements Iterator<Integer> {

    private List<Integer> integers;
    private int index = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        integers = new ArrayList<>();
        for (NestedInteger nestedInteger : nestedList) {
            decomposeInput(nestedInteger);
        }
    }

    private void decomposeInput(NestedInteger nestedInteger) {
        if (nestedInteger.isInteger()) {
            integers.add(nestedInteger.getInteger());
        } else {
            for (NestedInteger nested : nestedInteger.getList()) {
                decomposeInput(nested);
            }
        }
    }

    @Override
    public Integer next() {
        return integers.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < integers.size();
    }
}
