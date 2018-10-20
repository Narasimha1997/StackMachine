package com.prasanna.stackvm.architecture.memory;

class VariableException extends Exception {

    String variable;
    VariableException(String variable) {
        super();
        this.variable = variable;
    }

    @Override
    public String toString() {
        return "Duplicate variable name: "+variable;
    }
}

