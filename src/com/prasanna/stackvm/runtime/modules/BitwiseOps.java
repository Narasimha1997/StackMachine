package com.prasanna.stackvm.runtime.modules;

import com.prasanna.stackvm.architecture.InstructionSet;
import com.prasanna.stackvm.runtime.CPUStack;

public class BitwiseOps {

    public static final int getOidinalOf(String exp) {
        final int x = InstructionSet.IA0x32.valueOf(exp).ordinal();
        return x;
    }

    private static void and(CPUStack stack) {
        float x = (float)stack.pop();
        float y = (float)stack.pop();

        stack.push((int)x & (int)y);
    }

    private static void or(CPUStack stack) {
        float x = (float)stack.pop();
        float y = (float)stack.pop();

        stack.push((int)x | (int)y);
    }

    private static void not(CPUStack stack) {
        float x = (float)stack.pop();
        stack.push(~(int)x);
    }

    private static void xor(CPUStack stack) {
        float x = (float)stack.pop();
        float y = (float)stack.pop();

        stack.push((int)x ^ (int)y);
    }

    private static void lshift(CPUStack stack) {
        float x = (float)stack.pop();
        float y = (float)stack.pop();

        stack.push((int)x << (int)y);
    }

    private static void rshift(CPUStack stack) {
        float x = (float)stack.pop();
        float y = (float)stack.pop();

        stack.push((int)x >> (int)y);
    }

    public static void opCodeExecute(int opcode, CPUStack cpuStack) {
        if(opcode == getOidinalOf("AND")) {
            and(cpuStack);
        }else if(opcode == getOidinalOf("OR")) {
            or(cpuStack);
        }else if(opcode == getOidinalOf("NOT")) {
            not(cpuStack);
        }else if(opcode == getOidinalOf("XOR")) {
            xor(cpuStack);
        }else if(opcode == getOidinalOf("LSHIFT")) {
            lshift(cpuStack);
        }else if(opcode == getOidinalOf("RSHIFT")) {
            rshift(cpuStack);
        }
    }

}
