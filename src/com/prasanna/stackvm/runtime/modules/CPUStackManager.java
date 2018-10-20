package com.prasanna.stackvm.runtime.modules;

import com.prasanna.stackvm.architecture.memory.MemoryLayout;
import com.prasanna.stackvm.architecture.memory.VariableRegistry;
import com.prasanna.stackvm.runtime.CPUStack;

public class CPUStackManager {

    public static void pushVariable(String vName, VariableRegistry registry, MemoryLayout layout, CPUStack stack) {
        String type = registry.getType(vName.split(":")[0]);
        if(type.equals("VARIABLE")) {
            float value = layout.getValue(vName);
            stack.push(value);
        }else if(type.equals("STRING")) {
            String value = layout.stringStorage.getString(vName);
            stack.push(value);
        }else if(type.equals("ARRAY")) {
            String vname = vName.split(":")[0];
            int index = Integer.parseInt(vName.split(":")[1]);
            float value = layout.arrayStorage.getArray(vName.split(":")[0])[index];
            stack.push(value);
        }
    }

}
