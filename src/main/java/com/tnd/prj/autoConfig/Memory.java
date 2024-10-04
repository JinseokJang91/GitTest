package com.tnd.prj.autoConfig;

/**
 * <pre>
 * File Description
 * </pre>
 *
 * @since 2024-10-02
 * <pre>
 * ===============================================
 *
 * ===============================================
 * </pre>
 */
public class Memory {
    private long used;
    private long max;

    public Memory(long used, long max) {
        this.used = used;
        this.max = max;
    }

    public long getUsed() {
        return used;
    }

    public long getMax() {
        return max;
    }

    @Override
    public String toString() {
        return "Memory{" +
                "used=" + used +
                ", max=" + max +
                '}';
    }
}
