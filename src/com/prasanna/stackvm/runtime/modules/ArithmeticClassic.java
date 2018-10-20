package com.prasanna.stackvm.runtime.modules;

import com.prasanna.stackvm.architecture.InstructionSet;
import com.prasanna.stackvm.runtime.CPUStack;

public class ArithmeticClassic {

    public static final int getOidinalOf(String exp) {
        final int x = InstructionSet.IA0x32.valueOf(exp).ordinal();
        return x;
    }

    private static void add(CPUStack stack) {
        float x = (float)stack.pop();
        float y = (float)stack.pop();

        stack.push(x + y);
    }

    private static void sub(CPUStack stack) {
        float x = (float)stack.pop();
        float y = (float)stack.pop();

        stack.push(x - y);
    }

    private static void mul(CPUStack stack) {
        float x = (float)stack.pop();
        float y = (float)stack.pop();

        stack.push(x * y);
    }

    private static void div(CPUStack stack) {
        float x = (float)stack.pop();
        float y = (float)stack.pop();

        stack.push(x / y);
    }

    private static void mod(CPUStack stack) {
        float x = (float)stack.pop();
        float y = (float)stack.pop();

        stack.push(x % y);
    }

    public static void opCodeExecute(int opcode, CPUStack cpuStack) {
       if(opcode == getOidinalOf("ADD")) {
           add(cpuStack);
       }else if(opcode == getOidinalOf("SUB")) {
           sub(cpuStack);
       }else if(opcode == getOidinalOf("MUL")) {
           mul(cpuStack);
       }else if(opcode == getOidinalOf("DIV")) {
           div(cpuStack);
       }else if(opcode == getOidinalOf("MOD")) {
           mod(cpuStack);
       }
    }


}
