package com.abz.process;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>This class allows user to map a custom function to an ID of a json string set. It also allows user to launch that
 * function by calling a json String, if the id value has been already mapped to a function.</p>
 * <p>Side note: please download gson library from Google.</p>
 *
 * @author Phan Vu Hoang
 */
public class AbzDataFactory<T extends AbzData> {

    private static final String _NO_METHOD_EXCEPTION_MSG = "No method found, check your mapping!!!";
    private static final String _BAD_JSON_FORMAT_EXCEPTION_MSG = "JSON syntax error, check your input format!!!";

    private Map<Integer, AbzUserMethod> methodMap;
    private Gson json;
    private Class<T> dataAsObj;

    /**
     * Constructor. Initialize map set and Gson object.
     */
    public AbzDataFactory(Class<T> obj) {
        methodMap = new HashMap<>();
        json = new Gson();
        dataAsObj = obj;
    }

    /**
     * Map an id to a custom method.
     *
     * @param id the id value, which will be found later in the json string
     * @param method an <code>AbzUserMethod</code> instance, all methods inside must be override.
     */
    public void put(int id, AbzUserMethod method) {
        methodMap.put(id, method);
    }

    /**
     * Get a json string form of an <code>AbzData</code> object.
     *
     * @param data an <code>AbzData</code> object to be serialized
     * @return a JSON <code>String</code> form of the object above
     */
    public  String getCommandString(T data) {
        return json.toJson(data);
    }

    /**
     * Invoke the method corresponding to the id value of a json string. Will throw exception if the input string does
     * not follow the json form or the method is not initialized.
     *
     * @param jsonString an input json string
     */
    public void perform(String jsonString) {
        try {
            T data = json.fromJson(jsonString, dataAsObj);
            try {
                methodMap.get(data.getId()).invoke(data);
            } catch (NullPointerException e) {
                System.err.println(_NO_METHOD_EXCEPTION_MSG);
            }
        } catch (JsonSyntaxException e) {
            System.err.println(_BAD_JSON_FORMAT_EXCEPTION_MSG);
        }
    }
}
