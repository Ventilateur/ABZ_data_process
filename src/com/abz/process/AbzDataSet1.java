package com.abz.process;

/**
 * This class defines the data set 1
 *
 * @author Phan Vu Hoang
 */
public class AbzDataSet1 extends AbzData {
    private int[] orph;

    /**
     * Get the <code>orph</code> data
     *
     * @return <code>orph</code> data
     */
    public int[] getOrph() { return orph; }

    /**
     * Constructor.
     */
    AbzDataSet1() {
        super();
        orph = new int[3];
    }
}
