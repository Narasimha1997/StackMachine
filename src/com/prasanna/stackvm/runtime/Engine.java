package com.prasanna.stackvm.runtime;

import com.prasanna.stackvm.architecture.InstructionSet;
import com.prasanna.stackvm.architecture.memory.InstructionQueue;
import com.prasanna.stackvm.architecture.memory.MemoryLayout;
import com.prasanna.stackvm.compiler.ExecutableObject;
import com.prasanna.stackvm.runtime.modules.ArithmeticClassic;
import com.prasanna.stackvm.runtime.modules.BitwiseOps;
import com.prasanna.stackvm.runtime.modules.CPUStackManager;
import com.prasanna.stackvm.runtime.modules.NArithmetic;
import sun.plugin2.gluegen.runtime.CPU;

import java.util.ArrayList;

public class Engine {

    ExecutableObject object;
    CPUStack stack;

    public Engine(ExecutableObject object) {
        this.object = object;
        stack = new CPUStack();
    }

    public void printFunction(String vName) {
        String type = this.object.variableRegistry.getType(vName);
        if(type.equals("STRING")) {
            String value = this.object.layout.stringStorage.getString(vName);
            System.out.println(value);
        }else if(type.equals("VARIABLE")) {
            float value = this.object.layout.getValue(vName);
            System.out.println(value);
        }
    }

    public void executeOnInstructionQueue() {
        int pushSeq = 0;
        int printSeq = 0;
        int storeIndex = 0;
        InstructionQueue instructionQueue = object.layout.instructionQueue;
        //execute all the instructions :
        while(!instructionQueue.isEmpty()) {
            //get latest instruction from queue
            int opcode = instructionQueue.getInstruction();
            if(opcode >= InstructionSet.IA0x32.ADD.ordinal() && opcode <= InstructionSet.IA0x32.MOD.ordinal()) {
                ArithmeticClassic.opCodeExecute(opcode, stack);
            }else if(opcode == InstructionSet.IA0x32.PUSH.ordinal()) {
                //The PUSH Instruction, push from sequence
                CPUStackManager.pushVariable(
                        this.object.pushq.get(pushSeq),
                        this.object.variableRegistry,
                        this.object.layout,
                        this.stack
                );

                pushSeq +=1;

            }else  if(opcode == InstructionSet.IA0x32.POP.ordinal()) {
                //The POP instruction, POP top, simply discard
            }else if(opcode == InstructionSet.IA0x32.NADD.ordinal() && opcode <= InstructionSet.IA0x32.NMOD.ordinal()) {
                //arithmetic operations with no stack pop
                NArithmetic.opCodeExecute(opcode, stack);
            }else if(opcode == InstructionSet.IA0x32.PRINT.ordinal()) {

                printFunction(this.object.printsq.get(printSeq));
                printSeq ++;

            }else if(opcode == InstructionSet.IA0x32.STORE.ordinal()) {
                try{
                    this.object.layout.createMemory(this.object.storesq.get(storeIndex), (float)stack.pop());
                    this.object.variableRegistry.addEntry(this.object.storesq.get(storeIndex), "VARIABLE");
                    storeIndex++;
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }else if(opcode == InstructionSet.IA0x32.STORES.ordinal()) {
                try{
                    this.object.layout.stringStorage.putString(this.object.storesq.get(storeIndex), (String)stack.pop());
                    this.object.variableRegistry.addEntry(this.object.storesq.get(storeIndex), "STRING");
                    storeIndex++;
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else if(opcode >= InstructionSet.IA0x32.AND.ordinal() && opcode <= InstructionSet.IA0x32.RSHIFT.ordinal()) {
                BitwiseOps.opCodeExecute(opcode, stack);
            }



            //many more will be implemented
        }
    }

}
