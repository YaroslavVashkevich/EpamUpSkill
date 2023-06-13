package com.epam.rd.autocode.hashtableopen816;

public class HashtableOpen8to16Impl implements HashtableOpen8to16 {
    private final int MIN = 8;
    private final int MAX = 16;
    Record[] tableData = new Record[MIN];

    @Override
    public void insert(int key, Object value) {
        Object keyObj = key;
        if (size() == MAX && size() == checkFill() && !check(key)) {
            throw new IllegalStateException();
        } else {
            if (size() == checkFill() && !check(key)) {
                Record[] tableDataOld = tableData.clone();
                tableData = new Record[size() * 2];
                for (int i = 0; i < tableDataOld.length; i++) {
                    insert((int) tableDataOld[i].getKey(), tableDataOld[i].getData());
                }
            }
            int keyCode = keyObj.hashCode();
            int step = 0;
            int slot = hash(keyCode, step);
            while (!isEmpty(slot)) {
                if (keyObj.equals(tableData[slot].getKey())) {
                    tableData[slot].setData(value);
                    break;
                } else {
                    slot = hash(keyCode, step++);
                }
            }
            tableData[slot] = new Record(keyObj, value);
        }
    }

    @Override
    public Object search(int key) {
        Object keyObj = key;
        for (Record rec : tableData) {
            if (rec != null && rec.getKey() == keyObj) {
                return rec.getData();
            }
        }
        return null;
    }

    @Override
    public void remove(int key) {
        if (size() * 0.25 == checkFill() - 1 && check(key)) {
            delete(key);
            Record[] tableDataOld = tableData.clone();
            tableData = new Record[tableDataOld.length / 2];
            for (Record rec : tableDataOld) {
                if (rec != null) {
                    int keyCode = rec.getKey().hashCode();
                    int step = 0;
                    int slot = hash(keyCode, step);
                    while (!isEmpty(slot)) {
                        slot = hash(keyCode, step++);
                    }
                    tableData[slot] = new Record(rec.getKey(), rec.getData());
                }
            }
        }
        delete(key);
    }

    @Override
    public int size() {
        return tableData.length;
    }

    @Override
    public int[] keys() {
        int i = 0;
        int[] keys = new int[size()];
        for (Record rec : tableData) {
            if (rec == null) {
                keys[i] = 0;
            } else {
                keys[i] = (Integer) rec.getKey();
            }
            i++;
        }
        return keys;
    }

    private int hash(int key, int step) {
        if (step == 0) {
            return Math.abs(key) % size();
        } else {
            return (Math.abs(key) % size() + step) % size();
        }
    }

    private boolean isEmpty(int slot) {
        return tableData[slot] == null;
    }

    private class Record {
        Object key;
        Object data;

        public Record(Object key, Object data) {
            this.key = key;
            this.data = data;
        }

        public Object getKey() {
            return this.key;
        }

        public Object getData() {
            return this.data;
        }

        public void setKey(Object key) {
            this.key = key;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }

    public boolean check(int key) {
        Object keyObj = key;
        for (Record rec : tableData) {
            if (rec != null && keyObj.equals(rec.getKey())) {
                return true;
            }
        }
        return false;
    }

    public void delete(int key) {
        Object keyObj = key;
        for (int i = 0; i < size(); i++) {
            if (tableData[i] != null && keyObj.equals(tableData[i].getKey())) {
                tableData[i] = null;
            }
        }
    }

    public int checkFill() {
        int count = 0;
        for (Record rec : tableData) {
            if (rec != null) {
                count++;
            }
        }
        return count;
    }
}
