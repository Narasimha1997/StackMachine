package com.prasanna.stackvm.architecture.memory;

import java.util.*;

//can store arrays of floating point numbers

//total capacity  = (number of arrays X size of each array)

//Example if capacity = 100
// we can store 4 floating point arrays each of size 25
//or we can store 3 arrays each of size 50, 25, 25 

public class ArrayStorage {

    HashMap<String, float[]> arrays;
    int capacity;
    int size = 0;

    public ArrayStorage(int capacity) {
        arrays = new HashMap<>();
        this.capacity = capacity;
    }

    private boolean canFit(int required) {
        int free = capacity - size;

        if(free - required >= 0) return true;

        return false;
    }

    public void createNewArray(String varName, float[] values) throws Exception {
        int required = values.length;
        if(canFit(required)) {
            if(arrays.containsKey(varName)) throw new VariableException(varName);
            else {
                arrays.put(varName, values);
                size += values.length;
            }
        }else throw new Exception("Memory overflow");
    }

    public float[] getArray(String varName) {
        return arrays.get(varName);
    }
}