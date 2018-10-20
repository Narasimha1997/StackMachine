package com.prasanna.stackvm.architecture.memory;

import java.util.HashMap;
import java.util.Map;

public class VariableRegistry {
    Map<String, String> registry;

    public VariableRegistry() {
        registry = new HashMap<>();
    }

    public void addEntry(String vName, String type) {
        registry.put(vName, type);
    }

    public String getType(String vName) {
        return registry.get(vName);
    }
}
