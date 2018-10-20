package com.prasanna.stackvm.architecture.memory;
import java.util.*;

public class StringStorage {
    HashMap<String, String> stringStorage;

    public StringStorage() {
        stringStorage = new HashMap<String, String>();
    }

    public void putString(String vName, String value) throws VariableException {
        if(stringStorage.containsKey(value)) throw new VariableException(value);
        else stringStorage.put(vName, value);
    }

    public String getString(String vName) {
        return stringStorage.get(vName);
    }
}