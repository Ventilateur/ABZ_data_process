package com.abz.process;

/**
 * This class defines the data
 *
 * @author Phan Vu Hoang
 */
public class AbzData {
    private int id;
    private int[] orph;

    /**
     * Get data's identifier
     *
     * @return the value of id field
     */
    public int getId() { return id; }

    /**
     * Get the <code>orph</code> data
     *
     * @return <code>orph</code> data
     */
    public int[] getOrph() { return orph; }

    /**
     * Constructor.
     */
    AbzData() {
        id = 0;
        orph = new int[3];
    }
}
