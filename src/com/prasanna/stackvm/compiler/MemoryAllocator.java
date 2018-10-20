package com.prasanna.stackvm.compiler;

import com.prasanna.stackvm.architecture.memory.MemoryLayout;

import java.util.ArrayList;

//Creates a memory layout and returns it once parsing has finished
//Allocates variables, arrays and strings.

public class MemoryAllocator {

    MemoryLayout memoryLayout;

    public MemoryAllocator(int dataSegmentSize, int arraysSize) {
        memoryLayout = new MemoryLayout(dataSegmentSize, arraysSize);
    }

    public void allocateValue(String variableName, float value) {
        try{
            memoryLayout.createMemory(variableName, value);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void allocateString(String variableName, String string) {
        try{
            memoryLayout.stringStorage.putString(variableName, string);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void allocateArray(String variableName, float[] array) {
        try{
            memoryLayout.arrayStorage.createNewArray(variableName, array);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void feedInstructions(ArrayList<Integer> opcodes) {
        try{
           for(int op : opcodes) memoryLayout.instructionQueue.putInstruction(op);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public MemoryLayout getMemoryLayout() {
        return this.memoryLayout;
    }
}
