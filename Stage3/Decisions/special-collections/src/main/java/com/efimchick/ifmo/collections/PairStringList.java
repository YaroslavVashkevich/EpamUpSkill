package com.efimchick.ifmo.collections;

import java.util.ArrayList;
import java.util.Collection;

class PairStringList extends ArrayList {

    @Override
    public boolean add(Object o) {
        super.add(o);
        return super.add(o);
    }

    @Override
    public void add(int index, Object o) {
        if (index % 2 == 0) {
            super.add(index, o);
            super.add(index, o);
        } else {
            super.add(index + 1, o);
            super.add(index + 1, o);
        }
    }

    @Override
    public boolean addAll(Collection c) {
        Object[] o = c.toArray();
        for (int i = 0; i < o.length; i++) {
            add(o[i]);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        Object[] o = c.toArray();
        for (int i = o.length - 1; i >= 0; i--) {
            add(index, o[i]);
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        super.remove(o);
        return super.remove(o);
    }

    @Override
    public Object remove(int index) {
        if (index % 2 == 0) {
            super.remove(index);
            return super.remove(index + 1);
        } else {
            super.remove(index);
            return super.remove(index - 1);
        }
    }

    @Override
    public Object set(int index, Object o) {
        if (index % 2 == 0) {
            super.set(index, o);
            return super.set(index + 1, o);
        } else {
            super.set(index, o);
            return super.set(index - 1, o);
        }
    }
}