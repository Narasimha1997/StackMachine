package com.prasanna.stackvm.compiler;

import com.prasanna.stackvm.architecture.memory.MemoryLayout;
import com.prasanna.stackvm.architecture.memory.VariableRegistry;

import java.util.ArrayList;

public class ExecutableObject {
    public MemoryLayout layout;
    public ArrayList<String> pushq;
    public VariableRegistry variableRegistry;
    public ArrayList<String> storesq;
    public ArrayList<String> printsq;

    public ExecutableObject(
            MemoryLayout layout,
            ArrayList<String> pushseq,
            VariableRegistry variableRegistry,
            ArrayList<String> storesq,
            ArrayList<String> printsq

    ) {
        this.layout = layout;
        this.pushq = pushseq;
        this.variableRegistry = variableRegistry;
        this.printsq = printsq;
        this.storesq = storesq;
    }

}
