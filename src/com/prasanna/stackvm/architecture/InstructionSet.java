package com.prasanna.stackvm.architecture;

import java.util.*;


public class InstructionSet {
    public static  enum IA0x32{
        VAR,
        VARS,
        LABEL,
        VARA,
        ADD,
        SUB,
        MUL,
        DIV,
        MOD,
        AND,
        OR,
        XOR,
        NOT,
        LSHIFT,
        RSHIFT,
        MOVE,
        STORE,
        STORES,
        PUSH,
        POP,
        PRINT,
        NADD,
        NSUB,
        NMUL,
        NDIV,
        NMOD,
        NMOVE,
        NSTORE
    };

    public static int getOPCode(String instruction) {
        IA0x32 insrt = IA0x32.valueOf(instruction);
        return insrt.ordinal();
    }

    public static ArrayList<Integer> getOpCodes(ArrayList<String> instructionSet) {
        ArrayList<Integer> opcs = new ArrayList<Integer>();

        for(String instruction : instructionSet)opcs.add(getOPCode(instruction));

        return opcs;
    }
}