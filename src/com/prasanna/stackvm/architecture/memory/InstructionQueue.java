package com.prasanna.stackvm.architecture.memory;
import java.util.Queue;
import  java.util.LinkedList;


//stores all the instructions in FIFO order
//Instruction Queue has no memory constraints
//uses linked list to store instructions

//stores opcodes

public class InstructionQueue {

    Queue<Integer> instructionQueue;

    public InstructionQueue() {
        instructionQueue = new LinkedList<Integer>();
    }

    public void putInstruction(int opcode){
        instructionQueue.add(opcode);
    }

    public int getInstruction() {
        return instructionQueue.remove();
    }

    public boolean isEmpty() {
        return instructionQueue.isEmpty();
    }
}