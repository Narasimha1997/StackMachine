package com.prasanna.stackvm.runtime.modules;

import com.prasanna.stackvm.architecture.InstructionSet;
import com.prasanna.stackvm.runtime.CPUStack;
import sun.plugin2.gluegen.runtime.CPU;

public class NArithmetic {

    //does not pop the elements from the stack
    //static CPUStack cpuStack;

    public static final int getOidinalOf(String exp) {
        final int x = InstructionSet.IA0x32.valueOf(exp).ordinal();
        return x;
    }

    private static void add(CPUStack stack) {
        float x = (float)stack.getLast();
        float y = (float)stack.getLastButOne();

        stack.push(x + y);
    }

    private static void sub(CPUStack stack) {
        float x = (float)stack.getLast();
        float y = (float)stack.getLastButOne();

        stack.push(x - y);
    }

    private static void mul(CPUStack stack) {
        float x = (float)stack.getLast();
        float y = (float)stack.getLastButOne();

        stack.push(x * y);
    }

    private static void div(CPUStack stack) {
        float x = (float)stack.getLast();
        float y = (float)stack.getLastButOne();

        stack.push(x / y);
    }

    private static void mod(CPUStack stack) {
        float x = (float)stack.getLast();
        float y = (float)stack.getLastButOne();

        stack.push(x % y);
    }

    public static void opCodeExecute(int opcode, CPUStack cpuStack) {
        if(opcode == getOidinalOf("NADD")) {
            add(cpuStack);
        }else if(opcode == getOidinalOf("NSUB")) {
            sub(cpuStack);
        }else if(opcode == getOidinalOf("NMUL")) {
            mul(cpuStack);
        }else if(opcode == getOidinalOf("NDIV")) {
            div(cpuStack);
        }else if(opcode == getOidinalOf("NMOD")) {
            mod(cpuStack);
        }
    }
}
