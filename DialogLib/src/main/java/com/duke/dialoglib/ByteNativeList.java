package com.duke.dialoglib;

/**
 * @Author: duke
 * @DateTime: 2019-06-02 17:32
 * @Description:
 */
public class ByteNativeList {

    private static final int DEFAULT_LENGTH = 10;
    private static final float DEFAULT_FACTOR = 0.75F;

    private volatile byte[] bytes;
    private volatile int size;
    private volatile int index;
    private volatile float factor = DEFAULT_FACTOR;


    public ByteNativeList() {
        this(DEFAULT_LENGTH, DEFAULT_FACTOR);
    }

    public ByteNativeList(int defaultLength) {
        this(defaultLength, DEFAULT_FACTOR);
    }

    public ByteNativeList(int defaultLength, float factor) {
        this.factor = factor;
        bytes = new byte[defaultLength];
    }

    public synchronized void clear() {
        bytes = null;
        size = 0;
        index = 0;
        factor = DEFAULT_FACTOR;
    }

    public synchronized ByteNativeList trim() {
        if (bytes.length == size) {
            return this;
        }
        byte[] bytesTemp = new byte[size];
        System.arraycopy(bytes, 0, bytesTemp, 0, size);
        bytes = bytesTemp;
        return this;
    }

//    public synchronized void add(byte data) {
//
//    }
//
//    public synchronized void add(int position, byte data) {
//
//    }
//
//    public synchronized void addAll(byte data) {
//
//    }
//
//    public synchronized void addAll(int position, byte data) {
//
//    }
//
//    public synchronized void set(byte data) {
//
//    }
//
//    public synchronized void set(int position, byte data) {
//
//    }
//
//    public synchronized void setAll(byte data) {
//
//    }
//
//    public synchronized void setAll(int position, byte data) {
//
//    }
//
//    public synchronized void remove(byte data) {
//
//    }
//
//    public synchronized void removeAll(int position, byte data) {
//
//    }
//
//    public synchronized byte get(int position) {
//
//    }
//
//    /**
//     * 排序：<br/>
//     * 1. ASC 升序
//     * 2. DESC 降序
//     *
//     * @param isAsc
//     */
//    public synchronized ByteNativeList sort(boolean isAsc) {
//
//    }
}
