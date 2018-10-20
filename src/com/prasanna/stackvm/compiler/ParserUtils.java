package com.prasanna.stackvm.compiler;

import com.prasanna.stackvm.architecture.InstructionSet;
import com.prasanna.stackvm.architecture.memory.MemoryLayout;
import com.prasanna.stackvm.architecture.memory.VariableRegistry;

import  java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserUtils {

    static ArrayList<String> pushseq = new ArrayList<>();
    static ArrayList<String> printseq = new ArrayList<>();
    static ArrayList<String> storeseq = new ArrayList<>();

    static String EXPRESSION = "[a-zA-Z]+=[0-9]+.[0-9]*";
    static String ARRAY = "([a-zA-Z]+=([0-9]+.[0-9]*)+,)+";

    static String STRING = "[a-zA-Z]+=\".*\"";

    static boolean checkValidExp(String token) {
        Pattern pattern = Pattern.compile(EXPRESSION);
        Matcher matcher = pattern.matcher(token);

        if(matcher.find()) return true;
        return false;
    }

    static boolean checkArray(String token) {
        Pattern pattern = Pattern.compile(ARRAY);
        Matcher matcher = pattern.matcher(token);

        if(matcher.find()) return true;
        return false;
    }

    static boolean checkString(String token) {
        Pattern pattern = Pattern.compile(STRING);
        Matcher matcher = pattern.matcher(token);

        if(matcher.find()) return true;
        return false;
    }

    static void getVariable(MemoryAllocator allocator, String token, VariableRegistry registry) {
        if(checkValidExp(token)) {
            String vals[] = token.split("=");
            System.out.printf("%s , %s\n", vals[0], vals[1]);
            allocator.allocateValue(vals[0], Float.parseFloat(vals[1]));
            registry.addEntry(vals[0], "VARIABLE");
        }else {
            System.out.println("Error in syntax at "+token);
        }
    }

    static  void getString(MemoryAllocator allocator, String token, VariableRegistry registry) {
        if(checkString(token)) {
            String vals[] = token.split("=");
            allocator.allocateString(vals[0], vals[1]);
            registry.addEntry(vals[0], "STRING");
        }else System.out.println("Error in syntax at "+token);
    }

    static void getArray(MemoryAllocator allocator, String token, VariableRegistry registry) {
        if(checkArray(token)) {
            String vals[] = token.split("=");

            String[] array_valus = vals[1].split(",");
            float[] array_vals_f = new float[array_valus.length];
            for(int i = 0; i < array_vals_f.length; i++)
                array_vals_f[i] = Float.parseFloat(array_valus[i]);

            allocator.allocateArray(vals[0], array_vals_f);
            registry.addEntry(vals[0], "ARRAY");

        }else System.out.println("Error in syntax at "+token);
    }


    static void parserEngine(MemoryAllocator allocator, int instruction, String residue, VariableRegistry registry) {
        if(instruction == InstructionSet.IA0x32.VAR.ordinal()) {
            getVariable(allocator, residue, registry);
        }else if(instruction == InstructionSet.IA0x32.VARS.ordinal()) {
            getString(allocator, residue, registry);
        }else if(instruction == InstructionSet.IA0x32.VARA.ordinal()) {
            getArray(allocator, residue, registry);
        }else if(instruction == InstructionSet.IA0x32.PUSH.ordinal()) {
            pushseq.add(residue);
        }else if(instruction == InstructionSet.IA0x32.PRINT.ordinal()) {
            printseq.add(residue);
        }else if(instruction == InstructionSet.IA0x32.STORE.ordinal()
         || instruction == InstructionSet.IA0x32.STORES.ordinal()) {
            storeseq.add(residue);
        }
    }

}
