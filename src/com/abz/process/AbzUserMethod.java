package com.abz.process;

/**
 * This interface allows user to configure his own action when receive a data set.
 *
 * @author Phan Vu Hoang
 * @see AbzDataFactory
 */
public interface AbzUserMethod {
    /**
     * Method to be invoked when calling the right command.
     * @param data the received <code>AbzData</code> object
     * @see AbzDataFactory
     */
    void invoke(AbzData data);
}
