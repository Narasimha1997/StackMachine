package com.prasanna.stackvm.compiler;

import com.prasanna.stackvm.architecture.*;
import com.prasanna.stackvm.architecture.memory.MemoryLayout;
import com.prasanna.stackvm.architecture.memory.VariableRegistry;

import java.util.ArrayList;

public class Parser {

    ArrayList<String> lines;
    MemoryAllocator allocator;
    VariableRegistry registry;
    public Parser(ArrayList<String> lines) {
        allocator = new MemoryAllocator(1000, 1000);
        this.lines = lines;
        registry =  new VariableRegistry();
    }

    public ArrayList<Integer> getInstructions() {

        ArrayList<Integer> opcodes = new ArrayList<>();
        ArrayList<String> instructions = new ArrayList<>();
        for(String line : lines) {
            line = line.trim();
            String[] tokens = line.split(" ");
            if(tokens.length > 1) {
                instructions.add(tokens[0]);
                ParserUtils.parserEngine(
                        allocator, InstructionSet.getOPCode(tokens[0]), tokens[1], registry
                );
            }else {
                instructions.add(tokens[0]);
            }
        }

        opcodes = InstructionSet.getOpCodes(instructions);
        allocator.feedInstructions(opcodes);

        return opcodes;
    }

    public MemoryLayout getParsedLayout() {
        return allocator.getMemoryLayout();
    }

    public ExecutableObject getExecutableObjet() {
        return new ExecutableObject(
                allocator.getMemoryLayout(),
                ParserUtils.pushseq,
                registry,
                ParserUtils.storeseq,
                ParserUtils.printseq
        );
    }

}