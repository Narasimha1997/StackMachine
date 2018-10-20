package com.prasanna.stackvm;

import com.prasanna.stackvm.architecture.memory.MemoryLayout;
import com.prasanna.stackvm.compiler.*;
import com.prasanna.stackvm.compiler.Compiler;
import com.prasanna.stackvm.runtime.Engine;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try {
            //String fileName = args[0];
            //System.out.println(fileName);
            ExecutableObject object = Compiler.compile("Demo.s");
            Engine cpuRuntime = new Engine(object);
            cpuRuntime.executeOnInstructionQueue();
        }catch (Exception e) {
            System.out.println("Specify the file name");
        }
        System.out.println("\n---------------COMPILER TEST---------------\n");
        /*System.out.printf(
                "%d\t%d\t%s\t%f\t%s\t%s\n%s\n%s\n%s\n",
                object.layout.arrayStorage.getArray("").length,
                object.layout.instructionQueue.getInstruction(),
                object.layout.stringStorage.getString("D"),
                object.layout.getValue("C"),
                object.variableRegistry.getType("E"),
                object.variableRegistry.getType("A"),
                object.printsq.get(1),
                object.storesq.get(0),
                object.pushq.get(0)
        ); */

        //Execution test

    }
}