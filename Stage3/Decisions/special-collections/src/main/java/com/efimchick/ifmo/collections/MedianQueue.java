package com.efimchick.ifmo.collections;

import java.util.*;

class MedianQueue implements Queue {
    LinkedList<Integer> list = new LinkedList<>();

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public boolean offer(Object o) {
        return list.offer((Integer) o);
    }

    @Override
    public Object remove() {
        return null;
    }

    @Override
    public Object poll() {
        Integer result = getMedianElement();
        list.remove(result);
        return result;
    }

    @Override
    public Object element() {
        return null;
    }

    @Override
    public Object peek() {
        return getMedianElement();
    }

    public Integer getMedianElement() {
        list.sort(Comparator.reverseOrder());
        return list.get(list.size() / 2);
    }
}
