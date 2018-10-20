package com.prasanna.stackvm.architecture.memory;

import java.util.*;

//has 4 components : 

//Instruction Queue
//Memory table (HashMap) super class
//Array Storage (Will be implemented later)
//String storage

//Create an instance of this memory layout during execution,
//memory of this system is unlimited, or can also be restricted in config file.
// memory is considered as a HashMap that stores variable name followed by its value
//all the instructions that start with VAR instructions are treated as variable declarations
//Memory instruction format is : VAR A=10, creates a variable A with value 10.000

//all variables are floating point

public class MemoryLayout {
    
    //Data memory:
    HashMap<String, Float> memory;
    int totalSize;
    int size = 0;
    public InstructionQueue instructionQueue;
    public ArrayStorage arrayStorage;
    public StringStorage stringStorage;


    public MemoryLayout(int capacity, int arrayCapacity) {
        memory = new HashMap<String, Float>();
        totalSize = capacity;
        instructionQueue = new InstructionQueue();
        arrayStorage = new ArrayStorage(arrayCapacity);
        stringStorage = new StringStorage();
    }


    public void createMemory(String variableName, float value) throws VariableException{

        //check if memory is full : 
        if(getFreeSize() <= 0) return;

        if(memory.get(variableName) != null) throw new VariableException(variableName);
        else{
            memory.put(variableName, value);
            size ++;
        }
    }

    public float getValue(String variableName) {
        return memory.get(variableName);
    
    }

    public int getFreeSize() {
        return totalSize - size;
    }
}
