package com.prasanna.stackvm.runtime;

import java.util.ArrayList;

public class CPUStack {
    ArrayList<Object> stack;
    int top = -1;

    public CPUStack() {
        stack = new ArrayList<Object>();
    }

    public void push(float element) {
        stack.add(++top, (Object) element);
    }

    public void push(String element) {
        stack.add(++top, (Object) element);
    }

    public Object pop(){

        return stack.remove(top --);
    }

    public Object getLast() {
        return stack.get(top);
    }

    public Object getLastButOne() {
        return stack.get(top - 1);
    }

}
