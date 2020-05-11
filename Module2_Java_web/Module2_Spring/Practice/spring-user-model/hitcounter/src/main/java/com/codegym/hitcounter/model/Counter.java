package com.codegym.hitcounter.model;

public class Counter {
    private int count;
    public Counter(int count) {
        this.count = count;
    }
    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }
    public Counter() {
    }
    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }
    public void increase() {
        count++;
    }
}